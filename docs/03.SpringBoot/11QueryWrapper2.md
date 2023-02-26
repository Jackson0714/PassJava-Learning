Mybatis plus 强大的条件构造器 QueryWrapper 条件构造器基础方法解释

官网解释： https://mp.baomidou.com/guide/wrapper.html#abstractwrapper



### 一、条件构造器关系介绍



 

![img](http://cdn.jayh.club/uPic/1470521-20200408175328100-117288012RVosYn.png)









介绍 ：



- 上图绿色框为抽象类 abstract
- 蓝色框为正常 class 类，可 new 对象
- 黄色箭头指向为父子类关系，箭头指向为父类



wapper 介绍 ：



- Wrapper ： 条件构造抽象类，最顶端父类，抽象类中提供 4 个方法西面贴源码展示
- AbstractWrapper ： 用于查询条件封装，生成 sql 的 where 条件
- AbstractLambdaWrapper ： Lambda 语法使用 Wrapper 统一处理解析 lambda 获取 column。
- LambdaQueryWrapper ：看名称也能明白就是用于 Lambda 语法使用的查询 Wrapper
- LambdaUpdateWrapper ： Lambda 更新封装 Wrapper
- QueryWrapper ： Entity 对象封装操作类，不是用 lambda 语法
- UpdateWrapper ： Update 条件封装，用于 Entity 对象更新操作







解释





![img](http://cdn.jayh.club/uPic/1470521-20200408174347575-1589738937qvu8uU.png)









#### 构造器条件



[![img](http://cdn.jayh.club/uPic/copycode-20230222152640917bZUS9Y.gif)](javascript:void(0);)

```
package com.lqf.crud;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lqf.crud.bean.crm.User;
import com.lqf.crud.dao.crm.UserMapper;
import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.jsf.el.WebApplicationContextFacesELResolver;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryWrapperTests {

    @Autowired
    private UserMapper mapper;

    /**
     * <p>
     * 根据根据 entity 条件，删除记录,QueryWrapper实体对象封装操作类（可以为 null）
     * 下方获取到queryWrapper后删除的查询条件为name字段为null的and年龄大于等于12的and email字段不为null的
     * 同理写法条件添加的方式就不做过多介绍了。
     * </p>
     */
    @Test
    public void delete() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .isNull("name")
                .ge("age", 12)
                .isNotNull("email");
        int delete = mapper.delete(queryWrapper);
        System.out.println("delete return count = " + delete);
    }


    /**
     * <p>
     * 根据 entity 条件，查询一条记录,
     * 这里和上方删除构造条件一样，只是seletOne返回的是一条实体记录，当出现多条时会报错
     * </p>
     */
    @Test
    public void selectOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "lqf");

        User user = mapper.selectOne(queryWrapper);
        System.out.println(user);
    }


    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     *
     * @param queryWrapper 实体对象
     */
    @Test
    public void selectCount() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "lqf");

        Integer count = mapper.selectCount(queryWrapper);
        System.out.println(count);
    }


    /**
     * <p>
     * 根据 entity 条件，查询全部记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）为null查询全部
     */
    @Test
    public void selectList() {
        List<User> list = mapper.selectList(null);

        System.out.println(list);
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Test
    public void selectMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("name");
        List<Map<String, Object>> maps = mapper.selectMaps(queryWrapper);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    /**
     * 打印结果
     * {name=lqf, id=1046282328366391406, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391407, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391408, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391409, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391410, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391411, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391412, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391413, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391414, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391415, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391416, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391417, age=12, email=lqf@163.com, status=false}
     * {name=lqf, id=1046282328366391418, age=12, email=lqf@163.com, status=false}
     * json类型的键值对模式
     */

    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Test
    public void selectPage() {
        Page<User> page = new Page<>(1, 5);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        IPage<User> userIPage = mapper.selectPage(page, queryWrapper);
        System.out.println(userIPage);
    }

    /**
     * 打印结果
     * ==>  Preparing: SELECT COUNT(1) FROM user
     * ==> Parameters:
     * <==    Columns: COUNT(1)
     * <==        Row: 100
     * ==>  Preparing: SELECT id,name,age,email,status FROM user LIMIT 0,5
     * ==> Parameters:
     * <==    Columns: id, name, age, email, status
     * <==        Row: 1046282328366391319, lqf, 12, lqf@163.com, 0
     * <==        Row: 1046282328366391320, lqf, 12, lqf@163.com, 0
     * <==        Row: 1046282328366391321, lqf, 12, lqf@163.com, 0
     * <==        Row: 1046282328366391322, lqf, 12, lqf@163.com, 0
     * <==        Row: 1046282328366391323, lqf, 12, lqf@163.com, 0
     * <==      Total: 5
     *
     *
     * 这里需要在项目中加入分页插件
     *   @Bean
     *     public PaginationInterceptor paginationInterceptor() {
     *         return new PaginationInterceptor();
     *     }
     */


    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param page         分页查询条件
     * @param queryWrapper 实体对象封装操作类
     */
    @Test
    public void selectMapsPage() {
        Page<User> page = new Page<>(1, 5);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        IPage<Map<String, Object>> mapIPage = mapper.selectMapsPage(page, queryWrapper);
        System.out.println(mapIPage);
    }

    /**
     * 和上个分页同理只是返回类型不同
     */


    /**
     * <p>
     * 根据 whereEntity 条件，更新记录
     * </p>
     *
     * @param entity        实体对象 (set 条件值,不能为 null)
     * @param updateWrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where 语句）
     */
    @Test
    public void update() {

        //修改值
        User user = new User();
        user.setStatus(true);
        user.setName("zhangsan");

        //修改条件s
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("name", "lqf");

        int update = mapper.update(user, userUpdateWrapper);

        System.out.println(update);
    }

    /**
     * 打印结果
     * ==>  Preparing: UPDATE user SET name=?, status=? WHERE name = ?
     * ==> Parameters: zhangsan(String), true(Boolean), lqf(String)
     * <==    Updates: 100
     * Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@56a4f272]
     * 100
     * 2018-10-02 15:08:03.928  INFO 7972 --- [       Thread-2] o.s.w.c.s.GenericWebApplicationContext   : Closing org.springframework.web.context.support.GenericWebApplicationContext@37313c65: startup date [Tue Oct 02 15:08:00 CST 2018]; root of context hierarchy
     * 2018-10-02 15:08:03.937  INFO 7972 --- [       Thread-2] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
     * 2018-10-02 15:08:04.053  INFO 7972 --- [       Thread-2] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
     *
     * Process finished with exit code 0
     */

}
```

[![img](http://cdn.jayh.club/uPic/copycode-20230222152640917bZUS9Y.gif)](javascript:void(0);)



全文完

本文由 [简悦 SimpRead](http://ksria.com/simpread) 优化，用以提升阅读体验

使用了 全新的简悦词法分析引擎 beta，[点击查看](http://ksria.com/simpread/docs/#/词法分析引擎)详细说明





[一、条件构造器关系介绍](https://www.cnblogs.com/nongzihong/p/12661446.html#sr-toc-0)[构造器条件](https://www.cnblogs.com/nongzihong/p/12661446.html#sr-toc-1)