# 05.深入浅出 Spring Boot - 数据访问之JDBC

代码下载：https://github.com/Jackson0714/study-spring-boot.git

> 学而不思则罔

## 一、JDBC是什么？

JDBC API 属于Java APIJDBC用于以下几种功能：连接到数据库、执行SQL语句

## 二、Spring Boot中如何使用JDBC

### 2.1 创建 Spring Boot Project 时引入 JDBC API 依赖和 MySQL Driver依赖

![mark](http://cdn.jayh.club/blog/20200405/u0aQQl6asDKX.png?imageslim)
可以在POM中找到引入的JDBC依赖和mysql依赖：
JDBC 依赖：

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

MySql 驱动依赖：

``` xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>
```

### 2.2 配置数据库连接

新增配置文件：src/main/resources/application.yml

``` yaml
spring:
  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/study-spring-boot?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8
    driverClassName: com.mysql.cj.jdbc.Driver
```

注意：`com.mysq.jdbc.Driver` 被废弃了，需要使用`com.mysql.cj.jdbc.Driver`

### 2.3 查看使用的数据源和数据库连接

``` java
package com.jackson0714.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class Springboot05DataJdbcApplicationTests {

	@Autowired
	DataSource dataSource; //自动配置数据源，使用yml配置

	@Test
	void contextLoads() throws SQLException {
		System.out.println("数据源：" + dataSource.getClass());

		Connection connection = dataSource.getConnection();
		System.out.println("数据库连接：" + connection);
		connection.close();
	}

}

```

默认数据源：class com.zaxxer.hikari.HikariDataSource

数据库连接：HikariProxyConnection@1335157064 wrapping com.mysql.cj.jdbc.ConnectionImpl@7ff8a9dc

![](http://cdn.jayh.club/uPic/image-20211129205228266oaIdph.png)

## 三、自动配置原理

自动配置文件路径：org.springframework.boot.autoconfigure.jdbc

DataSourceConfiguration用来自动导入数据源（根据各种判断）

``` java
/**
	 * Tomcat Pool DataSource configuration.
	 */
	@Configuration(proxyBeanMethods = false)
	@ConditionalOnClass(org.apache.tomcat.jdbc.pool.DataSource.class)
	@ConditionalOnMissingBean(DataSource.class)
	@ConditionalOnProperty(name = "spring.datasource.type", havingValue = "org.apache.tomcat.jdbc.pool.DataSource",
			matchIfMissing = true)
	static class Tomcat {

		@Bean
		@ConfigurationProperties(prefix = "spring.datasource.tomcat")
```

### 3.1 自动选择数据源

如果导入了org.apache.tomcat.jdbc.pool.DataSource数据源，并且配置的spring.datasource.type配置的是org.apache.tomcat.jdbc.pool.DataSource，如果没配置type则使用tomcat数据源

### 3.2 HikariDataSource数据源也类似这样判断。

### 3.3 默认使用tomcat数据源

### 3.4 默认支持以下数据源

``` java
org.apache.tomcat.jdbc.pool、HikariDataSource、org.apache.commons.dbcp2
```

### 3.5 支持自定义数据源

使用DataSourceBuilder创建数据源，利用反射创建响应type的数据源，并且绑定相关属性

``` java
	/**
	 * Generic DataSource configuration.
	 */
	@Configuration(proxyBeanMethods = false)
	@ConditionalOnMissingBean(DataSource.class)
	@ConditionalOnProperty(name = "spring.datasource.type")
	static class Generic {

		@Bean
		DataSource dataSource(DataSourceProperties properties) {
          //使用DataSourceBuilder创建数据源，利用反射创建响应type的数据源，并且绑定相关属性
			return properties.initializeDataSourceBuilder().build();
		}

	}
```

### 3.6 DataSourceInitializerInvoker 运行脚本

```java
/**
 * Bean to handle {@link DataSource} initialization by running {@literal schema-*.sql} on
 * {@link InitializingBean#afterPropertiesSet()} and {@literal data-*.sql} SQL scripts on
 * a {@link DataSourceSchemaCreatedEvent}.
 *
 * @author Stephane Nicoll
 * @see DataSourceAutoConfiguration
 */
class DataSourceInitializerInvoker implements ApplicationListener<DataSourceSchemaCreatedEvent>, InitializingBean {
```

```java
createSchema() 创建表 （文件名规则 schema-*.sql）
initSchema() 执行数据脚本 （文件名规则 data-*.sql）
```

getScripts() 来获取需要执行的脚本

``` java
private List<Resource> getScripts(String propertyName, List<String> resources, String fallback) {
  if (resources != null) {
    return getResources(propertyName, resources, true);
  }
  String platform = this.properties.getPlatform();
  List<String> fallbackResources = new ArrayList<>();
  fallbackResources.add("classpath*:" + fallback + "-" + platform + ".sql");
  fallbackResources.add("classpath*:" + fallback + ".sql");
  return getResources(propertyName, fallbackResources, false);
}
```

1) `fallback` = "schema", `platform`="all",会自动执行根目录下：schema-all.sql 或schema.sql 文件

2) `fallback` = "data", `platform`="all",会自动执行根目录下：data-all.sql 或data.sql 文件

isEnabled() 方法判断是否开启了自动执行脚本

有三种模式：NEVER，EMBEDDED（默认），Always

疑问：用EMBEDDED模式返回false，开关关闭，不执行脚本，这是为啥呢？

