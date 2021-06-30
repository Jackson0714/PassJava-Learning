本篇主要是对多表查询基础的总结。

查询语句的 FROM 字句在逻辑上是第一条要处理的字句，在 FROM 字句内可以用表运算符对输入的表进行操作。

SQL Server 2008 支持四中表运算符：JOIN/APPLY/PIVOT/UNPIVOT

 ![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/c75e0128cfe04d7fbf380ac6f44dc508~tplv-k3u1fbpfcp-zoom-1.image)

# 一、交叉联接

## 1. 什么是交叉联接

（1）对输入的两个表进行操作，把它们联接起来，生成二者的笛卡儿积。

（2）将一个输入表的每行与另一个表的所有行进行匹配。

（3）如果一个表有 m 行，而另一个表有 n 行，将得到 m*n 的结果集。

## 2. 语法

先创建两张表 A,C, 如下图所示

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/ad3ec8b60fc6455891377f1c12efb16c~tplv-k3u1fbpfcp-zoom-1.image)

### （1）ANSI SQL-92 语法

下面的查询是对 A 表和 C 表进行交叉联接查询

SELECT A.a,C.c FROM A

CROSS JOIN C

因为 A 表有 4 行，C 表有 5 行，所以这个查询会生成一个包含 4*5=20 行的数据的结果集。

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/138bd9633fd54b9798f18545761f1b5f~tplv-k3u1fbpfcp-zoom-1.image)

使用 ANSI SQL-92 语法，需要在参与联接的两个表之间使用“Cross JOIN”关键字

### （2）ANSI SQL-89 语法

在 FROM 的表名之间加个逗号

``` sql
SELECT A.a,C.c FROM A,C
```

这两种语法在逻辑上和性能上都没有区别。

## 3. 自交叉联接

对同一个表进行联接，就是自联接。交叉联接、内联接、外联接都支持自联接。

``` sql
SELECT A1.a,A2.a FROM A AS A1
CROSS JOIN A AS A2
```

A 表有 4 行，查询会生成一个包含 4*4=16 行的数据的结果集

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/dd9982d4b1104e25a9adef92171617ad~tplv-k3u1fbpfcp-zoom-1.image)

在自联接中，必须为表起别名。如果不为表指定别名，联接结果中的列名就会有歧义。

比如在本例中，别名为 A1,A2。

# 二、内联接

## 1. 什么是内联接

对两个输入表进行笛卡尔积，然后根据指定的谓词对结果行进行过滤。

## 2. 语法

### （1）ANSI SQL-92 语法

　　a. 在两个表名之间指定 INNER JOIN 关键字

　　b.INNER 关键字可选，因为内联接是默认的联接方式

　　c. 对行进行过滤的谓词是在一个称为 ON 字句中指定的，该谓词也称为联接条件

例如查询 A 表和 C 表执行内联接运算，根据谓词条件 A.id=C.id 对表 A 和表 B 进行匹配：

``` sql
SELECT  A.id ,
        A.a ,
        C.id ,
        C.c
FROM    dbo.A
        INNER JOIN C ON C.id = A.id
```

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/53a2102b5a7b4058967e8de375bd6801~tplv-k3u1fbpfcp-zoom-1.image)

怎么理解内联接：

　　理解内联接最容易的方法是认为 A 表中每一行同 C 表中的所有行进行比较，如果 A 表中的 id 和 C 表中的 id 相等，则匹配成功。

　　另外一种更正式的方法是在关系代数的基础上来考虑内联接，联接运算首先对两个表求笛卡尔积（4 行 A 记录* 5 行 C 记录=20 行记录），然后根据条件 C.id=A.id 对行进行过滤，最终返回 16 行。

注意：

　　ON 字句与 WHERE 和 HAVING 字句类似，ON 字句也只返回令谓词结果为 TRUE 的行，而不会返回令为此计算结果为 FALSE 或 UNKNOW 的行。

### （2）ANSI SQL-89 语法

和交叉联接类似，内联接可以在表名之间用“，”来表示联接，然后用 WHERE 字句中定义联接条件。

``` sql
SELECT  A.id ,
        A.a ,
        C.id ,
        C.c

FROM    dbo.A ,
        dbo.C
WHERE   A.id = C.id
```

内联接的这两种语法执行结果和性能是一样的，但是推荐是用 ANSI SQL-92 语法。因为 ANSI SQL-92 语法更安全。

原因有两点：

　　a. 因为如果用内联接查询，但是忘了写 ON 条件，则语法分析器会报错，执行无效；

　　b. 使用 ANSI SQL-89 标准，有可能忘了 WHERE 字句中的联接，但是语法分析器不会报错，且执行成功。

