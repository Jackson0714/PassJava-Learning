## 一、什么是 TVP?
表值参数 Table-Value Parameter (TVP) 提供一种将客户端应用程序中的多行数据封送到 SQL Server 的简单方式，而不需要多次往返或特殊服务器端逻辑来处理数据。 您可以使用表值参数来包装客户端应用程序中的数据行，并使用单个参数化命令将数据发送到服务器。 传入的数据行存储在一个表变量中，然后您可以通过使用 Transact-SQL 对该表变量进行操作。

可以使用标准的 Transact-SQL SELECT 语句来访问表值参数中的列值。  

简单点说就是当想传递 aaaa,bbbb,cccc,dddd 给存储过程时，可以先将 aaa,bbb,ccc,dddd 存到一张表中：

![](http://cdn.jayh.club/blog/20210627/UM06JdUyTAb0.png?imageslim)

然后将这张表传递给存储过程。

如：当我们需要查询指定产品的信息时，通常可以传递一串产品 ID 到存储过程里面，如"1,2,3,4"，然后查询出 ID=1 或 ID=2 或 ID=3 或 ID=4 的产品信息。

可以先将"1,2,3,4"存到一张表中，然后将这张表传给存储过程。

![mark](http://cdn.jayh.club/blog/20210627/geVC1wkmHfSy.png?imageslim)

这种方法有什么优势呢？请接着往下看。

## 二、TVP 传递多行

早期版本是怎么在 SQL Server 中传递多行的？
在 SQL Server 2008 中引入表值参数之前，用于将多行数据传递到存储过程或参数化 SQL 命令的选项受到限制。 开发人员可以选择使用以下选项，将多个行传递给服务器：

使用一系列单个参数表示多个数据列和行中的值。 使用此方法传递的数据量受所允许的参数数量的限制。 SQL Server 过程最多可以有 2100 个参数。 必须使用服务器端逻辑才能将这些单个值组合到表变量或临时表中以进行处理。

将多个数据值捆绑到分隔字符串或 XML 文档中，然后将这些文本值传递给过程或语句。 此过程要求相应的过程或语句包括验证数据结构和取消捆绑值所需的逻辑。

针对影响多个行的数据修改创建一系列的单个 SQL 语句，例如通过调用 SqlDataAdapter 的 Update 方法创建的内容。 可将更改单独提交给服务器，也可以将其作为组进行批处理。 不过，即使是以包含多个语句的批处理形式提交的，每个语句在服务器上还是会单独执行。

使用 bcp 实用工具程序或 SqlBulkCopy 对象将很多行数据加载到表中。 尽管这项技术非常有效，但不支持服务器端处理，除非将数据加载到临时表或表变量中。

## 三、案例
当我们需要查询指定产品的信息时，通常可以传递一串产品 ID 到存储过程里面，如"1,2,3,4"，然后查询出 ID=1 或 ID=2 或 ID=3 或 ID=4 的产品信息。

我们可以先将“1,2,3,4”存到一张表中，然后作为参数传给存储过程。在存储过程里面操作这个参数。

### 3.1 使用 TVP 查询产品

查询产品 ID=1,2,3,4,5 的产品

``` c#
public static void TestGetProductsByIDs()
{
    Collection<int> productIDs = new Collection<int>();
    Console.WriteLine();
    Console.WriteLine("----- Get Product ------");
    Console.WriteLine("Product IDs: 1,2,3,4,5");
    productIDs.Add(1);
    productIDs.Add(2);
    productIDs.Add(3);
    productIDs.Add(4);
    productIDs.Add(5);

    Collection<Product> dtProducts = GetProductsByIDs(productIDs);
    foreach (Product product in dtProducts)
    {
        Console.WriteLine("{0}   {1}", product.ID, product.Name);
    }

}
```

查询的方法：

```c#
/// <summary>
/// Data access layer. Gets products by the collection of the specific product' ID.
/// </summary>
/// <param name="conn"></param>
/// <param name="productIDs"></param>
/// <returns></returns>
public static Collection<Product> GetProductsByIDs(SqlConnection conn, Collection<int> productIDs)
{
    Collection<Product> products = new Collection<Product>();
    DataTable dtProductIDs = new DataTable("Product");
    dtProductIDs.Columns.Add("ID", typeof(int));

    foreach (int id in productIDs)
    {
        dtProductIDs.Rows.Add(
            id
        );
    }
    
    SqlParameter tvpProduct = new SqlParameter("@ProductIDsTVP", dtProductIDs);
    tvpProduct.SqlDbType = SqlDbType.Structured;
    //SqlHelper.ExecuteNonQuery(conn, CommandType.StoredProcedure, "procGetProducts", tvpProduct);
    
    using (SqlDataReader dataReader = SqlHelper.ExecuteReader(conn, CommandType.StoredProcedure, "procGetProductsByProductIDsTVP", tvpProduct))
    {
        while (dataReader.Read())
        {
            Product product = new Product();
            product.ID = dataReader.IsDBNull(0) ? 0 : dataReader.GetInt32(0);
            product.Name = dataReader.IsDBNull(1) ? (string)null : dataReader.GetString(1).Trim();
    
            products.Add(product);
        }
    }
    return products;

}　
```





创建以产品 ID 作为列名的 TVP：

``` sql
IF NOT EXISTS(  SELECT * FROM sys.types WHERE name = 'ProductIDsTVP')
	CREATE TYPE [dbo].[ProductIDsTVP] AS TABLE
	(
		[ID] INT
	)
GO
```

查询产品的存储过程：

``` sql
/****** Object:  StoredProcedure [dbo].[procGetProductsByProductIDsTVP]******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[procGetProductsByProductIDsTVP]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
	DROP PROCEDURE [dbo].[procGetProductsByProductIDsTVP]
GO

Create PROCEDURE [dbo].[procGetProductsByProductIDsTVP]
(
	@ProductIDsTVP ProductIDsTVP READONLY
)
AS
            
SELECT p.ID, p.Name
	
FROM Product as p
INNER JOIN @ProductIDsTVP as t on p.ID = t.ID
```

### 3.2 使用 TVP 删除产品

删除产品 ID=1,5,6 的产品

```  c#
public static void TestDeleteProductsByIDs()
{
    Collection<int> productIDs = new Collection<int>();
    Console.WriteLine();
    Console.WriteLine("----- Delete Products ------");
    Console.WriteLine("Product IDs: 1,5,6");
    productIDs.Add(1);
    productIDs.Add(5);
    productIDs.Add(6);
    DeleteProductsByIDs(productIDs);
}

 删除的方法：

/// <summary>
/// Deletes products by the collection of the specific product' ID
/// </summary>
/// <param name="conn"></param>
/// <param name="productIDs"></param>
public static void DeleteProductsByIDs(SqlConnection conn, Collection<int> productIDs)
{
    Collection<Product> products = new Collection<Product>();
    DataTable dtProductIDs = new DataTable("Product");
    dtProductIDs.Columns.Add("ID", typeof(int));

    foreach (int id in productIDs)
    {
        dtProductIDs.Rows.Add(
            id
        );
    }
    
    SqlParameter tvpProduct = new SqlParameter("@ProductIDsTVP", dtProductIDs);
    tvpProduct.SqlDbType = SqlDbType.Structured;
    SqlHelper.ExecuteNonQuery(conn, CommandType.StoredProcedure, "procDeleteProductsByProductIDsTVP", tvpProduct);

}
```

删除产品的存储过程：

``` sql
/****** Object:  StoredProcedure [dbo].[procDeleteProductsByIDsByProductIDsTVP]******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[procDeleteProductsByProductIDsTVP]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
	DROP PROCEDURE [dbo].[procDeleteProductsByProductIDsTVP]
GO

Create PROCEDURE [dbo].[procDeleteProductsByProductIDsTVP]
(
	@ProductIDsTVP ProductIDsTVP READONLY
)
AS
            
DELETE p FROM Product AS p
INNER JOIN @ProductIDsTVP AS t on p.ID = t.ID
```

### 3.3 使用 TVP 增加产品
增加产品

``` c#
ID=5,Name=bbb

ID=6,Name=abc

public static void TestInsertProducts()
{
    Collection<Product> products = new Collection<Product>();
    Console.WriteLine();
    Console.WriteLine("----- Insert Products ------");
    Console.WriteLine("Product IDs: 5-bbb,6-abc");
    products.Add(
        new Product()
        {
            ID = 5,
            Name = "qwe"
        });

    products.Add(
        new Product()
        {
            ID = 6,
            Name = "xyz"
        });
    
    InsertProducts(products);

}
```

增加的方法：

``` C#
/// <summary>
/// Inserts products by the collection of the specific products.
/// </summary>
/// <param name="conn"></param>
/// <param name="products"></param>
public static void InsertProducts(SqlConnection conn, Collection<Product> products)
{
    DataTable dtProducts = new DataTable("Product");
    dtProducts.Columns.Add("ID", typeof(int));
    dtProducts.Columns.Add("Name", typeof(string));

    foreach (Product product in products)
    {
        dtProducts.Rows.Add(
            product.ID,
            product.Name
        );
    }
    
    SqlParameter tvpProduct = new SqlParameter("@ProductTVP", dtProducts);
    tvpProduct.SqlDbType = SqlDbType.Structured;
    SqlHelper.ExecuteNonQuery(conn, CommandType.StoredProcedure, "procInsertProductsByProductTVP", tvpProduct);

}
```

增加产品的存储过程：

``` sql
/****** Object:  StoredProcedure [dbo].[procInsertProductsByProductTVP]******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[procInsertProductsByProductTVP]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
	DROP PROCEDURE [dbo].[procInsertProductsByProductTVP]
GO

Create PROCEDURE [dbo].[procInsertProductsByProductTVP]
(
	@ProductTVP ProductTVP READONLY
)
AS
            
INSERT INTO Product (ID, Name)
SELECT
	t.ID, 
	t.Name
FROM @ProductTVP AS t

GO
```

### 3.4 使用 TVP 更新产品

将 ID=2 的产品的 Name 更新为 bbb

将 ID=6 的产品的 Name 更新为 abc

``` c#
public static void TestUpdateProducts()
{
    Collection<Product> products = new Collection<Product>();
    Console.WriteLine();
    Console.WriteLine("----- Update Products ------");
    Console.WriteLine("Product IDs: 2-bbb,6-abc");
    products.Add(
        new Product()
        {
            ID = 2,
            Name = "bbb"
        });

    products.Add(
        new Product()
        {
            ID = 6,
            Name = "aaa"
        });
    
    UpdateProducts(products);

}
```

　更新的方法：

``` C#
/// <summary>
/// Updates products by the collection of the specific products
/// </summary>
/// <param name="conn"></param>
/// <param name="products"></param>
public static void UpdateProducts(SqlConnection conn, Collection<Product> products)
{
    DataTable dtProducts = new DataTable("Product");
    dtProducts.Columns.Add("ID", typeof(int));
    dtProducts.Columns.Add("Name", typeof(string));

    foreach (Product product in products)
    {
        dtProducts.Rows.Add(
            product.ID,
            product.Name
        );
    }
    
    SqlParameter tvpProduct = new SqlParameter("@ProductTVP", dtProducts);
    tvpProduct.SqlDbType = SqlDbType.Structured;
    SqlHelper.ExecuteNonQuery(conn, CommandType.StoredProcedure, "procUpdateProductsByProductTVP", tvpProduct);

}

创建以产品 ID 和产品 Name 作为列名的 TVP：

IF NOT EXISTS(  SELECT * FROM sys.types WHERE name = 'ProductTVP')

	CREATE TYPE [dbo].[ProductTVP] AS TABLE(
		[ID] [int] NULL,
		[Name] NVARCHAR(100)
	)

GO
```

增加产品的存储过程：

``` SQL
/****** Object:  StoredProcedure [dbo].[procUpdateProductsByIDs]******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = OBJECT_ID(N'[dbo].[procUpdateProductsByProductTVP]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
	DROP PROCEDURE [dbo].[procUpdateProductsByProductTVP]
GO

Create PROCEDURE [dbo].[procUpdateProductsByProductTVP]
(
	@ProductTVP ProductTVP READONLY
)
AS
            
Update p
SET 
	p.ID = t.ID, 
	p.Name = t.Name
FROM product AS p
INNER JOIN @ProductTVP AS t on p.ID = t.ID

GO
```

结果：

注意：

（1）无法在表值参数中返回数据。 表值参数是只可输入的参数；不支持 OUTPUT 关键字。

（2）表值参数为强类型，其结构会自动进行验证。 

（3）表值参数的大小仅受服务器内存的限制。

（4）删除表值参数时，需要先删除引用表值参数的存储过程。


参考资料
表值参数 https://msdn.microsoft.com/zh-cn/library/bb675163.aspx

表值参数（数据库引擎）https://msdn.microsoft.com/zh-CN/Library/bb510489(SQL.100).aspx 
