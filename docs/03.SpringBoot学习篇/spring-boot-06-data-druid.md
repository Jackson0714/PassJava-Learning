# 06.深入浅出 Spring Boot - 数据访问之Druid

代码下载：https://github.com/Jackson0714/study-spring-boot.git

# 一、Druid是什么？

1、Druid是数据库连接池，功能、性能、扩展性方面都算不错。最大的亮点是为监控而生的数据库连接池。

2、数据库、数据源、数据库连接池、JDBC、JDBC实现是什么关系？

![](http://cdn.jayh.club/uPic/image-20211129205928306XCtKHV.png)

- JDBC：Java和关系型数据库的桥梁，是一个桂芳，不是实现。不同类型的数据库需要有自己的JDBC实现
- 数据源：包含数据库连接池，连接池管理。常见的有C3P0、HikariDataSoiurce、Druid等
- 连接池：预先创建一些数据库连接，放到连接池里面，用的时候从连接池里面取，用完后放回连接池
- 连接池管理：创建数据库连接，管理数据库连接
- JDBC实现：MySQL JDBC实现、Oracle JDBC实现等其他实现

# 二、使用Druid数据源



## 1. 从Maven仓库找到Druid数据源

https://mvnrepository.com/search?q=druid

![](http://cdn.jayh.club/uPic/image-20211129205913101CprULA.png)

## 2. 引入druid依赖

``` java
<!-- Druid -->
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>druid</artifactId>
	<version>1.1.21</version>
</dependency>
```

## 3. 修改数据源

修改application.yml文件，增加type属性

```
type: com.alibaba.druid.pool.DruidDataSource
```

数据源：class com.alibaba.druid.pool.DruidDataSource
数据库连接：com.mysql.cj.jdbc.ConnectionImpl@202898d7

## 4. 设置属性

- 修改application.yml文件，增加数据源配置

``` yaml
initialSize: 5
minIdle: 5
maxActive: 20
maxWait: 60000
timeBetweenEvictionRunsMillis: 60000
minEvictableIdleTimeMillis: 300000
validationQuery: SELECT 1 FROM DUAL
testWhileIdle: true
testOnBorrow: false
testOnReturn: false
poolPreparedStatements: true
#   配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
filters: stat,wall,log4j
maxPoolPreparedStatementPerConnectionSize: 20
useGlobalDataSourceStat: true
connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
```

- 添加DruidConfig.java文件，使上面的属性生效

```java
package com.jackson0714.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    // 配置Durid监控
    // 1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> servletInitParams = new HashMap<>();
        servletInitParams.put("loginUserName", "Admin");
        servletInitParams.put("loginPassword", "abc123");
        servletInitParams.put("deny","192.168.10.160"); // 拒绝访问
        servletInitParams.put("allow",""); // 默认允许所有
        servletRegistrationBean.setInitParameters(servletInitParams);

        return servletRegistrationBean;
    }

    // 2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());

        Map<String, String> filterInitParams = new HashMap<>();
        filterInitParams.put("exclusions", "*.js,*.css,/druid/*");// 不拦截js、css文件请求，不拦截/druid/*的请求
        filterRegistrationBean.setInitParameters(filterInitParams);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*")); // 拦截所有请求

        return filterRegistrationBean;
    }
}

```

运行测试程序，可以看到DataSource中的属性值已经与配置文件中的相同

![](http://cdn.jayh.club/uPic/image-20211129205849392EweFaL.png)

## 5. Druid监控

- 先用ip地址访问druid后台

http://192.168.10.160:8082/druid

会提示没有权限访问该后台

![img](..\images\spring-boot-06-druid-jdbc\tip1.png)

- 正常进入后可以看到监控后台

![](http://cdn.jayh.club/uPic/image-20211129205825449wPnau6.png)



- 执行SQL语句

  ![](http://cdn.jayh.club/uPic/image-20211129205807465SMFtnT.png)

查看监控：

有一条查询请求的记录

![](http://cdn.jayh.club/uPic/image-20211129205753237BFAqOT.png)

# 三、技术问题

## 1. 报错 Failed to bind properties under 'spring.datasource' to javax.sql.DataSource:

``` java
***************************
APPLICATION FAILED TO START
***************************

Description:

Failed to bind properties under 'spring.datasource' to javax.sql.DataSource:

    Property: spring.datasource.filters
    Value: stat,wall,log4j
    Origin: class path resource [application.yml]:23:14
    Reason: org.apache.log4j.Logger

Action:

Update your application's configuration


Process finished with exit code 1
```

解决方案：pom.xml文件中添加log4j的配置

``` xml
<!-- https://mvnrepository.com/artifact/log4j/log4j -->
<dependency>
  <groupId>log4j</groupId>
  <artifactId>log4j</artifactId>
  <version>1.2.17</version>
</dependency>
```

## 2. Druid设置了登录账号和密码但是没有进入登录页面

``` java
servletInitParams.put("loginUsername", "Admin");
servletInitParams.put("loginPassword", "abc123");
```

![](http://cdn.jayh.club/uPic/image-20211129205733420eOytID.png)



未找到解决方案



下一篇我们来讲Spring Boot 整合 MyBatis

关注公众号：悟空聊架构，回复pmp，领取pmp资料！回复悟空，领取架构师资料！![img](.\images\common\qrcode.png)

关注我，带你每天进步一点点！