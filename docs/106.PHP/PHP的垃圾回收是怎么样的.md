# 我天，PHP 的垃圾回收可太秀了！

![mark](PHP的垃圾回收是怎么样的.assets/Pc9UbIojX8C0.png)

Java 种的垃圾回收机制，大家肯定都有所了解，比如如何确定垃圾，有两种算法，引用计数法和可达性分析算法。Java 中使用的是可达性分析算法，而 PHP 使用的引用计数算法。我们都知道引用计数算法较难处理循环引用的问题，PHP 这波奇怪的操作可太秀了，那 PHP 的垃圾回收原理是怎么样的？

# 一、PHP 中的引用计数

## 1.1 如何确定垃圾

**原理：** 给对象添加一个引用计数器，每当有一个地方引用它，计数器的值就加一。每当有一个引用失效，计数器的值就减一。

- 如果一个变量 value 的 refcount 减一之后等于 0，此 value 可以被`释放`掉，`不属于`垃圾。**垃圾回收器不会处理** 。

- 如果一个变量 value 的 refcount 减一之后还是大于 0，此 value 被认为不能被释放掉，`可能`成为一个垃圾。

- 垃圾回收器将可能的垃圾收集起来，等达到一定数量后开始启动`垃圾鉴定程序`，把`真正`的垃圾释放掉。

**缺点：** 需要维护引用计数器，有一定的消耗。且较难处理循环引用的问题。后面也会讲到如何解决这个问题。

下面的例子说明引用计数的是如何变化的：

