   



# RocketMQ 原理 - 自动创建 Topic 机制

来源：https://juejin.cn/post/7003999365173870605



> RocketMQ 源码版本 4.9.1

下载了 RocketMQ 源码，在本地 IDE 中正常启动了 Broker 服务 和 NameServer 服务。

生产者发送消息的 demo 如下

![](http://cdn.jayh.club/uPic/a7ace23b03994001b174efa421f3ce2e~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-202209281919365373ZHrtl.awebp)

在发送消息的过程中报错了，报错信息如下

![](http://cdn.jayh.club/uPic/4b9f065760514782a6263976deceaf86~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191936572cDCNy6.awebp)

从报错信息可以看到： \*\*Topic 对应的路由信息没有正常获取到（Topic 名称为 TopicTest）。\*\*也难怪，Broker 启动后没有人为地去创建 Topic 对应的队列，发送消息自然没办法获取到路由信息。

想到 Broker 有自动创建 Topic 的机制，可以通过在 Broker 的配置文件中添加如下配置：

```
autoCreateTopicEnable = true
复制代码
```

**问题在于即使配置了这个参数，重启 Broker 服务之后，发送消息时还是如上的报错，因此打算仔细看看 RocketMQ 自动创建 Topic 的实现原理。**

## 自动创建Topic机制

首先需要解决两个问题

-   W1：Broker 注册路由信息方式
-   W2：生产者获取路由信息的策略

### 路由信息注册（Broker）

-   Broker 节点在启动时会先初始化当前 Broker 的路由信息，根据 autoCreateTopicEnable 参数的配置情况决定是否要添加【默认主题】的路由信息
-   Broker 节点会定期向 NameServer 注册路由信息

路由信息主要包含的内容

-   当前 Broker 节点存在的 Topic 列表
-   每个 Topic 对应的队列分配情况（读写队列数量）

1.Broker 节点启动时，会开启一个定时任务，定期向 NameServer 注册路由信息

![](http://cdn.jayh.club/uPic/2a609e1d18164d9b9f88b66d61d819d7~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191936608HmLJXN.awebp)

2.调用具体的注册方法，topicConfigWrapper 对象中包含本次需要注册的路由信息

![](http://cdn.jayh.club/uPic/fd2b0c18675c43efa29668d85fae4be1~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-202209281919366432QtQdQ.awebp)

3.topicConfigWrapper 对象的构建过程，其实是把 topicConfigTable 对象包装了一层

![](http://cdn.jayh.club/uPic/5d9e7a2f85c449f7b6b9d53d841506a9~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191936679mW2UBU.awebp)

4.topicConfigTable 对象类型为 ConcurrentMap，Map 的 Key 为 Topic 名称，Value 为 Topic 对应的路由信息（包含读写队列数量信息）

![](http://cdn.jayh.club/uPic/df6f32d1022445afb6b48c1ca6c57af5~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191936720j7P3iN.awebp)

5.下面看到 topicConfigTable 对象的初始化过程，主要看到关于【自动创建 Topic】 的逻辑，其它代码先省略（初始化了一系列系统预设的 Topic 路由信息）

-   判断 Broker 是否开启了自动创建 Topic 的开关，即开头讲的 autoCreateTopicEnable = true 的配置
-   如果开启了自动创建 Topic，则会往 topicConfigTable 对象中放入一个【默认主题】的路由信息， 名称为 TBW102，这边将它称为【TBW102默认路由信息】
-   因此最终往 NameServer 中注册的路由信息包含 【TBW102默认路由信息】

![](http://cdn.jayh.club/uPic/6406d5c3d43c42a8bb33027316093734~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191936756ETjvk7.awebp)

### 路由信息获取（生产者）

-   生产者发送消息时，会根据当前消息指定的 Topic 查询路由信息，如果本地缓存没有查询到，则尝试从 NameServer 服务查询
-   当没有查询到指定 Topic 的路由信息时，会使用系统【默认主题】的名称再次尝试查询路由，如果查询到【默认主题】的路由信息，则正常发送消息

1.发送消息前，先尝试获取消息对应 Topic 的路由信息

![](http://cdn.jayh.club/uPic/04269b70983f4e0a8f7972c897e24a03~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191936792dXqNl1.awebp)

2.获取路由信息

![](http://cdn.jayh.club/uPic/3d0ae36051964032abbf758058515d91~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191936830dSjzFq.awebp)

3.获取默认的路由信息，如果 isDefault = true，则尝试获取【默认主题】的路由信息， Topic 名称为 TBW102（与 Broker 注册的默认主题的路由名称相同）

![](http://cdn.jayh.club/uPic/3c9af01c06334f91a6c3a12734043cff~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191936871qrwbAy.awebp)

### 创建路由信息（Broker）

Broker 接收到消息之后，会先检查消息的 Topic 是否存在；如果消息对应的 Topic 不存在，且 Broker 允许自动创建不存在的 Topic，则会自动创建 Topic。

1.先检查 Topic 的路由信息是否存在，如果不存在，则自动创建 Topic

![](http://cdn.jayh.club/uPic/d4e76b8c8a044eb9a3f4b97ae438c161~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191936907ejQKfs.awebp)

2.具体自动创建 Topic 的操作，通过检查路由信息中是否包含【默认主题】的路由来判断 Broker 是否开启了自动创建 Topic

![](http://cdn.jayh.club/uPic/3fead0ab7a124c99bfad7416f37176cd~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191936948sbXlSj.awebp)

### 整体流程

我把自动创建 Topic 的流程概括为【偷梁换柱】，这个活是由 Broker，NameServer，生产者配合完成的

-   生产发送消息时，如果指定的 Topic 不存在，NameServer 会返回一个【默认主题】的路由信息，使得生产者能够正常发生消息
    
-   Broker 收到消息后，发现消息对应 Topic 不存在，且 Broker 允许自动创建 Topic，则会为消息创建 Topic ，并定时把路由信息同步至 NameServer
    
-   生产者也会定时从 NameServer 同步最新的路由信息，缓存至本地
    
-   后续生产者发送消息时，就可以从本地的缓存中查询到对应 Topic 的路由信息了
    

![](http://cdn.jayh.club/uPic/972fc826c5be423ba86381c79e89cbb0~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191936982Cn7Hac.awebp)

### 问题解决

了解了 Broker 自动创建 Topic 的原理，很快便解决了我的问题。

为什么即使 Broker 配置了自动创建不存在的 Topic，发送消息时还是会出现 Topic 路由信息无法获取的现象？ 原因如下

-   发送消息的 demo 中引入的 RocketMQ 版本为 4.3.0
-   本地启动的 Broker 服务，RocketMQ 版本为 4.9.1
-   两个版本中对于【默认主题】的命名不一致，所以导致 Broker 虽然向 NameServer 注册了【默认主题】的路由信息，生产者也获取不到

4.3.0 版本【默认主题】的名称为【AUTO\_CREATE\_TOPIC\_KEY】

![](http://cdn.jayh.club/uPic/c25657f87aee41eaac8ef795b69d7bc5~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191937037RcS5Iv.awebp)

4.9.1 版本【默认主题】的名称为【TBW102】

![](http://cdn.jayh.club/uPic/99ab4babe07846529a029e0f2ed1c4b2~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-202209281919370757ZjTvq.awebp)

因为 Broker 服务是通过本地源码启动的，于是我更改了源码中对于【默认主题】命名，使得两边【默认主题】的命名保持一致，并重新启动 Broker 服务

![](http://cdn.jayh.club/uPic/8da8f06ddf284299acedb25f0542cbce~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191937110hzA1Mt.awebp)

生产者成功发送消息，问题解决。

![](http://cdn.jayh.club/uPic/f6e99856b3e34fb28ffb25bf8617017a~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0-20220928191937147xrAxz4.awebp)



