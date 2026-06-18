PassJava 项目全套学习教程连载中，[关注公众号](#公众号)第一时间获取。

可落地的 Spring Cloud项目：`PassJava` https://github.com/Jackson0714/PassJava-Platform

## 此项目分为公开版和 VIP 版

VIP 版请加入我的星球获取。下方有扫码加入的方式。

> VIP 版提供全功能的的代码仓库，预计代码量在 2W+ 以上。
>
> VIP 版提供新开发功能的文档，计划 80+ 讲。公开版目前更新了 30+讲，且不系统。
>
> VIP 版提供更加规范和系统的文档 🌹
>
> VIP 版提供技术支持💪🏻
>
> VIP 版提供正确学习项目的路线☀️

![image-20230326094344901](http://cdn.passjava.cn/uPic/image-20230326094344901tF4uTBX6iqFqH8riqnvw656Q.png)

### 学习此项目能在简历上写些什么内容

**项目技术**: SpringBoot、SpringCloud、ElasticSearch、Mybatis、Redis、MySQL、Nacos、OpenFeign、 Gateway； 

**项目描述**: 该项目实现了一个在线答题、背题、刷题等功能的智慧在线学习平台。用户可以在小程序端进行在线在线答题。此项目可支撑 10W 人同时在线使用，并发量最高能达到 3000。

**项目亮点:** 

- 使用 SpringCloud Alibaba 微服务组件 Nacos 作为注册中心，使用 Sentinel 作为限流组件。
- 使用消息队列 RocketMQ 来进行大并发交卷的削峰，并利用 RocketMQ来实现分布式事务。
- 使用Spring Cloud Gateway + JWT实现登录认证； 
- 使用ElasticSearch实现中文题库的搜索功能，并支持高亮提示。 
- 使用Redisson分布式锁可以确保同一用户在同一时间只能提交一次试卷，避免因重复提交而导致的数据不一致或者重复操作。
- 使用 Redis 缓存试卷、题目，避免频繁查库，并保证缓存和数据库一致性。
- 使用ELK Stack进行日志采集，使用链路追踪 Skywalking 实现链路的追踪，性能分析。
- 使用 XXL-JOB 实现用户活跃度的统计、用户等级的更新、统计题目和试卷的评分等。

### 入场券

下面是一张星球入场券，星球里面有多个专栏小册：《DevOps 持续集成》、《SpringCloud 微服务架构原理》、《分布式协议原理》，无其他套路。

![](http://cdn.passjava.cn/uPic/xingqiu-2025xYGCEX.png)

# PassJava 学习教程

## 关于我

🌈InfoQ 签约作者、蓝桥签约作者、阿里云社区博客专家、51CTO Top红人。

🍭公众号：悟空聊架构，20000+ 技术爱好者关注。

💪🏻擅长微服务、分布式、架构设计。

🍎目前在一家上市公司从事基础架构建设工作。

[我的 B站](https://space.bilibili.com/493005591?spm_id_from=333.999.0.0)

![目录](http://cdn.passjava.cn/uPic/640tw1bSU.jpg)
### 技术支持🌈

> 因作者本人平时很忙，如果需要技术支持，请加入我的 VIP 答疑星球（下方扫码加入）。

星球提供以下服务：

一、专栏 

1、《Spring Cloud 微服务实战项目 PassJava》已更新30+❤️ 

2、《SpringCoud微服务架构原理》已更新16讲🚀 

3、《分布式协议原理剖析》已更新9讲🤟

 3、《Java并发编程原理剖析》已更新6讲🌴 

4、《ELK实战+原理剖析》已更新7讲🚗

 5、《毕设项目：基于ES的知识库系统》计划中🎉 等等正在持续更新中。

 二、与大牛零距离接触，赶快向嘉宾提问吧💪🏻

 三、简历修改+职场经验+内推机会🎁 

四、实际大型项目实战经验、架构原理和填坑指南🍎 

五、前沿技术探讨，如 ChatGPT 

六、星球打卡活动，赠书赠书赠书

![星球优惠券-100](http://cdn.passjava.cn/uPic/xingqiu-2025xYGCEX.png)


**悟空的多个技术专题**：

33 篇 SpringCloud 实战，回复PDF获取。

8 篇分布式算法文章，回复分布式获取。

7 篇JVM 专项训练，回复JVM获取。

Elasticsearch 筋斗云版蓝皮书1.0，回复ES获取

面试必备资料，关注公众号`悟空聊架构`即可获取。


## Java 学习路线（赛亚人版）

[🌈Java 学习路线（赛亚人版）](http://passjava.cn/#/01.%E9%A1%B9%E7%9B%AE%E7%AE%80%E4%BB%8B/9.Java%E5%AD%A6%E4%B9%A0%E8%B7%AF%E7%BA%BF)

## PassJava 部署教程

### 1、Mac M1 部署项目

[Mac M1 部署项目](http://www.passjava.cn/#/01.项目简介/7.本地部署项目Mac版):heavy_check_mark:

Windows 版正在更新中，可参考 Mac 版的部署教程。


前后端都在这个仓库：

后台代码地址：https://github.com/Jackson0714/PassJava-Platform

### 2、后端部署教程

[后端部署教程](http://www.passjava.cn/#/01.PassJava/01.Introduction/7.%E6%9C%AC%E5%9C%B0%E9%83%A8%E7%BD%B2%E9%A1%B9%E7%9B%AEMac%E7%89%88):heavy_check_mark: 

### 3、前端部署教程

[前端部署教程](https://github.com/Jackson0714/PassJava-Platform/tree/master/passjava-portal):heavy_check_mark:

前端 Vue 代码地址：https://github.com/Jackson0714/PassJava-Platform/tree/master/passjava-portal

### 小程序部署教程

 [小程序部署教程](https://github.com/Jackson0714/PassJava-Platform/blob/master/passjava-miniApp/README.md):heavy_check_mark:

小程序代码地址：https://github.com/Jackson0714/PassJava-Platform/tree/master/passjava-miniApp

## 简介

- PassJava-Learning项目是PassJava（佳必过）项目的学习教程。对架构、业务、技术要点进行讲解。
- PassJava 是一款Java`面试刷题`的开源系统，可以用零碎时间利用小程序查看常见面试题，夯实Java基础。
- PassJava 项目可以教会你如何搭建SpringBoot项目，Spring Cloud项目
- 采用流行的技术，如 SpringBoot、MyBatis、Redis、 MySql、 MongoDB、 RabbitMQ、Elasticsearch，采用Docker容器化部署。

## 更好的阅读体验

- 文档地址：[http://www.passjava.cn](http://www.passjava.cn)
- 备用地址1：[https://jackson0714.github.io/PassJava-Learning](https://jackson0714.github.io/PassJava-Learning/) 
- 备用地址2：http://jayh2018.gitee.io/passjava-learning/#/README

## PassJava 教程连载目录

关注公众号：悟空聊架构，回复 PDF 获取离线版教程。

- [打造一款 刷Java 知识的小程序](https://www.cnblogs.com/jackson0714/p/passJava1.html)
- [打造一款 刷Java 知识的小程序（二）](https://www.cnblogs.com/jackson0714/p/passJava2.html)
- [01.五分钟搞懂分布式基础概念](http://www.passjava.cn/#/03.Distributed/01.分布式基础概念)
- [02.快速搭建Linux环境-运维必备](http://www.passjava.cn/#/01.PassJava/03.Deploy/01.环境搭建篇)
- [03.配置虚拟机网络](http://www.passjava.cn/#/01.PassJava/03.Deploy/02.配置虚拟机网络)
- [04.安装Docker](http://www.passjava.cn/#/01.PassJava/03.Deploy/03.安装docker)
- [05.Docker安装mysql](http://www.passjava.cn/#/01.PassJava/03.Deploy/04.docker安装mysql)
- [06.Docker安装redis](http://www.passjava.cn/#/01.PassJava/03.Deploy/05.docker安装redis)
- [07.本地开发环境配置](http://www.passjava.cn/#/01.PassJava/03.Deploy/06.本地开发环境配置)
- [08.配置Git](http://www.passjava.cn/#/01.PassJava/03.Deploy/07.配置git)
- [09.初始化项目和添加微服务](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/01.创建项目和添加模块)
- [10.PassJava-微服务划分图](http://www.passjava.cn/#/01.项目简介/3.微服务划分图)
- [11.初始化数据库和表](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/02.创建数据库和表)
- [12.搭建管理后台](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/03.搭建管理后台)
- [13.自动生成前后端代码](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/04.自动生成前后端代码)
- [14.整合MyBatis-Plus实现CRUD](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/05.整合MyBatis-Plus实现CRUD)
- [15.生成所有微服务的CRUD代码](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/06.生成所有微服务的CRUD代码)
- [16.Spring Cloud Alibaba 组件简介](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/07.SpringCloudAlibaba组件简介)
- [17.SpringCloud整合Alibaba-Nacos注册中心](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/08.SpringCloud整合Alibaba-Nacos组件)
- [18.SpringCloud整合OpenFeign组件](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/09.SpringCloud整合OpenFeign组件)
- [19.SpringCloud整合Alibaba-Nacos配置中心](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/10.SpringCloud整合Nacos配置中心)
- [20.SpringCloud整合Gateway网关](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/11.SpringCloud整合Gateway网关)
- [21.管理后台-题目类型功能](http://www.passjava.cn/#/01.PassJava/04.PassJava_Business/01.管理后台-题目类型功能)
- [22.SpringCloud整合OSS对象存储](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/12.SpringCloud整合OSS对象存储)
- [23.整合统一异常处理](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/13.整合统一异常处理.md)
- [24.Elasticsearch上篇（原理）](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/14.Elasticsearch原理.md)
- [25.Elasticsearch中篇（实战）](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/15.Elasticsearch实战.md)
- [26.Elasticsearch下篇（集群部署）更新中](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/16.Elasticsearch集群部署.md)
- [27.微服务架构中的链路追踪](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/17.微服务架构中的链路追踪.md)
- [28.48张图手摸手教你性能压测](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/18.48张图手摸手教你性能压测.md)
- [29.缓存实战（一）](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/19.缓存实战（一）.md)
- [30.缓存实战（二）Redis分布式锁](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/22.缓存实战（二）Redis分布式锁.md)
- [31.缓存实战（三）Redisson分布式锁](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/23.缓存实战（三）Redisson分布式锁.md)
- [32.缓存实战（四）实战 Spring Cache](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/24.缓存实战（四）SpringCache.md)

## 小程序演示

![](https://static001.geekbang.org/infoq/1a/1a00670c3bb10bc125f7b91d9ca169b4.gif)

## 项目地址

[PassJava](https://github.com/Jackson0714/PassJava-Platform)

## 介绍

- [PassJava 架构及功能概览](http://www.passjava.cn/#/01.项目简介/2.项目微服务架构图)
- [PassJava 学习所需知识点](http://www.passjava.cn/#/01.项目简介/5.项目前置要求)

## 架构篇

> 手把手教你搭建一个PassJava 中使用的 SpringCloud框架

- [01.Spring Cloud Alibaba 组件简介](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/07.SpringCloudAlibaba组件简介)
- [02.SpringCloud整合Alibaba-Nacos注册中心](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/08.SpringCloud整合Alibaba-Nacos组件)
- [03.SpringCloud整合OpenFeign组件](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/09.SpringCloud整合OpenFeign组件)
- [04.SpringCloud整合Alibaba-Nacos配置中心](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/10.SpringCloud整合Nacos配置中心)
- [05.SpringCloud整合Gateway网关](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/11.SpringCloud整合Gateway网关)
- [06.SpringCloud整合OSS对象存储](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/12.SpringCloud整合OSS对象存储)
- [07.整合统一异常处理](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/13.整合统一异常处理)
- [08.Elasticsearch上篇（原理）](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/14.Elasticsearch原理)
- [09.Elasticsearch中篇（实战）](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/15.Elasticsearch实战.md)
- [10.Elasticsearch下篇（集群部署）更新中](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/16.Elasticsearch集群部署.md)
- [11.微服务架构中的链路追踪](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/17.微服务架构中的链路追踪.md)
- [12.48张图手摸手教你性能压测](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/18.48张图手摸手教你性能压测.md)
- [13.缓存实战（一）](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/19.缓存实战（一）.md)
- [14.缓存实战（二）Redis分布式锁](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/22.缓存实战（二）Redis分布式锁.md)
- [15.缓存实战（三）Redisson分布式锁](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/23.缓存实战（三）Redisson分布式锁.md)
- [16.缓存实战（四）实战 Spring Cache](http://www.passjava.cn/#/01.PassJava/02.PassJava_Architecture/24.缓存实战（四）SpringCache.md)


## Java并发多线程

> 从源码层面详细讲解并发多线程
> 关注公众号：悟空聊架构，回复`多线程`获取离线版教程。

  - [01.反制面试官-14张原理图-再也不怕被问volatile!](http://www.passjava.cn/#/10.并发多线程/01.反制面试官-14张原理图-再也不怕被问volatile!.md)
  - [02.我跟老婆讲CAS原理，被鄙视太简单！15张图-源码调试](http://www.passjava.cn/#/10.并发多线程/02.我跟老婆讲CAS原理-被鄙视太简单-15张图-源码调试.md)
  - [03.Java并发必知必会第三弹：用积木讲解ABA原理](http://www.passjava.cn/#/10.并发多线程/03.Java并发必知必会第三弹：用积木讲解ABA原理.md)
  - [04.全网最细-21张图带你领略集合的线程不安全](http://www.passjava.cn/#/10.并发多线程/04.全网最细-21张图带你领略集合的线程不安全.md)
  - [05.5000字-24张图带你彻底理解Java中的21种锁](http://www.passjava.cn/#/10.并发多线程/05.5000字-24张图带你彻底理解Java中的21种锁.md)
  - [06.干货-45张图庖丁解牛18种Queue，你知道几种？](http://www.passjava.cn/#/10.并发多线程/06.干货-45张图庖丁解牛18种Queue，你知道几种.md)


## 分布式

关注公众号：悟空聊架构，回复`分布式`获取离线版教程。

- [01.分布式基础概念](http://www.passjava.cn/#/03.Distributed/01.分布式基础概念.md)
- [02.这三年被分布式坑惨了，曝光十大坑](http://www.passjava.cn/#/03.Distributed/02.分布式中的十种坑.md)
- [03.用三国杀讲分布式算法，舒适了吧？](http://www.passjava.cn/#/03.Distributed/03.用三国杀讲分布式算法，舒适了吧？.md)
- [04.用太极拳讲分布式理论，舒服！](http://www.passjava.cn/#/03.Distributed/04.用太极拳讲分布式理论，舒服！.md)
- [05.诸葛VS庞统，拿下Paxos](http://www.passjava.cn/#/03.Distributed/05.诸葛VS庞统，拿下Paxos.md)
- [06.用动图讲解分布式Raft](http://www.passjava.cn/#/03.Distributed/06.用动图讲解分布式Raft.md)
- [07.韩信大招：一致性哈希](http://www.passjava.cn/#/03.Distributed/07.韩信大招：一致性哈希.md)
- [08.Gossip协议](http://www.passjava.cn/#/03.Distributed/08.Gossip协议.md)
- [09.QuorumNWR算法](http://www.passjava.cn/#/03.Distributed/09.QuorumNWR算法.md)
- [10.区块链12问和Pow算法](http://www.passjava.cn/#/03.Distributed/10.区块链12问.md)
- [11.Zookeeper中的ZAB协议](http://www.passjava.cn/#/03.Distributed/14.ZAB协议.md)

## 架构设计

  - [01.微服务架构中的两款流量防卫兵](http://www.passjava.cn/#/04.Architecture/01.架构图解/01.微服务架构中的两款流量防卫兵.md)
  - [02.浅析扣减库存的方案设计](http://www.passjava.cn/#/04.Architecture/01.架构图解/02.浅析扣减库存的方案设计.md)
  - [03.订单系统中的补偿事务设计](http://www.passjava.cn/#/04.Architecture/01.架构图解/03.订单系统中的补偿事务设计.md)
  - [04.请警惕Elasticsearch的三大坑](http://www.passjava.cn/#/04.Architecture/01.架构图解/04.请警惕Elasticsearch的三大坑.md)
  - [05.B站崩了，聊聊高可用和异地多活](http://www.passjava.cn/#/04.Architecture/01.架构图解/05.B站崩了，聊聊高可用和异地多活.md)
  - [06.查漏补缺，DDD领域驱动设计2022-02-15](http://www.passjava.cn/#/15.DDD领域驱动设计/01.查漏补缺，DDD领域驱动设计.md)
  - [07.自研简易版任务调度框架2022-03-04](http://www.passjava.cn/#/04.Architecture/01.架构图解/06.自研简易版任务调度框架2022-03-04.md)
  - [96.闲鱼架构演进](http://www.passjava.cn/#/04.Architecture/01.架构图解/96.闲鱼架构演进.md)
  - [97.京东白条数据架构演进](http://www.passjava.cn/#/04.Architecture/01.架构图解/97.京东白条数据架构演进.md)
  - [98.春晚红包架构](http://www.passjava.cn/#/04.Architecture/01.架构图解/98.春晚红包架构.md)
  - [99.淘宝架构10年](http://www.passjava.cn/#/04.Architecture/01.架构图解/99.淘宝架构10年.md)


## SpringCloud 架构剖析🔥🔥🔥

  - 注册中心Eureka
      - [01.Eureka基本原理和简单使用](http://www.passjava.cn/#/02.SpringCloud/01.Eureka注册中心/01.Eureka基本原理和简单使用.md)
      - [02.Eureka本地集群搭建](http://www.passjava.cn/#/02.SpringCloud/01.Eureka注册中心/02.Eureka本地集群搭建.md)
      - [03.Eureka源码之启动过程](http://www.passjava.cn/#/02.SpringCloud/01.Eureka注册中心/03.Eureka源码之启动过程.md)
      - [04.Eureka源码之客户端注册](http://www.passjava.cn/#/02.SpringCloud/01.Eureka注册中心/04.Eureka源码之客户端注册.md)
      - [05.Eureka源码之服务端接收注册信息](http://www.passjava.cn/#/02.SpringCloud/01.Eureka注册中心/05.Eureka源码之服务端接收注册信息.md)
      - [06.Eureka源码之客户端首次获取注册表](http://www.passjava.cn/#/02.SpringCloud/01.Eureka注册中心/06.Eureka源码之客户端首次获取注册表.md)
      - [07.Eureka源码之客户端增量获取注册表](http://www.passjava.cn/#/02.SpringCloud/01.Eureka注册中心/07.Eureka源码之客户端增量获取注册表.md)
      - [08.Eureka源码之Server端的多级缓存机制](http://www.passjava.cn/#/02.SpringCloud/01.Eureka注册中心/08.Eureka源码之Server端的多级缓存机制.md)
      - [98.Eureka控制台参数说明](http://www.passjava.cn/#/02.SpringCloud/01.Eureka注册中心/98.Eureka控制台参数说明.md)
  - 负载均衡Ribbon
      - [01.Ribbon架构剖析](http://www.passjava.cn/#/02.SpringCloud/02.Ribbon负载均衡/01.Ribbon架构剖析.md)
  - 远程调用Feign
      - [01.Feign远程调用基本原理和使用](http://www.passjava.cn/#/02.SpringCloud/03.Feign远程调用/01.Feign远程调用基本原理和使用.md)
      - [02.Feign架构剖析](http://www.passjava.cn/#/02.SpringCloud/03.Feign远程调用/02.Feign架构剖析.md)
  - 熔断限流Hystrix
    - [01.Hystrix架构剖析](http://www.passjava.cn/#/02.SpringCloud/04.Hystrix限流熔断器/01.Hystrix架构剖析.md)
  - Gateway网关
    - [01.SpringCloud整合Gateway网关](02.SpringCloud/06.Gateway网关/01.SpringCloud整合Gateway网关.md)
    - [02.深入浅入Gateway](http://www.passjava.cn/#/02.SpringCloud/06.Gateway网关/02.深入浅入Gateway.md)
  - Nacos配置注册中心
    - [01.使用Nacos作为注册中心](http://www.passjava.cn/#/02.SpringCloud/07.Nacos配置注册中心/01.使用Nacos作为注册中心和配置中心.md)
    - [02.Nacos架构原理①：一条注册请求会经历什么？](http://www.passjava.cn/#/02.SpringCloud/07.Nacos配置注册中心/02.Nacos架构原理①：一条注册请求会经历什么？.md)
    - [03.Nacos架构原理②：揭秘AP架构——Distro一致性协议](http://www.passjava.cn/#/02.SpringCloud/07.Nacos配置注册中心/03.Nacos架构原理②：揭秘AP架构——Distro一致性协议.md)
  - Sentinel限流
    - [01.Hystrix和Sentinel选型对比](http://www.passjava.cn/#/02.SpringCloud/08.Sentinel限流/01.Hystrix和Sentinel选型对比.md)

## 用故事讲解技术

  * 中间件选型
    - [01.如果把4个「消息队列」都在一个群里，他们会聊什么？](http://www.passjava.cn/#/04.Architecture/03.用故事讲解技术/01.中间件选型/01.如果消息队列都在一个群里，他们会聊什么？.md)
    - [02.如果把4个「链路追踪」组件放到一个群里，他们会聊些什么？](http://www.passjava.cn/#/04.Architecture/03.用故事讲解技术/01.中间件选型/02.链路追踪如何选型)
  * 高可用
    * [01.东汉末年，他们把熔断限流玩到了极致](http://www.passjava.cn/#04.Architecture/03.用故事讲解技术/02.高可用/01.东汉末年，他们把熔断限流玩到了极致.md)
    * [02.我是一个秒杀请求，正在逃离这颗星球](http://www.passjava.cn/#/04.Architecture/03.用故事讲解技术/02.高可用/02.我是一个秒杀请求，正在逃离这颗星球.md)
    * [03.为什么要除夕，原来是内存爆了](http://www.passjava.cn/#/04.Architecture/03.用故事讲解技术/02.高可用/03.为什么要除夕，原来是内存爆了.md)


## 面试必背
- [01.Redis 面试题汇总 第一季](http://www.passjava.cn/#/88.Interview/01.Redis/Redis1.md)
- [02.并发编程 面试突击](http://www.passjava.cn/#/88.Interview/02.Thread/Thread1.md)
- [03.MySQL 面试突击](http://www.passjava.cn/#/88.Interview/03.Database/MySQL1.md)
- [04.JVM 面试突击](http://www.passjava.cn/#/88.Interview/04.JVM/JVM1.md)
- 05.设计模式
    - [01.观察者模式ObserverPattern](http://www.passjava.cn/#/88.Interview/05.DesignPattern/01.观察者模式ObserverPattern.md)
    - [02.备忘录模式MementoPattern](http://www.passjava.cn/#/88.Interview/05.DesignPattern/02.备忘录模式MementoPattern.md)
    - [03.原型模式PrototypePattern](http://www.passjava.cn/#/88.Interview/05.DesignPattern/03.原型模式PrototypePattern.md)
    -[04.中介者模式MediatorPattern](http://www.passjava.cn/#/88.Interview/05.DesignPattern/04.中介者模式MediatorPattern.md)


## 悟空学习群问题汇总
- [01.悟空群聊问题20201026-删除binlog问题](http://www.passjava.cn/#/102.学习群问题汇总/01.20201026_删除binlog问题.md)
- [02.悟空群聊问题20201028_导出报表问题](http://www.passjava.cn/#/102.学习群问题汇总/02.20201028_导出报表问题.md)
- [03.悟空群聊问题20201030_List和ArrayList如何选择](http://www.passjava.cn/#/102.学习群问题汇总/03.20201030_List和ArrayList如何选择.md)
## 群成员学习分享
- [01.Nginx Location 正则](http://www.passjava.cn/#/104.群成员学习分享/01.NginxLocation正则.md)

## JVM
- [01.50+道JVM面试题+11张思维导图就是让你懂JVM](http://www.passjava.cn/#/06.Java核心知识/04.JVM进阶/01.50+道JVM面试题+11张思维导图就是让你懂JVM.md)
- [02.秒懂JVM的三大参数类型，就靠这十个小实验了](http://www.passjava.cn/#/06.Java核心知识/04.JVM进阶/02.秒懂JVM的三大参数类型，就靠这十个小实验了.md)
- [98.字节码指令表](http://www.passjava.cn/#/06.Java核心知识/04.JVM进阶/98.字节码指令表.md)
- [99.JVM参数列表](http://www.passjava.cn/#/06.Java核心知识/04.JVM进阶/99.JVM参数列表.md)

## 工具篇

> 一些常用开发工具的使用

- [01.自定义Markdown神器Typora的主题样式](https://juejin.im/post/6864745378558771214)
- [02.使用docsify写开源文档](http://www.passjava.cn/#/99.tools/02.使用docsify写开源文档)
- [03.Git同时上传到码云和github](https://juejin.im/post/6859388700858679303)
- [04.图床神器配置](http://www.passjava.cn/#/99.tools/04.图床神器配置)
- [05.我的常用工具](http://www.passjava.cn/#/99.tools/05.我的常用工具)
- [06.Idea的十八般武艺](http://www.passjava.cn/#/99.tools/06.Idea的十八般武艺)
- [07.画架构原理图，还是它好使](http://www.passjava.cn/#/99.tools/07.画架构原理图，还是它好使)
- [08.添加Gitee密钥](http://www.passjava.cn/#/99.tools/08.添加Gitee密钥)
- [09.给自己的博客docsify加上评论功能](http://www.passjava.cn/#/99.tools/09.给自己的博客docsify加上评论功能)
- [91.Maven配置](http://www.passjava.cn/#/99.tools/91.Maven配置)
- [92.Java环境问题](http://www.passjava.cn/#/99.tools/92.Java环境问题)
- [93.IDEA快捷键](http://www.passjava.cn/#/99.tools/93.IDEA快捷键)
- [94.Ubuntu16.04安装最新版nodejs](http://www.passjava.cn/#/99.tools/94.Ubuntu16_04安装最新版nodejs)
- [95.VSCode快速生成Vue模板](http://www.passjava.cn/#/99.tools/95.VSCode快速生成Vue模板)
- [96.HTML特殊符号](http://www.passjava.cn/#/99.tools/96.HTML特殊符号)
- [97.IDEA设置代码彩虹颜色](http://www.passjava.cn/#/99.tools/97.IDEA设置代码彩虹颜色)
- [98.IDEA调试Java多线程](http://www.passjava.cn/#/99.tools/98.IDEA调试Java多线程)
- [99.IDEA调试Java源码](http://www.passjava.cn/#/99.tools/99.IDEA调试Java源码)

## 业务篇

> 全面解析 PassJava 中使用的数据库表结构和功能

## SpringBoot 学习篇

> PassJava 中一些功能的技术要点解析

- [05.SpringBoot整合Jdbc](http://www.passjava.cn/#/03.SpringBoot学习篇/spring-boot-05-data-jdbc.md)
- [06.SpringBoot整合Druid](http://www.passjava.cn/#/03.SpringBoot学习篇/spring-boot-06-data-druid.md)
- [07.spring-boot-05-data-jdbc](http://www.passjava.cn/#/03.SpringBoot学习篇/spring-boot-07-data-mybatis.md)
- [08.SpringBoot Mybatis逻辑删除](http://www.passjava.cn/#/03.SpringBoot学习篇/08.SpringBoot-Mybatis逻辑删除.md)
- [09.Object划分](http://www.passjava.cn/#/03.SpringBoot学习篇/09.Object划分.md)

## 部署篇

> PassJava 开发及生产环境的搭建

- [01.快速搭建Linux环境-运维必备](http://www.passjava.cn/#/01.PassJava/03.Deploy/01.环境搭建篇)
- [02.配置虚拟机网络](http://www.passjava.cn/#/01.PassJava/03.Deploy/02.配置虚拟机网络)
- [03.安装Docker](http://www.passjava.cn/#/01.PassJava/03.Deploy/03.安装docker)
- [04.Docker安装mysql](http://www.passjava.cn/#/01.PassJava/03.Deploy/04.docker安装mysql)
- [05.Docker安装redis](http://www.passjava.cn/#/01.PassJava/03.Deploy/05.docker安装redis)
- [06.本地开发环境配置](http://www.passjava.cn/#/01.PassJava/03.Deploy/06.本地开发环境配置)
- [07.配置Git](http://www.passjava.cn/#/01.PassJava/03.Deploy/07.配置git)

## LeetCode刷题
- [LeetCode数组第一题](http://www.passjava.cn/#/92.LeetCode算法题/01.数组/001.两数之和-数组-LeetCode第1题)


## 公众号

PassJava 项目全套学习教程连载中，关注公众号「**PassJava666**」第一时间获取。

![公众号图片](http://cdn.passjava.cn/blog/20200910/dBsGAx0fBgC2.png?imageslim)