![mark](http://cdn.jayh.club/blog/20201119/pC3qrmPbKVb5.png?imageslim)

## 1.2 PHP 中的变量知识

每个 php 变量存在一个叫 `zval` 的变量容器中。一个 zval 变量容器，除了包含变量的类型和值，还包括两个字节的额外信息。

第一个是 `is_ref`，是个 bool 值，用来标识这个变量是否是属于引用集合（reference set） 。通过这个字节，php 引擎才能把普通变量和引用变量区分开来，由于 php 允许用户通过使用&来使用自定义引用，zval 变量容器中还有一个内部引用计数机制，来优化内存使用。

第二个额外字节是 `refcount`，用以表示指向这个 zval 变量容器的变量（也称符号即 symbol ）个数。

## 1.3 使用引用计数的类型

有 5 种类型用的引用计数：

**string、array、object、resource、reference**

下面的表格说明了只有 type_flag 为以下 8 种类型且 IS_TYPE_REFOUNTED=true 的变量才使用引用计数，如下表所示

![使用引用计数的类型](http://cdn.jayh.club/blog/20201119/cfyVPmgbHew8.png?imageslim)

 

# 二、回收原理

### 2.1. 回收时机

- 自动回收：在变量 zval 断开 value 的指向时，如果发现 refcount=0 则会直接释放 value。
  - 断开 value 指向的情形
    - 修改变量时会断开原有 value 的指向
    - 函数返回时会释放所有的局部变量

- 主动回收

  调用 `unset()` 函数。类似于 Java 中的 `System.gc()`

## 2.2 垃圾鉴定

垃圾收集器收集的`可能垃圾`到达一定数量后，启动垃圾鉴定、回收程序。

原理：垃圾是由于成员引用自身导致的，那么就对 value 的 refcount 减一操作，如果 value 的 refount 变为了 0，则表明其引用全部来自自身成员，value 属于垃圾。另外垃圾只会出现在array、object类型中。

![回收步骤](http://cdn.jayh.club/blog/20201119/aqTDSoepOCEB.png?imageslim)

- **步骤一：** 遍历垃圾回收器的 buffer 缓冲区，把 value 标为灰色，把 value 的成员的 refount-1，还是标为灰色。

- **步骤二：** 遍历垃圾回收器的 buffer 缓冲区，如果 value 的 refcount 等于 0，标为白色，认为是垃圾；如果不等于 0，则表示还有外部的引用，不是垃圾，将 refcount+1 还原回去，标为黑色。

- **步骤三：** 遍历垃圾回收器的 buffer 缓冲区，将 value 为非白色的节点从 buffer 中删除，最终 buffer 缓冲区中都是真正的垃圾。

- **步骤四：** 遍历垃圾回收器的 buffer 缓冲区，释放此 value。

# 三、带你看源码

## 1. 垃圾管家

我称 _zend_gc_globals 为垃圾管家，结构体会对垃圾进行管理，收集到的可能成为垃圾的 value 就保存在这个结构的 buf 中，称为垃圾缓存区。

文件路径：\Zend\zend_gc.h。

![垃圾管家](http://cdn.jayh.club/blog/20201119/5aOxjJj3Opde.png?imageslim)

## 2. 垃圾管家初始化

（1）php.ini 解析后调用 gc_init() 初始垃圾管家_zend_gc_globals 

文件路径：\Zend\zend_gc.c

![初始垃圾管家](http://cdn.jayh.club/blog/20201119/s0Vylu4pzboK.png?imageslim)

（2）gc_init() 函数里面调用 gc_reset() 函数初始化。

![gc_reset() 函数初始化](http://cdn.jayh.club/blog/20201119/qQ1L5HD9WKrm.png?imageslim)

## 3. 判断是否需要收集

（1）在销毁一个变量时就会判断是否需要收集。调用 i_zval_ptr_dtor() 函数

​          文件路径：Zend\zend_variables.h

![核心逻辑](http://cdn.jayh.club/blog/20201119/Q7FXNpeUFk3y.png?imageslim)

- 如果 refcount 减一后，refcount 等于 0，则认为不是垃圾，调用 _zval_dtor_func 方法释放此 value。

- 如果 refcount 减一后，refcount 大于 0，则认为 value 可能是垃圾，垃圾管家进行收集

##  3. 收集垃圾

文件路径：\Zend\zend_gc.c，调用方法：gc_possible_root

![gc_possible_root](http://cdn.jayh.club/blog/20201119/qx0YC2eDHrrm.png?imageslim)

- 拿出 unused 指向的节点。
- 如果拿出的节点是可用的，则将 unused 指向下一个节点。
- 如果 unused 没有可用的，且 first_unused 还没有推进到 last_unused，则表示 buf 缓存区中还有可用的节点。
- 拿出 first_unused 指向的节点。
- first_unused 指向下一个节点。
- buf 缓存区已满，启动垃圾鉴定、垃圾回收。
- 如果未启用垃圾回收，则直接返回。

![mark](http://cdn.jayh.club/blog/20201119/o2K3WPyE1qPn.png?imageslim)

- 将插入的变量标为紫色，防止重复插入。
- 将该节点在 buf 数组中的位置保存到了 gc_info 中，当后续 value 的 refcount 变为了 0。
- 需要将其从 buf 中删除时可以知道该 value 保存在哪个 gc_root_buffer 中。

## 5. 释放垃圾

由于回收方法 zend_gc_collect_cycles() 实在是太长，我把几个关键步骤理出来了：

![mark](http://cdn.jayh.club/blog/20201119/hQvvvONQUABB.png?imageslim)

- 扫描根节点
- 收集根节点
- 调用回收器
- 清理变量

- 收集完成

# 四、总结

（1）PHP 的垃圾回收和 Java 的垃圾回收还是很有很大区别的，我们都以为没有高级语言会用到引用计数法来回收垃圾，但偏偏 PHP 用的是引用计数。

（2）PHP 用了一套自己的算法来解决因循环引用而产生垃圾的问题，这套算法可以简单理解为先把可疑垃圾的引用计数减一来进行测试，如果引用计数确实等于 0 ，则标记颜色为黑色，后续一起清理。

（3）PHP 垃圾收集中总共用到了三种关键颜色： 白色- 垃圾， 黑色- 非垃圾， 紫色- 防止重复插入。