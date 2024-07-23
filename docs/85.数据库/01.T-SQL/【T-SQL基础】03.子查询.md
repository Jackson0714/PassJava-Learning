## 概述

本篇主要是子查询基础的总结。

 ![](https://oscimg.oschina.net/oscnet/up-2cd3bcec8df7c862a817fd858d4a0ee1.jpg)

 关键词解释：

**外部查询**：查询结果集返回给调用者

**内部查询**：查询结果集返回给外部查询。

**独立子查询**：独立子查询独立于其外部查询的子查询，可以单独运行子查询。在逻辑上，独立子查询在执行外部查询之前先执行一次，接着外部查询再使用子查询的结果继续进行查询。

**相关子查询**：引用了外部查询中出现的表的子查询，查询要依赖于外部查询，不能独立地调用它。在逻辑上，子查询会为每个外部行单独计算一次。

**标量子查询**：返回单个值的子查询。标量子查询可以出现在外部查询中期望使用单个值的任何地方。

**多值子查询**：在一个列中

### 为什么要使用子查询？

可以避免在查询解决方案中把操作分成多个步骤，并在变量中保存中间查询结果的需要。

## 一、独立子查询

### 1. 独立标量子查询

例子：从 HR.Employees 表中返回 empid 最大的员工信息。

可以分两步：

#### a. 定义一个变量 maxid ，通过独立标量子查询查询出 empid 最大的员工的 empid，然后将这个 empid 保存到变量@maxid 中

#### b. 在 WHERE 条件中过滤出 empid = @maxid 的记录

```
DECLARE @maxid AS INT = ( SELECT    MAX(empid)
                          FROM      HR.Employees
                        )
SELECT  *
FROM    HR.Employees
WHERE   empid = @maxid
```

更简单的方法是嵌套子查询，只需要一条查询语句就可以查询出 empid 最大的员工信息

``` sql
SELECT  *
FROM    HR.Employees
WHERE   empid = ( SELECT    MAX(empid)
                  FROM      HR.Employees
                )
```

注意：

1. 对于有效的标量子查询，它的返回值不能超过一个，如果标量子查询返回了多个值，在运行时则可能会失败。

2. 如果标量子查询没有返回任何值，其结果就转换为 NULL，和 NULL 行进行比较得到的是 UNKNOWN，查询过滤器不会返回任何让过滤表达式计算结果为 UNKNOWN 的行。

## 2. 独立多值子查询

### (1) 多值子查询的语法格式

<标量表达式、> IN ( <多值子查询、> )

例子：返回 title 包含 manager 的雇员处理过的订单的信息

方案一：独立多值子查询

``` sql
SELECT  *
FROM    Sales.Orders
WHERE   empid IN ( SELECT   empid
                   FROM     HR.Employees
                   WHERE    HR.Employees.title LIKE '%Manager' )
```

方案二：内联接查询

``` sql
SELECT  *
FROM    Sales.Orders
        INNER JOIN HR.Employees ON Sales.Orders.empid = HR.Employees.empid
WHERE   HR.Employees.title LIKE '%Manager'
```

类似地，很多地方既可以用子查询也可以用联接查询来解决问题。数据库引擎对两种查询的解释有时候是一样的，而在另外一些情况下，对二者的解释则是不同的。可以先用一种查询解决问题，如果性能不行，再尝试用联接替代子查询，或用子查询替代联接。

### 3. 子查询之 distinct 关键字

 当我们想要剔除掉子查询中的重复值时，会想到在子查询中不必指定 distinct 关键字，其实是没有必要的，因为数据库引擎会帮助我们删除重复的值，而不用我们显示指定 distinct 关键字。

## 二、相关子查询

### 1. 相关子查询

什么是相关子查询：引用了外部查询中出现的表的列，依赖于外部查询，不能独立地运行子查询。在逻辑上，子查询会为每个外部行单独计算一次。

例子：查询每个客户返回在他参与活动的最后一天下过的所有订单。

期望结果：

![](https://oscimg.oschina.net/oscnet/up-896a9bb644cd32e698a712e3744ee320.jpg)

影响行数：90

1. 首先用独立标量子查询查询出最大的订单日期，返回给外部查询

``` sql
SELECT  MAX(orderdate)
FROM    sales.Orders AS O2
```

2. 外部查询用 O1.orderdate 进行过滤，过滤出等于最大订单日期的订单

3. 因为要查询出每个客户参与的订单，所以将独立标量子查询改成相关子查询，用子查询 O2.custid 与外查询 O1.custid 关联。

对于 O1 中每一行，子查询负责返回当前客户的最大订单日期。如果 O1 中某行的订单日期和子查询返回的订单日期匹配，那么 O1 中的这个订单日期就是当前客户的最大的订单日期，在这种情况下，查询便会返回 O1 表中的这个行。

``` sql
SELECT  MAX(orderdate)
FROM    sales.Orders AS O2
WHERE   O2.custid = O1.custid
```

综合上面的步骤，得到下面的查询语句：

``` sql
SELECT  orderid,orderdate,custid
FROM    sales.Orders AS O1
WHERE   O1.orderdate = ( SELECT MAX(orderdate)
                         FROM   sales.Orders AS O2
                         WHERE  O2.custid = O1.custid
                       )
```

### 2.EXISTS 谓词

1.  <外查询>  WHERE EXISTS ( 子查询 )
2.  它的输入是一个子查询，：如果子查询能够返回任何行，改谓词则返回 TRUE，否则返回 FALSE.
3.  如果子查询查询结果又多条，SQL SERVER 引擎查询出一条记录后，就会立即返回，这种处理方式叫做短路处理。
4.  Exist 谓词只关心是否存在匹配行，而不考虑 SELECT 列表中指定的列，所有使用 SELECT * FROM TABLE，并没有什么负面影响，但是为了展开*代码的列名会有少少量的开销，但是还是推荐使用*通配符，查询语句应该尽可能保持自然和直观，除非有非常令人信服的理由，才可以牺牲代码在这方面的要求。
5.  NOT EXISTS 谓词是 EXISTS 谓词的反面

## 三、练习题

### 1. 写一条查询语句，返回 Orders 表中活动的最后一天生成的所有订单。

期望结果：

![](https://oscimg.oschina.net/oscnet/up-446558e2cbb586de621550d64ac69a4f.jpg)

本题考察独立子查询的基本用法，首先用独立子查询返回最后一天的日期，然后外部查询过滤出订单日期等于最后一天的所有订单。

``` sql
SELECT  orderid ,
        orderdate ,
        custid ,
        empid
FROM    Sales.Orders
WHERE   orderdate = ( SELECT    MAX(orderdate)
                      FROM      Sales.Orders

                    )
```

### 2. 查询出拥有订单数量的最多的客户下过的所有订单。

期望结果：

![](https://oscimg.oschina.net/oscnet/up-d51d19a789903508c4e911eb3fb4bd73.jpg)

本题考察独立子查询的用法，和第一题类似，分两个步骤：

（1）先用子查询查询出订单数量最多的客户 id

（2）然后将 id 返回给外部查询，外部查询通过客户 id 过滤出客户下过的所有订单

方案一：独立标量子查询

``` sql
SELECT  custid ,
        orderid ,
        orderdate ,
        empid
FROM    Sales.Orders
WHERE   custid = ( SELECT TOP ( 1 ) WITH TIES
                            O.custid
                   FROM     Sales.Orders AS O
                   GROUP BY custid
                   ORDER BY COUNT(*) DESC

                 )
```

注意：

```
TOP ( 1 ) WITH TIES O.custid
```

查找出排序后与第一条记录 O.custid 相等的所有行

因为下过订单数最多的客户的总订单数是 31，且只有一个客户（custid=71），所以最后的查询结果中只有 custid=71 的客户下过的所有订单。

### 3. 查询出 2008 年 5 月 1 号（包括这一天）以后没有处理过订单的雇员。

期望结果：

![](https://oscimg.oschina.net/oscnet/up-3d2005801e8c29bf4c3ba223db4142a0.jpg)

本题考察独立子查询的用法，本题也可以采用两步来查询出结果。

（1）首先用子查询返回所有 2008 年 5 月 1 号（包括这一天）以后处理过订单的雇员，将这些雇员的 empid 返回给外部查询

（2）然后外部查询用 NOT IN 过滤出所有 2008 年 5 月 1 号（包括这一天）之后没有处理过订单的雇员

方案一：独立标量子查询 \+ NOT IN

``` sql
SELECT  *
FROM    HR.Employees
WHERE   empid NOT IN ( SELECT   empid
                       FROM     Sales.Orders
                       WHERE    orderdate >= '20080501' )
```

### 4. 查询 2007 年下过订单，而在 2008 年没有下过订单的客户

期望输出：

 ![](https://oscimg.oschina.net/oscnet/up-b20fafa383764d47de5e76d97a10ee18.jpg)

方案一：内联接+独立标量子查询

1. 查询出 20070101~20071231 所有下过订单的客户集合 Collection1

``` sql
SELECT DISTINCT C.custid,companyname FROM Sales.Orders O
	INNER JOIN Sales.Customers AS C ON C.custid = O.custid
	WHERE (orderdate <= '20071231' AND orderdate >= '20070101')
```

2. 查询出 20080101~20081231 所有下过订单的客户结合 Collection2

``` sql
SELECT C.custid FROM Sales.Orders O
	INNER JOIN Sales.Customers AS C ON C.custid = O.custid
	WHERE (orderdate <= '20081231' AND orderdate >= '20080101')
```

3.Collection1 不包含 Collection2 的子集就是 2007 年下过订单而在 2008 年下过订单的客户

``` sql
SELECT DISTINCT C.custid,companyname FROM Sales.Orders O
	INNER JOIN Sales.Customers AS C ON C.custid = O.custid
	WHERE (orderdate <= '20071231' AND orderdate >= '20070101')
	AND C.custid NOT IN 
(
	SELECT C.custid FROM Sales.Orders O
	INNER JOIN Sales.Customers AS C ON C.custid = O.custid
	WHERE (orderdate <= '20081231' AND orderdate >= '20080101')
)
```

方案二：相关子查询 EXISTS+NOT EXISTS

1. 查询出 20070101~20071231 所有下过订单的客户集合 Collection1

2. 查询出 20080101~20081231 所有下过订单的客户结合 Collection2

3.Collection1 不包含 Collection2 的子集就是 2007 年下过订单而在 2008 年下过订单的客户

``` sql
SELECT  C.custid ,
        companyname
FROM    Sales.Customers AS C
WHERE   EXISTS ( SELECT *
                 FROM   Sales.Orders AS O
                 WHERE  O.custid = C.custid
                        AND ( orderdate <= '20071231'
                              AND orderdate >= '20070101'
                            ) )
        AND NOT EXISTS ( SELECT *
                         FROM   Sales.Orders AS O
                         WHERE  O.custid = C.custid
                                AND ( orderdate <= '20081231'
                                      AND orderdate >= '20080101'
                                    ) )    

 
```

由方案一和方案二，我们可以总结出：INNER JOIN+独立子查询可以用 Exists+相关子查询代替

### 5. 查询订购了第 12 号产品的客户

期望结果：

![](https://oscimg.oschina.net/oscnet/up-a9ccfe81d01ecf139e09ca267b878cff.jpg)

方案一：内联接多张表

``` sql
SELECT DISTINCT
        C.custid ,
        companyname
FROM    Sales.Customers AS C
        INNER JOIN Sales.Orders AS O ON C.custid = O.custid
        INNER JOIN Sales.OrderDetails AS D ON O.orderid = D.orderid
WHERE   D.productid = '12'
```

方案二：嵌套相关子查询

``` sql
SELECT  C.custid ,
        companyname
FROM    Sales.Customers AS C
WHERE   EXISTS ( SELECT *
                 FROM   Sales.Orders AS O
                 WHERE  O.custid = C.custid
                        AND EXISTS ( SELECT *
                                     FROM   Sales.OrderDetails AS D
                                     WHERE  D.orderid = O.orderid
                                            AND D.productid = '12' ) )
```

参考资料：

《SQL2008 技术内幕：T-SQL 语言基础》
