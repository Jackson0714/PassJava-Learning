你好，我是悟空。

> 本文已收录至Github，欢迎 Star：https://github.com/Jackson0714/PassJava-Learning  
> 个人网站：www.passjava.cn

## 数据库专题

- [x] [有了 MySQL，为什么还要 NoSQL？](https://juejin.cn/post/6945034344658370574)
- [x] [TempDB 的使用和性能问题](https://juejin.cn/post/6973107715761504287)
- [x] [数据库实战：表表达式（一）](https://juejin.cn/post/6972140697961005093)
- [x] [数据库实战：表表达式（二）](https://juejin.cn/post/6972701802189815839)
- [x] [详解 SQL 的集合运算](https://juejin.cn/post/6973987563669291039)
- [x] [详解 SQL 中的联接查询](https://juejin.cn/post/6975895983037087751)
- [x] [详解 SQL 中的子查询](https://juejin.cn/post/6975895983037087751)

本篇主要总结了常见的对单表查询的 SQL 查询题目。

首先我们必须了解 SQL 查询的各字句在逻辑上按以下顺序进行处理：

- 1.FROM

- 2.WHERE

- 3.Group BY

- 4.HAVING

- 5.SELECT

- 6.ORDER BY

在做下面的题目之前，我们可以先把环境准备好，以下的 SQL 脚本可以帮助大家创建数据库，创建表，插入数据。

下载脚本文件：[TSQLFundamentals2008.zip](http://files.cnblogs.com/files/jackson0714/TSQLFundamentals2008.zip)

题目：

## 1. 返回 2007 年 6 月生成的订单

![](https://oscimg.oschina.net/oscnet/up-a15e50c808d800949247bf6a57560436.jpg)

(30 row(s) affected)

本题考察的是过滤日期范围

参考答案：

方案一：

 如果要过滤日期范围（比如，整年或正月），比较自然的方法就是使用 YEAR 和 MONTH 之类的函数。

``` sql
SELECT orderid, orderdate, custid, empid
FROM Sales.Orders
WHERE YEAR(orderdate)= 2007
AND MONTH(orderdate)=6;
```

不过，应该小心的一点是：在大多数情况下，当对过滤条件中的列应用了一定的处理后，就不能以有效的方式来使用索引了。为了潜在地有效利用索引，就需要对为此进行调整，以便对过滤条件中的列不进行处理。

使用一个范围过滤条件：

orderdate >= '20070601'  
AND orderdate < '20070701'

方案二：

``` sql
SELECT orderid, orderdate, custid, empid
FROM Sales.Orders
WHERE orderdate >= '20070601'
  AND orderdate < '20070701';
```

## 2. 返回每个月的最后一天生成的订单

涉及的表：Sales.Orders 表

 ![](https://oscimg.oschina.net/oscnet/up-7b4a37ffb034849d07749a3456da3b65.jpg)

本题主要考察 DATEADD 和 DATEDIFF 的用法

DATEADD:

将指定 _number_ 时间间隔（有符号整数）与指定 _date_ 的指定 _datepart_ 相加后，返回该 _date_。

1. 语法

```
DATEADD (_datepart_ , number , d_ate_ )
```

2. 参数：

 **datepart**

<img src="http://cdn.jayh.club/blog/20210623/hAo1bfdigzud.png?imageslim" style="zoom:80%;" />

 `number` 是一个表达式，可以解析为与 _date_ 的 _datepart_ 相加的 int。用户定义的变量是有效的。

如果您指定一个带小数的值，则将小数截去且不进行舍入。

`date`是一个表达式，可以解析为 **time**、**date**、**smalldatetime**、**datetime**、**datetime2** 或 **datetimeoffset** 值。_date_ 可以是表达式、列表达式、用户定义的变量或字符串文字。如果表达式是字符串文字，则它必须解析为一个 **datetime** 值。为避免不确定性，请使用四位数年份。有关两位数年份的信息，请参阅 two digit year cutoff 选项。

3. **返回值**

**datepart 参数**

**dayofyear**、**day** 和 **weekday** 返回相同的值。

每个 _datepart_ 及其缩写都返回相同的值。

如果 _datepart_ 为 **month** 且 _date_ 月份比返回月份的天数多，因而 _date_ 中的日在返回月份中不存在，则返回返回月份的最后一天。例如，9 月份有 30 天；因此，下面两个语句返回 2006-09-30 00:00:00.000：

```sql
SELECT DATEADD(month, 1, '2006-08-30')
SELECT DATEADD(month, 1, '2006-08-31')
```



**number 参数**

_number_ 参数不能超出 **int** 的范围。在下面的语句中，_number_ 的参数超出 **int** 范围 1。将返回如下错误消息：“将表达式转换为数据类型 int 时出现算术溢出错误。”

```sql
SELECT DATEADD(year,2147483648, '2006-07-31');
SELECT DATEADD(year,-2147483649, '2006-07-31');
```

**date 参数**

_date_ 参数不能增加至其数据范围之外的值。在下面的语句中，与 _date_ 值相加的 _number_ 值超出了 _date_ 数据类型的范围。将返回如下错误消息：“将值添加到 'datetime' 列导致溢出。”

```sql
SELECT DATEADD(year,2147483647, '2006-07-31');
SELECT DATEADD(year,-2147483647, '2006-07-31');
```

**DATEDIFF**

返回指定的 _startdate_ 和 _enddate_ 之间所跨的指定 _datepart_ 边界的计数（带符号的整数）。

语法：

``` sql
DATEDIFF ( *datepart* , *startdate* , *enddate* )
```

**参数**

**datepart**

是指定所跨边界类型的 _startdate_ 和 _enddate_ 的一部分。下表列出了所有有效的 _datepart_ 参数。用户定义的变量等效项是无效的。

**startdate**、**enddate**

是一个表达式，可以解析为 **time**、**date**、**smalldatetime**、**datetime**、**datetime2** 或 **datetimeoffset** 值。_date_ 可以是表达式、列表达式、用户定义的变量或字符串文字。从 _enddate_ 减去 _startdate_。

为避免不确定性，请使用四位数年份。有关两位数年份的信息，请参阅 two digit year cutoff 选项。

**返回类型**

**int**

**返回值**

每个 _datepart_ 及其缩写都返回相同的值。

如果返回值超出 **int** 的范围（-2,147,483,648 到 +2,147,483,647），则会返回一个错误。对于 **millisecond**，_startdate_ 与 _enddate_ 之间的最大差值为 24 天 20 小时 31 分钟 23.647 秒。对于 **second**，最大差值为 68 年。

如果为 _startdate_ 和 _enddate_ 都只指定了时间值，并且 _datepart_ 不是时间 _datepart_，则会返回 0。

在计算返回值时不使用 _startdate_ 或 _endate_ 的时区偏移量部分。

由于 smalldatetime 仅精确到分钟，因此将 **smalldatetime** 值用作 _startdate_ 或 _enddate_ 时，返回值中的秒和毫秒将始终设置为 0。

如果只为某个日期数据类型的变量指定时间值，则所缺日期部分的值将设置为默认值：1900-01-01。如果只为某个时间或日期数据类型的变量指定日期值，则所缺时间部分的值将设置为默认值：00:00:00。如果 _startdate_ 和 _enddate_ 中有一个只含时间部分，另一个只含日期部分，则所缺时间和日期部分将设置为各自的默认值。

如果 _startdate_ 和 _enddate_ 属于不同的日期数据类型，并且其中一个的时间部分或秒小数部分精度比另一个高，则另一个的所缺部分将设置为 0。

参考答案：

方案一：

``` sql
SELECT * FROM Sales.Orders

WHERE MONTH(DATEADD(DAY,1,orderdate)) <> MONTH(orderdate)
```

方案二：

``` sql
SELECT orderid, orderdate, custid, empid
FROM Sales.Orders
WHERE orderdate = DATEADD(month, DATEDIFF(month, '20051231', orderdate), '20051231');
```

得到每月的最后一天的日期：
```
DATEADD(month, DATEDIFF(month, '20051231', orderdate), '20051231')
```

## 3. 返回姓氏 (last name) 中包含字母'a'两次获更多次的雇员

涉及的表：HR.Employees 表

![](https://oscimg.oschina.net/oscnet/up-2f8939334ef3bef2b2c28116385ae8aa.jpg)

本题主要考察%（百分号）通配符的用法

百分号代表任意长度的字符串，包括空字符串。

参考答案：

``` sql
SELECT empid, firstname, lastname
FROM HR.Employees
WHERE lastname LIKE '%a%a%';
```

## 4. 返回总价格（数量*单价）大于 10000 的所有订单，并按总价格排序

涉及的表：Sales.OrderDetails 表

 ![](https://oscimg.oschina.net/oscnet/up-709b681fe8ccc2c69dc8101189b44737.jpg)

参考答案：

``` sql
SELECT orderid,
SUM(unitprice*qty) AS totalValue
  FROM Sales.OrderDetails
  GROUP BY orderid
  HAVING SUM(unitprice*qty)>10000
  ORDER BY totalValue desc;
```

## 5. 返回 2007 年平均运费最高的发货国家

涉及的表：Sales.Orders 表

![](https://oscimg.oschina.net/oscnet/up-0c40e02b294d84597fc13d2e1659e54e.jpg)

参考答案：

``` sql
SELECT TOP(3) shipcountry, AVG(freight) AS avgfreight
FROM Sales.Orders
WHERE orderdate >= '20070101' AND orderdate < '20080101'
GROUP BY shipcountry
ORDER BY avgfreight DESC;　　
```

## 6. 为每个顾客单独根据订单日期的顺序（用 order ID 作为附加属性）来计算其订单的行号。

涉及的表：Sales.Orders 表

![](https://oscimg.oschina.net/oscnet/up-5916c89e35c50f7c24753d41582344b0.jpg)

(830 row(s) affected)

参考答案：

``` sql
SELECT  custid ,
        orderdate ,
        orderid ,
        ROW_NUMBER() OVER ( PARTITION BY custid ORDER BY orderdate, orderid ) AS rownum
FROM    Sales.Orders
ORDER BY custid ,
        rownum;
```

## 7. 构造一个 SELECT 语句，让它根据每个雇员的友好称谓，而返回其性别。对于'Ms.'和'Mrs'，则返回 Female：对于'Mr'，则返回'Male'；对于其他情况（例如，'Dr.', 则返回'Unknown'。

涉及的表：HR.Employees 表

![](https://oscimg.oschina.net/oscnet/up-dc703ad9ca64a5a245f6adb8db8ee31b.jpg)

1. 搜索格式的 CASE 表达式

``` sql
SELECT  empid ,
        firstname ,
        lastname ,
        titleofcourtesy ,
        CASE WHEN titleofcourtesy IN ( 'Ms.', 'Mrs.' ) THEN 'Female'
             WHEN titleofcourtesy = 'Mr.' THEN 'Male'
             ELSE 'Unknown'
        END AS gender
FROM    HR.Employees
```

2. 简单的 CASE 表达式格式

``` sql
SELECT  empid ,
        firstname ,
        lastname ,
        titleofcourtesy ,
        CASE titleofcourtesy
          WHEN 'Ms.' THEN 'Female'
          WHEN 'Mrs.' THEN 'Female'
          WHEN 'Mr.' THEN 'Male'
          ELSE 'Unknown'
        END AS gender;
FROM    HR.Employees
```

## 8. 返回每个客户的客户 ID 和所在区域。对输出中的行按区域排序，NULL 值排在最后（在所有非 NULL 值之后）。

注意，T-SQL 中 NULL 值的默认行为是把 NULL 值排在前面（所有非 NULL 值之前）。

涉及的表：Sales.Customers 表。

![](https://oscimg.oschina.net/oscnet/up-4fad07e4425c08f7512ebdd53904b859.jpg)

参考答案：

``` sql
SELECT  custid ,
        region
FROM    Sales.Customers
ORDER BY CASE WHEN region IS NULL THEN 1
              ELSE 0
         END ,
        region;
```

参考资料：

《SQL2008 技术内幕：T-SQL 语言基础》

欢迎关注我的公众号：「`悟空聊架构`」

[我的 Github](https://github.com/Jackson0714)

>作者简介：8 年互联网职场老兵｜全栈工程师｜90 后超级奶爸｜开源践行者｜公众号万粉原创号主。    蓝桥签约作者，著有《JVM 性能调优实战》专栏，手写了一套 **7 万字** SpringCloud 实战总结和 **3 万字**分布式算法总结。    欢迎关注我的公众号「悟空聊架构」，免费获取资料学习。

_**我是悟空，努力变强，变身超级赛亚人！**_