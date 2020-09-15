

# 秒懂JVM的三大参数类型，就靠这十个小实验了

![封面](http://cdn.jayh.club/blog/20200915/64RykjzQjHkQ.png?imageslim)

> 你好，我是悟空哥，「7年项目开发经验，全栈工程师，开发组长，超喜欢图解编程底层原理」。手写了2个小程序，Java刷题小程序，PMP刷题小程序，已发布到公众号菜单。  
> SpringCloud实战项目[Github](https://github.com/Jackson0714/PassJava-Platform)  
> Java在线文档[Github](https://github.com/Jackson0714/PassJava-Learning)

本实验的目的是讲解JVM的三大参数类型。在JVM调优中用到的最多的XX参数，而如何去查看和设置JVM的XX参数也是调优的基本功，本节以实验的方式讲解JVM参数的查看和设置。希望大家能有所启发。

<img src="http://cdn.jayh.club/blog/20200915/MV0FYJ4Yk4St.png?imageslim" alt="目录" style="zoom: 67%;" />

## 标配参数

### 常见标配参数

- -version，获取JDK版本

- -help，获取帮助

- -showverision，获取JDK版本和帮助

### 动手实验 1 - 查看标配参数

实验步骤：

- 查看Java JDK 版本

``` java
java -version
```

![实验 1-1](http://cdn.jayh.club/blog/20200915/kh8gIaaDNWcO.png?imageslim)

可以看到Java JDK 版本为1.8.0_131

- 查看 Java 帮助文档

``` JAVA
java -help
```

![实验 1-2](http://cdn.jayh.club/blog/20200915/LrdkQchIeA68.png?imageslim)

- 查看版本和帮助文档

``` java
java -showversion
```

![实验 1-3](http://cdn.jayh.club/blog/20200915/m071zNL09FWL.png?imageslim)

## X参数

### X参数简介

我们常用的`javac`大家都知道是把java代码编译成class文java文件，那么class文件怎么去执行呢？这里用到了三个X参数来说明class文件怎么在虚拟机里面跑起来的。

- -Xint：直接解释执行
- -Xcomp：先编译成本地代码再执行
- -XMixed：混合模式（既有编译执行也有解释执行）

### 动手实验 2 - 查看和配置X参数

- 查看版本

``` shell
java -version
```

在WebIDE的控制台窗口执行java -version后，可以看到我的环境是混合模式执行java程序的。

![实验 2-1](http://cdn.jayh.club/blog/20200915/WilmN3z594lS.png?imageslim)

- 修改编译模式为解释执行模式

``` sh
java -Xint -version
```

在WebIDE的控制台窗口执行命令

![实验 2-2](http://cdn.jayh.club/blog/20200915/Vw6LnUFlAoV4.png?imageslim)

- 修改编译模式为只编译模式

``` sh
java -Xcomp -version
```

![实验 2-3](http://cdn.jayh.club/blog/20200915/WfCWww8QPPey.png?imageslim)

## XX 参数

### XX参数简介

XX参数有两种类型，一种是Boolean类型，另外一种是键值对类型。

- Boolean 类型
  - 公式：`-XX:+某个属性` 或者，`-XX:-某个属性` +表示开启了这个属性，-表示关闭了这个属性。
  - 案例：`-XX:-PrintGCDetails`，表示关闭了GC详情输出
- key-value类型
  - 公式：`-XX:属性key=属性value`
  - 案例：`-XX:属性metaspace=2000000`，设置Java元空间的值为2000000。

### 动手实验 3 - 查看参数是否开启

本实验主要讲解如下内容：查看运行的Java程序PrintGCDetails参数是否开启

- 编写一个一直运行的Java程序
- 查看该应用程序的进程id
- 查看该进程的GCDetail参数是否开启

#### 在 WEBIDE 上右键单击菜单，选择 New File 创建新文件

![New File](http://cdn.jayh.club/blog/20200915/LqSg8Wfv4Q0N.png?imageslim)

####  创建文件名为 demoXXparam.java

![demoXXparam.java](http://cdn.jayh.club/blog/20200915/l7S79mJGxMyW.png?imageslim)

#### 在 WebIDE 上编写 demoXXparam.java

``` JAVA
public class demoXXparam {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello XX params");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
```

#### 在 WebIDE 的控制台窗口编译 demoXXparam.java 代码

```java
javac demoXXparam.java 
```

![编译代码](http://cdn.jayh.club/blog/20200915/LfePCqTuPfw8.png?imageslim)

编译之后，会在当前文件夹产生我们所编写的  `demoXXparam` 类的 `demoXXparam.class` 字节码文件

![生产Class文件](http://cdn.jayh.club/blog/20200915/JHN788srztv4.png?imageslim)

#### 在 WebIDE 上运行 demoXXparam 代码

``` java
java demoXXparam
```

![运行Java程序](http://cdn.jayh.club/blog/20200915/nEMy2HVmtvn5.png?imageslim)

输出：

``` SH
hello XX params
```

### 在 WebIDE 中新开一个控制台窗口

Terminal->New Terminal

![开启新控制台窗口](http://cdn.jayh.club/blog/20200915/EMXBB1AclsiR.png?imageslim)

#### 查看所有的运行的java程序，-l 表示打印出class文件的包名

``` JAVA
jps -l
```

![jps](http://cdn.jayh.club/blog/20200915/Oyv9PTQLyn6F.png?imageslim)

发现`demoXXparam`进程的id为 518

#### 查看 demoXXparam 程序是否开启了PrintGCDetails这个参数

**PrintGCDetails：**  在发生垃圾回收时打印内存回收日志，并在进程退出时输出当前内存各区域分配情况

``` SH
jinfo -flag PrintGCDetails 518
```

![jinfo](http://cdn.jayh.club/blog/20200915/omoVEe2GINuu.png?imageslim)

结果如下：

``` SH
-XX:-PrintGCDetails
```

上面提到  `- `号表示关闭，所以当前 demo 程序没有开启 `PrintGCDetails`参数。

###  动手实验 4  - 开启参数 

- 在 WebIDE 控制台强制退出demoXXparam程序

``` sh
ctrl + c
```

- 然后清理屏幕

``` sh
clear
```

- 然后以参数 `-XX:+PrintGCDetails` 运行 demoXXparam 程序

``` sh
java -XX:+PrintGCDetails demoXXparam
```

![实验 4](http://cdn.jayh.club/blog/20200915/MOgivWNJrU2h.png?imageslim)

- 输出：

```sh
hello XX params
```

#### 查看demoXXparam进程的 id

![进程 id](http://cdn.jayh.club/blog/20200915/AnyM84Hm6ssL.png?imageslim)

可以看到demoXXparam进程 id 为 1225

#### 查看 demoXXparam 的配置参数 PrintGCDetails

打开一个新的控制台窗口，执行以下命令来查看进程为 1225 的 `PrintGCDetails`参数是否开启

``` sh
jinfo -flag PrintGCDetails 1225
```

![PrintGCDetails 参数](http://cdn.jayh.club/blog/20200915/Aq86jo99LesY.png?imageslim)

可以看到PrintGCDetails是开启的，`+`号表示开启。

### 动手实验 5 - Key-Value 类型参数值

#### 查看元空间的值

``` sh
jinfo -flag MetaspaceSize 526
```

![MetaspaceSize 大小](http://cdn.jayh.club/blog/20200915/gnLKSvpUHs9u.png?imageslim)

由此可以得出元空间的大小为 21 M。

#### 设置元空间的值为 128 M

```sh
java -XX:MetaspaceSize=128m demoXXparam   
```

查看元空间的大小

``` sh
    jinfo -flag MetaspaceSize 1062
```

![调整元空间大小](http://cdn.jayh.club/blog/20200915/UkLaR8mWA3ci.png?imageslim)

## 最常见的 -Xms 和 -Xmx 属于哪种参数？

- -Xms参数代表-XX:InitialHeapSize ，初始化堆内存（默认只会用最大物理内存的64分1）
- -Xmx:参数代表-XX:MaxHeapSize ，大堆内存（默认只会用最大物理内存的4分1）

起了别名，但还是属于XX参数。

### 动手实验 6 - 设置 -XX:InitialHeapSize 和 -XX:MaxHeapSize 的值。

``` sh
java -XX:InitialHeapSize=200m demoXXparam
或者
java -Xms200m demoXXparam
```

查看 InitialHeapSize 参数的值，大小为 200 M。

![设置 InitialHeapSize](http://cdn.jayh.club/blog/20200915/cFPq3SXFaYhj.png?imageslim)

``` sh
java -XX:MaxHeapSize=200M demoXXparam
或者
java -Xmx200m demoXXparam
```

查看 MaxHeapSize 参数的值，大小为 200 M。

![设置 MaxHeapSize](http://cdn.jayh.club/blog/20200915/6gSgjOIrxPeQ.png?imageslim)

### 扩展：查看 Java 程序已设置的所有参数值

``` sh
jinfo -flags <进程id>
```

![mark](http://cdn.jayh.club/blog/20200915/JvPXocfjcNrD.png?imageslim)

-  Non-Defalut VM flags 代表参数类型是JVM自带的参数。
-  Command line 代表是用户自定义的参数

## 如何查看出厂设置和自定义设置的XX配置项

### 动手实验 7 - 查看出厂默认设置的所有XX配置项

``` sh
java -XX:+PrintFlagsInitial -version 
```

![PrintFlagsInitial](http://cdn.jayh.club/blog/20200915/xpiHl2QULIbI.png?imageslim)

### 动手实验 8 - 查看 JVM 当前所有XX配置项

``` sh
java -XX:+PrintFlagsFinal -version 
```

![PrintFlagsFinal](http://cdn.jayh.club/blog/20200915/KWTbx4Qi0krm.png?imageslim)

我们可以看到几个关键信息：

- `[Global flags]`：全局参数，如果自定义修改了某个应用的参数，并不会修改全局参数

  比如之前我们修改了MetaspaceSize为128m，但列表里面还是21m。

![Global flags](http://cdn.jayh.club/blog/20200915/UbnXulH9GdUa.png?imageslim)

- `:=`：参数已被修改，如下图所示InitialHeapSize初始化堆内存参数已修改为264241152

  总结如下：

![出厂设置和自定义参数设置](http://cdn.jayh.club/blog/20200915/yWaE4B437bXk.png?imageslim)

### 动手实验 9 - 运行程序时打印XX配置选项

``` sh
java -XX:+PrintFlagsFinal -XX:+InitialHeapSize=150M demoXXparam
```

可以看到修改后的值为 157286400（150 M）

![运行程序时打印XX配置选项](http://cdn.jayh.club/blog/20200915/NQ6Q9szVKbvq.png?imageslim)

### 动手实验 10 - 查看 JVM 自动配置的或者用户手动设置的XX选项（非应用程序的）

``` java
java -XX:+PrintCommandLineFlags -version
```

会打印出如下参数：

![JVM 自动配置的XX选项](http://cdn.jayh.club/blog/20200915/sqztVGrgOkYm.png?imageslim)

## 实验总结

本节实验课学习了如何查看基本参数、X参数、XX参数和设置XX参数。以及用好jps和jinfo工具来查看进程和设置参数。

**JVM性能调优**还有很多要讲的，一篇是讲不完的，我会分成几篇来为大家讲述，形式主要以小实验的方式来为大家讲解。