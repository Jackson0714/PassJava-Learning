# 聊聊 MyBatis 缓存

[TOC]



你好，我是悟空。

本文主要内容如下：

![image-20221019162136436](http://cdn.jayh.club/uPic/image-20221019162136436eTEJRc.png)



## 一、MyBatis 缓存中的常用概念

**MyBatis 缓存**：它用来优化 SQL 数据库查询的，但是可能会产生脏数据。

**SqlSession**：代表和数据库的一次会话，向用户提供了操作数据库的方法。

**MappedStatement**：代表要发往数据库执行的指令，可以理解为是 SQL 的抽象表示。

**Executor**： 代表用来和数据库交互的执行器，接受 MappedStatment 作为参数。

**namespace**：每个 Mapper 文件只能配置一个 namespace，用来做 Mapper 文件级别的缓存共享。

**映射接口**：定义了一个接口，然后里面的接口方法对应要执行 SQL 的操作，具体要执行的 SQL 语句是写在映射文件中。

**映射文件**：MyBatis 编写的 XML 文件，里面有一个或多个 SQL 语句，不同的语句用来映射不同的接口方法。通常来说，每一张单表都对应着一个映射文件。

## 二、MyBatis 一级缓存

### 2.1 一级缓存原理

在一次 SqlSession 中（数据库会话），程序执行多次查询，且查询条件完全相同，多次查询之间程序没有其他增删改操作，则第二次及后面的查询可以从缓存中获取数据，避免走数据库。

![](http://cdn.jayh.club/uPic/image-20221004155156880Hk5ZsX.png)

每个SqlSession中持有了Executor，每个Executor中有一个LocalCache。当用户发起查询时，MyBatis根据当前执行的语句生成`MappedStatement`，在Local Cache进行查询，如果缓存命中的话，直接返回结果给用户，如果缓存没有命中的话，查询数据库，结果写入`Local Cache`，最后返回结果给用户。

Local Cache 其实是一个 hashmap 的结构：

```java
private Map<Object, Object> cache = new HashMap<Object, Object>();
```

如下图所示，有两个 SqlSession，分别为 SqlSession1 和 SqlSession2，每个 SqlSession 中都有自己的缓存，缓存是 hashmap 结构，存放的键值对。

键是 SQL 语句组成的 Key ：

``` SH
Statement Id + Offset + Limmit + Sql + Params
```

值是 SQL 查询的结果：

![](http://cdn.jayh.club/uPic/image-20221019150214368Zgvd84.png)



### 2.2 一级缓存配置

在 mybatis-config.xml 文件配置，`name=localCacheScope`，value有两种值：`SESSION` 和 `STATEMENT`

```xml
<configuration>
    <settings>
        <setting name="localCacheScope" value="SESSION"/>
    </settings>
<configuration>
```

SESSION：开启一级缓存功能

STATEMENT：缓存只对当前执行的这一个 SQL 语句有效，也就是没有用到一级缓存功能。

首先我们通过几个考题来体验下 MyBatis 一级缓存。

### 2.3 一级缓存考题

> 考题（1）只开启了一级缓存，下面的代码调用了三次查询操作 getStudentById，请判断，下列说法正确的是？

``` JAVA
// 打开一个 SqlSession
SqlSession sqlSession = factory.openSession(true);
StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class); 
// 根据 id=1 查询学生信息
System.out.println(studentMapper.getStudentById(1)); 
// 根据 id=1 查询学生信息
System.out.println(studentMapper.getStudentById(1)); 
// 根据 id=1 查询学生信息
System.out.println(studentMapper.getStudentById(1));
```

答案：第一次从数据库查询到的数据，第二次和第二次从 MyBatis 一级缓存查询的数据。

解答：第一次从数据库查询后，后续查询走 MyBatis 一级缓存

> 考题（2）只开启了一级缓存，下面代码示例中，开启了一个 SqlSession 会话，调用了一次查询，然后对数据进行了更改，又调用了一次查询，下列关于两次查询的说法，正确的是？

``` JAVA
// 打开一个 SqlSession
SqlSession sqlSession = factory.openSession(true);
StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class); 
// 根据 id=1 查询学生信息
System.out.println(studentMapper.getStudentById(1)); 
// 插入了一条学生数据，改变了数据库
System.out.println("增加了" + studentMapper.addStudent(buildStudent()) + "个学生"); 
// 根据 id=1 查询学生信息
System.out.println(studentMapper.getStudentById(1)); 
sqlSession.close();
```

**答案**：第一次从数据库查询到的数据，第二次从数据库查询的数据

**解答**：第一次从数据库查询后，后续更新（包括增删改）数据库中的数据后，这条 SQL 语句的缓存失效了，后续查询需要重新从数据库获取数据。

> 考题（3）当开启了一级缓存，下面的代码中，开启了两个 SqlSession，第一个 SqlSession 查询了两次学生 A 的姓名，第二次 SqlSession 更新了一次学生 A 的姓名，请判断哪个选项符合最后的查询结果。

``` JAVA
SqlSession sqlSession1 = factory.openSession(true); 
SqlSession sqlSession2 = factory.openSession(true); 
StudentMapper studentMapper = sqlSession1.getMapper(StudentMapper.class); 
StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class); studentMapper2.updateStudentName("B",1); 
System.out.println(studentMapper.getStudentById(1)); 
System.out.println(studentMapper2.getStudentById(1));
```

**答案**：

``` SH
A
B
```

**解答**：只开启一级缓存的情况下，SqlSession 级别是不共享的。代码示例中，分别创建了两个 SqlSession，在第一个 SqlSession 中查询学生 A 的姓名，第二个 SqlSession 中修改了学生 A 的姓名为 B，SqlSession2 更新了数据后，不会影响 SqlSession1，所以 SqlSession1 查到的数据还是 A。

### 2.4 MyBatis 一级缓存失效的场景

1. 不同的SqlSession对应不同的一级缓存
2. 同一个SqlSession但是查询条件不同
3. 同一个SqlSession两次查询期间执行了任何一次增删改操作
4. 同一个SqlSession两次查询期间手动清空了缓存

### 2.5 MyBatis 一级缓存总结

- MyBatis一级缓存内部设计简单，只是一个没有容量限定的 HashMap，在缓存的功能性上有所欠缺

- MyBatis的一级缓存最大范围是SqlSession内部，有多个SqlSession或者分布式的环境下，数据库写操作会引起脏数据，建议设定缓存级别为Statement

- 一级缓存的配置中，默认是 SESSION 级别，即在一个MyBatis会话中执行的所有语句，都会共享这一个缓存。

## 三、MyBatis 二级缓存

### 3.1 MyBatis 二级缓存概述

- MyBatis的二级缓存相对于一级缓存来说，实现了`SqlSession`之间缓存数据的共享，同时粒度更加的细，能够到`namespace`级别，通过Cache接口实现类不同的组合，对Cache的可控性也更强。

- MyBatis在多表查询时，极大可能会出现脏数据，有设计上的缺陷，安全使用二级缓存的条件比较苛刻。

- 在分布式环境下，由于默认的MyBatis Cache实现都是基于本地的，分布式环境下必然会出现读取到脏数据，需要使用集中式缓存将 MyBatis的Cache 接口实现，有一定的开发成本，直接使用Redis、Memcached 等分布式缓存可能成本更低，安全性也更高。

### 3.2 MyBatis 二级缓存原理

一级缓存最大的共享范围就是一个 `SqlSession` 内部，如果多个 `SqlSession` 之间需要共享缓存，则需要使用到二级缓存。

开启二级缓存后，会使用 `CachingExecutor` 装饰 `Executor`，进入一级缓存的查询流程前，先在CachingExecutor 进行二级缓存的查询。

二级缓存开启后，同一个 `namespace`下的所有操作语句，都影响着同一个Cache。

![](http://cdn.jayh.club/uPic/image-20221019150616495ANTthr.png)

每个 Mapper 文件只能配置一个 namespace，用来做 Mapper 文件级别的缓存共享。

``` xml
<mapper namespace="mapper.StudentMapper"></mapper>
```

二级缓存被同一个 `namespace` 下的多个 `SqlSession` 共享，是一个全局的变量。MyBatis 的二级缓存不适应用于映射文件中存在多表查询的情况。

通常我们会为每个单表创建单独的映射文件，由于MyBatis的二级缓存是基于`namespace`的，多表查询语句所在的`namspace`无法感应到其他`namespace`中的语句对多表查询中涉及的表进行的修改，引发脏数据问题。

### 3.3 MyBatis缓存查询的顺序

![](http://cdn.jayh.club/uPic/image-20221019151425968bgUHJp.png)

- 先查询二级缓存，因为二级缓存中可能会有其他程序已经查出来的数据，可以拿来直接使用
- 如果二级缓存没有命中，再查询一级缓存
- 如果一级缓存也没有命中，则查询数据库
- SqlSession关闭之后，一级缓存中的数据会写入二级缓存。



### 3.4 二级缓存配置

开启二级缓存需要在 mybatis-config.xml 中配置：

``` 
<settingname="cacheEnabled"value="true"/>
```

### 3.5 二级缓存考题

测试`update`操作是否会刷新该`namespace`下的二级缓存。

> 开启了一级和二级缓存，通过三个SqlSession 查询和更新 学生张三的姓名，判断最后的输出结果是什么？

``` JAVA
SqlSession sqlSession1 = factory.openSession(true); 
SqlSession sqlSession2 = factory.openSession(true); 
SqlSession sqlSession3 = factory.openSession(true); 
StudentMapper studentMapper = sqlSession1.getMapper(StudentMapper.class); 
StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class); 
StudentMapper studentMapper3 = sqlSession3.getMapper(StudentMapper.class); System.out.println("studentMapper读取数据: " + studentMapper.getStudentById(1)); 
sqlSession1.commit(); 
System.out.println("studentMapper2读取数据: " + studentMapper2.getStudentById(1)); studentMapper3.updateStudentName("李四",1); 
sqlSession3.commit(); 
System.out.println("studentMapper2读取数据: " + studentMapper2.getStudentById(1));
```

**答案**：

``` SH
张三
张三
李四
```

**解答**：三个 SqlSession 是共享 MyBatis 缓存，SqlSession2 更新数据后，MyBatis 的 namespace 缓存（StudentMapper） 就失效了，SqlSession2 最后是从数据库查询到的数据。

## 四、MyBatis 自定义缓存

### 4.1 MyBatis 自定义缓存概述

当 MyBatis 二级缓存不能满足要求时，可以使用自定义缓存替换。（较少使用）

自定义缓存需要实现 MyBatis 规定的接口：`org.apache.ibatis.cache.Cache`。这个接口里面定义了 7 个方法，我们需要自己去实现对应的缓存逻辑。

![](http://cdn.jayh.club/uPic/image-202210191427407195XsiTc.png)

### 4.2 整合第三方缓存 EHCache

EHCache 和 MyBatis 已经帮我们整合好了一个自定义缓存，我们可以直接拿来用，不需要自己去实现 MyBatis 的 `org.apache.ibatis.cache.Cache` 接口。

添加 mybatis-ehcache 依赖包。

``` XML
<dependency>
	<groupId>org.mybatis.caches</groupId>
	<artifactId>mybatis-ehcache</artifactId>
	<version>1.2.1</version>
</dependency>
```

创建EHCache的配置文件ehcache.xml。

``` XML
<?xml version="1.0" encoding="utf-8" ?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="../config/ehcache.xsd">
    <!-- 磁盘保存路径 -->
    <diskStore path="D:\passjava\ehcache"/>
    <defaultCache
            maxElementsInMemory="1000"
            maxElementsOnDisk="10000000"
            eternal="false"
            overflowToDisk="true"
            timeToIdleSeconds="120"
            timeToLiveSeconds="120"
            diskExpiryThreadIntervalSeconds="120"
            memoryStoreEvictionPolicy="LRU">
    </defaultCache>
</ehcache>
```

设置二级缓存的类型，在xxxMapper.xml文件中设置二级缓存类型

```XML
<cache type="org.mybatis.caches.ehcache.EhcacheCache"/>
```

### 4.3 EHCache配置文件说明

![](http://cdn.jayh.club/uPic/image-20221019152000949FeC0xy.png)

## 五、总结

本篇分别介绍了 MyBatis 一级缓存、二级缓存、自定义缓存的原理和使用，其中还穿插了 4 道考题来验证 MyBatis 缓存的功能。不足之处是 MyBatis 缓存源码未分析。

参考资料：

https://tech.meituan.com/2018/01/19/mybatis-cache.html