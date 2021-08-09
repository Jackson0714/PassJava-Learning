线程池问题汇总：

* [x] 线程池的原理？ 07-30
* [x] 阻塞队列有哪几种？07-31
* [ ] 线程池如何使用？
* [x] 线程池有几种状态？08-03
* [x] 线程池的拒绝策略有哪几种？08-02
* [x] 多线程创建多少个线程合适？08-01
* [x] Java 线程池有哪几种？08-04
* [x] 线程池如何监控？
* [ ] Executor 框架？
* [x] Executor 有哪几种线程池？



# 什么是 AQS

AbstractQueuedSynchronizer 类如其名，抽象的队列式的同步器，将基础的同步相关操作抽象在 AbstractQueuedSynchronizer 中，利用 AQS 为我们构建同步结构提供了范本。

AQS定义了一套多线程访问共享资源的同步器框架，许多同步类实现都依赖于它，如常用的ReentrantLock/Semaphore/CountDownLatch。

将基础的同步相关操作抽象在 AbstractQueuedSynchronizer 中，利用 AQS 为我们构建同步结构提供了范本。

AQS 内部数据和方法，可以简单拆分为：

- 一个 volatile 的整数成员表征状态，同时提供了 setState 和 getState 方法。

- 一个先入先出（FIFO）的等待线程队列，以实现多线程间竞争和等待，这是 AQS 机制的核心之一。

- 各种基于 CAS 的基础操作方法，以及各种期望具体同步结构去实现的 acquire/release 方法。

利用 AQS 实现一个同步结构，至少要实现两个基本类型的方法，分别是 acquire 操作，获取资源的独占权；还有就是 release 操作，释放对某个资源的独占。

# Java 线程池的原理知道吗？

## 线程池的好处

- 降低资源消耗。重复利用已创建的线程降低线程创建和销毁造成的消耗。
- 提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
- 提高线程的可管理性。线程是稀缺资源，如果频繁创建，会消耗系统资源，降低系统稳定性，使用线程池统一分配、调优和监控。

## 线程池有核心参数：

1. maximumPoolSize：最大线程数。线程池允许创建的最大线程数。

2. corePoolSize：核心线程数。当提交一个任务到线程池时，线程池会创建一个线程来执行任务，即使其他空闲的核心线程能够执行新任务也会创建线程，等到 需要执行的任务数大于线程池基本大小时就不再创建。如果调用了线程池的 prestartAllCoreThreads() 方法，则线程池会提前创建并启动所有基本线程。

3. keepAliveTime：线程活动保持时间 ，线程池的工作线程空闲后，保持存活的时间。

4. runnableTaskQueue：任务队列，用于保存等待执行的任务的阻塞队列。有四种：ArrayBlockingQueue、LinkedBlockingQueue、SynchronousQueue、PriorityBlockingQueue。。

5. RejectedExecutionHandler 拒绝策略。当队列和线程满了后，采取一种策略处理提交的新任务。

## 线程池执行流程

当提交一个新任务到线程池时，具体的执行流程如下：

1. 当我们提交任务，线程池会根据 corePoolSize 大小创建若干任务数量线程执行任务
2. 当任务的数量超过 corePoolSize 数量，后续的任务将会进入阻塞队列阻塞排队。
3. 当阻塞队列也满了之后，那么将会继续创建（maximumPoolSize-corePoolSize）个数量的线程来执行任务，如果任务处理完成，maximumPoolSize-corePoolSize 额外创建的线程等待 keepAliveTime 之后被自动销毁
4. 如果达到 maximumPoolSize，阻塞队列还是满的状态，那么将根据不同的拒绝策略对应处理。

# 线程池中的阻塞队列有哪几种？

阻塞队列用于保存等待执行的任务。当任务的数量超过 corePoolSize 数量，后续的任务将会进入阻塞队列，阻塞排队。

有以下几种阻塞队列：

## ArrayBlockingQueue

是一个基于数组结构的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行排序。

