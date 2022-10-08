# 聊聊 MyBatis 缓存

你好，我是悟空。

## 前言

最近在帮朋友制作一些 MyBatis 缓存的面试题，围绕 MyBatis 的一级缓存、二级缓存（全局缓存）、自定义缓存进行出题。

下面我会对这几个内容进行讲解。

## MyBatis 缓存中的常用概念

MyBatis 缓存：它用来优化 SQL 数据库查询的，但是可能会产生脏数据。

SqlSession：代表和数据库的一次会话，向用户提供了操作数据库的方法。

MappedStatement：代表要发往数据库执行的指令，可以理解为是 SQL 的抽象表示。

Executor： 代表用来和数据库交互的执行器，接受 MappedStatment 作为参数。

namespace：每个 Mapper 文件只能配置一个 namespace，用来做 Mapper 文件级别的缓存共享。

映射接口：定义了一个接口，然后里面的接口方法对应要执行 SQL 的操作，具体要执行的 SQL 语句是写在映射文件中。

映射文件：MyBatis 编写的 XML 文件，里面有一个或多个 SQL 语句，不同的语句用来映射不同的接口方法。通常来说，每一张单表都对应着一个映射文件。

## MyBatis 一级缓存

### 一级缓存原理

在一次数据库会话中，程序执行多次查询，且查询条件完全相同，多次查询之间程序没有其他增删改操作，则第二次及后面的查询可以从缓存中获取数据，避免走数据库。

![](http://cdn.jayh.club/uPic/image-20221004155156880Hk5ZsX.png)

每个SqlSession中持有了Executor，每个Executor中有一个LocalCache。当用户发起查询时，MyBatis根据当前执行的语句生成`MappedStatement`，在Local Cache进行查询，如果缓存命中的话，直接返回结果给用户，如果缓存没有命中的话，查询数据库，结果写入`Local Cache`，最后返回结果给用户。

### 一级缓存配置

在 mybatis-config.xml 文件配置，name=localCacheScope，value有两种值：SESSION 和 STATEMENT

```xml
<configuration>
    <settings>
        <setting name="localCacheScope" value="SESSION"/>
    </settings>
<configuration>
```



## MyBatis 二级缓存



## MyBatis 自定义缓存