用Always模式则每次启动spring boot重复执行脚本（创建表脚本都是先判断有没有表，有则删除后重建）

``` java
private boolean isEnabled() {
  DataSourceInitializationMode mode = this.properties.getInitializationMode();
  if (mode == DataSourceInitializationMode.NEVER) {
    return false;
  }
  if (mode == DataSourceInitializationMode.EMBEDDED && !isEmbedded()) {
    return false;
  }
  return true;
}
```

### 3.7 通过配置文件指定需要执行脚本

```yaml
schema:
  - classpath:department.sql
```

创建出的 `department` 表

![](http://cdn.jayh.club/uPic/image-20211129205136810RdTL6J.png)

## 四、JdbcTemplate

JdbcTemplateAutoConfiguration.java 文件 自动注入了JdbcTemplate。（JdbcTemplate用来操作数据库）

``` java
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({ DataSource.class, JdbcTemplate.class })
@ConditionalOnSingleCandidate(DataSource.class)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
@EnableConfigurationProperties(JdbcProperties.class)
@Import({ JdbcTemplateConfiguration.class, NamedParameterJdbcTemplateConfiguration.class })
public class JdbcTemplateAutoConfiguration {

}
```

我们用Swagger的方式来测试

## 五、配置Swagger用来测试

### 5.1 pom.xml文件 添加swagger依赖

``` xml
<!-- swagger -->
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger2</artifactId>
  <version>2.9.2</version>
</dependency>
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger-ui</artifactId>
  <version>2.9.2</version>
</dependency>
```

### 5.2 添加SwaggerConfig.java文件

``` java
package com.jackson0714.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("玩转Spring Boot 接口文档")
                .description("This is a restful api document of Spring Boot.")
                .version("1.0")
                .build();
    }

}
```

### 5.3 访问Swagger文档

http://localhost:8081/swagger-ui.html

![](http://cdn.jayh.club/uPic/image-202111292053024977s7YVS.png)

## 六、测试

### 6.1 新增部门

``` java
@ApiOperation(value = "1.新增部门")
@ApiImplicitParams({
  @ApiImplicitParam(name = "name", value = "部门名称")
})
@PostMapping("/create")
public int createDepartment(@RequestParam String name) {
  String sql = String.format("insert into department(departmentName) value('%s')", name);
  int result = jdbcTemplate.update(sql);
  return result;
}
```

![](http://cdn.jayh.club/uPic/image-20211129205322369PtJB4B.png)

表记录

![img](..\images\spring-boot-05-data-jdbc\create_table.png)

### 6.2 查询所有部门

``` java
@ApiOperation(value = "2.查询所有部门")
@GetMapping("/getAllDepartment")
public List<Map<String, Object>> getAllDepartment() {
  List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
  return list;
}
```

![](http://cdn.jayh.club/uPic/image-20211129205342044eUwjOE.png)

### 6.3 根据id查询某个部门

``` java
@ApiOperation(value = "3.根据id查询某个部门")
@ApiImplicitParams({
  @ApiImplicitParam(name = "id", value = "需要查询的部门id")
})
@GetMapping("/{id}")
public Map<String, Object> getDepartmentById(@PathVariable Long id) {
  String sql = "select * from department where id = " + id;
  List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
  return list.get(0);
}
```

![](http://cdn.jayh.club/uPic/image-2021112920540345192oCWe.png)

### 6.4 根据id更新部门名称

``` java
@ApiOperation(value = "根据id更新部门名称")
@ApiImplicitParams({
  @ApiImplicitParam(name = "id", value = "需要更新的部门id"),
  @ApiImplicitParam(name = "name", value = "需要更新的部门名称")
})
@PostMapping("/update")
public int updateDepartmentById(@RequestParam Long id, @RequestParam String name) {
  String sql = String.format("update department set departmentName = '%s' where id = %d", name, id);
  int result = jdbcTemplate.update(sql);
  return result;
}
```

![](http://cdn.jayh.club/uPic/image-20211129205419184jyNPy7.png)

### 6.5 根据id删除部门

``` java
@ApiOperation(value = "根据id删除部门")
@ApiImplicitParams({
  @ApiImplicitParam(name = "id", value = "需要删除的部门id")
})
@PostMapping("/delete")
public int deleteDepartment(@RequestParam Long id) {
  String sql = String.format("delete from department where id = %d", id);
  int result = jdbcTemplate.update(sql);
  return result;
}
```

![](http://cdn.jayh.club/uPic/image-20211129205436421XMDVdv.png)





# 报错：

### 问题1

java.sql.SQLException:null, message from server: "Host 'Siri' is not allowed to connect to this MySQL server"

![](http://cdn.jayh.club/uPic/image-20211129205451782M5h9XW.png)

解决方案：

执行命令：

``` shell
use mysql;
select host from user;
update user set host = '%' where user = 'root'
```

执行结果：

``` shell
Query OK, 1 row affected
```

如下图所示：

![](http://cdn.jayh.club/uPic/image-202111292055070630f4nHh.png)

### 问题2

Caused by: com.mysql.cj.exceptions.InvalidConnectionAttributeException: The server time zone value '�й���׼ʱ��' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the 'serverTimezone' configuration property) to use a more specifc time zone value if you want to utilize time zone support.

![](http://cdn.jayh.club/uPic/image-20211129205519517Qk9qF4.png)

解决方案：

配置spring.datasource.url 时，增加参数：serverTimezone=UTC

![](http://cdn.jayh.club/uPic/image-20211129205532829oU3luy.png)