![](http://cdn.jayh.club/blog/20210731/R6PjbpiGGuym.png?imageslim)

- ArrayBlockingQueue是一个用数组实现的有界阻塞队列。
- 队列慢时插入操作被阻塞，队列空时，移除操作被阻塞。
- 按照先进先出（FIFO）原则对元素进行排序。
- 默认不保证线程公平的访问队列。
- 公平访问队列：按照阻塞的先后顺序访问队列，即先阻塞的线程先访问队列。
- 非公平性是对先等待的线程是非公平的，当队列可用时，阻塞的线程都可以争夺访问队列的资格。有可能先阻塞的线程最后才访问访问队列。
- 公平性会降低吞吐量。

## LinkedBlockingQueue

一个基于链表结构的阻塞队列，此队列按 FIFO 排序元素，吞吐量通常要高于 ArrayBlockingQueue。静态工厂方法 Executors.newFixedThreadPool() 使用了这个队列。（newFixedThreadPool 用于创建固定线程数）

![图片](https://mmbiz.qpic.cn/mmbiz_png/SfAHMuUxqJ15FD3ebksZdnZeeWicsyDnJ52Nwoq0ticKZDgBHXwCC1rrweeTm36fsXzu2tqKF2c80rrK4xdMbK1Q/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)LinkedBlockingQueue 原理

- LinkedBlockingQueue具有单链表和有界阻塞队列的功能。
- 队列慢时插入操作被阻塞，队列空时，移除操作被阻塞。
- 默认和最大长度为Integer.MAX_VALUE，相当于无界(值非常大：2^31-1)。

## SynchronousQueue

一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于 LinkedBlockingQueue，静态工厂方法 Executors.newCachedThreadPool 使用这个队列。（newCachedThreadPool 用于根据需要创建新线程）

![](https://mmbiz.qpic.cn/mmbiz_png/SfAHMuUxqJ15FD3ebksZdnZeeWicsyDnJ6zTDxpibX2gqloNEdHILkibMVpfiacObUMGxV3RHVZ5Ou42nVwpFEvqjQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)SynchronousQueue 原理

- 我称SynchronousQueue为”传球好手“。想象一下这个场景：小明抱着一个篮球想传给小花，如果小花没有将球拿走，则小明是不能再拿其他球的。
- SynchronousQueue负责把生产者产生的数据传递给消费者线程。
- SynchronousQueue本身不存储数据，调用了put方法后，队列里面也是空的。
- 每一个put操作必须等待一个take操作完成，否则不能添加元素。
- 适合传递性场景。
- 性能高于ArrayBlockingQueue 和 LinkedBlockingQueue。

## PriorityBlockingQueue

一个具有优先级的无限阻塞队列。

![](https://mmbiz.qpic.cn/mmbiz_png/SfAHMuUxqJ15FD3ebksZdnZeeWicsyDnJv5KNjwGPMD1vcFKu1LQ1pCiaAQARA1icReSHTNCHo2QDic3kUpxDe022Q/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)PriorityBlockQueue的原理图

- PriorityBlockQueue = PriorityQueue + BlockingQueue
- 之前我们也讲到了PriorityQueue的原理，支持对元素排序。
- 元素默认自然排序。
- 可以自定义CompareTo()方法来指定元素排序规则。
- 可以通过构造函数构造参数Comparator来对元素进行排序。

之前写过一篇文章：[干货 | 45张图庖丁解牛18种Queue，你知道几种？](https://mp.weixin.qq.com/s/1cWszX8MWXq_XNMXNyeDMg)

# 多线程创建多少个合适？

## CPU 密集型

CPU 密集型计算：大部分场景下都是纯 CPU 计算。

对于 CPU 密集型计算，多线程本质上是提升多核 CPU 的利用率，所以对于一个 4 核的 CPU，每个核一个线程，理论上创建 4 个线程就可以了，再多创建线程也只是增加线程切换的成本。

理论上“线程的数量 =CPU 核数”就是最合适的。不过在工程上，线程的数量一般会设置为“CPU 核数 +1”，这样的话，当线程因为偶尔的内存页失效或其他原因导致阻塞时，这个额外的线程可以顶上，从而保证 CPU 的利用率。

## IO 密集型

由于 I/O 设备的速度相对于 CPU 来说都很慢，所以大部分情况下，I/O 操作执行的时间相对于 CPU 计算来说都非常长，这种场景我们一般都称为 I/O 密集型计算。

最佳线程数 = CPU 核数 * [ 1 +（I/O 耗时 / CPU 耗时）]

# 线程池的拒绝策略

如果线程池中所有的线程都在忙碌，并且工作队列也满了（前提是工作队列是有界队列），那么此时提交任务，线程池就会拒绝接收。至于拒绝的策略，你可以通过 handler 这个参数来指定。

ThreadPoolExecutor 已经提供了以下 4 种策略。

- CallerRunsPolicy：提交任务的线程自己去执行该任务。
- AbortPolicy：默认的拒绝策略，会 throws RejectedExecutionException。
- DiscardPolicy：直接丢弃任务，没有任何异常抛出。
- DiscardOldestPolicy：丢弃最老的任务，其实就是把最早进入工作队列的任务丢弃，然后把新任务加入到工作队列。

以上内置拒绝策略均实现了 RejectedExecutionHandler 接口，若以上策略仍无法满足实际需要，完全可以自己扩展 RejectedExecutionHandler 接口。

# 线程池的生命周期

线程池生命周期包括:

- RUNNING：接收新的任务并处理队列中的任务
- SHUTDOWN：不接收新的任务，但是处理队列中的任务
- STOP：不接收新的任务，不处理队列中的任务，同时中断处理中的任务
- TIDYING：所有的任务处理完成，有效的线程数是0
- TERMINATED：terminated() 方法执行完毕。

生命周期状态和方法对应的关系：

![](http://cdn.jayh.club/blog/20210803/eLi3jz0AV83c.png?imageslim)

# Java 线程池有哪几种？

通常开发者都是利用 Executors 提供的通用线程池创建方法，去创建不同配置的线程池，主要区别在于不同的 ExecutorService 类型或者不同的初始参数。

Executors 目前提供了 5 种不同的线程池创建配置：

（1）newCachedThreadPool()，它是一种用来处理大量短时间工作任务的线程池，具有几个鲜明特点：它会试图缓存线程并重用，当无缓存线程可用时，就会创建新的工作线程；如果线程闲置的时间超过 60 秒，则被终止并移出缓存；长时间闲置时，这种线程池，不会消耗什么资源。其内部使用 SynchronousQueue 作为工作队列。

（2）newFixedThreadPool(int nThreads)，重用指定数目（nThreads）的线程，其背后使用的是无界的工作队列，任何时候最多有 nThreads 个工作线程是活动的。这意味着，如果任务数量超过了活动队列数目，将在工作队列中等待空闲线程出现；如果有工作线程退出，将会有新的工作线程被创建，以补足指定的数目 nThreads。

（3）newSingleThreadExecutor()，它的特点在于工作线程数目被限制为 1，操作一个无界的工作队列，所以它保证了所有任务的都是被顺序执行，最多会有一个任务处于活动状态，并且不允许使用者改动线程池实例，因此可以避免其改变线程数目。

（4）newSingleThreadScheduledExecutor() 和 newScheduledThreadPool(int corePoolSize)，创建的是个ScheduledExecutorService，可以进行定时或周期性的工作调度，区别在于单一工作线程还是多个工作线程。

（5）newWorkStealingPool(int parallelism)，这是一个经常被人忽略的线程池，Java 8 才加入这个创建方法，其内部会构建ForkJoinPool，利用Work-Stealing算法，并行地处理任务，不保证处理顺序。



# 如何优雅地终止线程

线程池提供了两个方法来终止线程：shutdown()和shutdownNow()。

**shutdown()** 方法是一种很保守的关闭线程池的方法。线程池执行 shutdown() 后，就会拒绝接收新的任务，但是会等待线程池中正在执行的任务和已经进入阻塞队列的任务都执行完之后才最终关闭线程池。

而 **shutdownNow()** 方法，相对就激进一些了，线程池执行 shutdownNow() 后，会拒绝接收新的任务，同时还会中断线程池中正在执行的任务，已经进入阻塞队列的任务也被剥夺了执行的机会，不过这些被剥夺执行机会的任务会作为 shutdownNow() 方法的返回值返回。因为 shutdownNow() 方法会中断正在执行的线程，所以提交到线程池的任务，如果需要优雅地结束，就需要正确地处理线程中断。

如果提交到线程池的任务不允许取消，那就不能使用 shutdownNow() 方法终止线程池。不过，如果提交到线程池的任务允许后续以补偿的方式重新执行，也是可以使用 shutdownNow() 方法终止线程池的。

# 如何监控线程池

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