对于交叉联接来说，也是推荐使用 ANSI SQL-92 语法。

原因有两点：

　　a. 保持一致，统一使用 ANSI SQL-92 语法

　　b. 如果开发人员本来是想用 ANSI SQL-89 语法来写一个内联接查询，却又忘了写 WHERE 字句中的联接条件，则这段 SQL 的联接类型和交叉联接是一样的。另外的开发人员再来看的时候并不能判断前面的开发人员到底是想内联接查询还是交叉联接。

## 3. 特殊的联接实例

### （1）组合联接

组合联接就是联接条件涉及联接两边的多个列的查询。当需要根据主键-外键关系来联接两个表而且主外键关系是组合的（即关系基于多个列）时，通常使用组合联接。

如 B 表定义了一个外键（id1,id2），引用了 D 表的 id1,id2 列，现在要写一个主外键关系来联接两个表的查询。

``` sql
SELECT  *
FROM    B
INNER JOIN D
ON D.id1 = B.id1
AND D.id2 = B.id2
```

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/305303e929e14bc5b136df07875f9763~tplv-k3u1fbpfcp-zoom-1.image)

### （2）不等联接

联接条件只包含等号运算符，叫做等值联接，联接条件包含除等号以外的其他运算符，叫做不等联接。

``` sql
SELECT    *
FROM      A
INNER JOIN C
ON dbo.A.id < dbo.C.id
```

如果使用交叉联接，得到的结果中将包含自偶对（例如，1 和 1），以及镜像对（例如，1 和 2、2 和 1）. 使用内联接，并在联接条件中指定左边的键值要小于右边的键值，就可以消除这两种没有用的情况。

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/4483a074e52847b2b419d752dcc281bd~tplv-k3u1fbpfcp-zoom-1.image)

### （3）多表联接

当 FROM 子句中包含多个表运算符时，表运算符在逻辑上是按从左到右的顺序处理的。

表 A 和表 B 进行 JOIN 关联，得到结果集 AB，AB 将作为第二个表运算符 JOIN 的输入，与表 C 进行 JOIN 关联，得到结果 ABC，以此类推。

所以如果 FROM 字句包含多个连接，逻辑上只有第一个联接对两个基础表进行操作，而其他联接则将前一个联接的结果作为其左边的输入。

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/d026bfe9201441e1b034996dd683f59e~tplv-k3u1fbpfcp-zoom-1.image)

# 三、外联接

## 1. 什么是外联接

对两张表进行笛卡尔积，ON 过滤，添加外部行

## 2. 语法

只有 ANSI SQL-92 语法

表名之间用

LEFT OUTER JOIN 或

RIGHT OUTER JOIN 或

FULL OUTER JOIN 或

在 ON 字句中进行过滤

## 3. 外联接基础

（1）LEFT 关键字标识左边表的行驶保留的，RIGHT 关键字表示右边的行是保留的，FULL 关键字则表示左右两边表的行都是保留的。

（2）外联接的第三个逻辑查询处理步骤就是要识别保留表中按照 ON 条件在另一个表找不到与之匹配的那些行，再把这些行添加到联接的前两个步骤生成的结果表中。

（3）对于来自联接的非保留表的那些列，追加的外部行中的这些列则用 NULL 作为占位符。

集合 A 包含两个集合，集合 A1 和集合 A2，集合 B 包含两个集合，集合 B1 和集合 B2。A 和 B 的交集是 A2 和 B2

A 和 B 进行 LEFT OUTER JOIN 后，A1 和 A2 都保留，因 A1 在 B 中找不到对应的数据，则 A1 对应的行需要保留，添加到联接的前两个步骤生成的结果表中，而对于非保留表的列，在外部行中则用 NULL 作为占位符。

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/2a1d8a75368646f29f36500beb38a756~tplv-k3u1fbpfcp-zoom-1.image)

例子：

客户的 ID 和订单的客户 ID 对 Customer 表和 Orders 表进行关联，并返回客户和他们的订单信息。

Customer 包含两部分：有订单的客户，没有订单的客户，用左外联接，查询结果返回有订单的客户和没有订单的客户：

``` sql
SELECT  Cus.custid ,
        o.orderid
FROM    Sales.Customers AS Cus
        LEFT OUTER JOIN Sales.Orders AS O 
        ON Cus.custid = O.custid
```

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/b702a8fb02d84549bb6c823f57d0741e~tplv-k3u1fbpfcp-zoom-1.image)

我们可以通过下面的查询，查询出没有订单的客户

