线程池问题汇总：

* [x] 线程池的原理？ 07-30
* [x] 阻塞队列有哪几种？07-31
* [ ] 线程池如何使用？
* [ ] 线程池有几种状态？
* [x] 线程池的拒绝策略有哪几种？08-02
* [x] 多线程创建多少个线程合适？08-01
* [ ] 如何合理配置线程池参数？
* [ ] 线程池如何监控？
* [ ] Executor 框架？
* [ ] Executor 有哪几种线程池？

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

![](http://cdn.jayh.club/blog/20210803/jMDbGBMxL7gE.png?imageslim)

