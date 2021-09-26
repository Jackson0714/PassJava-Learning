大家好，我是悟空。今天来一波多线程核心知识点汇总：

> 先说下哈，这次给大家带来的大厂面试题，都来源于我的知识星球。

请扫码进入知识星球查看！

![](https://img-blog.csdnimg.cn/2021071922263371.png)

> 面试题第一时间会发到我的知识星球和群聊里面。

## 多线程面试问题汇总（第一季）

[toc]

* Java 的高并发容器有哪些？
* ABA 问题？
* 线程池的原理？
* 阻塞队列有哪几种？
* 线程池的拒绝策略有哪几种？
* 多线程创建多少个线程合适？
* Java 线程池有哪几种？
* 线程池如何监控？
* Executor 有哪几种线程池？
* 什么是 AQS
* ThreadLocal 有什么缺点？
* volatile 有什么特点，和 synchornized 相比有什么区别？
* 线程池的生命周期 08-03
* Java 内存模型知道吗？

## Java 的高并发容器有哪些？

### 同步容器

Java 在 1.5 版本之前所谓的线程安全的容器，主要指的就是**同步容器**。

**同步容器的问题**：

不过同步容器有个最大的问题，那就是性能差，所有方法都用 synchronized 来保证互斥，串行度太高了。

### 并发容器

因此 Java 在 1.5 及之后版本提供了性能更高的容器，我们一般称为**并发容器**。

**并发容器的分类**：

并发容器虽然数量非常多，但依然是前面我们提到的四大类：List、Map、Set 和 Queue，下面的并发容器关系图，基本上把我们经常用的容器都覆盖到了。

![](https://img-blog.csdnimg.cn/img_convert/39419e9d21aed1d474cac82fab0ed8b4.png)

## 并发编程中的 CAS 原理知道吗？

原子整型类 AtomicInteger 的 getAndIncrement 方法就用到 CAS。

比如这一段代码：

```SH
atomicInteger.compareAndSet(10, 20);
```

调用 atomicInteger 的 CAS 方法，先比较当前变量 atomicInteger 的值是否是10，如果是，则将变量的值设置为20。

- CAS 的全称：Compare-And-Swap（比较并交换）。比较变量的现在值与之前的值是否一致，若一致则替换，否则不替换。

- CAS 的作用：原子性更新变量值，保证线程安全。

- CAS 指令底层代码：需要有三个操作数，变量的当前值（V），旧的预期值（A），准备设置的新值（B）。

- CAS 指令执行条件：当且仅当 V=A 时，处理器才会设置 V=B，否则不执行更新。

- CAS 的返回值：V 的之前值。

- CAS 处理过程：原子操作，执行期间不会被其他线程中断，线程安全。

- CAS 并发原语：体现在 Java 语言中 sun.misc.Unsafe 类的各个方法。调用 UnSafe 类中的 CAS 方法，JVM 会帮我们实现出 CAS 汇编指令，这是一种完全依赖于硬件的功能，通过它实现了原子操作。由于 CAS 是一种系统原语，原语属于操作系统用于范畴，是由若干条指令组成，用于完成某个功能的一个过程，并且原语的执行必须是连续的，在执行过程中不允许被中断，所以 CAS 是一条 CPU 的原子指令，不会造成所谓的数据不一致的问题，所以 CAS 是线程安全的。

CAS 带来的问题：

1）频繁出现自旋，循环时间长，开销大（因为执行的是do while，如果比较不成功一直在循环，最差的情况，就是某个线程一直取到的值和预期值都不一样，这样就会无限循环）

2）只能保证一个共享变量的原子操作

- 当对一个共享变量执行操作时，我们可以通过循环CAS的方式来保证原子操作

- 但是对于多个共享变量操作时，循环CAS就无法保证操作的原子性，这个时候只能用锁来保证原子性。

## ABA 问题?

**ABA 问题**：

因为 CAS 需要在操作值的时候，检查值有没有发生变化，如果没有发生变化则更新，但是如果一个值原来是A，变成了 B，又变成了 A，那么使用 CAS 进行检查时会发现它的值没有发生变化，但是实际上却变化了。

**解决方案**：

ABA 问题的解决思路就是使用版本号。在变量前面追加上版本号，每次变量更新的时候把版本号加 1，那么 A→B→A 就会变成 1A→2B→3A。

从Java 1.5开始，JDK 的 Atomic 包里提供了一个类 AtomicStampedReference 来解决 ABA 问题。这个类的compareAndSet 方法的作用是首先检查当前引用是否等于预期引用，并且检查当前标志是否等于预期标志，如果全部相等，则以原子方式将该引用和该标志的值设置为给定的更新值。

原子类`AtomicStampedReference`的底层代码：

比较并替换方法`compareAndSet`。

![compareAndSet 源码](https://img-blog.csdnimg.cn/img_convert/33b08537f3b16fabea18e404aed08a6d.png)

`expectedReference`：期望值

`newReference`：替换值

`expectedStamp`：期望版本号

`newStamp`：替换版本号

先比较期望值 expectedReference 和当前值是否相等，以及期望版本号和当前版本号是否相等，如果两者都相等，则表示没有被修改过，可以进行替换。

**举例说明**：

甲乙线程想改变三角形 A 的形状，乙线程先改成了四边形，后又改成了三角形，三角形 A1->四边形 V2-> 三角形 A3。

当甲线程想改变 A3 为五边形时报错，因为三角形经过已线程修改后，前后版本号不一样，被判定为已修改过，其他线程不能修改。这样就防止了 ABA 问题。

![举例说明](https://img-blog.csdnimg.cn/img_convert/1ee534259df1fdd6ca5b34633b6fae76.png)


## volatile 有什么特点，和 synchornized 相比有什么区别？

### volatile 有什么特点？

- volatile 保证了可见性：当一个线程修改了共享变量的值时，其他线程能够立即得知这个修改。
- volatile 保证了单线程下指令不重排：通过插入内存屏障保证指令执行顺序。
- volatile 不保证原子性，如 a++ 这种自增操作是有并发风险的，比如扣减库存、发放优惠券的场景。
- volatile 类型的 64 位的 long型和 double 型变量，对该变量的读/写具有原子性。
- volatile 可以用在双重检锁的单例模式种，比 synchronized 性能更好。
- volatile 可以用在检查某个状态标记以判断是否退出循环。

###  volatile 和 synchornized 对比

- volatile 只能修饰实例变量和类变量，synchronized 可以修饰方法和代码块。

- volatile 不保证原子性，而 synchronized 保证原子性

- volatile 不会造成阻塞，而 synchronized 可能会造成阻塞

- volatile 轻量级锁，synchronized 重量级锁

- volatile 和 synchronized 都保证了可见性和有序性。

## 什么是Java内存模型？

![原理图1-Java内存模型](https://img-blog.csdnimg.cn/img_convert/41368385b5b7a2d39d4aab909b1ece8c.png)

### 3.1 为什么需要Java内存模型？

> `Why`:屏蔽各种硬件和操作系统的内存访问差异

JMM是Java内存模型，也就是Java Memory Model，简称JMM，本身是一种抽象的概念，实际上并不存在，它描述的是一组规则或规范，通过这组规范定义了程序中各个变量（包括实例字段，静态字段和构成数组对象的元素）的访问方式。

### 3.2 到底什么是Java内存模型？

- 1.定义程序中各种变量的访问规则
- 2.把变量值存储到内存的底层细节
- 3.从内存中取出变量值的底层细节

### 3.3 Java内存模型的两大内存是啥？

<img src="http://cdn.jayh.club/blog/20200816/lCr3gHq8fxlV.png?imageslim" alt="原理图2-两大内存" style="zoom:67%;" />

- 主内存
  - Java堆中对象实例数据部分
  - 对应于物理硬件的内存
- 工作内存
  - Java栈中的部分区域
  - 优先存储于寄存器和高速缓存

### 3.4 Java内存模型是怎么做的？

Java内存模型的几个规范：

- 1.所有变量存储在主内存

- 2.主内存是虚拟机内存的一部分

- 3.每条线程有自己的工作内存

- 4.线程的工作内存保存变量的主内存副本

- 5.线程对变量的操作必须在工作内存中进行
- 6.不同线程之间无法直接访问对方工作内存中的变量
- 7.线程间变量值的传递均需要通过主内存来完成

由于JVM运行程序的实体是线程，而每个线程创建时JVM都会为其创建一个工作内存（有些地方称为栈空间），工作内存是每个线程的私有数据区域，而Java内存模型中规定所有变量都存储在主内存，主内存是共享内存区域，所有线程都可以访问，`但线程对变量的操作（读取赋值等）必须在工作内存中进行，首先要将变量从主内存拷贝到自己的工作内存空间，然后对变量进行操作，操作完成后再将变量写会主内存`，不能直接操作主内存中的变量，各个线程中的工作内存中存储着主内存中的变量副本拷贝，因此不同的线程间无法访问对方的工作内存，线程间的通信（传值）必须通过主内存来完成，其简要访问过程：

![原理图3-Java内存模型](https://img-blog.csdnimg.cn/img_convert/5bf9c9dae6f7b867fc1b4ab7977b593d.png)

### 3.5 Java内存模型的三大特性

- 可见性（当一个线程修改了共享变量的值时，其他线程能够立即得知这个修改）
- 原子性（一个操作或一系列操作是不可分割的，要么同时成功，要么同时失败）
- 有序性（变量赋值操作的顺序与程序代码中的执行顺序一致）

关于有序性：如果在本线程内观察，所有的操作都是有序的；如果在一个线程中观察另一个线程，所有的操作都是无序的。前半句是指“线程内似表现为串行的语义”（Within-Thread As-If-Serial Semantics），后半句是指“指令重排序”现象和“工作内存与主内存同步延迟”现象。

## ThreadLocal 有什么缺点？

### ThreadLocal 使用场景

适用于变量在线程间隔离，而在方法或类间共享的场景。如果用户信息的获取比较昂贵（比如从数据库查询用户信息），那么在 ThreadLocal 中缓存数据是比较合适的做法。

### ThreadLocal 的缺点

线程池会重用固定的几个线程，一旦线程重用，那么很可能首次从 ThreadLocal 获取的值是之前其他用户的请求遗留的值。

阿里嵩山开发手册：

【强制】必须回收自定义的ThreadLocal变量，尤其在线程池场景下，线程经常会被复用，如果不清理自定义的ThreadLocal变量，可能会影响后续业务逻辑和造成内存泄露等问题。尽量在代理中使用try-finally块进行回收。

正例：

```JAVA
objectThreadLocal.set(userInfo);

try{ 
    // ...
}
finally{ 
    objectThreadLocal.remove();
}
```

## 什么是 AQS？

AbstractQueuedSynchronizer 类如其名，抽象的队列式的同步器，将基础的同步相关操作抽象在 AbstractQueuedSynchronizer 中，利用 AQS 为我们构建同步结构提供了范本。

AQS定义了一套多线程访问共享资源的同步器框架，许多同步类实现都依赖于它，如常用的ReentrantLock/Semaphore/CountDownLatch。

将基础的同步相关操作抽象在 AbstractQueuedSynchronizer 中，利用 AQS 为我们构建同步结构提供了范本。

AQS 内部数据和方法，可以简单拆分为：

- 一个 volatile 的整数成员表征状态，同时提供了 setState 和 getState 方法。

- 一个先入先出（FIFO）的等待线程队列，以实现多线程间竞争和等待，这是 AQS 机制的核心之一。

- 各种基于 CAS 的基础操作方法，以及各种期望具体同步结构去实现的 acquire/release 方法。

利用 AQS 实现一个同步结构，至少要实现两个基本类型的方法，分别是 acquire 操作，获取资源的独占权；还有就是 release 操作，释放对某个资源的独占。

## Java 线程池的原理知道吗？

### 线程池的好处

- 降低资源消耗。重复利用已创建的线程降低线程创建和销毁造成的消耗。
- 提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
- 提高线程的可管理性。线程是稀缺资源，如果频繁创建，会消耗系统资源，降低系统稳定性，使用线程池统一分配、调优和监控。

### 线程池有核心参数：

1. maximumPoolSize：最大线程数。线程池允许创建的最大线程数。

2. corePoolSize：核心线程数。当提交一个任务到线程池时，线程池会创建一个线程来执行任务，即使其他空闲的核心线程能够执行新任务也会创建线程，等到 需要执行的任务数大于线程池基本大小时就不再创建。如果调用了线程池的 prestartAllCoreThreads() 方法，则线程池会提前创建并启动所有基本线程。

3. keepAliveTime：线程活动保持时间 ，线程池的工作线程空闲后，保持存活的时间。

4. runnableTaskQueue：任务队列，用于保存等待执行的任务的阻塞队列。有四种：ArrayBlockingQueue、LinkedBlockingQueue、SynchronousQueue、PriorityBlockingQueue。。

5. RejectedExecutionHandler 拒绝策略。当队列和线程满了后，采取一种策略处理提交的新任务。

## 线程池执行流程?

当提交一个新任务到线程池时，具体的执行流程如下：

1. 当我们提交任务，线程池会根据 corePoolSize 大小创建若干任务数量线程执行任务
2. 当任务的数量超过 corePoolSize 数量，后续的任务将会进入阻塞队列阻塞排队。
3. 当阻塞队列也满了之后，那么将会继续创建（maximumPoolSize-corePoolSize）个数量的线程来执行任务，如果任务处理完成，maximumPoolSize-corePoolSize 额外创建的线程等待 keepAliveTime 之后被自动销毁
4. 如果达到 maximumPoolSize，阻塞队列还是满的状态，那么将根据不同的拒绝策略对应处理。

## 线程池中的阻塞队列有哪几种？

阻塞队列用于保存等待执行的任务。当任务的数量超过 corePoolSize 数量，后续的任务将会进入阻塞队列，阻塞排队。

有以下几种阻塞队列：

### ArrayBlockingQueue

是一个基于数组结构的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行排序。

![](https://img-blog.csdnimg.cn/img_convert/9de3b077b8a71e2dfc3058fb05742b53.png)

- ArrayBlockingQueue是一个用数组实现的有界阻塞队列。
- 队列慢时插入操作被阻塞，队列空时，移除操作被阻塞。
- 按照先进先出（FIFO）原则对元素进行排序。
- 默认不保证线程公平的访问队列。
- 公平访问队列：按照阻塞的先后顺序访问队列，即先阻塞的线程先访问队列。
- 非公平性是对先等待的线程是非公平的，当队列可用时，阻塞的线程都可以争夺访问队列的资格。有可能先阻塞的线程最后才访问访问队列。
- 公平性会降低吞吐量。

### LinkedBlockingQueue

一个基于链表结构的阻塞队列，此队列按 FIFO 排序元素，吞吐量通常要高于 ArrayBlockingQueue。静态工厂方法 Executors.newFixedThreadPool() 使用了这个队列。（newFixedThreadPool 用于创建固定线程数）

![图片](https://img-blog.csdnimg.cn/img_convert/a7af8345b83d8c22eb7ece641defa140.png)LinkedBlockingQueue 原理

- LinkedBlockingQueue具有单链表和有界阻塞队列的功能。
- 队列慢时插入操作被阻塞，队列空时，移除操作被阻塞。
- 默认和最大长度为Integer.MAX_VALUE，相当于无界(值非常大：2^31-1)。

### SynchronousQueue

一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于 LinkedBlockingQueue，静态工厂方法 Executors.newCachedThreadPool 使用这个队列。（newCachedThreadPool 用于根据需要创建新线程）

![](https://img-blog.csdnimg.cn/img_convert/b8d9ea1a8448a2569ea582e1a3bb2c6f.png)SynchronousQueue 原理

- 我称SynchronousQueue为”传球好手“。想象一下这个场景：小明抱着一个篮球想传给小花，如果小花没有将球拿走，则小明是不能再拿其他球的。
- SynchronousQueue负责把生产者产生的数据传递给消费者线程。
- SynchronousQueue本身不存储数据，调用了put方法后，队列里面也是空的。
- 每一个put操作必须等待一个take操作完成，否则不能添加元素。
- 适合传递性场景。
- 性能高于ArrayBlockingQueue 和 LinkedBlockingQueue。

### PriorityBlockingQueue

一个具有优先级的无限阻塞队列。

![](https://img-blog.csdnimg.cn/img_convert/e7d502f0234731f4bf3d5d7f14fc5e47.png)PriorityBlockQueue的原理图

- PriorityBlockQueue = PriorityQueue + BlockingQueue
- 之前我们也讲到了PriorityQueue的原理，支持对元素排序。
- 元素默认自然排序。
- 可以自定义CompareTo()方法来指定元素排序规则。
- 可以通过构造函数构造参数Comparator来对元素进行排序。

之前写过一篇文章：[干货 | 45张图庖丁解牛18种Queue，你知道几种？](https://mp.weixin.qq.com/s/1cWszX8MWXq_XNMXNyeDMg)

## 多线程创建多少个合适？

### CPU 密集型

CPU 密集型计算：大部分场景下都是纯 CPU 计算。

对于 CPU 密集型计算，多线程本质上是提升多核 CPU 的利用率，所以对于一个 4 核的 CPU，每个核一个线程，理论上创建 4 个线程就可以了，再多创建线程也只是增加线程切换的成本。

理论上“线程的数量 =CPU 核数”就是最合适的。不过在工程上，线程的数量一般会设置为“CPU 核数 +1”，这样的话，当线程因为偶尔的内存页失效或其他原因导致阻塞时，这个额外的线程可以顶上，从而保证 CPU 的利用率。

### IO 密集型

由于 I/O 设备的速度相对于 CPU 来说都很慢，所以大部分情况下，I/O 操作执行的时间相对于 CPU 计算来说都非常长，这种场景我们一般都称为 I/O 密集型计算。

最佳线程数 = CPU 核数 * [ 1 +（I/O 耗时 / CPU 耗时）]

## 线程池的拒绝策略?

如果线程池中所有的线程都在忙碌，并且工作队列也满了（前提是工作队列是有界队列），那么此时提交任务，线程池就会拒绝接收。至于拒绝的策略，你可以通过 handler 这个参数来指定。

ThreadPoolExecutor 已经提供了以下 4 种策略。

- CallerRunsPolicy：提交任务的线程自己去执行该任务。
- AbortPolicy：默认的拒绝策略，会 throws RejectedExecutionException。
- DiscardPolicy：直接丢弃任务，没有任何异常抛出。
- DiscardOldestPolicy：丢弃最老的任务，其实就是把最早进入工作队列的任务丢弃，然后把新任务加入到工作队列。

以上内置拒绝策略均实现了 RejectedExecutionHandler 接口，若以上策略仍无法满足实际需要，完全可以自己扩展 RejectedExecutionHandler 接口。

## 线程池的生命周期?

线程池生命周期包括:

- RUNNING：接收新的任务并处理队列中的任务
- SHUTDOWN：不接收新的任务，但是处理队列中的任务
- STOP：不接收新的任务，不处理队列中的任务，同时中断处理中的任务
- TIDYING：所有的任务处理完成，有效的线程数是0
- TERMINATED：terminated() 方法执行完毕。

生命周期状态和方法对应的关系：

![](https://img-blog.csdnimg.cn/img_convert/b845cc3606c2448b2ce542752fe3a1d4.png)

## Java 线程池有哪几种？

通常开发者都是利用 Executors 提供的通用线程池创建方法，去创建不同配置的线程池，主要区别在于不同的 ExecutorService 类型或者不同的初始参数。

**Executors 目前提供了 5 种不同的线程池创建配置**：

- （1）**newCachedThreadPool()**，它是一种用来处理大量短时间工作任务的线程池，具有几个鲜明特点：它会试图缓存线程并重用，当无缓存线程可用时，就会创建新的工作线程；如果线程闲置的时间超过 60 秒，则被终止并移出缓存；长时间闲置时，这种线程池，不会消耗什么资源。其内部使用 SynchronousQueue 作为工作队列。

- （2）**newFixedThreadPool(int nThreads)**，重用指定数目（nThreads）的线程，其背后使用的是无界的工作队列，任何时候最多有 nThreads 个工作线程是活动的。这意味着，如果任务数量超过了活动队列数目，将在工作队列中等待空闲线程出现；如果有工作线程退出，将会有新的工作线程被创建，以补足指定的数目 nThreads。

- （3）**newSingleThreadExecutor()**，它的特点在于工作线程数目被限制为 1，操作一个无界的工作队列，所以它保证了所有任务的都是被顺序执行，最多会有一个任务处于活动状态，并且不允许使用者改动线程池实例，因此可以避免其改变线程数目。

- （4）**newSingleThreadScheduledExecutor()** 和 **newScheduledThreadPool(int corePoolSize)**，创建的是个ScheduledExecutorService，可以进行定时或周期性的工作调度，区别在于单一工作线程还是多个工作线程。

- （5）newWorkStealingPool(int parallelism)，这是一个经常被人忽略的线程池，Java 8 才加入这个创建方法，其内部会构建ForkJoinPool，利用Work-Stealing算法，并行地处理任务，不保证处理顺序。



## 如何优雅地终止线程

线程池提供了两个方法来终止线程：shutdown()和shutdownNow()。

**shutdown()** 方法是一种很保守的关闭线程池的方法。线程池执行 shutdown() 后，就会拒绝接收新的任务，但是会等待线程池中正在执行的任务和已经进入阻塞队列的任务都执行完之后才最终关闭线程池。

而 **shutdownNow()** 方法，相对就激进一些了，线程池执行 shutdownNow() 后，会拒绝接收新的任务，同时还会中断线程池中正在执行的任务，已经进入阻塞队列的任务也被剥夺了执行的机会，不过这些被剥夺执行机会的任务会作为 shutdownNow() 方法的返回值返回。因为 shutdownNow() 方法会中断正在执行的线程，所以提交到线程池的任务，如果需要优雅地结束，就需要正确地处理线程中断。

如果提交到线程池的任务不允许取消，那就不能使用 shutdownNow() 方法终止线程池。不过，如果提交到线程池的任务允许后续以补偿的方式重新执行，也是可以使用 shutdownNow() 方法终止线程池的。

## 如何监控线程池

用一个 printStats 方法实现了最简陋的监控，每秒输出一次线程池的基本内部信息：

```JAVA
private void printStats(ThreadPoolExecutor threadPool) {
   Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
        log.info("=========================");
        log.info("Pool Size: {}", threadPool.getPoolSize());
        log.info("Active Threads: {}", threadPool.getActiveCount());
        log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
        log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());

        log.info("=========================");
    }, 0, 1, TimeUnit.SECONDS);
}
```

getPoolSize()：获取线程池的线程数量。如果线程池不销毁的话，线程池里的线程不会自动销毁。

getActiveCount()：获取活跃的线程数。

getCompletedTaskCount：获取线程池再运行过程中已完成的任务数量。

getQueue().size()：获取队列中还有多少积压任务。

---

写了两本 PDF，回复 **分布式** 和 **PDF** 下载分布式和 SpringCloud 教程。

我的 JVM 专栏已上架，回复 **JVM** 领取

回复 **Redis** 获取 Redis 开发手册 | 花果山版

![img](https://mmbiz.qpic.cn/mmbiz_png/SfAHMuUxqJ1Mh4vk6GSuD4mI0At8Vu6LGibGPC5ZkXdEKWfWn0b7JdCFNWaJM70aIdibmia9shsRxz86KR13r864g/640?wx_fmt=png)

![img](https://mmbiz.qpic.cn/mmbiz_png/SfAHMuUxqJ1Mh4vk6GSuD4mI0At8Vu6LicFWMmxJ0nJvPB2kibh0nwkdYjAA6GkzLDc7bavRSqVpbOjeaI3l5EXg/640?wx_fmt=png)