``` sql
SELECT  Cus.custid ,
        O.orderid ,
        O.custid ,
        O.orderdate ,
        O.requireddate ,
        O.shippeddate
FROM    Sales.Customers AS Cus
        LEFT OUTER JOIN Sales.Orders AS O ON Cus.custid = O.custid
WHERE   o.custid IS NULL
```

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/81602fc762a940958617b415b8835a1c~tplv-k3u1fbpfcp-zoom-1.image)

1. 他们的 ID 分别为 22 和 57。查询结果中这两个客户在 Order 表中的列都为 NULL。

2. 从逻辑上说，这两个客户相关的数据行在联接的第二步（基于 ON 谓词条件的过滤）就被过滤了，而在第三部又把这些行作为外部行添加了进来。

3. 如果使用内联接，结果将不会返回这两行。添加这两行后，就可以在结果中保留左边表的所有行。

4. 外联接结果可以看作两种，内不行和外部行，内部行是 ON 字句的条件能在另一边找到匹配的那些行；外部行则是找不到那些行。内联接只返回内不行，而外联接返回内部行和外部行。

5.ON 字句中的条件不能最终决定保留表中部分行是否会在结果中出现，当决定哪些行可以匹配非保留表，就在 ON 字句中指定联接条件。当在生成外部行以后，要应用外部行以后，要应用过滤器，而且希望过滤条件是最终的。就应该在 WHERE 字句中指定条件。

## 4. 在多表联接中使用外联接

1. 对外联接的处理顺序进行调整，可能会得到不同的输出结果，所以不能随意调整它们的顺序。

2. 对于任何外联接（左外联接欸、右外联接、和全外联接），如果后面紧跟着一个内联接或右外联接，都会抵消外联接的外部行。前提是，联接条件对来自联接左边的 NULL 值和联接右边的某些值进行了比较。

# 四、多表查询-几道 SQL 查询题

表间关系图

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/5d88962b97fb45898e30005eb137e35e~tplv-k3u1fbpfcp-zoom-1.image)

在做下面的题目之前，我们可以先把环境准备好，以下的 SQL 脚本可以帮助大家创建数据库，创建表，插入数据。

下载脚本文件：[TSQLFundamentals2008.zip](http://files.cnblogs.com/files/jackson0714/TSQLFundamentals2008.zip)

## 1. 返回来自美国的客户，并为每个客户返回订单总数和商品交易总数量。

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/f3d5efa4a37a4107a14ec4f2b33d8737~tplv-k3u1fbpfcp-zoom-1.image)

本题是一道外联接查询，需要查询出所有客户（有订单的客户和没有订单的客户）对应的订单总数，然后再与订单详情关联，查询出每个客户对应的所有订单上的所有的商品的交易总数量。

然后筛选出 country = 'USA'。为了得到每个客户的订单总数，需要用 COUNT(DISTINCT O.orderid) 进行统计。

``` sql
SELECT  C.custid ,
        COUNT(DISTINCT O.orderid) AS numorders ,
        SUM(CASE WHEN qty IS NULL THEN 0 ELSE qty END) AS totalqty

FROM    Sales.Customers AS C
        LEFT OUTER JOIN Sales.Orders AS O ON O.custid = C.custid
        LEFT OUTER JOIN Sales.OrderDetails D ON D.orderid = O.orderid
WHERE   country = 'USA'
GROUP BY C.custid
```

## 2. 返回客户及其订单信息，包括没有下过任何订单的客户。

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/3d10ff6626ed4e448f09aadf8d0ac90a~tplv-k3u1fbpfcp-zoom-1.image)

``` sql
SELECT  C.custid ,
        C.companyname ,
        O.orderid ,
        O.orderdate
FROM    Sales.Customers AS C
        LEFT OUTER JOIN Sales.Orders AS O 
        ON O.custid = C.custid
```

## 3. 返回在 2007 年 2 月 12 日下过订单的客户，以及他们的订单。同时也返回在 2007 年 2 月 12 日没有下过订单的客户。

![](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/eac7b5c93a054c1ea2d71db5a1973ffa~tplv-k3u1fbpfcp-zoom-1.image)

这题主要考察在联接查询中，ON 和 WHERE 的用法。

（1）订单日期的过滤过滤条件必须出现在 ON 字句，而不是 WHERE 字句中。WHERE 过滤条件是在外部行被添加以后才被应用的，而且是最终的。

（2）订单的日期的过滤条件只是用于决定是否匹配，但不是决定客户行的最终条件。

``` sql
SELECT  C.custid ,
        C.companyname ,
        O.orderid ,
        O.orderdate
FROM    Sales.Customers AS C
        LEFT OUTER JOIN Sales.Orders AS O
        ON O.custid = C.custid
        AND O.orderdate = '20070212'
```

参考资料：

《SQL2008 技术内幕：T-SQL 语言基础》


