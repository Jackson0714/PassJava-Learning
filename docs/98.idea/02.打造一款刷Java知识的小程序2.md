# 打造一款刷Java 知识的小程序（二）
> 学习Java的神器即将面向广大Java爱好者

![mark](http://cdn.jayh.club/blog/20200405/ik8h4UItdnSA.jpg?imageslim)

## 一、第二版做了什么？

- 第一版小程序只具有初级展示功能，知识点都是hardcode在代码里面的。
- 这一次进行了大升级，知识点从后端（小程序云开发）获取
- 知识点都是用Markdown语言写的，支持将Markdown内容无缝转换成小程序页面。
## 二、C端与后端的交互逻辑
![mark](http://cdn.jayh.club/blog/20200405/utxoOgwUrtc9.png?imageslim)
### 2.1、功能跳转
- 首页点击Java基础图标进入到Java基础知识列表页面
- 列表页点击“查看”按钮进入详情页面
### 2.2、准备工作
1) 云开发存储上传一个markdown文件
![mark](http://cdn.jayh.club/blog/20200405/629FSwfShtOA.png?imageslim)
2) 云开发数据库插入两条记录
![mark](http://cdn.jayh.club/blog/20200405/xA3hBYrsRPfq.png?imageslim)
### 2.2、代码实现
1) 调用 自己编写的云函数 getJavaQuestionList 获取列表；
2) 调用 自己编写的云函数 getJavaQuestionDetail 获取详情的 Markdown文件路径；
3) 调用 系统自带的云函数 downloadFile 下载 Markdown文件保存为临时文件；
4) 调用 小程序自带的 saveFileSync 将临时文件保存到本地；
5) 调用 小程序自带的 readFileSync 将本地文件读入缓存（注意：开发者工具上不需要保存到本地也可以正常读取）；
6) 使用 towxml 开源组件将缓存中markdown内容转成小程序可以识别的元素
7) 给 图片元素添加预览事件
## 三、我与“Markdown转小程序页面”大战一天一晚
![mark](http://cdn.jayh.club/blog/20200405/e6y2sG2FgJGx.png?imageslim)

### 方案一、用Typora工具将 Markdown文件复制为html内容直接粘贴到表字段里面

![mark](http://cdn.jayh.club/blog/20200405/NkoHPzoz4Nb4.png?imageslim)

遇到的问题，发现复制的HTML代码都不包含样式，而用小程序富文本组件后，在WXSS文件定义样式对富文本里面的标签元素是不生效的。于是只能自己加样式，那就用正则匹配标签来加style吧。写着写着发现好多style要加。比如h1,h2,image。最坑的是Markdown转为html是code标签，小程序不识别code标签，所以将code标签转为div标签，然后还得处理换行，而且针对代码需要有不同的高亮显示，这太麻烦了。但基本上已经不影响阅读了。

![mark](http://cdn.jayh.club/blog/20200405/pFNp5iqIb5qR.png?imageslim)

### 方案二、将Markdown文件复制为markdown格式内容直接粘贴到表字段里面

找到一个开源组件可以将markdown 标记转为小程序元素，叫做wemark。

于是就把markdown 内容复制到数据库中，但发现存到数据库的是没有换行的，所以读取之后需要做换行处理，这里就又用到正则表达式了。处理完了也能正常显示了，但图片不能放大看，这个就比较难受了。

### 方案三、将Markdown文件存到某个地方，比如COS，阿里云，七牛云，自己搭建的服务器

这里是将文件上传到小程序云开发的存储里面，而且小程序提供了对应的下载云存储文件的SDK，非常方便。

然后使用towxml 

[^towxml]: https://github.com/sbfkcel/towxml

开源组件将markdown转为小程序元素，和wemark相比优势如下：

1.支持自定义towxml组件哪些功能开放，比如转换markdown的图表、数学公式等

2.支持自定义towxml 支持哪些code格式高亮

3.支持绑定小程序元素事件（这个功能太棒了）



