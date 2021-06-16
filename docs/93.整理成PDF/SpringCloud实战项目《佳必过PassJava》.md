# Spring Cloud 实战项目 - 从理论到落地 v 1.1

## 更新记录

### v 1.1 2021-03-23

- 新增 《6.8 整合链路追踪》
- 新增 《8.1 压测、性能监控、性能调优》

###  v 1.0 2020-11-25

- 初始版本

## 公众号：悟空聊架构 （原创好文，第一时间推送）

![公众号：悟空聊架构](http://cdn.jayh.club/blog/20210323/cMGAFt562d4J.png?imageslim)

## 加我好友 （答疑解惑）

![加我好友](http://cdn.jayh.club/blog/20210323/2AlG6mLwpKcV.png?imageslim)

# 一、PassJava 项目简介

- PassJava 是一款 Java `面试刷题` 的开源系统，可以用零碎时间利用小程序查看常见面试题，夯实 Java 基础。
- PassJava 项目可以教会你如何搭建 SpringBoot 项目，Spring Cloud 项目
- 采用流行的技术，如 SpringBoot、MyBatis、Redis、 MySql、 MongoDB、 RabbitMQ、Elasticsearch，采用 Docker 容器化部署。

## 项目地址

* [后台平台] https://github.com/Jackson0714/PassJava-Platform
* [后台管理] https://github.com/Jackson0714/PassJava-Portal
* [学习教程] https://github.com/Jackson0714/PassJava-Learning

## 项目演示

- 后台管理系统

![添加题目管理菜单](http://cdn.jayh.club/blog/20200425/xN7NHGsUFGNe.png?imageslim)

- 小程序

![mark](http://cdn.jayh.club/blog/20200405/ik8h4UItdnSA.jpg?imageslim)

![mark](http://cdn.jayh.club/blog/20200405/pjfJNfuiXVnF.gif)

## PassJava 中使用的技术

SpringBoot、MyBatis、Redis、 MySql、 MongoDB、 RabbitMQ、Elasticsearch

## PassJava 实现的功能概览



![mark](http://cdn.jayh.club/blog/20200405/pjfJNfuiXVnF.gif)

## PassJava 数据库表概览

![mark](http://cdn.jayh.club/blog/20200411/4jVMyPUGn0ns.png?imageslim)

### 数据库表前缀说明

- ums_*：会员模块相关表
- cms_*：内容管理模块相关表
- qms_*：题目模块相关表
- chms_*：渠道模块相关表
- sms_*：学习模块相关表

# 二、项目微服务架构图

## 微服务架构图

![mark](http://cdn.jayh.club/blog/20200407/scg1XhlvGbUV.png?imageslim)

![mark](http://cdn.jayh.club/blog/20200410/IIBsmjviRsAx.png?imageslim)

# 三、项目前置要求

> 由于 PassJava 项目涉及到很多知识点，希望大家先补下功课，推荐的书籍如下。

## 推荐资料

### IDEA

《IntelliJ-IDEA-Tutorial》：[https://github.com/judasn/IntelliJ-IDEA-Tutorial](https://github.com/judasn/IntelliJ-IDEA-Tutorial)

### Spring

《Spring 实战（第 4 版）》：[https://book.douban.com/subject/26767354/](https://book.douban.com/subject/26767354/)

### SpringBoot

《Spring Boot 实战》：[https://book.douban.com/subject/26857423/](https://book.douban.com/subject/26857423/)

### MyBatis

《MyBatis 从入门到精通》：[https://book.douban.com/subject/27074809/](https://book.douban.com/subject/27074809/)

### MySql

《深入浅出 MySQL》：[https://book.douban.com/subject/25817684/](https://book.douban.com/subject/25817684/)

### Linux

《循序渐进 Linux（第 2 版）》：[https://book.douban.com/subject/26758194/](https://book.douban.com/subject/26758194/)

### Elasticsearch

《Elasticsearch 权威指南》：[https://www.elastic.co/guide/cn/elasticsearch/guide/current/index.html](https://www.elastic.co/guide/cn/elasticsearch/guide/current/index.html)

《Elasticsearch 技术解析与实战》：[https://book.douban.com/subject/26967826/](https://book.douban.com/subject/26967826/)

### Mongodb

《MongoDB 实战 (第二版)》：[https://book.douban.com/subject/27061123/](https://book.douban.com/subject/27061123/)

### Docker

《Spring Cloud 与 Docker 微服务架构实战》：[https://book.douban.com/subject/27028228/](https://book.douban.com/subject/27028228/)

# 四、环境搭建篇

## 4.1 Vagrant 快速搭建 Ubuntu 虚拟机环境

### 1. 开启虚拟机服务

Windows 启动配置：Intel Virtualization Technology -> Enabled

### 2. 下载安装 VirtualBox

VirtualBox：虚拟机管理软件

https://www.virtualbox.org/wiki/Downloads

### 3. 下载安装 Vagrant

Vagrant：创建和管理虚拟机

Vagrant 软件：https://www.vagrantup.com/downloads.html

Vagrant 官方镜像：https://app.vagrantup.com/boxes/search

![mark](http://cdn.jayh.club/blog/20200407/Islf9HWK5dpm.png?imageslim)

- check 是否安装好了 vagrant

命令行输入 vagrant

```shell
vagrant
```

![mark](http://cdn.jayh.club/blog/20200407/RbGapilevUic.png?imageslim)

### 4. 安装 vagrant ubuntu 国内镜像

```
# ubuntu 18.04 LTS:
vagrant box add https://mirrors.tuna.tsinghua.edu.cn/ubuntu-cloud-images/bionic/current/bionic-server-cloudimg-amd64-vagrant.box --name ubuntu18

# ubunt 16.04 LTS：
vagrant box add https://mirrors.tuna.tsinghua.edu.cn/ubuntu-cloud-images/xenial/current/xenial-server-cloudimg-amd64-vagrant.box --name ubuntu16

# ubuntu14：
vagrant box add https://mirrors.tuna.tsinghua.edu.cn/ubuntu-cloud-images/vagrant/trusty/current/trusty-server-cloudimg-amd64-vagrant-disk1.box --name ubuntu14
```

安装 ubuntu 18

```shell
vagrant box add https://mirrors.tuna.tsinghua.edu.cn/ubuntu-cloud-images/bionic/current/bionic-server-cloudimg-amd64-vagrant.box --name ubuntu18
```

![mark](http://cdn.jayh.club/blog/20200407/g6qNmBtq4DdX.png?imageslim)

- 创建 vagrant 配置文件

```
vagrant init
```

- 打开 C:\Users\Administrator\Vagrantfile 文件

``` powershell
config.vm.box = "base" 修改为
config.vm.box = "ubuntu18"
```

### 5. 启动虚拟机

``` shell
vagrant up
```

![mark](http://cdn.jayh.club/blog/20200407/F8SfLKFfJgph.png?imageslim)

![mark](http://cdn.jayh.club/blog/20200407/ToVOBfPMuFzV.png?imageslim)

### 6. 连接虚拟机

```
vagrant ssh
```

![mark](http://cdn.jayh.club/blog/20200407/E9vL6MlHcEvf.png?imageslim)



### 7. 配置密码登录

- 配置密码登录 vagrant

```sh
Vagrant ssh 进入系统之后
sudo su
编辑 sshd_config
vi /etc/ssh/sshd_config
PasswordAuthentication no 改为 PasswordAuthentication yes
PermitRootLogin prohibit-password 改为 PermitRootLogin yes
重启服务
service sshd restart
```

- 安装 XShell 工具和 XFTP 工具

- XShell 连接虚拟机

  账号：root

  密码：vagrant

- ![mark](http://cdn.jayh.club/blog/20200712/CVipwCrtRTaC.png?imageslim)

![连接成功](http://cdn.jayh.club/blog/20200712/L898uNJPtYmE.png?imageslim)

## 4.2 配置虚拟机网络

### 1.查看VirtualBox Host-Only Network

![mark](http://cdn.jayh.club/blog/20200408/mh0LjwASREf6.png?imageslim)

本地VirtualBox 网络地址 `192.168.56.1`，则修改虚拟机IP地址为同一个网段下，比如`192.168.56.10`

### 2.配置虚拟机IP地址

打开Vagrant 配置文件 C:\Users\Administrator\Vagrantfile

``` powershell
# config.vm.network "private_network", ip: "192.168.33.10"
修改为
config.vm.network "private_network", ip: "192.168.56.10"
```

### 3.重新加载虚拟机

``` shell
vagrant reload
```

### 4.查看虚拟机IP地址

虚拟机IP地址：192.168.56.10，和配置文件中的一致

![mark](http://cdn.jayh.club/blog/20200408/o8OTm5m7g5Ht.png?imageslim)

### 5.测试本机是否可以ping通虚拟机

ping 192.168.56.10，可以ping通

![mark](http://cdn.jayh.club/blog/20200408/raELgTdl3IXc.png?imageslim)

### 6.测试虚拟机是否可以ping通本机

ping 192.168.10.160，可以ping通


## 4.3 安装docker

 https://docs.docker.com/engine/install/ubuntu/

### 1.卸载老版本docker

```sh
sudo apt-get remove docker docker-engine docker.io containerd runc
```

### 2.设置仓库

```sh
// 命令1
$ sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg-agent \
    software-properties-common
```

```sh
// 命令2
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

// 命令3
sudo apt-key fingerprint 0EBFCD88

// 命令4
sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"
   

```

### 3.安装docker

```sh
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io
```

### 4.测试安装成功

```sh
sudo docker run hello-world
```

![mark](http://cdn.jayh.club/blog/20200408/8ESqchvexBAd.png?imageslim)

### 5.设置开机自启动

sudo systemctl enable docker 

### 6.配置镜像加速

https://cr.console.aliyun.com/cn-hangzhou/instances/mirrors

![mark](http://cdn.jayh.club/blog/20200408/9ODDhfgeyXzK.png?imageslim)

``` sh
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["您的专属加速器地址"]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker
```



### 7. 免sudo使用docker命令

当以普通用户身份去使用docker images时，出现以下错误：

Got permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Get http://%2Fvar%2Frun%2Fdocker.sock/v1.26/images/json: dial unix /var/run/docker.sock: connect: permission denied
可以看都，最后告知我们时权限的问题。那么在linux文件权限有三个数据左右drwxrwxrwx，

![img](https://box.kancloud.cn/272ac83aa7afb34e47648edbfe7ca229_548x73.png)

其中第一为d代表该文件是一个文件夹
前三位、中三位、后三位分别代表这属主权限、属组权限、其他人权限。
如图，其中 第三列、第四列分别代表文件的属主、属组。

上图是报错文件的权限展示，可以看到其属主为root，权限为rw，可读可写；其属组为docker，权限为rw，可读可写。如果要当前用户可直接读取该文件，那么我们就为当前用户添加到docker属组即可。

如果还没有 docker group 就添加一个：

```
sudo groupadd docker

将用户加入该 group 内。然后退出并重新登录就生效啦。
sudo gpasswd -a ${USER} docker

重启 docker 服务
sudo service docker restart

切换当前会话到新 group 或者重启 X 会话
newgrp - docker

注意:最后一步是必须的，否则因为 groups 命令获取到的是缓存的组信息，刚添加的组信息未能生效，所以 docker images 执行时同样有错。
```

### 8. apt-get update更新慢

Ubantu 18.04 apt-get update 无法更新，更新慢的问题 https://blog.csdn.net/stopping5/article/details/80493643

```sh
sudo cp /etc/apt/sources.list /etc/apt/sources.list.old
sudo vim /etc/apt/sources.list
替换成阿里源

#阿里源：
deb http://mirrors.aliyun.com/ubuntu/ trusty main restricted universe multiverse
deb http://mirrors.aliyun.com/ubuntu/ trusty-security main restricted universe multiverse
deb http://mirrors.aliyun.com/ubuntu/ trusty-updates main restricted universe multiverse
deb http://mirrors.aliyun.com/ubuntu/ trusty-proposed main restricted universe multiverse
deb http://mirrors.aliyun.com/ubuntu/ trusty-backports main restricted universe multiverse
deb-src http://mirrors.aliyun.com/ubuntu/ trusty main restricted universe multiverse
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-security main restricted universe multiverse
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-updates main restricted universe multiverse
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-proposed main restricted universe multiverse
deb-src http://mirrors.aliyun.com/ubuntu/ trusty-backports main restricted universe multiverse
```





其他命令

docker update redis --restart=always 虚拟机重启后，redis自动启动

docker update mysql --restart=always 虚拟机重启后，mysql自动启动

## 4.4 docker 安装mysql

### 1.下载镜像

``` sh
sudo docker pull mysql:5.7
```

```
ubuntu@VM-0-13-ubuntu:~$ sudo docker pull mysql:5.7
5.7: Pulling from library/mysql
c499e6d256d6: Pull complete 
22c4cdf4ea75: Pull complete 
6ff5091a5a30: Pull complete 
2fd3d1af9403: Pull complete 
0d9d26127d1d: Pull complete 
54a67d4e7579: Pull complete 
fe989230d866: Pull complete 
466a91a95e2f: Pull complete 
3e4554c238f1: Pull complete 
603b48ead88c: Pull complete 
1e86a9aa7171: Pull complete 
Digest: sha256:fbaeced79cfdae5d3c8d4a8c41e883f254f72ed7428c6b93a498824b76d97121
Status: Downloaded newer image for mysql:5.7
docker.io/library/mysql:5.7
```

### 2.查看下载的镜像

``` sh
sudo docker images
```

![mark](http://cdn.jayh.club/blog/20200408/7QiFgCOVD0OC.png?imageslim)

### 3.创建mysql实例并启动

- 创建mysql实例并启动

``` sh
sudo docker run -p 3306:3306 --name mysql \
-v /mydata/mysql/log:/var/log/mysql \
-v /mydata/mysql/data:/var/lib/mysql \
-v /mydata/mysql/conf:/etc/mysql \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql:5.7
参数说明
-p 3306:3306 将容器的3306端口映射到主机
-v /mydata/mysql/log:/var/log/mysql\ 将日志文件挂载到主机
-v /mydata/mysql/data:/var/lib/mysql\ 将数据文件挂载到主机
-v /mydata/mysql/conf:/etc/mysql\ 将配置文件挂载到主机
```

![mark](http://cdn.jayh.club/blog/20200408/3edTHcpOsU46.png?imageslim)

- 查看docker容器

  mysql容器已启动

![mark](http://cdn.jayh.club/blog/20200408/99jqOmq2tshz.png?imageslim)

### 4.连接数据库

- 用Workbench连接数据库

![mark](http://cdn.jayh.club/blog/20200408/vj81LmpK9zEn.png?imageslim)

- 查看数据库

![mark](http://cdn.jayh.club/blog/20200408/hkkUN9VUCNR4.png?imageslim)

### 5.进入mysql 容器

``` sh
sudo docker exec -it mysql /bin/bash
```

![mark](http://cdn.jayh.club/blog/20200408/ruh1ghIj40QA.png?imageslim)

### 6.查看虚拟机映射文件

``` sh
cd /mydata/mysql
ls
```

![mark](http://cdn.jayh.club/blog/20200408/wzdOsRaOi2D8.png?imageslim)

### 7.修改mysql账号密码

``` sh
1.进入mysql容器
docker exec -it mysql /bin/bash

2.登录mysql
mysql -u root -p
输入密码：root

3.切换数据库
use mysql

4.查询root用户
select * from user where user = root;

5.修改密码
update user set authentication_string = password('新的密码'), password_expired = 'N', password_last_changed = now() where user = 'root';

6.这条命令暂不清楚
update user set plugin="mysql_native_password";

7.刷新权限
flush privileges;

8.退出
quit;

9.重新登录
mysql -u root -p 

输入新的密码，登录成功
```

### 8.其他命令

- 设置容器在机器重启后自动启动

``` sh
docker update 84c --restart=always
```

## 4.5 docker安装redis

### 1.下载镜像

- 下载镜像

``` sh
sudo docker pull redis
```

```sh
ubuntu@VM-0-13-ubuntu:~$ sudo docker pull redis
Using default tag: latest
latest: Pulling from library/redis
c499e6d256d6: Already exists 
bf1bc8a5a7e4: Pull complete 
7564fb795604: Pull complete 
ec6e86f783e4: Pull complete 
1371d6223f46: Pull complete 
021fd554320f: Pull complete 
Digest: sha256:a732b1359e338a539c25346a50bf0a501120c41dc248d868e546b33e32bf4fe4
Status: Downloaded newer image for redis:latest
docker.io/library/redis:latest
```

- 查看下载的镜像

``` sh
sudo docker images
```

![mark](http://cdn.jayh.club/blog/20200408/MKBt0WBqxGan.png?imageslim)

### 2.启动redis

- 创建redis.conf 配置文件

``` sh
sudo mkdir -p /mydata/redis/conf
sudo touch /mydata/redis/conf/redis.conf
```

- 启动redis

``` sh
sudo docker run -p 6379:6379 --name redis -v /mydata/redis/data:/data \
-v /mydata/redis/conf/redis.conf:/etc/redis/redis.conf \
-d redis redis-server /etc/redis/redis.conf
```

![mark](http://cdn.jayh.club/blog/20200408/G7ajnGUfDQsn.png?imageslim)

### 3.连接redis

```sh
sudo docker exec -it redis redis-cli
```

### 4.测试redis

设置a=100，返回OK

``` sh
set a 100
```

获取a的值，返回"100"

``` sh
get a
```

![mark](http://cdn.jayh.club/blog/20200408/pyqMcA67Sye8.png?imageslim)

### 5.设置redis持久化存储

- 修改虚拟机映射的redis配置文件

``` sh
修改配置文件：
sudo vim  /mydata/redis/conf/redis.conf
添加配置：
appendonly yes


```

- 检查是否生效

``` sh
重启redis容器：
docker restart redis
设置a=200，返回OK
set a 200
获取a的值，返回"200"
get a
重启redis容器
sudo docker restart redis
重新连接redis容器
sudo docker exec -it redis redis-cli
获取a的值
get a,返回"200"
```

### 6.安装redis可视化工具

- 安装redis可视化工具

  redis-desktop-manager

- 连接redis

![mark](http://cdn.jayh.club/blog/20200408/Nf7XJjB1DzbW.png?imageslim)

- 查看redis数据库

![mark](http://cdn.jayh.club/blog/20200408/QUVveBGFSvcB.png?imageslim)

## 4.6 本地开发环境配置

### 1. 本地环境安装Java

我本地环境的java版本 1.8.0_131

``` sh
java -version
```

![mark](http://cdn.jayh.club/blog/20200409/Rgsr2cSJK2op.png?imageslim)

java安装和环境变量配置：https://www.cnblogs.com/jackson0714/p/6591942.html

### 2.本地环境配置Maven

（1）下载Maven，拷贝文件夹到C盘

C:\apache-maven-3.6.2

（2）添加到环境变量

![mark](http://cdn.jayh.club/blog/20200412/v7rtqjkVwQtC.png?imageslim)

 

 cmder里面 执行命令 mvn -v

如果报错命令不存在，则重新启动cmder

![mark](http://cdn.jayh.club/blog/20200412/7rGpkYz7poOv.png?imageslim)

（3）设置Maven代理

阿里云代理 https://maven.aliyun.com/mvn/view

点击使用指南，拷贝配置指南

![mark](http://cdn.jayh.club/blog/20200412/QzrJuur9YETW.png?imageslim)

```xml
<mirror>
    <id>aliyunmaven</id>
    <mirrorOf>*</mirrorOf>
    <name>阿里云公共仓库</name>
    <url>https://maven.aliyun.com/repository/public</url>
</mirror>
```

（4）配置jdk1.8编译项目

``` xml
<profiles>
    <profile>
        <id>jdk-1.8</id>
        <activation>
            <activeByDefault>true</activeByDefault>
            <jdk>1.8</jdk>
        </activation>
        <properties>
            <maven.compiler.source>1.8</maven.compiler.source>
            <maven.compiler.target>1.8</maven.compiler.target>
            <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
        </properties>
    </profile>
<profiles>
```

### 3.IDEA Maven构建工具配置

- Maven配置

![Maven配置](http://cdn.jayh.club/blog/20200409/hnOTRUp5FuFM.png?imageslim)

- 字符集配置

![字符集配置](http://cdn.jayh.club/blog/20200412/cerMB5gRuyG7.png?imageslim)

### 4. IDEA 安装Lombok插件

Lombok：简化JavaBean的开发

![mark](http://cdn.jayh.club/blog/20200409/QXsBR9HVIlzz.png?imageslim)

## 5. IDEA 安装mybatisx 插件

mybatisx：mybatis plus开发的一个插件，从mapper方法快速定位到xml文件

![mark](http://cdn.jayh.club/blog/20200409/r3v9UwnpFadN.png?imageslim)



### 6.安装VSCode

https://code.visualstudio.com/

![mark](http://cdn.jayh.club/blog/20200409/YxKrkYS18n7X.png?imageslim)



### 7.添加VSCode插件

![mark](http://cdn.jayh.club/blog/20200409/yJbjY1fhR3O3.png?imageslim)

- Auto Close Tag 自动加上关闭标签

![mark](http://cdn.jayh.club/blog/20200409/VipCQvRyj9wo.png?imageslim)

- Auto Rename Tag 自动命名配对标签

![mark](http://cdn.jayh.club/blog/20200409/aePiOxpNRkKB.png?imageslim)

- Chinese 中文简体包

![mark](http://cdn.jayh.club/blog/20200409/QAIlWX9eA4lG.png?imageslim)

- ESLint 语法检查

![mark](http://cdn.jayh.club/blog/20200409/Pnz46wDClPNa.png?imageslim)

- HTML CSS Support 帮助CSS开发

![mark](http://cdn.jayh.club/blog/20200409/Rt7NNbFQItKu.png?imageslim)

- HTML Snippets 帮忙HTML开发

![mark](http://cdn.jayh.club/blog/20200409/l5UTT1JNDKVT.png?imageslim)

- JavaScript (ES6) 帮助JavaScript开发

![mark](http://cdn.jayh.club/blog/20200409/zNX7cnSxhsB6.png?imageslim)

- Liver Server 启动一个本地服务

![mark](http://cdn.jayh.club/blog/20200409/lslvvQy9fAKr.png?imageslim)

- open in browser 用浏览器打开文件

![mark](http://cdn.jayh.club/blog/20200409/5XOOR410BIYJ.png?imageslim)

- Vetur  帮助Vue开发

![mark](http://cdn.jayh.club/blog/20200409/PleA3UCu77i1.png?imageslim)

- minapp 帮助小程序开发

![mark](http://cdn.jayh.club/blog/20200409/oQ8dXmeAK6Y2.png?imageslim)

### 问题

1.新项目导入main1,main2

删除main1.iml,main2.iml

## 4.7 配置Git

### 1.配置git 用户名和邮箱

``` sh
git config --global user.name "jackson0714"
git config --global user.email "jackson0585@163.com"
```

### 2.生成ssh key

```sh
ssh-keygen -t rsa -b 4096 -C "jackson0585@163.com"
```

![mark](http://cdn.jayh.club/blog/20200409/Onz67H4OF7fd.png?imageslim)

### 3.设置ssh key

- 打开文件

 C:\Users\Administrator\.ssh\id_rsa.pub

- 拷贝里面的内容

- 打开这个链接

https://github.com/settings/ssh/new

- 粘贴已拷贝的内容

![mark](http://cdn.jayh.club/blog/20200409/26eesOCTIv1A.png?imageslim)

- 保存ssh key

![mark](http://cdn.jayh.club/blog/20200409/EdBtsTK7cnQc.png?imageslim)



### 4.遇到的问题

如果遇到Fatal: HttpRequestException encountered问题

![mark](http://cdn.jayh.club/blog/20200409/GhJ87LMpSTr2.png?imageslim)

则下载这个安装包解决：

[Git Credential Manager for Windows v1.20](https://github.com/microsoft/Git-Credential-Manager-for-Windows/releases/tag/1.20.0)

链接：https://github.com/Microsoft/Git-Credential-Manager-for-Windows/releases/


git每次提交都需要输入用户名和密码

解决办法：git config --global credential.helper store

下次提交输入用户名和密码后就会记住了

### 5.让一个项目同时提交到码云和GitHub两个仓库

在项目目录里找到.git文件夹然后找到config文件。

打开这个文件后找到下面的代码

```
[remote "origin"]
    url = git提交地址
    fetch = +refs/heads/*:refs/remotes/origin/*
```

将其改成

```
[remote "origin"]
    url = 码云Git提交地址
    url = GitHub提交地址
    fetch = +refs/heads/*:refs/remotes/origin/*
```

问题：

c731c6f..69bae9b  master -> master
To https://gitee.com/jayh2018/passjava-portal.git
! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'https://gitee.com/jayh2018/passjava-portal.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.

## 4.8 Windows安装mysql 

### 1.安装截图

![mark](http://cdn.jayh.club/blog/20200610/TkeERMXCMQlu.png?imageslim)

### 2.遇到的问题 1
windows用syslog连接本地mysql数据库，提示 plugin caching_sha2_password


![mark](http://cdn.jayh.club/blog/20200426/MUb6xENWSIOh.png?imageslim)

解决方案：

```sql
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123';
```

![mark](http://cdn.jayh.club/blog/20200426/Ky258k2bJazi.png?imageslim)

### 2.遇到的问题 2
Host is not allowed to connect to this MySQL server

使用远程连接mysql的时候碰到这样的错误：

Host is not allowed to connect to this MySQL server。

简单的解决方式如下：

（1）修改表。可能是你的帐号不允许从远程登陆，只能在localhost。这个时候只要在localhost的那台电脑，登入mysql后，更改 "mysql" 数据库里的 "user" 表里的 "host" 项，从"localhost"改称"%"

mysql -u root -p

按照提示输入密码

mysql>use mysql;

mysql>update user set host = '%' where user = 'root';

（2）修改完后执行如下SQL命令

flush privileges

# 五、PassJava 基础实践篇

## 5.1 初始化项目和添加微服务

### 1.GitHub上创建一个空的仓库

![mark](http://cdn.jayh.club/blog/20200409/4mLUrA7X1YcJ.png?imageslim)

### 2.从GitHub上引入空的项目

![mark](http://cdn.jayh.club/blog/20200409/vYwfPQGdsoLG.png?imageslim)

![mark](http://cdn.jayh.club/blog/20200409/vSURUbNHLdHG.png?imageslim)

### 3.添加内容服务

passjava-content

![mark](http://cdn.jayh.club/blog/20200409/F0vJzcY1oWbK.png?imageslim)

![mark](http://cdn.jayh.club/blog/20200409/ybHePqhqYYMa.png?imageslim)

| 序号 | 字段        | 内容                             |
| ---- | ----------- | -------------------------------- |
| 1    | group       | com.jackson0714.passjava         |
| 2    | Artifact    | passjava-content                 |
| 3    | Name        | passjava-content                 |
| 4    | Description | 佳必过-内容服务                  |
| 5    | Package     | com.jackson0714.passjava.content |

- 添加依赖组件SpringWeb, OpenFeign

![mark](http://cdn.jayh.club/blog/20200409/3492WTNWK8aU.png?imageslim)

![mark](http://cdn.jayh.club/blog/20200409/6GPTxqNeBNyJ.png?imageslim)

### 3.添加其他微服务

| 序号 | 服务描述   | 服务名            |
| ---- | ---------- | ----------------- |
| 1    | 内容微服务 | passjava-content  |
| 2    | 会员微服务 | passjava-member   |
| 3    | 题目微服务 | passjava-question |
| 4    | 学习微服务 | passjava-study    |
| 5    | 渠道微服务 | passjava-channel  |

![mark](http://cdn.jayh.club/blog/20200411/IkdojQtrCVxa.png?imageslim)

### 4.PassJava-Platform添加Pom.xml文件

![mark](http://cdn.jayh.club/blog/20200409/kGoFAy6wAqQ0.png?imageslim)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.jackson0714.passjava</groupId>
    <artifactId>passjava</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>passjava</name>
    <description>佳必过-聚合服务</description>
    <packaging>pom</packaging>

    <modules>
        <module>passjava-content</module>
        <module>passjava-member</module>
        <module>passjava-question</module>
        <module>passjava-study</module>
        <module>passjava-channel</module>
    </modules>
</project>
```

### 5.添加根目录Maven 配置

![mark](http://cdn.jayh.club/blog/20200409/WWWnhkUwJ6J1.png?imageslim)

![mark](http://cdn.jayh.club/blog/20200409/xjpUeEEiGNvz.png?imageslim)

Maven操作根项目就可以了，试下clean

![mark](http://cdn.jayh.club/blog/20200409/F8ice3B84EoQ.png?imageslim)

![mark](http://cdn.jayh.club/blog/20200409/6J6wcD3jcTEO.png?imageslim)

### 6. 配置.gitignore文件

提交代码时，忽略某些文件

```json
### gradle ###
.gradle
/build/
!gradle/wrapper/gradle-wrapper.jar

### STS ###
.settings/
.apt_generated
.classpath
.factorypath
.project
.settings
.springBeans
bin/

### IntelliJ IDEA ###
.idea
*.iws
*.iml
*.ipr
rebel.xml

### NetBeans ###
nbproject/private/
build/
nbbuild/
dist/
nbdist/
.nb-gradle/

### maven ###
target/
*.war
*.ear
*.zip
*.tar
*.tar.gz
**/mvnw
**/mvnw.cmd
**/.mvn

### logs ####
/logs/
*.log

### temp ignore ###
*.cache
*.diff
*.patch
*.tmp
*.java~
*.properties~
*.xml~

### system ignore ###
.DS_Store
Thumbs.db
Servers
.metadata
upload
gen_code

### database ###

db/db_back_dir/

### redis ###
/redis/
```

删除子项目的.gitignore文件

![mark](http://cdn.jayh.club/blog/20200409/Xby2yw7XDVpu.png?imageslim)

### 7.提交代码

可以用IDEA的git工具提交，也可以用git bash命令行提交

``` sh
git add .
git commit -m 'xxx'
git push origin master
```

## 5.2 初始化数据库和表

### 用PowerDisigner工具创建数据库

- 用PowerDisigner工具创建数据库

![用PowerDisigner工具创建数据库](http://cdn.jayh.club/blog/20200411/rGkitjMmv7T2.png?imageslim)

总共有5个微服务数据库：内容、学习、渠道、用户、题目

![5个数据库](http://cdn.jayh.club/blog/20200411/Xo71F4ku86PB.png?imageslim)

- 内容微服务的数据库

![内容微服务的数据库](http://cdn.jayh.club/blog/20200411/PkKsIdaWrcUA.png?imageslim)

- 学习微服务的数据库

  ![学习微服务的数据库](http://cdn.jayh.club/blog/20200411/j9dtS9xryyEv.png?imageslim)

- 渠道微服务的数据库

  ![渠道微服务的数据库](http://cdn.jayh.club/blog/20200411/60lbRmKajihg.png?imageslim)

- 用户微服务的数据库

  ![用户微服务的数据库](http://cdn.jayh.club/blog/20200411/qa2OQTzGyR9U.png?imageslim)

- 题目微服务的数据库

![题目微服务的数据库](http://cdn.jayh.club/blog/20200411/LTxxK6fEeL6E.png?imageslim)

SQL文件在这个项目里面：https://github.com/Jackson0714/PassJava-Platform.git

![SQL文件](http://cdn.jayh.club/blog/20200411/lSMwH7s8V19O.png?imageslim)

![mark](http://cdn.jayh.club/blog/20200411/4jVMyPUGn0ns.png?imageslim)


## 5.3 搭建管理后台

> 管理后台使用人人开源的后台管理框架，完成快速搭建。

### 1.下载人人开源后台管理框架

- renren-fast

https://gitee.com/renrenio/renren-fast.git

- renren-fast-vue

https://gitee.com/renrenio/renren-fast-vue.git

### 2.添加人人开源后端代码

PassJava项目

拷贝文件夹renren-fast到PassJava根目录

POM文件 添加依赖

``` xml
<module>renren-fast</module>
```

### 3.初始化后台管理数据库

- 创建数据库：passjava_admin

- 执行renren-fast/db/mysql.sql脚本

![](http://cdn.jayh.club/blog/20200411/juqCArak674q.png?imageslim)

### 4.修改renren-fast 服务的配置文件

文件路径：src/main/resources/application-dev.yml

- 修改数据库连接为自己的mysql数据库连接

![mark](http://cdn.jayh.club/blog/20200411/gisvmdRTwJmz.png?imageslim)

### 5.启动renren-fast服务

- 配置SDK为1.8 

![mark](http://cdn.jayh.club/blog/20200411/rR2Pthfpcya9.png?imageslim)

![mark](http://cdn.jayh.club/blog/20200411/swolhMLLHlLD.png?imageslim)- 

- 运行renren-fast后台

  ![mark](http://cdn.jayh.club/blog/20200411/gMYiHlBHl4zn.png?imageslim)

出现错误：com.mysql.cj.jdbc.exceptions.PacketTooBigException: Packet for query is too large...

解决方案：修改mysql容器的配置文件

``` sh
cd /mydata/mysql/conf
sudo vim my.cnf

添加配置，[mysqld_safe]如果有，则不需要添加
[mysqld_safe]
max_allowed_packet=32M
```

- 执行结果

![mark](http://cdn.jayh.club/blog/20200411/IFil27TVJIQT.png?imageslim)

- 测试服务运行状态

  浏览器输入：http://localhost:8080/renren-fast/

  显示结果：

  ``` json
  {"msg":"invalid token","code":401}
  ```

  结果如上所示，则表示服务运行正常。另外结果里面的invalid token说明权限不足，不是指服务不正常。

### 6.启动前端项目

- 配置cnpm

  ``` sh
  npm install -g cnpm --registry=https://registry.npm.taobao.org
  ```

- 安装node_modules依赖包

  ``` sh
  cnpm install
  ```

- 打包前端项目

  ```  sh
  npm run dev
  ```

- 浏览后台

  http://localhost:8002

  ![mark](http://cdn.jayh.club/blog/20200411/F6qFoEbBFFKP.png?imageslim)

### 7.前后端联调登录

- 登录后台

  账号：admin

  密码：admin

  登录成功

  ![mark](http://cdn.jayh.club/blog/20200411/c2RmpUrgw7MP.png?imageslim)

- 查看后端服务日志

  ![mark](http://cdn.jayh.club/blog/20200411/oPGlFndNIRps.png?imageslim)

说明前端登录请求发送到了后端服务，并验证了用户名和密码是否正确。

## 5.4 自动生成前后端代码

### 1.下载代码生成器框架

``` sh
git clone https://gitee.com/renrenio/renren-generator.git
```

### 2.添加人人开源后端代码

PassJava项目

拷贝文件夹renren-fast到PassJava根目录

POM文件 添加依赖

``` xml
<module>renren-generator</module>
```

### 3.修改renren-generator服务的配置文件

（1）修改数据库链接 src/main/resources/application-dev.yml

- 修改数据库连接为自己的mysql数据库连接

- 数据库名改为要生成代码的服务，如passjava_qms数据库

  ``` xml
  url: jdbc:mysql://129.211.188.xxx:3306/passjava_qms?useUnicode=true&characterEncoding=UTF-8&useSSL=false
  username: root
  password: root
  ```


（2）修改属性配置文件 src/main/resources/generator.properties

```properties
# 以question微服务为例
mainPath=com.jackson0714
package=com.jackson0714.passjava
moduleName=question
author=jackson0714
email=jackson0585@163.com
tablePrefix=qms_
```

（3）修改controller 模板文件

src/main/resources/template/Controller.java.vm

删除引入的包，后面再引入

``` java
import org.apache.shiro.authz.annotation.RequiresPermissions;
```

注释RequiresPermissions注解，后面再引入

```java
@RequiresPermissions("${moduleName}:${pathName}:list")
```

### 4.启动代码生成器服务

![启动代码生成器服务](http://cdn.jayh.club/blog/20200412/yJd2l0DKTfd0.png?imageslim)

浏览器打开localhost，可以看到数据库qms的两张表已经显示在后台了

![mark](http://cdn.jayh.club/blog/20200412/ddEkOhGYqoGD.png?imageslim)

### 5.生成代码

- 生成代码

![生成代码](http://cdn.jayh.club/blog/20200412/BgYYVUlnY2NC.png?imageslim)

![代码生成器生成的pms服务代码](http://cdn.jayh.club/blog/20200412/NM1ApxlLXKKu.png?imageslim)

- 拷贝main文件夹到question模块src目录

- 删除前端代码passjava-question\src\main\resources\src目录

- 代码结构

  ![代码结构](http://cdn.jayh.club/blog/20200412/TkijmnIalY9z.png?imageslim)

生成的代码包含controller，dao层，实体类，接口实现类，mapper映射文件

### 6.添加common 模块

因为自动生成的代码引用了一些工具类，而我们的项目中没有，所以需要加个common模块添加一些工具类

![引用工具类报错](http://cdn.jayh.club/blog/20200412/MthdcPT2mqK8.png?imageslim)

- 添加passjava-common

  New Module: 选择Maven

  ![选择Maven](http://cdn.jayh.club/blog/20200412/XCYkwexOdyg6.png?imageslim)

Name: passjava-common

![添加common模块](http://cdn.jayh.club/blog/20200412/8Jvylhjdn85G.png?imageslim)

### 7.question模块添加common模块依赖

pom文件添加依赖

```xml
<dependency>
    <groupId>com.jackson0714.passjava</groupId>
    <artifactId>passjava-common</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### 8.common模块添加依赖

- MyBatis-Plus

  ``` xml
  <!--mybatis-plus DAO层工具 https://mp.baomidou.com/-->
  <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus</artifactId>
      <version>3.2.0</version>
  </dependency>
  ```
  
- lombok依赖

  ``` xml
  <!--lombok 不需要写getter,setter方法了-->
  <dependency>
    <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.12</version>
  </dependency>
  ```
  
- httpcore依赖
  ``` xml
  <!--httpcore 依赖-->
  <dependency>
      <groupId>org.apache.httpcomponents</groupId>
      <artifactId>httpcore</artifactId>
      <version>4.4.12</version>
  </dependency>
  ```

- commons-lang依赖

  ```xml
  <!--commons-lang 依赖 -->
  <dependency>
      <groupId>commons-lang</groupId>
      <artifactId>commons-lang</artifactId>
      <version>2.6</version>
  </dependency>
  ```

- servlet依赖

  ``` xml
  <!--  导入servlet-api 依赖  -->
  <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
      <scope>provided</scope>
  </dependency>
  ```

### 9.common模块添加工具类

- 添加包com.jackson0714.common.utils

- 从renren-fast项目copy文件

  `Constans.java`、`PageUtils.java`、`Query.java`、`R.java`、`RRException.java`

- 添加包`com.jackson0714.common.xss`

- 从renren-fast项目copy文件

  `HTMLFilter.java`、`SQLFilter.java`

![passjava-common代码结构图](http://cdn.jayh.club/blog/20200413/9HK1gDH3i5nB.png?imageslim)

![拷贝renren-fast文件](http://cdn.jayh.club/blog/20200413/Aqx99dkjs5SC.png?imageslim)

## 5.5 整合MyBatis-Plus实现CRUD

### 1.添加Mybatis-Plus依赖

``` xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.2.0</version>
</dependency>
```

### 2.配置数据源

- 导入数据库的驱动
  - 查看mysql版本 5.7.29

![mark](http://cdn.jayh.club/blog/20200413/6kWL77qdyEGc.png?imageslim)

到maven仓库查看适用的mysql驱动，5.7的没有，8.0兼容5.7的，所以选择8.0的驱动

```xml
<!--添加mysql驱动-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.17</version>
</dependency>
```

### 3.配置MyBatis-Plus

- 添加application.yml 文件配置数据源

  文件路径：/passjava-question/src/main/resources/application.yml

  ``` yaml
  spring:
    datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://129.211.188.xxx:3306/passjava_admin?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
        username: root
        password: xxx
  ```

- 配置mapper映射文件路径

  ![配置mabatis-plus时的智能提示](http://cdn.jayh.club/blog/20200414/6mexDBOjV7mO.png?imageslim)
  
  ``` yxml
  mybatis-plus:
    mapper-locations: classpath:/mapper/**/*.xml
    global-config:
      db-config:
        id-type: auto
  ```
  
- 添加MapperScan注解

  ``` java
  @MapperScan("com.jackson0714.passjava.question.dao")
  @SpringBootApplication
  public class PassjavaQuestionApplication {
      public static void main(String[] args) {
          SpringApplication.run(PassjavaQuestionApplication.class, args);
      }
  }
  ```

### 4.测试mybatis-plus的CRUD方法

- 创建类型为javaBasic的type表数据

  ``` java
  @Autowired
  TypeService typeService;
  
  // 创建题目类型
  @Test
  void testCreateType() {
      TypeEntity typeEntity = new TypeEntity();
      typeEntity.setType("javaBasic");
      typeService.save(typeEntity);
      System.out.println("创建成功");
  }
  ```

  ![创建类型为javaBasic的type表数据](http://cdn.jayh.club/blog/20200414/aJ5jNXUKoiUW.png?imageslim)

- 更新id=1的表数据

  ``` java
  // 更新type=jvm
  @Test
  void testUpdateType() {
      TypeEntity typeEntity = new TypeEntity();
      typeEntity.setId(1L);
      typeEntity.setType("jvm");
      typeService.updateById(typeEntity);
      System.out.println("修改成功");
  }
  ```

  ![更新id=1的表数据](http://cdn.jayh.club/blog/20200414/AM3PCVuHgaQu.png?imageslim)



- 查询id=1的表数据

  ```
  // 查询题目类型
  @Test
  void testSelectType() {
      List<TypeEntity> typeEntityList = typeService.list(new QueryWrapper<TypeEntity>().eq("id",1L));
      typeEntityList.forEach((item)-> {
          System.out.println(item);
      });
      System.out.println("查询成功");
  }
  ```

![查询id=1的表数据](http://cdn.jayh.club/blog/20200414/9LfJymakpcWw.png?imageslim)

- 删除id=1的表数据

  ```java
  // 删除题目类型记录
  @Test
  void testRemoveType() {
      typeService.removeById(1L);
      System.out.println("删除成功");
  }
  ```

![删除id=1的表数据](http://cdn.jayh.club/blog/20200414/N0hTuJB1mDm1.png?imageslim)

## 5.6 生成所有微服务的CRUD代码
### 1. 修改代码生成器配置文件

（1）\renren-generator\src\main\resources\generator.properties

``` properties
mainPath=com.jackson0714
package=com.jackson0714.passjava
moduleName=channel
author=jackson0714
email=jackson0585@163.com
tablePrefix=chms_
```

（2）\renren-generator\src\main\resources\application.yml

修改连接的数据库：passjava_chms

### 2.生成渠道微服务代码

启动服务，打开浏览器：http://localhost:8003/#generator.html

注意：端口地址默认是8080，我配置成了8003。

![生成渠道微服务代码](http://cdn.jayh.club/blog/20200415/QSr1Ctzk2YOq.png?imageslim)

### 3.添加生成的代码

- 删除自动生成的代码中的文件夹：main\resources\src
- 拷贝main文件夹到channel模块src目录下

### 4.配置渠道微服务

- pom.xml引入common模块

  ``` xml
  <dependency>
      <groupId>com.jackson0714.passjava</groupId>
      <artifactId>passjava-common</artifactId>
      <version>0.0.1-SNAPSHOT</version>
  </dependency>
  ```

- 添加application.yml

  ``` yaml
  spring:
    datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://129.211.188.xxx:3306/passjava_chms?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
        username: root
        password: xxx
  
  mybatis-plus:
    mapper-locations: classpath:/mapper/**/*.xml
    global-config:
      db-config:
        id-type: auto
  ```

- 5.测试channel服务接口

  访问：http://localhost:8000/channel/channel/list

  返回：

  ``` json
  {"msg":"success","code":0,"page":{"totalCount":0,"pageSize":10,"totalPage":0,"currPage":1,"list":[]}}
  ```

### 5.生成所有微服务的CRUD代码

![生成所有微服务代码](http://cdn.jayh.club/blog/20200415/4Ka6egGEKz0m.png?imageslim)

### 6.配置微服务端口

``` sh
passjava-channel  端口8000
passjava-content  端口9000
passjava-member 端口10000
passjava-question 端口11000
passjava-study 端口12000
```

所有微服务都启动成功并测试接口通过

``` sh
http://localhost:8000/channel/channel/list
http://localhost:9000/content/banner/list
http://localhost:10000/member/member/list
http://localhost:11000/question/question/list
http://localhost:12000/study/studytime/list
```

![mark](http://cdn.jayh.club/blog/20200415/1XPKa1g1NdoL.png?imageslim)


## 5.7 管理后台-题目类型功能

### 1.环境准备

- 代码准备

  将renren-fast-vue代码copy到自己的前端项目中

- 安装node_module

```sh
cnpm install
```

- 启动前端portal

``` sh
npm run dev
```

- 登陆后台

  1.启动RenrenAplication
  
  2.输入用户名和密码登陆
  
  ![PassJava后台](http://cdn.jayh.club/blog/20200425/DQDm4seRS85s.png?imageslim)

### 2. 添加目录和菜单

- 添加`题目中心`目录(一级菜单)

![添加题目管理菜单](http://cdn.jayh.club/blog/20200425/xN7NHGsUFGNe.png?imageslim)

刷新页面,就可以看到题目中心菜单

- 添加题目`类型维护`菜单(二级菜单)

![题目类型维护菜单](http://cdn.jayh.club/blog/20200425/mg5QrTbMnNCn.png?imageslim)

![题目中心菜单](http://cdn.jayh.club/blog/20200425/NlVRP5AdpJjV.png?imageslim)

可以看到数据库新增了两条记录,分别对应两个菜单

![sys_menu表](http://cdn.jayh.club/blog/20200425/c6WJ6Xdt1JR9.png?imageslim)

点击类型维护菜单,打开了链接:http://localhost:8002/#/question-type,页面显示空白页面.

### 3.自动生成前端页面

用renren-generator自动生成前端代码,可以参考这篇:[13.SpringCloud实战项目-自动生成前后端代码](http://www.passjava.cn/#/02.PassJava架构篇/04.自动生成前后端代码)

拷贝question目录到前端目录 \src\views\modules

![自动生成前端代码](http://cdn.jayh.club/blog/20200425/lQIv1UMSBLBH.png?imageslim)

![前端Vue页面](http://cdn.jayh.club/blog/20200425/pzjq0UwcnbfU.png?imageslim)



### 4. 测试类型维护功能

点击类型维护菜单,可以看到请求报404

 http://localhost:8080/renren-fast/question/type/list?t=1587825969456&page=1&limit=10&key=

![mark](http://cdn.jayh.club/blog/20200425/jdVLJmTeKUsh.png?imageslim)

> 因为页面的请求都访问到renren-fast服务了,所以要修改为访问题目微服务。但是前端有很多请求访问的是不同的服务，所以我们可以通过网关来作为请求的入口，然后将不同的请求路由到不同的服务。

SpringCloud整合网关可以看之前写的一篇文章：[20.SpringCloud整合Gateway网关](http://www.passjava.cn/#/02.PassJava架构篇/11.SpringCloud整合Gateway网关)

### 5.配置请求到网关

文件：\static\config\index.js

api接口请求地址替换为gateway的地址

``` javascript
window.SITE_CONFIG['baseUrl'] = 'http://localhost:8080/renren-fast';
替换为
window.SITE_CONFIG['baseUrl'] = 'http://localhost:8060'; // 网关地址
```

刷新页面，发现会回到登录页面，而且验证码获取不到，F12调试工具可以看到验证码请求发送到网关上，而网关上找不到这个请求地址(http://localhost:8060/captcha.jpg)，所以报404。其实验证码请求应该访问renren-fast服务，所以我们要将验证码请求通过网关转发到renren-fast服务(http://localhost:8080/renren-fast/captcha.jpg)。

``` json
# 验证码请求：
GET http://localhost:8060/captcha.jpg?uuid=1ce21f53-1866-40b1-8b20-2f4515d59f0d 404 (Not Found)
```

![获取验证码报404](http://cdn.jayh.club/blog/20200425/kAhPX4oiglXY.png?imageslim)

> 可以将renren-fast注册到注册中心，然后通过网关将请求转发到renren-fast服务。

### 6.注册renren-fast服务

- renren-fast项目添加common依赖

``` xml
<dependency>
    <groupId>com.jackson0714.passjava</groupId>
    <artifactId>passjava-common</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

- 配置注册中心地址

```yaml
cloud:
  nacos:
    discovery:
      server-addr: 127.0.0.1:8848
```

- 配置应用程序的名称

``` yaml
application:
  name: renren-fast
```

- 应用类添加`@EnableDiscoveryClient`注解

- 查看服务是否注册成功

![Nacos服务列表](http://cdn.jayh.club/blog/20200425/JcoXD3tdLLoQ.png?imageslim)

### 7. 添加网关路由规则

- 配置路由规则

passjava-gateway项目中application.yml文件配置路由规则，并重启passjava-gateway服务

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: route_portal # 路由规则id
          uri: lb://renren-fast # 负载均衡，renren-fast服务
          predicates: # 断言
            - Path=/api/** # 如果前端请求路径包含 api，则应用这条路由规则
          filters: #过滤器
            - RewritePath=/api/(?<segment>.*),/renren-fast/$\{segment} # 将访问路径中包含的api替换成renren-fast，但是替换的url不会在前端显示，还是网关的访问路径。这里不是跳转到新的路径，而是转发请求。
```

- 修改前端请求路径

文件：\static\config\index.js

请求路径添加`api`

``` javascript
 window.SITE_CONFIG['baseUrl'] = 'http://localhost:8086';
 替换为
 window.SITE_CONFIG['baseUrl'] = 'http://localhost:8060/api'; // 添加api
```

- 刷新登录页面，可以正常获取验证码，请求路径为网关地址 + /api/captcha
``` javascript
http://localhost:8060/api/captcha.jpg?uuid=84d36089-07ae-4201-85c0-8217b032f21b
```

> 前端将请求发送到网关http://localhost:8060/api/captcha.jpg，网关将请求转发到http://localhost:8060/api/renren-fast/captcha.jpg。

- 登录，报跨域问题

``` javascript
Access to XMLHttpRequest at 'http://localhost:8060/api/sys/login' from origin 'http://localhost:8002' has been blocked by CORS policy: Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on the requested resource.
```

> 登录页面url：http://localhost:8002，点击登录访问的请求url：http://localhost:8060/api/sys/login，两个url的端口号不一样，产生了跨域问题。 


### 8.跨域问题

- 跨域资源共享([CORS](https://developer.mozilla.org/zh-CN/docs/Glossary/CORS)) 是一种机制，它使用额外的 [HTTP](https://developer.mozilla.org/zh-CN/docs/Glossary/HTTP) 头来告诉浏览器 让运行在一个 origin (domain) 上的Web应用被准许访问来自不同源服务器上的指定的资源。当一个资源从与该资源本身所在的服务器**不同的域、协议或端口**请求一个资源时，资源会发起一个**跨域 HTTP 请求**。

- 比如，站点 http://domain-a.com 的某 HTML 页面通过 [ 的 src ](https://developer.mozilla.org/zh-CN/docs/Web/HTML/Element/Img#Attributes)请求 http://domain-b.com/image.jpg。网络上的许多页面都会加载来自不同域的CSS样式表，图像和脚本等资源。

- 出于安全原因，浏览器限制从脚本内发起的跨源HTTP请求。 例如，XMLHttpRequest和Fetch API遵循同源策略。 这意味着使用这些API的Web应用程序只能从加载应用程序的同一个域请求HTTP资源，除非响应报文包含了正确CORS响应头。

  ![跨域场景](http://cdn.jayh.club/blog/20200426/WIKGCdNkHU2S.png?imageslim)

[^官方文档]: https://developer.mozilla.org/zh-CN/docs/Web/http/access_control_cors

### 9.解决跨域问题

- 添加响应头，配置当次请求允许跨域
  - **Access-Control-Allow-Origin**：支持哪些来源的请求跨域
  - **Access-Control-Allow-Methods**：支持哪些方法跨域
  - **Access-Control-Allow-Credentials**：跨域请求默认不包含cookie，设置为true可以包含cookie
  - **Access-Control-Expose-Headers**：跨域请求暴露的字段CORS请求时，XMLHttpRequest对象的getResponseHeader()方法只能拿到6个基本字段：Cache-Control、Content-Language、Content-Type、Expires、Last-Modified、Pragma。如果想拿到其他字段，就必须在Access-Control-Expose-Headers里面指定。
  - **Access-Control-Max-Age**：表明该响应的有效时间为多少秒。在有效时间内，浏览器无
    须为同一请求再次发起预检请求。请注意，浏览器自身维护了一个最大有效时间，如果
    该首部字段的值超过了最大有效时间，将不会生效。  

- 添加跨域配置

  passjava-gateway应用中添加配置类PassJavaCorsConfiguration.java

``` java
package com.jackson0714.passjava.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class PassJavaCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 配置跨域
        corsConfiguration.addAllowedHeader("*"); // 允许所有请求头跨域
        corsConfiguration.addAllowedMethod("*"); // 允许所有请求方法跨域
        corsConfiguration.addAllowedOrigin("*"); // 允许所有请求来源跨域
        corsConfiguration.setAllowCredentials(true); //允许携带cookie跨域，否则跨域请求会丢失cookie信息

        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsWebFilter(source);
    }
}
```

- 注释renren-fast里面的跨域配置

  文件路径：src/main/java/io/renren/config/CorsConfig.java

- 登录成功

  可以看到login请求的响应报文中包含了已配置的CORS响应头

![login请求](http://cdn.jayh.club/blog/20200426/NSLDIVzxTObO.png?imageslim)

### 10.配置题目服务的路由规则

我们访问题目中心的类型页面，发现还是报404找不到资源

所以我们需要配置题目服务的路由规则，将题目中心的页面请求经网关转发到题目服务。

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: route_question # 题目微服务路由规则
          uri: lb://passjava-question # 负载均衡，将请求转发到注册中心注册的renren-fast服务
          predicates: # 断言
            - Path=/api/question/** # 如果前端请求路径包含 api/question，则应用这条路由规则
          filters: #过滤器
            - RewritePath=/api/(?<segment>.*),/$\{segment} # 将跳转路径中包含的api替换成question
```

> 注意：若predicates的Path更精确，则将路由规则放到更上面，优先命中更上面的路由规则。

### 11.测试类型维护功能

- 数据库插入3条测试数据

- 测试查询列表，可以看到有三条记录查询出来了

  ![类型维护页面](http://cdn.jayh.club/blog/20200426/bHc19bUWFYh5.png?imageslim)

- 测试修改一条数据，可以看到数据库里面记录更新为23了

  ![修改类型logo](http://cdn.jayh.club/blog/20200426/9uvVAcBOPTyR.png?imageslim)

- 测试删除一条数据，可以看到界面和数据库都删除了一条数据

  ![mark](http://cdn.jayh.club/blog/20200426/d2TqT4T7JHOI.png?imageslim)

### 12.打开新增和批量删除功能

注释权限判断，默认返回true

``` js
// src\utils\index.js
/**
 * 是否有权限
 * @param {*} key
 */
export function isAuth (key) {
  // return JSON.parse(sessionStorage.getItem('permissions') || '[]').indexOf(key) !== -1 || false
  return true
}
```

![新增和批量删除按钮](http://cdn.jayh.club/blog/20200426/ik2i5TzzSoGJ.png?imageslim)

## 5.8 管理后台-题目维护功能

### 1.配置逻辑删除

- 所有表字段添加del_flag字段

  ``` sql
  del_flag tinyint(1) DEFAULT 0 COMMENT '删除标记（0-正常，1-删除）',
  ```

- MyBatisPlus配置逻辑删除

``` yaml
mybatis-plus:
  mapper-locations: classpath:/mapper/**/*.xml
  global-config:
    db-config:
      id-type: auto
      logic-delete-field: delFlag  #全局逻辑删除字段值 3.3.0开始支持，详情看下面。
      logic-delete-value: 1 # 逻辑已删除值(默认为 1)
      logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)
```

- log中打印查询SQL语句

``` sql
SELECT id,type,comments,logo_url,del_flag,create_time,update_time FROM qms_type WHERE del_flag=0 
```

- log打印删除SQL语句

``` sql
UPDATE qms_type SET del_flag=1 WHERE id IN ( 1 ) AND del_flag=0 
```

### 2.快速显示开关

想要将是否显示改为快速开关

![mark](http://cdn.jayh.club/blog/20200426/dWB1QSPspqJN.png?imageslim)



- 自定义列模板

  1.通过 `Scoped slot` 可以获取到 row, column, $index 和 store（table 内部的状态管理）的数据

  2.使用Switch开关

``` vue
Scoped slot：https://element.eleme.cn/#/zh-CN/component/table
Switch开关：https://element.eleme.cn/#/zh-CN/component/switch

<el-table-column prop="enable"
                 header-align="center"
                 align="center"
                 label="是否显示">
    <template slot-scope="scope">
<el-switch
           v-model="scope.row.enable"
           :active-value=1
           :inactive-value=0
           active-color="#13ce66"
           inactive-color="#ff4949"
           @change="updateQuestionStatus(scope.row)">
        </el-switch>
    </template>
</el-table-column>
```

添加更新方法

``` javascript
// 更新题目是否显示
updateQuestionStatus(data) {
    console.log(data)
    let {id, enable} = data
    this.$http({
        url: this.$http.adornUrl('/question/question/update'),
        method: 'post',
        data: this.$http.adornData({id, enable}, false)
    }).then(({ data }) => {
        this.$message({
            type:"success",
            message: "状态更新成功"
        })
    });
},
```

### 3.前端字段校验

对排序字段限制：必须为正整数

``` vue
dataRule: {
  displayOrder: [
    {
      validator: (rule, value, callback) => {
        if (value == "") {
          callback(new Error("排序字段必须填写"));
        } else if (!Number.isInteger(value) || value<0) {
          callback(new Error("排序必须是一个大于等于0的整数"));
        } else {
          callback();
        }
      },
      trigger: "blur"
    }
  ]
}
```

### 4.后端字段校验

- 实体类字段上添加注解`@Positive`必须是大于0的数字

```java
/**
 * 排序
 */
@Positive
private Integer displayOrder;
```

- API 添加注解`@Valid`

```
/**
* 保存
*/
@RequestMapping("/save")
public R save(@Valid @RequestBody QuestionEntity question){
	questionService.save(question);
	return R.ok();
}
```

测试结果

![后端字段校验](http://cdn.jayh.club/blog/20200430/D4xbDjs5c0z7.PNG)

-1，0，0.2 不通过

测试1，1.2通过

### 5.模糊查询题目列表

修改实现类`QuestionServiceImpl`的`queryPage`方法

**原方法**：

``` java
public PageUtils queryPage(Map<String, Object> params) {
    IPage<QuestionEntity> page = this.page(
        new Query<QuestionEntity>().getPage(params),
        new QueryWrapper<QuestionEntity>()
    );

    return new PageUtils(page);
}

```

**修改后**：

``` java
@Override
public PageUtils queryPage(Map<String, Object> params) {
    //1.get key
    String key = (String) params.get("key");
    QueryWrapper<QuestionEntity> queryWrapper = new QueryWrapper<>();
    if (!StringUtils.isEmpty(key)) {
        queryWrapper.eq("id", key).or().like("title", key).or().like("answer", key);
    }
    IPage<QuestionEntity> page = this.page(
        new Query<QuestionEntity>().getPage(params),
        queryWrapper
    );

    return new PageUtils(page);
}

```

### 6.添加分页插件

![没有分页插件显示共0条](http://cdn.jayh.club/blog/20200611/tsgcSujemoXG.png?imageslim)

添加分页插件

```java
package com.jackson0714.passjava.question.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //开启事务
@MapperScan("com.jackson0714.passjava.question.dao")
public class MyBatisConfig {

    //引入分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
         paginationInterceptor.setOverflow(true);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInterceptor.setLimit(1000);
        return paginationInterceptor;
    }
}
```

添加分页插件后的显示

![配置了分页插件的显示](http://cdn.jayh.club/blog/20200611/11fb5z71NsVr.png?imageslim)

# 六、PassJava 高级实践篇

## 6.1 Spring Cloud Alibaba 组件简介
### 1.SpringCloud Alibaba概述

> Spring Cloud Alibaba 致力于提供微服务开发的一站式解决方案。此项目包含开发分布式应用微服务的必需组件，方便开发者通过 Spring Cloud 编程模型轻松使用这些组件来开发分布式应用服务。
>
> 依托 Spring Cloud Alibaba，您只需要添加一些注解和少量配置，就可以将 Spring Cloud 应用接入阿里微服务解决方案，通过阿里中间件来迅速搭建分布式应用系统。

Github:https://github.com/alibaba/spring-cloud-alibaba

**Spring Cloud的几大痛点**

- 部分组件停止维护和更新，有问题也不易解决
- 部分环境搭建起来比较复杂，没有非常友好的可视化界面
- 配置相对来说复杂，需要较高的学习成本

**Spring Cloud Alibaba的优势**

- 阿里经历过了时间的考验
- 设计合理
- 拥有不错的可视化界面，方便运维监控和排查问题
- 环境搭建和配置简单，学习成本低

**PassJava项目搭配SpringCloud Alibaba技术的搭配方案**

| 描述         | Spring Cloud                   | Spring Cloud Alibaba | 组合选用                        |
| ------------ | ------------------------------ | -------------------- | ------------------------------- |
| 服务发现组件 | Eureka（停止维护）服务发现组件 | Nacos 注册中心       | Spring Cloud Alibaba - Nacos    |
| 配置中心组件 | Spring Cloud Config 配置中心   | Nacos 配置中心       | Spring Cloud Alibaba - Nacos    |
| 断路保护组件 | Hystrix 断路保护               | Sentinel 服务容错    | Spring Cloud Alibaba - Sentinel |
| 链路追踪组件 | Sleuth 调用链监控              | /                    | Spring Cloud - Sleuth           |
| 负载均衡组件 | Ribbon                         | /                    | Spring Cloud - Ribbon           |
| 远程调用组件 | OpenFeign （HTTP+JSON）        | Dubbo（RPC框架）     | Spring Cloud - OpenFeign        |
| 分布式事务   | /                              | Seata 分布式事务     | Spring Cloud Alibaba - Seata    |
| API 网关     | Gateway                        | /                    | Spring Cloud - Gateway          |

**最后技术选型：**

``` json
Spring Cloud Alibaba - Nacos 实现注册中心
Spring Cloud Alibaba - Nacos 实现配置中心
Spring Cloud Alibaba - Sentinel  实现服务容错
Spring Cloud Alibaba - Seata 实现分布式事务

Spring Cloud - Ribbon 实现负载均衡
Spring Cloud - Feign 实现远程调用
Spring Cloud - Gateway API网关
Spring Cloud - Sleuth 实现调用链监控
```

### 2.Spring Cloud Alibaba版本

项目的版本号格式为 x.x.x 的形式，其中 x 的数值类型为数字，从 0 开始取值，且不限于 0~9 这个范围。项目处于孵化器阶段时，第一位版本号固定使用 0，即版本号为 0.x.x 的格式。

由于 Spring Boot 1 和 Spring Boot 2 在 Actuator 模块的接口和注解有很大的变更，且 spring-cloud-commons 从 1.x.x 版本升级到 2.0.0 版本也有较大的变更，因此阿里采取跟 SpringBoot 版本号一致的版本:

- 1.5.x 版本适用于 Spring Boot 1.5.x
- 2.0.x 版本适用于 Spring Boot 2.0.x
- 2.1.x 版本适用于 Spring Boot 2.1.x
- 2.2.x 版本适用于 Spring Boot 2.2.x

Spring Cloud Alibaba 版本和Spring Cloud 和Spring Boot 版本兼容性列表

| Spring Cloud 版本       | Spring Cloud Alibaba 版本 | Spring Boot 版本 |
| ----------------------- | ------------------------- | ---------------- |
| Spring Cloud Hoxton.SR3 | 2.2.x.RELEASE             | 2.2.x.RELEASE    |
| Spring Cloud Greenwich  | 2.1.x.RELEASE             | 2.1.x.RELEASE    |
| Spring Cloud Finchley   | 2.0.x.RELEASE             | 2.0.x.RELEASE    |
| Spring Cloud Edgware    | 1.5.x.RELEASE             | 1.5.x.RELEASE    |

我们采用`Spring Cloud Hoxton.SR3`, `Spring Cloud Alibaba 2.2.0.RELEASE`, `Spring Boot 2.2.6 RELEASE`

PassJava-Common的pom.xml文件引入Spring Cloud Alibaba依赖

```xml
<dependencyManagement>
    <dependencies>
        <!--  Spring Cloud Alibaba 依赖  -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-alibaba-dependencies</artifactId>
            <version>2.2.0.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

## 6.2 SpringCloud整合Alibaba-Nacos组件
> [Nacos](https://github.com/alibaba/Nacos) 是阿里巴巴开源的一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。

### 1.引入Nacos 服务发现组件

passjava-common模块的pom.xml文件引入Nacos 服务发现组件

``` xml
<!-- nacos discovery 服务发现组件-->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

### 2.下载Nacos Server并启动

- 下载Nacos Server 压缩包

https://github.com/alibaba/nacos/releases

启动 Server，进入解压后文件夹或编译打包好的文件夹，找到如下相对文件夹 nacos/bin，并对照操作系统实际情况之下如下命令。

1. Linux/Unix/Mac 操作系统，执行命令 `sh startup.sh -m standalone`
2. Windows 操作系统，执行命令 `cmd startup.cmd`

windows执行startupm.cmd遇到问题：

```
λ startup.cmd                                                      
 Please set the JAVA_HOME variable in your environment, We need java(x64)! jdk8 or later is better! 
```

解决方案：

修改startup.cmd文件中的%JAVA_HOME%

```  sh
%JAVA_HOME% 替换为 C:\Program Files\Java\jdk1.8.0_131
```

启动成功：

<img src="http://cdn.jayh.club/blog/20200417/g2RCtpUpwFyF.png?imageslim" alt="nacos server启动结果" style="zoom:50%;" />


### 3.每个微服务都配置Nacos Server 地址

- 配置Nacos Server 地址

在passjava-question、passjava-channel、passjava-content、passjava-member、passjava-study 应用的 /src/main/resources/application.yml配置文件中配置 Nacos Server 地址

``` yaml
spring:
   cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848
```

### 4.添加注解

为每个服务使用 @EnableDiscoveryClient 注解开启服务注册与发现功能

``` java
@EnableDiscoveryClient
@MapperScan("com.jackson0714.passjava.question.dao")
@SpringBootApplication
public class PassjavaQuestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassjavaQuestionApplication.class, args);
    }

}
```

### 5.配置微服务的名称

```yaml
spring:
  application:
    name: passjava-question
```

### 6.访问nacos server后台

- 登录后台

http://localhost:8848/nacos/index.html#/login

用户名：nacos

密码：nacos

<img src="http://cdn.jayh.club/blog/20200417/n8M8mic6VCrC.png?imageslim" alt="nacos server后台" style="zoom:67%;" />

- 查看已注册的服务

  ``` json
  passjava-channel 渠道微服务
  passjava-member 用户微服务
  passjava-study 学习微服务
  passjava-question 问题微服务
  passjava-content 内容微服务
  ```

  <img src="http://cdn.jayh.club/blog/20200417/LQBRITAhS6eX.png?imageslim" alt="已注册的服务" style="zoom:67%;" />

## 6.3 SpringCloud整合OpenFeign远程调用

### 1.Feign 概述

- Feign声明式客的HTTP客户端，让远程调用更简单。
- 提供了HTTP请求的模板，编写简单的接口和插入注解，就可以定义好HTTP请求的参数、格式、地址等信息
- 整合了Ribbon（负载均衡组件）和Hystix（服务熔断组件），不需要显示使用这两个组件
- Spring Cloud Feign 在Netflix Feign的基础上扩展了对SpringMVC注解的支持

### 2. 远程调用示例

>  示例：查询用户的学习时长

用户微服务passjava-member调用学习微服务passjava-study的方法

#### 2.1 引入openfeign依赖

passjava-member和passjava-study项目的pom文件引入openfeign依赖

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

#### 2.2 StudyTimeController定义远程调用测试方法

返回某个用户学习题目的总时长

```java
@RequestMapping("/member/list/test")
public R memberStudyTimeTest() {
    StudyTimeEntity studyTimeEntity = new StudyTimeEntity();
    studyTimeEntity.setTotalTime(100); // 学习时长：100分钟
    studyTimeEntity.setQuesTypeId(1L); // 题目类型：1 （javaBasic）

    return R.ok().put("studyTime", Arrays.asList(studyTimeEntity));
}
```

#### 2.3 member目录下创建feign service

- 创建package: com.jackson0714.passjava.member.feign

- 创建StudyTimeFeignService接口

- 添加注解`@FeignClient`。显示声明这个接口用来远程调用`study`服务。

  ``` java
  @FeignClient("passjava-study")
  public interface StudyTimeFeignService {}
  ```

- 添加远程调用方法

  ``` java
  public R memberStudyTime();
  ```

- 给方法添加要远程调用的方法的路径`study/studytime/member/list/test`

  ``` java
  @RequestMapping("study/studytime/member/list/test")
  public R getMemberStudyTimeListTest();
  ```

- 添加注解`@EnableFeignClients`开启远程调用服务。

  给类PassjavaStudyApplication.java添加注解`@EnableFeignClients`。

  basePackages代表自动扫码指定路径下所有带有@FeignClient注解的接口。

  ``` java
  @EnableFeignClients(basePackages = "com.jackson0714.passjava.member.feign")
  @EnableDiscoveryClient
  @MapperScan("com.jackson0714.passjava.member.dao")
  @SpringBootApplication
  public class PassjavaMemberApplication {
  
      public static void main(String[] args) {
          SpringApplication.run(PassjavaMemberApplication.class, args);
      }
  
  }
  ```

- 测试接口

  - 启动passjava-member和passjava-study服务

  - 用postman工具或浏览器输入请求地址

    http://localhost:10000/member/member/studytime/list/test

  - 返回结果如下图

  studytime和member都有数据，学习时长：100分钟，昵称：悟空聊架构

  ![接口测试结果](http://cdn.jayh.club/blog/20200419/Ty3LMSktFR60.png?imageslim)

#### 2.4 测试OpenFeign传参

示例：用户id作为参数在服务间传递

MemberController

``` java
@RequestMapping("/studytime/list/test/{id}")
public R getMemberStudyTimeListTest(@PathVariable("id") Long id) {
    //mock数据库查到的会员信息
    MemberEntity memberEntity = new MemberEntity();
    memberEntity.setId(id); // 学习时长：100分钟
    memberEntity.setNickname("悟空聊架构");

    //远程调用拿到该用户的学习时长（学习时长是mock数据）
    R memberStudyTimeList = studyTimeFeignService.getMemberStudyTimeListTest(id);
    return R.ok().put("member", memberEntity).put("studytime", memberStudyTimeList.get("studytime"));
}
```

StudyTimeFeignService

``` java
@FeignClient("passjava-study")
public interface StudyTimeFeignService {
    @RequestMapping("study/studytime/member/list/test/{id}")
    public R getMemberStudyTimeListTest(@PathVariable("id") Long id);
}
```

StudyTimeController

``` java
@RequestMapping("/member/list/test/{id}")
public R memberStudyTimeTest(@PathVariable("id") Long id) {
    StudyTimeEntity studyTimeEntity = new StudyTimeEntity();
    studyTimeEntity.setTotalTime(100); // 学习时长：100分钟
    studyTimeEntity.setQuesTypeId(1L); // 题目类型：1 （javaBasic）

    return R.ok().put("studytime", Arrays.asList(studyTimeEntity));
}
```

请求地址和参数：http://localhost:10000/member/member/studytime/list/test/1

执行结果：

![执行结果](http://cdn.jayh.club/blog/20200419/ND82clGdmgwj.png?imageslim)

#### 2.5 总结FeignClient使用方法

- 引入OpenFeign依赖
- 定义FeignClient接口类（注解`@FeignClient`），声明这个接口类是用来远程调用其他服务的
- 接口类中定义要远程调用的接口方法，指定远程服务方法的路径
- Controller类中调用接口方法
- 开启远程调用（注解`@EnableFeignClients`）
- 远程调用的流程：
  - @RequestBody将这个对象转为json
  - 找到passjava-study服务，给study/studytime/member/list/test服务发送请求
  - 将json放到请求体里面，发送请求
  - 对方服务收到请求，请求体里有json数据
  - 将请求体中的json数据转换成对方服务的参数类型。只需要两边的字段名称和类型是一致的。

## 6.4 Spring Cloud 整合 Nacos配置中心

### 1.传统配置方式

- application.properties文件中定义两个配置：

```properties
member.nickname = "悟空聊架构"
member.age = "18"
```

- 示例控制器中定义私有变量nickname和age，@value代表从配置中取值

```java
@Value("${member.nickname}")
private  String nickname;

@Value("$member.age")
private  Integer age;
```

- 示例控制器中定义方法：获取nick和age的值

```java
@RequestMapping("/test-local-config")
public R testLocalConfig() {
    return R.ok().put("nickname", nickname).put("age", age);
}
```

- 测试结果

![mark](http://cdn.jayh.club/blog/20200419/hVV0scmFNGyo.png?imageslim)

总结：从配置文件中获取配置。

这种方式的缺点是什么呢？如果要修改配置参数，则需要重新启动服务。如果服务很多，则需要重启所有服务，非常不方便。

有没有什么办法不停服务修改配置而且使其生效呢？

答案：有的，用Spring Cloud Alibaba的Nacos 组件就可以完成。

### 2.引入Nacos依赖

PassJava-Common项目的pom.xml文件引入Spring Cloud Alibaba Nacos Config依赖

``` xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
```

### 3.配置Nacos元数据

- passjava-member 添加 /src/main/resources/bootstrap.properties 配置文件（注意：bootstrap.properties 优先级高于其他配置文件）

- 配置 Nacos Config 元数据

![bootstrap.properties](http://cdn.jayh.club/blog/20200419/Ts8oLK9Bnzi3.png?imageslim)

``` properties
spring.application.name=passjava-member
spring.cloud.nacos.config.server-addr=127.0.0.1:8848
```

### 4.Nacos后台新增配置

**Data ID:** passjava-member.properties

**Group:** DEFAULT_GROUP

**配置格式:**

``` properties
member.nick="悟空"
member.age=10
```

![Nacos后台新增配置](http://cdn.jayh.club/blog/20200419/jrSKiQ6H0VES.png?imageslim)

### 5.开启动态刷新配置功能

添加注解@RefreshScope开启动态刷新配置功能

```java
@RefreshScope
@RestController
@RequestMapping("member/sample")
public class SampleController {}
```

可以从控制台看到日志信息：

``` properties
Refresh keys changed: [member.age]
2020-04-19 23:34:07.154  INFO 8796 --- [-127.0.0.1_8848] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848] [notify-ok] dataId=passjava-member.properties, group=DEFAULT_GROUP, md5=df136e146c83cbf857567e75acb11e2b, listener=com.alibaba.cloud.nacos.refresh.NacosContextRefresher$1@4f49b78b 
2020-04-19 23:34:07.154  INFO 8796 --- [-127.0.0.1_8848] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848] [notify-listener] time cost=529ms in ClientWorker, dataId=passjava-member.properties, group=DEFAULT_GROUP, md5=df136e146c83cbf857567e75acb11e2b, listener=com.alibaba.cloud.nacos.refresh.NacosContextRefresher$1@4f49b78b 
```

`member.age` 更新了，通知了member服务，刷新了配置。对应的配置id为`passjava-member.properties`，分组为`DEFAULT_GROUP`。监听器为`com.alibaba.cloud.nacos.refresh.NacosContextRefresher`

### 6.测试结果

访问：http://localhost:10000/member/sample/test-local-config

结果：nickname和age和Nacos后台配置一致

结论：只用在Nacos后台改配置即可实时修改配置。

注意：Nacos的配置项优先级高于application.propertite里面的配置。

![测试结果](http://cdn.jayh.club/blog/20200419/hU9oOojlIG5T.png?imageslim)

### 7.命名空间

我们现在有5个微服务，每个微服务用到的配置可能都不一样，那不同微服务怎么样获取自己微服务的配置呢？

这里可以用到命名空间，我们针对每个微服务，都创建一个命名空间。

- 创建命名空间

  ![创建命名空间](http://cdn.jayh.club/blog/20200420/BUfm3HeAJn0Q.png?imageslim)

``` json
# 创建5个命名空间
passjava-channel
passjava-content
passjava-member
passjava-question
passjava-study
```

![命名空间](http://cdn.jayh.club/blog/20200420/aUf1sIOuqtxq.png?imageslim)

- 命名空间下创建配置

  我们打开配置列表菜单，可以看到有五个命名空间。

  ![命名空间下创建配置](http://cdn.jayh.club/blog/20200420/XnxTl32zmBJo.png?imageslim)

选中passjava-channel命名空间，然后新增配置项，与之前新增配置的步骤一致，也可以通过克隆命名空间来克隆配置。

![克隆配置](http://cdn.jayh.club/blog/20200420/YqMIkqR7AQok.png?imageslim)

- 修改指定的命名空间

  bootstrap.properties配置命名空间

  ``` properties
  spring.cloud.nacos.config.namespace=passjava-member
  ```

- 测试配置是否生效

  修改passjava-member.properties的配置内容

  ![passjava-member.properties](http://cdn.jayh.club/blog/20200420/pSiFa7mJVXiD.png?imageslim)

  重启member服务

  

  访问方法：/member/sample/test-local-config

  执行结果：

  ``` json
  {
      "msg": "success",
      "code": 0,
      "nickname": "\"悟空member\"",
      "age": 30
  }
  ```

  说明获取的是passjava-member命名空间的配置

#### 8.分组

如果我们有多套环境，比如开发环境，测试环境，生产环境，每一套环境的配置参数不一样，那配置中心该如何配置呢？

我们可以使用配置中心的`分组`功能。每一套环境都是一套分组。

- 首先创建一套dev环境配置项，然后克隆配置到test和prod环境

![dev环境](http://cdn.jayh.club/blog/20200420/GsB5STRumA72.png?imageslim)

![dev、test、prod分组](http://cdn.jayh.club/blog/20200420/kUF8qfV1ty18.png?imageslim)

- bootstrap.properties配置当前使用的分组：prod

```
spring.cloud.nacos.config.group=prod
```

- 测试获取生产环境配置

  ``` json
  {
      "msg": "success",
      "code": 0,
      "nickname": "\"悟空-prod\"",
      "age": 10
  }
  ```

  可以看到获取到的是prod分组的配置

### 9.多配置集

我们可以将application.yml文件中的datasource、mybatis-plus等配置进行拆解，放到配置中心。group可以创建3套，dev/test/prod。

1.配置中心新建`datasource.yml` 配置

![datasource.yml 配置](http://cdn.jayh.club/blog/20200422/0gOWIlAxhfpn.png?imageslim)

2.配置中心新建`mybatis.yml` 配置

![mybatis.yml配置](http://cdn.jayh.club/blog/20200422/D3qEAgusQmnn.png?imageslim)

3.配置中心新建`more.yml` 配置

![more.yml配置](http://cdn.jayh.club/blog/20200422/v6Cci7Lm82fD.png?imageslim)

4.克隆dev环境配置到test和prod环境

![mark](http://cdn.jayh.club/blog/20200422/vtWsoYwn8XBW.png?imageslim)



5.bootstrap.properties增加nacos配置，application.yml注释配置

``` properties
spring.application.name=passjava-member
spring.cloud.nacos.config.server-addr=127.0.0.1:8848

spring.cloud.nacos.config.namespace=passjava-member
spring.cloud.nacos.config.group=prod

spring.cloud.nacos.config.extension-configs[0].data-id=datasource.yml
spring.cloud.nacos.config.extension-configs[0].group=dev
spring.cloud.nacos.config.extension-configs[0].refresh=true

spring.cloud.nacos.config.extension-configs[1].data-id=mybatis.yml
spring.cloud.nacos.config.extension-configs[1].group=dev
spring.cloud.nacos.config.extension-configs[1].refresh=true

spring.cloud.nacos.config.extension-configs[2].data-id=more.yml
spring.cloud.nacos.config.extension-configs[2].group=dev
spring.cloud.nacos.config.extension-configs[2].refresh=true
```

6.测试配置是否生效

- 测试passjava-member.properties和more.yml配置是否生效

请求url:http://localhost:10000/member/sample/test-local-config

返回配置的nick和age，且端口是10000，且member服务注册到注册中心

``` json
{
    "msg": "success",
    "code": 0,
    "nickname": "\"悟空-prod1\"",
    "age": 22
}
```

- 测试datasource.yml和mybatis.yml配置是否生效

请求url:http://localhost:10000/member/member/list

返回数据库查询结果

``` json
{
    "msg": "success",
    "code": 0,
    "page": {
        "totalCount": 0,
        "pageSize": 10,
        "totalPage": 0,
        "currPage": 1,
        "list": []j
    }
}
```

说明以上配置都生效了。



#### 更多配置项

| 配置项                   | key                                       | 默认值        | 说明                                                         |
| ------------------------ | ----------------------------------------- | ------------- | ------------------------------------------------------------ |
| 服务端地址               | spring.cloud.nacos.config.server-addr     |               |                                                              |
| DataId前缀               | spring.cloud.nacos.config.prefix          |               | spring.application.name                                      |
| Group                    | spring.cloud.nacos.config.group           | DEFAULT_GROUP |                                                              |
| dataID后缀及内容文件格式 | spring.cloud.nacos.config.file-extension  | properties    | dataId的后缀，同时也是配置内容的文件格式，目前只支持 properties |
| 配置内容的编码方式       | spring.cloud.nacos.config.encode          | UTF-8         | 配置的编码                                                   |
| 获取配置的超时时间       | spring.cloud.nacos.config.timeout         | 3000          | 单位为 ms                                                    |
| 配置的命名空间           | spring.cloud.nacos.config.namespace       |               | 常用场景之一是不同环境的配置的区分隔离，例如开发测试环境和生产环境的资源隔离等。 |
| AccessKey                | spring.cloud.nacos.config.access-key      |               |                                                              |
| SecretKey                | spring.cloud.nacos.config.secret-key      |               |                                                              |
| 相对路径                 | spring.cloud.nacos.config.context-path    |               | 服务端 API 的相对路径                                        |
| 接入点                   | spring.cloud.nacos.config.endpoint        | UTF-8         | 地域的某个服务的入口域名，通过此域名可以动态地拿到服务端地址 |
| 是否开启监听和自动刷新   | spring.cloud.nacos.config.refresh-enabled | true          |                                                              |

### 10.使用Nacos总结

- 1.引入Nacos依赖
- 2.配置Nacos数据源
- 3.配置中心配置数据集`DataId`和配置内容
- 4.开启动态刷新配置`@RefreshScope`
- 5.获取配置项的值`@value`
- 6.优先使用配置中心的配置
- 7.使用命名空间`namespace`来创建各服务的配置
- 8.使用分组`group`来区分不同环境
- 9.使用多配置集`extension-configs`区分不同类型的配置


## 6.5 SpringCloud整合Gateway网关

### 1.Gateway网关介绍

- 网关:流量的入口
- 网关常用功能:路由转发,权限校验,限流控制
- Spring Cloud Gateway是Spring Cloud官方推出的第二代网关框架
- Spring Cloud Gateway取代了netflix的Zuul网关

### 2.Gateway原理

PassJava项目中,小程序和管理后台请求先访问到API网关.

API网关通过注册中心实时感知微服务的状态的路由地址,准确地将请求路由到各个服务.

![Spring Cloud Gateway](http://cdn.jayh.club/blog/20200423/WhIlX8s2ielj.png?imageslim)

官方文档:https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.2.RELEASE/reference/html/

![Gateway原理](http://cdn.jayh.club/blog/20200423/vFG3pl5kg6Mh.png?imageslim)

- 请求到达网关后,先经过断言Predicate,是否符合某个路由规则
- 如果符合,则按路由规则路由到指定地址

- 请求和响应都可以通过过滤器Filter进行过滤

### 3.创建Gateway 模块

- 适用Spring 初始化器创建Gateway module

![Spring 初始化器](http://cdn.jayh.club/blog/20200423/8otVyqWM34sp.png?imageslim)

- 创建module

![Gateway module](http://cdn.jayh.club/blog/20200423/1gpsU7eg2ADO.png?imageslim)

- 选择Gateway依赖

![选择Gateway依赖](http://cdn.jayh.club/blog/20200423/ei7LC9ILPwc4.png?imageslim)

- 引入Gateway模块

```
<module>passjava-gateway</module>
```

### 4.配置Gateway

- 引入Nacos组件

因common模块引入了nacos注册中心组件,所以我们可以直接引用common模块

``` xml
<dependency>
	<groupId>com.jackson0714.passjava</groupId>
	<artifactId>passjava-common</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

- 应用类上添加注解`@EnableDiscoveryClient`

``` java
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PassjavaGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(PassjavaGatewayApplication.class, args);
	}
}
```

### 5.使用Gateway demo

- 新建application.yml文件

  ``` yml
  spring:
    cloud:
      gateway:
        routes:
          - id: route_qq
            uri: http://www.qq.com
            predicates:
              - Query=url,qq
          - id: route_baidu
            uri: http://www.baidu.com
            predicates:
              - Query=url,baidu
  ```

  第一条路由规则:当请求路径中包含url=qq,则跳转到http://www.qq.com

  第二条路由规则:当请求路径中包含url=baidu,则跳转到http://www.baidu.com

后续在PassJava项目中使用Gateway的强大功能.

## 6.6 整合OSS对象存储

### 1.缘起

> 文件上传在系统中用的很频繁，所以我们需要将上传的文件进行存储，传统的将文件上传到本机已不适用分布式系统。自己搭建文件服务器有复杂性和维护成本。所以我们可以采用市面上成熟的文件存储服务，如阿里云的OSS对象存储服务。

![上传图片](http://cdn.jayh.club/blog/20200428/BbhUgx6bs0xI.gif)

每个 OSS 的用户都会用到上传服务。Web 端常见的上传方法是用户在浏览器或 APP 端上传文件到应用服务器，应用服务器再把文件上传到 OSS。具体流程如下图所示。
![具体流程](http://cdn.jayh.club/blog/20200428/RJIuke5m522w.png?imageslim)

和数据直传到 OSS 相比，以上方法有三个缺点：

- 上传慢：用户数据需先上传到应用服务器，之后再上传到OSS。网络传输时间比直传到OSS多一倍。如果用户数据不通过应用服务器中转，而是直传到OSS，速度将大大提升。而且OSS采用BGP带宽，能保证各地各运营商之间的传输速度。
- 扩展性差：如果后续用户多了，应用服务器会成为瓶颈。
- 费用高：需要准备多台应用服务器。由于OSS上传流量是免费的，如果数据直传到OSS，不通过应用服务器，那么将能省下几台应用服务器。

### 2.技术方案

#### 2.1 服务端签名后直传

##### 2.1.1 背景

采用JavaScript客户端直接签名（参见[JavaScript客户端签名直传](https://help.aliyun.com/document_detail/31925.html#concept-frd-4gy-5db)）时，AccessKeyID和AcessKeySecret会暴露在前端页面，因此存在严重的安全隐患。因此，OSS提供了服务端签名后直传的方案。

##### 2.1.2 原理介绍

![原理介绍](http://cdn.jayh.club/blog/20200428/Uq4PAu1zk720.png?imageslim)

服务端签名后直传的原理如下：

1. 用户发送上传Policy请求到应用服务器。
2. 应用服务器返回上传Policy和签名给用户。
3. 用户直接上传数据到OSS。

### 3.实现案例

#### 3.1 开通阿里云OSS

- 登录阿里云官网

  https://www.aliyun.com/sale-season/2020/procurement-new-members?userCode=thp9caen

![登录阿里云官网](http://cdn.jayh.club/blog/20200427/0AJHQmBdGIpC.png?imageslim)



- 创建Bucket 存储桶

  ![创建Bucket 存储桶](http://cdn.jayh.club/blog/20200427/VPfBeJAPQ5Tb.png?imageslim)

- 获取accesskey id和secret

![获取accesskey id和secret](http://cdn.jayh.club/blog/20200427/hfgi86eqp8Ob.png?imageslim)

![获取accesskey id和secret](http://cdn.jayh.club/blog/20200427/pCrDo8UwFAWF.png?imageslim)

![获取accesskey id和secret](http://cdn.jayh.club/blog/20200427/xGPP7PFGK8uJ.png?imageslim)

- 分配权限

  分配 管理对象存储服务（OSS）权限

  ![分配权限](http://cdn.jayh.club/blog/20200427/2p085d9bNdaq.png?imageslim)

#### 3.2 使用OSS SDK

##### 3.2.1 安装SDK

在Maven项目中加入依赖项

```xml
https://help.aliyun.com/document_detail/32009.html?spm=a2c4g.11186623.6.769.2c5145dc4TUgTa
<dependency>
    <groupId>com.aliyun.oss</groupId>
    <artifactId>aliyun-sdk-oss</artifactId>
    <version>3.8.0</version>
</dependency>
```

##### 3.2.2  上传文件到OSS

```java
@Test
void testUploadByOss() throws FileNotFoundException {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    String accessKeyId = "xxxx";
    String accessKeySecret = "xxxx";
    String bucketName = "passjava";

    // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
    String localFile = "C:\\Users\\Administrator\\Pictures\\coding_java.png";
    String fileKeyName = "coding_java.png";
    // 创建OSSClient实例。
    OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

    InputStream inputStream = new FileInputStream(localFile);
    ossClient.putObject(bucketName, fileKeyName, inputStream);

    // 关闭OSSClient。
    ossClient.shutdown();
}
```



#### 3.3 整合Spring Cloud Alicloud OSS

##### 3.3.1  passjava-common项目引入spring-cloud-starter-alicloud-oss依赖

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alicloud-oss</artifactId>
</dependency>
```

##### 3.3.2  配置alicloud oss

```yaml
spring:
  cloud:
    alicloud:
      access-key: xxxx
      secret-key: xxxx
      oss:
        endpoint: oss-cn-beijing.aliyuncs.com
```

##### 3.3.3  测试上传

```java
@Autowired
OSSClient ossClient;

@Test
void testUploadByAlicloudOss() throws FileNotFoundException {
    String bucketName = "passjava";
    String localFile = "C:\\Users\\Administrator\\Pictures\\coding_java.png";
    String fileKeyName = "coding_java.png";
    InputStream inputStream = new FileInputStream(localFile);
    ossClient.putObject(bucketName, fileKeyName, inputStream);
    ossClient.shutdown();
}
```

![上传成功](http://cdn.jayh.club/blog/20200428/F64VnQ6l5Kn9.png?imageslim)

#### 3.4 获取服务端签名

##### 3.4.1 准备工作：

- 创建一个第三方服务passjava-thirdparty
- 引入passjava-common模块，并且排除mybatis-plus依赖

``` xml
<dependency>
    <groupId>com.jackson0714.passjava</groupId>
    <artifactId>passjava-common</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <exclusions>
        <exclusion>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

- 配置服务发现和端口

``` yaml
spring:
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848
  application:
        name: passjava-thirdparty
server:
  port: 14000
```

- 配置配置中心

```  yaml
spring.application.name=passjava-thirdparty
spring.cloud.nacos.config.server-addr=127.0.0.1:8848
spring.cloud.nacos.config.namespace=passjava-thirdparty

spring.cloud.nacos.config.extension-configs[0].data-id=oss.yml
spring.cloud.nacos.config.extension-configs[0].group=DEFAULT_GROUP
spring.cloud.nacos.config.extension-configs[0].refresh=true
```

- 配置Nacos命名空间和oss.yml

``` yaml
spring:
  cloud:
    alicloud:
      access-key: LTAI4G3KxBJ26EUbWsenmqhP
      secret-key: RHtADVlvlKJvVBQnFNNvnne9p4NwnA
      oss:
        endpoint: oss-cn-beijing.aliyuncs.com
```

![配置oss.yml](http://cdn.jayh.club/blog/20200427/nDFBnzvuVXaI.png?imageslim)

- 开启服务发现`@EnableDiscoveryClient`

``` java
@EnableDiscoveryClient
@SpringBootApplication
public class PassjavaThirdpartyApplication {
    public static void main(String[] args) {
        SpringApplication.run(PassjavaThirdpartyApplication.class, args);
    }
}
```

##### 3.4.2 获取签名类

``` java
@RestController
@RequestMapping("/thirdparty/v1/admin/oss")
public class OssController {

    @Autowired
    OSS ossClient;

    @Value("${spring.cloud.alicloud.access-key}")
    private String accessId;

    @Value("${spring.cloud.alicloud.secret-key}")
    private String accessKey;

    @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endpoint;

    @Value("${spring.cloud.alicloud.oss.bucket}")
    private String bucket;

    @RequestMapping("/getPolicy")
    public Map<String, String> getPolicy() {
        String host = "https://" + bucket + "." + endpoint; // host的格式为 bucketname.endpoint
        // callbackUrl为 上传回调服务器的URL，请将下面的IP和Port配置为您自己的真实信息。
        // String callbackUrl = "http://88.88.88.88:8888";
        String formatDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dir = formatDate + "/"; // 用户上传文件时指定的前缀。

        Map<String, String> respMap = new LinkedHashMap<String, String>();

        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);


            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));


        } catch (Exception e) {
            // Assert.fail(e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            ossClient.shutdown();
        }

        return respMap;
    }
}
```

测试接口

``` json
http://localhost:14000/api/thirdparty/v1/admin/oss/getPolicy 
{
	"accessid": "LTAI4G3KxBJ26EUbWsenmqhP",
	"policy": "eyJleHBpcmF0aW9uIjoiMjAyMC0wNC0yOFQwMjozMzowNy42NzNaIiwiY29uZGl0aW9ucyI6W1siY29udGVudC1sZW5ndGgtcmFuZ2UiLDAsMTA0ODU3NjAwMF0sWyJzdGFydHMtd2l0aCIsIiRrZXkiLCIyMDIwLTA0LTI4LyJdXX0=",
	"signature": "pfn4cggFTMMNqTs+qUnDN5c+k5M=",
	"dir": "2020-04-28/",
	"host": "https://passjava.oss-cn-beijing.aliyuncs.com",
	"expire": "1588041187"
}
```

##### 3.4.3 配置网关路由

因为前端页面配置的统一访问路径是http://localhost:8060/api/，所以需要将访问thirdparty的服务通过网关路由到thirdparty服务

``` javascript
将请求
http://localhost:8060/api/thirdparty/v1/admin/oss/getPolicy
转发到
http://localhost:14000/api/thirdparty/v1/admin/oss/getPolicy 
```

配置网关：

``` yaml
spring:
  cloud:
    gateway:
      routes:
        - id: route_thirdparty # 题目微服务路由规则
          uri: lb://passjava-thirdparty # 负载均衡，将请求转发到注册中心注册的assjava-thirdparty服务
          predicates: # 断言
            - Path=/api/thirdparty/** # 如果前端请求路径包含 api/thirdparty，则应用这条路由规则
          filters: #过滤器
            - RewritePath=/api/(?<segment>.*),/$\{segment} # 将跳转路径中包含的api替换成空
```

测试可以上传成功

##### 3.4.4 配置跨域访问

配置跨域访问，所有post请求都可以跨域访问

![配置跨域访问](http://cdn.jayh.club/blog/20200428/1UhhbsBvpGbY.png?imageslim)

##### 3.4.5 Web端上传组件

- 单文件上传组件

``` javascript
singleUpload.vue
<template> 
  <div>
    <el-upload
      action="http://passjava.oss-cn-beijing.aliyuncs.com"
      :data="dataObj"
      list-type="picture"
      :multiple="false" :show-file-list="showFileList"
      :file-list="fileList"
      :before-upload="beforeUpload"
      :on-remove="handleRemove"
      :on-success="handleUploadSuccess"
      :on-preview="handlePreview">
      <el-button size="small" type="primary">点击上传</el-button>
      <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过10MB</div>
    </el-upload>
    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="fileList[0].url" alt="">
    </el-dialog>
  </div>
</template>
<script>
   import {policy} from './policy'
   import { getUUID } from '@/utils'

  export default {
    name: 'singleUpload',
    props: {
      value: String
    },
    computed: {
      imageUrl() {
        return this.value;
      },
      imageName() {
        if (this.value != null && this.value !== '') {
          return this.value.substr(this.value.lastIndexOf("/") + 1);
        } else {
          return null;
        }
      },
      fileList() {
        return [{
          name: this.imageName,
          url: this.imageUrl
        }]
      },
      showFileList: {
        get: function () {
          return this.value !== null && this.value !== ''&& this.value!==undefined;
        },
        set: function (newValue) {
        }
      }
    },
    data() {
      return {
        dataObj: {
          policy: '',
          signature: '',
          key: '',
          ossaccessKeyId: '',
          dir: '',
          host: '',
          // callback:'',
        },
        dialogVisible: false
      };
    },
    methods: {
      emitInput(val) {
        this.$emit('input', val)
      },
      handleRemove(file, fileList) {
        this.emitInput('');
      },
      handlePreview(file) {
        this.dialogVisible = true;
      },
      beforeUpload(file) {
        let _self = this;
        return new Promise((resolve, reject) => {
          policy().then(response => {
            _self.dataObj.policy = response.data.policy;
            _self.dataObj.signature = response.data.signature;
            _self.dataObj.ossaccessKeyId = response.data.accessid;
            _self.dataObj.key = response.data.dir + getUUID()+'_${filename}';
            _self.dataObj.dir = response.data.dir;
            _self.dataObj.host = response.data.host;
            resolve(true)
          }).catch(err => {
            reject(false)
          })
        })
      },
      handleUploadSuccess(res, file) {
        console.log("上传成功...")
        this.showFileList = true;
        this.fileList.pop();
        this.fileList.push({name: file.name, url: this.dataObj.host + '/' + this.dataObj.key.replace("${filename}",file.name) });
        this.emitInput(this.fileList[0].url);
      }
    }
  }
</script>
<style>

</style>
```

- 获取签名的JS文件

``` javascript
import http from '@/utils/httpRequest.js'
export function policy () {
  return new Promise((resolve) => {
    http({
      url: http.adornUrl('/thirdparty/v1/admin/oss/getPolicy'),
      method: 'get',
      params: http.adornParams({})
    }).then(({ data }) => {
      resolve(data)
    })
  })
}
```

- 使用单文件上传组件

``` javascript
使用上传图片组件
<el-form-item label="类型logo路径" prop="logoUrl">
    <single-upload v-model="dataForm.logoUrl"></single-upload>
</el-form-item>

<script>
  import SingleUpload from "@/components/upload/singleUpload" // 引入单文件上传组件
  export default {
    components:{ SingleUpload }
  }
</script>
```

![上传图片](http://cdn.jayh.club/blog/20200428/BbhUgx6bs0xI.gif)

上传文件成功

## 6.7 整合统一异常处理

### 1.缘起

> 我们在写代码的时候，通常会在方法里面添加各种try catch来捕获异常，会发现有很多重复的代码，所以我们可以整合统一异常处理来优化代码结构。

拦截异常并统一处理我们可以用到`@RestControllerAdvice`注解

### 2.自定义异常处理类

- 添加统一异常处理类注解`@RestControllerAdvice`

- 添加日志注解`@Slf4j`
- 添加异常处理方法注解`@ExceptionHandler`

``` java
package com.jackson0714.passjava.question.exception;

/*
* 集中处理所有异常
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.jackson0714.passjava.question.controller")
public class PassjavaExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型：{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError)->{
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMsg()).put("data", errorMap);
    }

    @ExceptionHandler(value=Throwable.class)
    public R handleException(Throwable throwable) {
        log.error("未知异常{}，异常类型：{}", throwable.getMessage(), throwable.getClass());
        
        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.UNKNOWN_EXCEPTION.getMsg());
    }
}
```

### 3.推荐的系统错误码

#### 3.1 错误码和错误信息定义类

- 1.错误码长度：5个数字

- 2.前两位：业务场景

- 3.后三位：错误码

``` json
10：通用业务
	001：参数格式校验错误（10001）
11：会员业务
12：题目业务
13：内容业务
14：学习业务
```

#### 3.2 错误码枚举类

com.jackson0714.common.exception.BizCodeEnum

定义了两种异常枚举：系统未知异常、参数格式校验失败

``` java
package com.jackson0714.common.exception;

public enum BizCodeEnum {
    UNKNOWN_EXCEPTION(10000, "系统未知异常"),
    VALID_EXCEPTION(10001, "参数格式校验失败");

    private int code;
    private String msg;
    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
```

### 4.测试代码

> **测试场景1：校验参数displayOrder必须为正整数，如果displayOrder不为正整数，则会抛出异常**

- 1.实体类上添加校验注解`@Positive`

```java
/**
 * 排序
 */
@Positive
private Integer displayOrder;
```

- 2.controller类里面添加save方法，并添加校验参数注解@Valid

``` java
/**
* 保存
*/
@RequestMapping("/save")
public R save(@Valid @RequestBody QuestionEntity question){
    questionService.save(question);

    return R.ok();
}
```

测试：

用Postman工具调用save方法

请求地址：

```javascript
http://192.168.10.160:8060/api/question/v1/admin/question/save
```

请求参数：

``` json
{
    "displayOrder": 0.2
}
```

返回结果：

```json
{
    "msg": "参数格式校验失败",
    "code": 10001,
    "data": {
        "displayOrder": "必须是正数"
    }
}
```

> **测试场景2：对于代码里面直接抛出的异常，也可以handle**

1.controller类里面添加查询题目的方法，并抛出Exception异常

``` java
/**
* 信息
*/
@RequestMapping("/info/{id}")
//@RequiresPermissions("question:question:info")
public R info(@PathVariable("id") Long id) throws Exception {
    QuestionEntity question = questionService.getById(id);
    throw new Exception("test");

    //return R.ok().put("question", question);
}
```

测试：

用Postman工具调用save方法

请求地址：

```javascript
http://192.168.10.160:8060/api/question/v1/admin/question/save
```

返回结果：

```json
{
    "msg": "系统未知异常",
    "code": 10000
}
```

证明统一处理方法被调用了：

``` java
@ExceptionHandler(value=Throwable.class)
public R handleException(Throwable throwable) {
    return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.UNKNOWN_EXCEPTION.getMsg());
}
```

## 6.8 整合链路追踪

![封面](02.微服务架构中的链路追踪.assets/tUuJz4TnDwHa.png)

封面图是 凌晨 3点半起来更文的锁屏桌面。

本篇主要内容如下：

### 前言

从上周六 7 号到今天的 11 号，我都在医院，小孩因肺炎已经住院了，我白天和晚上的时间需要照顾娃，只能在娃睡觉的时候肝文了。对了，医院没有宽带和 WiFi，我用的手机开的热点~

### 本篇主要内容

这篇主要是理论 + 实践相结合。实践部分涉及到如何把链路追踪 `Sleuth` + `Zipkin` 加到我的 Spring Cloud 《佳必过》开源项目上。

本篇知识点：

- 链路追踪基本原理
- 如何在项目中轻松加入链路追踪中间件
- 如何使用链路追踪排查问题。

### 1. 为什么要用链路追踪？

#### 1.1 因：拆分服务单元

`微服务`架构其实是一个`分布式`的架构，按照业务划分成了多个服务单元。

由于服务单元的`数量`是很多的，有可能几千个，而且业务也会更复杂，如果出现了错误和异常，很难去定位。

#### 1.2 因：逻辑复杂

比如一个请求需要调用多个服务才能完成整个业务闭环，而内部服务的代码逻辑和业务逻辑比较复杂，假如某个服务出现了问题，是难以快速确定那个服务出问题的。

#### 1.3 果：快速定位

而如果我们加上了`分布式链路追踪`，去跟踪一个请求有哪些服务参与其中，参与的顺序是怎样的，这样我们就知道了每个请求的详细经过，即使出了问题也能快速定位。

 ### 2. 链路追踪的核心

链路追踪组件有 Twitter 的可视化链路追踪组件 `Zipkin`、Google 的 `Dapper`、阿里的 `Eagleeye` 等，而 Sleuth 是 Spring Cloud 的组件。Spring Cloud Sleuth 借鉴了 Dapper 的术语。

本文主要讲解 Sleuth + Zipkin 结合使用来更好地实现链路追踪。

为什么能够进行整条链路的追踪？其实就是一个 Trace ID 将 一连串的 Span 信息连起来了。根据 Span 记录的信息再进行整合就可以获取整条链路的信息。下面

#### 2.1 Span（跨度）

- 大白话：远程调用和 Span  `一对一`。
- 基本的工作单元，每次发送一个远程调用服务就会产生一个 Span。

- Span 是一个 64 位的唯一 ID。
- 通过计算 Span 的开始和结束时间，就可以统计每个服务调用所花费的时间。

#### 2.2 Trace（跟踪）

- 大白话：一个 Trace 对应多个 Span，`一对多`。
- 它由一系列 Span 组成，树状结构。

- 64 位唯一 ID。
- 每次客户端访问微服务系统的 API 接口，可能中间会调用多个微服务，每次调用都会产生一个新的 Span，而多个 Span 组成了 Trace

#### 2.3 Annotation（注解）

链路追踪系统定义了一些核心注解，用来定义一个请求的开始和结束，注意是微服务之间的请求，而不是浏览器或手机等设备。注解包括：

- `cs` - Client Sent：客户端发送一个请求，描述了这个请求调用的 `Span` 的开始时间。注意：这里的客户端指的是微服务的调用者，不是我们理解的浏览器或手机等客户端。
- `sr` - Server Received：服务端获得请求并准备开始处理它，如果将其 `sr` 减去 `cs` 时间戳，即可得到网络传输时间。
- `ss` - Server Sent：服务端发送响应，会记录请求处理完成的时间，`ss` 时间戳减去 `sr` 时间戳，即可得到服务器请求的时间。
- `cr` - Client Received：客户端接收响应，Span 的结束时间，如果 `cr` 的时间戳减去 `cs` 时间戳，即可得到一次微服务调用所消耗的时间，也就是一个 `Span` 的消耗的总时间。

#### 2.4 链路追踪原理

假定三个微服务调用的链路如下图所示：`Service 1` 调用 `Service 2`，`Service 2` 调用 `Service 3` 和 Service 4。

![微服务调用链路图](http://cdn.jayh.club/blog/20201113/0DBcQe6jT0D5.png?imageslim)

那么链路追踪会在每个服务调用的时候加上 Trace ID 和 Span ID。如下图所示：

![链路追踪原理图](http://cdn.jayh.club/blog/20201113/QmIVxLVczhEl.png?imageslim)

**大白话解释：** 

- 大家注意上面的颜色，相同颜色的代表是同一个 Span ID，说明是链路追踪中的一个节点。

- 第一步：客户端调用 `Service 1`，生成一个 `Request`，`Trace ID` 和 `Span ID` 为空，那个时候请求还没有到 `Service 1`。
- 第二步：请求到达 `Service 1`，记录了 Trace ID = X，Span ID 等于 A。
- 第三步：`Service 1` 发送请求给 `Service 2`，Span ID 等于 B，被称作 Client Sent，即客户端发送一个请求。
- 第四步：请求到达 `Service 2`，Span ID 等于 B，Trace ID 不会改变，被称作 Server Received，即服务端获得请求并准备开始处理它。
- 第五步：`Service 2` 开始处理这个请求，处理完之后，Trace ID 不变，Span ID = C。
- 第六步：`Service 2` 开始发送这个请求给 `Service 3`，Trace ID 不变，Span ID = D，被称作 Client Sent，即客户端发送一个请求。
- 第七步：`Service 3` 接收到这个请求，Span ID = D，被称作 Server Received。
- 第八步：`Service 3` 开始处理这个请求，处理完之后，Span ID = E。
- 第九步：`Service 3` 开始发送响应给 `Service 2`，Span ID = D，被称作 Server Sent，即服务端发送响应。
- 第十步：`Service 3` 收到 `Service 2` 的响应，Span ID = D，被称作 Client Received，即客户端接收响应。
- 第十一步：`Service 2` 开始返回 响应给 `Service 1`，Span ID = B，和第三步的 Span ID 相同，被称作 Client Received，即客户端接收响应。
- 第十二步：`Service 1` 处理完响应，Span ID = A，和第二步的 Span ID 相同。
- 第十三步：`Service 1` 开始向客户端返回响应，Span ID = A、
- `Service 3` 向 Service 4 发送请求和 `Service 3` 类似，对应的 Span ID 是 F 和 G。可以参照上面前面的第六步到第十步。

**把以上的相同颜色的步骤简化为下面的链路追踪图：** 

![链路追踪父子节点图](http://cdn.jayh.club/blog/20201113/jD37o9mBtnwJ.jpg?imageslim)

- 第一个节点：Span ID = A，Parent ID = null，`Service 1` 接收到请求。
- 第二个节点：Span ID = B，Parent ID= A，`Service 1` 发送请求到 `Service 2` 返回响应给 `Service 1` 的过程。
- 第三个节点：Span ID = C，Parent ID= B，`Service 2` 的 中间处理过程。
- 第四个节点：Span ID = D，Parent ID= C，`Service 2` 发送请求到 `Service 3` 返回响应给 `Service 2` 的过程。
- 第五个节点：Span ID = E，Parent ID= D，`Service 3` 的中间处理过程。
- 第六个节点：Span ID = F，Parent ID= C，`Service 3` 发送请求到 Service 4 返回响应给 `Service 3` 的过程。
- 第七个节点：Span ID = G，Parent ID= F，Service 4 的中间处理过程。

通过 Parent ID 即可找到父节点，整个链路就可以进行跟踪追溯了。

### 3. Spring Cloud 整合 Sleuth

大家可以参照我的 GitHub 开源项目 PassJava（佳必过）。

#### 3.1 引入 Spring Cloud 依赖

在 passjava-common 中引入 Spring Cloud 依赖

因为我们使用的链路追踪组件 Sleuth 是 Spring Cloud 的组件，所以我们需要引入 Spring Cloud 依赖。

```
<dependencyManagement>
    <dependencies>
        <!--  Spring Cloud 依赖  -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Hoxton.SR3</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

#### 3.2 引入Sleuth依赖

引入链路追踪组件 Sleuth 非常简单，在 pom.xml 文件中引入 Sleuth 依赖即可。

在 passjava-common 中引入 Sleuth 依赖：

``` xml
<!-- 链路追踪组件 -->
<dependency>
	<groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
```

#### 3.3 通过日志观察链路追踪

我们先不整合 zipkin 链路追踪可视化组件，而是通过日志的方式来查看链路追踪信息。

``` properties
文件路径：\PassJava-Platform\passjava-question\src\main\resources\application.properties
添加配置：
logging.level.org.springframework.cloud.openfeign=debug
logging.level.org.springframework.cloud.sleuth=debug
```

#### 3.4 启动微服务

启动以下微服务：

- passjava-gateway 服务（网关）

- passjava-question 服务（题目中心微服务）

- renren 服务（Admin 后台管理服务）

  启动成功后如下图所示：

![启动微服务](http://cdn.jayh.club/blog/20201113/bep64zUgq0k8.png?imageslim)



#### 3.5 测试跟踪请求

打开 Admin 后台，访问题目中心->题目配置页面，可以看到发送了下面的请求：

``` http
http://localhost:8060/api/question/v1/admin/question/list?t=1605170539929&page=1&limit=10&key=
```

![佳必过项目的后台界面](http://cdn.jayh.club/blog/20201113/UkTQdJqazR3f.png?imageslim)

打开控制台，可以看到打印出了追踪日志。

![链路追踪日志](http://cdn.jayh.club/blog/20201113/EVK7LJBndCut.png?imageslim)

说明：

- 当没有配置 Sleuth 链路追踪的时候，INFO 信息里面是 [passjava-question,,,]，后面跟着三个空字符串。
- 当配置了 Sleuth 链路追踪的时候，追踪到的信息是 [passjava-question,504a5360ca906016,e55ff064b3941956,false] ，第一个是 Trace ID，第二个是 Span ID。

### 4. Zipkin 链路追踪原理

上面我们通过简单的引入 Sleuth 组件，就可以获取到调用链路，但只能通过控制台的输出信息来看，不太方便。

Zipkin 油然而生，一个图形化的工具。Zipkin 是 Twitter 开源的分布式跟踪系统，主要用来用来收集系统的时序数据，进而可以跟踪系统的调用问题。

而且引入了 Zipkin 组件后，就不需要引入 Sleuth 组件了，因为 Zipkin 组件已经帮我们引入了。

Zipkin 的官文：https://zipkin.io

#### 4.1 Zipkin 基础架构

![Zipkin 基础架构](http://cdn.jayh.club/blog/20201113/FRXaXaM82QHB.png?imageslim)

**Zipkin 包含四大组件：** 

- Collection（收集器组件），主要负责收集外部系统跟踪信息。
- Storage（存储组件），主要负责将收集到的跟踪信息进行存储，默认存放在内存中，支持存储到 MySQL 和 ElasticSearch。
- API（查询组件），提供接口查询跟踪信息，给 UI 组件用的。
- UI （可视化 Web UI 组件），可以基于服务、时间、注解来可视化查看跟踪信息。注意：Web UI 不需要身份验证。

#### 4.2 Zipkin 跟踪流程

![ Zipkin 跟踪流程](http://cdn.jayh.club/blog/20201113/9TJsLVF4q9Iu.png?imageslim)

**流程解释：** 

- 第一步：用户代码发起 HTTP Get 请求，请求路径：/foo。
- 第二步：请求到到跟踪工具后，请求被拦截，会被记录两项信息：标签和时间戳。以及HTTP Headers 里面会增加跟踪头信息。
- 第三步：将封装好的请求传给 HTTP 客户端，请求中包含 X-B3-TraceID 和 X-B3-SpanId 请求头信息。
- 第四步：由HTTP 客户端发送请求。
- 第五步：Http 客户端返回响应 200 OK 后，跟踪工具记录耗时时间。
- 第六步：跟踪工具发送 200 OK 给用户端。
- 第七步：异步报告 Span 信息给 Zipkin 收集器。

### 5. 整合 Zipkin 可视化组件

#### 5.1 启动虚拟机并连接

``` sh
vagrant up
```

![启动虚拟机](http://cdn.jayh.club/blog/20201113/0MHnr14FCOEQ.png?imageslim)

用 Xshell 工具连接 虚拟机。

#### 5.2 docker 安装 zipkin 服务

- 使用以下命令开始拉取 zipkin 镜像并启动 zipkin 容器。

``` sh
docker run -d -p 9411:9411 openzipkin/zipkin
```

- 命令执行完后，会执行下载操作和启动操作。

![docker 安装 zipkin 服务](http://cdn.jayh.club/blog/20201113/SqP777Tdyw1V.png?imageslim)

- 使用 docker ps 命令可以看到 zipkin 容器已经启动成功了。如下图所示：

![zipkin 容器启动成功](http://cdn.jayh.club/blog/20201113/744ztsITuJkV.png?imageslim)

- 在浏览器窗口打开 zipkin UI 

> 访问服务地址：http://192.168.56.10:9411/zipkin。

<img src="http://cdn.jayh.club/blog/20201113/ttYgi3S0vCDA.png?imageslim" alt="链路追踪" style="zoom:67%;" />

#### 5.3 引入 Zipkin 依赖

在公共模块引入 zipkin 依赖

```xml
<!-- 链路追踪组件 Zipkin -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```

因为 zipkin 包里面已经引入了 sleuth 组件，所以可以把之前引入的 sleuth 组件删掉。

#### 5.4 添加 Zipkin 配置

在需要追踪的微服务模块下添加 zipkin 配置。

```properties
# zipkin 的服务器地址
spring.zipkin.base-url=http://192.168.56.10:9411/
# 关闭服务发现，否则 Spring Cloud 会把 zipkin 的 URL 当作服务名称。
spring.zipkin.discovery-client-enabled=false
# 设置使用 http 的方式传输数据，也可以用 RabbitMQ 或 Kafka。
spring.zipkin.sender.type=web
# 设置采样率为 100 %，默认为 0.1（10%）
spring.sleuth.sampler.probability=1
```

#### 5.5 测试 Zipkin 是否工作

这里我在 passjava-member 微服务中写了一个 API：

passjava-member 服务的 API：getMemberStudyTimeListTest，访问路径为/studytime/list/test/{id}。

passjava-member 服务远程调用 passjava-study 服务的 API：getMemberStudyTimeListTest。

我用 postman 工具测试 member 服务的 API：

![测试 Passjava-member 服务的 API](http://cdn.jayh.club/blog/20201113/fdTdJTy6d9AX.png?imageslim)

打开 Zipkin 工具，搜索 passjava-member 的链路追踪日志，可以看到有一条记录，相关说明如下图所示：

![zipkin 示例](http://cdn.jayh.club/blog/20201113/mpU94HPGzLSa.png?imageslim)

从图中可以看到 passjava-member 微服务调用了 passjava-study 微服务，如图中左半部分所示。

而且 passjava-study 微服务详细的调用时间都记录得非常清楚，如图中右半部分所示。

**时间计算：**

- 请求传输时间：Server Start - Client Start = 2.577s-2.339s = 0.238s
- 服务端处理时间：Server Finish - Server Start = 2.863s - 2.577s = 0.286s
- 请求总耗时：Client Finish - Client Start = 2.861s - 2.339s = 0.522s
- Passjava-member 服务总耗时：3.156 s
- Passjava-study 服务总耗时：0.521s
- 由此可以看出 passjava-member 服务花费了很长时间，性能很差。



还可以用图标的方式查看：

![图标的方式查看](http://cdn.jayh.club/blog/20201113/oVdmfBTIVCg5.png?imageslim)

### 6. Zipkin 数据持久化

#### 6.1 Zipkin 支持的数据库

Zipkin 存储数据默认是放在内存中的，如果 Zipkin 重启，那么监控数据也会丢失。如果是生成环境，数据丢失会带来很大问题，所以需要将 Zipkin 的监控数据持久化。而 Zipkin 支持将数据存储到以下数据库：

- 内存（默认，不建议使用）
- MySQL（数据量大的话， 查询较为缓慢，不建议使用）
- Elasticsearch（建议使用）
- Cassandra（国内使用 Cassandra 的公司较少，相关文档也不多）

#### 6.2 使用 Elasticsearch 作为储存介质

- 通过 docker 的方式配置 elasticsearch 作为 zipkin 数据的存储介质。

``` sh
docker run --env STORAGE_TYPE=elasticsearch --env ES_HOSTS=192.168.56.10:9200 openzipkin/zipkin-dependencies
```

- ES 作为存储介质的配置参数：

![ES 作为存储介质的配置参数](http://cdn.jayh.club/blog/20201113/Tw1EtAwIvTkr.png?imageslim)

### 7. 总结

本篇讲解了链路追踪的核心原理，以及 Sleuth + Zipkin 的组件的原理，以及将这两款组件加到了我的开源项目《佳必过》里面了。

> 开源项目地址：https://github.com/Jackson0714/PassJava-Platform

### 写在最后

这周真的身心俱疲，娃也是受罪，出院后，娃吃饭也不像以前那么积极了，看到医生那种衣服就怕，连看到照片打印机都怕了。生怕是要给他打针、吃药、做雾化的。还未结婚生娃的抓紧时间学习吧，加油少年~



参考文档：

> https://github.com/openzipkin/zipkin#storage-component
>
> https://github.com/openzipkin/zipkin/tree/master/zipkin-server#elasticsearch-storage
>
> https://github.com/openzipkin/zipkin/tree/master/zipkin-storage/elasticsearch



# 七、ELK 篇

## 7.1 Elasticsearch上篇（原理）

本篇主要内容如下：

![主要内容](http://cdn.jayh.club/blog/20201009/FeDIusuH1JXe.png?imageslim)

### 前言

项目中我们总是用 `Kibana` 界面来搜索测试或生产环境下的日志，来看下有没有异常信息。`Kibana` 就是 我们常说的 `ELK` 中的 `K`。

Kibana 界面如下图所示：

![Kibana 界面](http://cdn.jayh.club/blog/20201007/oxihEk0lT425.png?imageslim)

但这些日志检索原理是什么呢？这里就该我们的 Elasticsearch 搜索引擎登场了。

**我会分为三篇来讲解 Elasticsearch（简称ES）的原理、实战及部署。**  

- **上篇：** 讲解 ES 的原理、中文分词的配置。
- **中篇：** 实战 ES 应用。
- **下篇：** ES 的集群部署。

为什么要分成三篇，因为每一篇都很长，而且侧重点不一样，所以分成三篇来讲解。

### 1. Elasticsearch 简介

#### 1.1 什么是 Elasticsearch?

Elasticsearch 是一个分布式的开源搜索和分析引擎，适用于所有类型的数据，包括文本、数字、地理空间、结构化和非结构化数据。简单来说只要涉及搜索和分析相关的， ES 都可以做。

#### 1.2 Elasticsearch 的用途？

Elasticsearch 在速度和可扩展性方面都表现出色，而且还能够索引多种类型的内容，这意味着其可用于多种用例：

-   比如一个在线网上商店，您可以在其中允许客户搜索您出售的产品。在这种情况下，您可以使用Elasticsearch 存储整个产品目录和库存，并为它们提供搜索和自动完成建议。

![搜索手机](http://cdn.jayh.club/blog/20201008/bouuKG9HOiEo.png?imageslim)

-   比如收集日志或交易数据，并且要分析和挖掘此数据以查找趋势，统计信息，摘要或异常。在这种情况下，您可以使用 Logstash（Elasticsearch / Logstash / Kibana堆栈的一部分）来收集，聚合和解析数据，然后让 Logstash 将这些数据提供给 Elasticsearch。数据放入 Elasticsearch 后，您可以运行搜索和聚合以挖掘您感兴趣的任何信息。

#### 1.3 Elasticsearch 的工作原理？

![ELK 原理图](http://cdn.jayh.club/blog/20201009/zGTJCTFPs4Xq.png?imageslim)

Elasticsearch 是在 Lucene 基础上构建而成的。ES 在 Lucence 上做了很多增强。

Lucene 是apache软件基金会 4 的 jakarta 项目组的一个子项目，是一个[开放源代码](https://baike.baidu.com/item/开放源代码/114160)的全文检索引擎工具包，但它不是一个完整的全文检索引擎，而是一个全文检索引擎的架构，提供了完整的查询引擎和索引引擎，部分[文本分析](https://baike.baidu.com/item/文本分析/11046544)引擎（英文与德文两种西方语言）。Lucene的目的是为软件开发人员提供一个简单易用的工具包，以方便的在目标系统中实现全文检索的功能，或者是以此为基础建立起完整的全文检索引擎。（来自百度百科）

**Elasticsearch 的原始数据从哪里来？** 

原始数据从多个来源 ( 包括日志、系统指标和网络应用程序 ) 输入到 Elasticsearch 中。

**Elasticsearch 的数据是怎么采集的？** 

数据采集指在 Elasticsearch 中进行索引之前解析、标准化并充实这些原始数据的过程。这些数据在 Elasticsearch 中索引完成之后，用户便可针对他们的数据运行复杂的查询，并使用聚合来检索自身数据的复杂汇总。这里用到了 Logstash，后面会介绍。

**怎么可视化查看想要检索的数据？** 

这里就要用到 Kibana 了，用户可以基于自己的数据进行搜索、查看数据视图等。

#### 1.4 Elasticsearch 索引是什么？

Elasticsearch 索引指相互关联的文档集合。Elasticsearch 会以 JSON 文档的形式存储数据。每个文档都会在一组键 ( 字段或属性的名称 ) 和它们对应的值 ( 字符串、数字、布尔值、日期、数值组、地理位置或其他类型的数据 ) 之间建立联系。

Elasticsearch 使用的是一种名为倒排索引的数据结构，这一结构的设计可以允许十分快速地进行全文本搜索。倒排索引会列出在所有文档中出现的每个特有词汇，并且可以找到包含每个词汇的全部文档。

在索引过程中，Elasticsearch 会存储文档并构建倒排索引，这样用户便可以近实时地对文档数据进行搜索。索引过程是在索引 API 中启动的，通过此 API 您既可向特定索引中添加 JSON 文档，也可更改特定索引中的 JSON 文档。

#### 1.5 Logstash 的用途是什么？

Logstash 就是 `ELK` 中的 `L`。

Logstash 是 Elastic Stack 的核心产品之一，可用来对数据进行聚合和处理，并将数据发送到 Elasticsearch。Logstash 是一个开源的服务器端数据处理管道，允许您在将数据索引到 Elasticsearch 之前同时从多个来源采集数据，并对数据进行充实和转换。

#### 1.6 Kibana 的用途是什么？

Kibana 是一款适用于 Elasticsearch 的数据可视化和管理工具，可以提供实时的直方图、线性图等。

#### 1.7 为什么使用 Elasticsearch

- ES 很快，近实时的搜索平台。
- ES 具有分布式的本质特质。
- ES 包含一系列广泛的功能，比如数据汇总和索引生命周期管理。

官方文档：https://www.elastic.co/cn/what-is/elasticsearch

### 2. ES 基本概念

#### 2.1 Index ( 索引 )

动词：相当于 Mysql 中的 insert

名词：相当于 Mysql 中的 database

与 mysql 的对比

| 序号 | Mysql                      | Elasticsearch             |
| ---- | -------------------------- | ------------------------- |
| 1    | Mysql 服务                  | ES 集群服务                |
| 2    | 数据库 Database            | 索引 Index                |
| 3    | 表 Table                   | 类型 Type                 |
| 4    | 记录 Records ( 一行行记录 ) | 文档 Document ( JSON 格式 ) |

#### 2.2 倒排索引

假如数据库有如下电影记录：

1-大话西游

2-大话西游外传

3-解析大话西游

4-西游降魔外传

5-梦幻西游独家解析

**分词：将整句分拆为单词** 

| 序号 | 保存到 ES 的词 | 对应的电影记录序号 |
| ---- | ------------ | ------------------ |
| A    | 西游         | 1,2, 3,4, 5      |
| B    | 大话         | 1,2, 3            |
| C    | 外传         | 2,4, 5            |
| D    | 解析         | 3,5               |
| E    | 降魔         | 4                  |
| F    | 梦幻         | 5                  |
| G    | 独家         | 5                  |

**检索：独家大话西游** 

将 ` 独家大话西游 ` 解析拆分成 ` 独家 `、` 大话 `、` 西游 `

ES 中 A、B、G 记录 都有这三个词的其中一种，  所以 1,2, 3,4, 5 号记录都有相关的词被命中。

1 号记录命中 2 次， A、B 中都有 ( 命中 `2` 次 ) ，而且 1 号记录有 `2` 个词，相关性得分：`2` 次/`2` 个词=`1`

2 号记录命中 2 个词 A、B 中的都有 ( 命中 `2` 次 ) ，而且 2 号记录有 `2` 个词，相关性得分：`2` 次/`3` 个词= `0.67`

3 号记录命中 2 个词 A、B 中的都有 ( 命中 `2` 次 ) ，而且 3 号记录有 `2` 个词，相关性得分：`2` 次/`3` 个词= `0.67`

4 号记录命中 2 个词 A 中有 ( 命中 `1` 次 ) ，而且 4 号记录有 `2` 个词，相关性得分：`1` 次/`3` 个词= `0.33`

5 号记录命中 2 个词 A 中有 ( 命中 `2` 次 ) ，而且 4 号记录有 `4` 个词，相关性得分：`2` 次/`4` 个词= `0.5`

**所以检索出来的记录顺序如下：** 

​    1-大话西游 ( 想关性得分：1 )

​    2-大话西游外传 ( 想关性得分：0.67 )

​    3-解析大话西游 ( 想关性得分：0.67 )

​    5-梦幻西游独家解析 ( 想关性得分：0.5 )

​    4-西游降魔 ( 想关性得分：0.33 )

### 3. Docker 搭建环境

#### 3.1. 搭建 Elasticsearch 环境

搭建虚拟机环境和安装 docker 可以参照之前写的文档：

-   [01. 快速搭建 Linux 环境-运维必备](http://www.passjava.cn/#/05.安装部署篇/01.环境搭建篇)
-   [02. 配置虚拟机网络](http://www.passjava.cn/#/05.安装部署篇/02.配置虚拟机网络)
-   [03. 安装 Docker](http://www.passjava.cn/#/05.安装部署篇/03.安装docker)

##### 1 ) 下载镜像文件

```sh
docker pull elasticsearch:7.4.2
```

##### 2 ) 创建实例

-   1. 映射配置文件

```sh
配置映射文件夹
mkdir -p /mydata/elasticsearch/config

配置映射文件夹
mkdir -p /mydata/elasticsearch/data

设置文件夹权限任何用户可读可写
chmod 777 /mydata/elasticsearch -R

配置 http.host
echo "http.host: 0.0.0.0" >> /mydata/elasticsearch/config/elasticsearch.yml
```

-   2. 启动 elasticsearch 容器

``` sh
docker run --name elasticsearch -p 9200:9200 -p 9300:9300 \
-e "discovery.type"="single-node" \
-e ES_JAVA_OPTS="-Xms64m -Xmx128m" \
-v /mydata/elasticsearch/config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml \
-v /mydata/elasticsearch/data:/usr/share/elasticsearch/data \
-v /mydata/elasticsearch/plugins:/usr/share/elasticsearch/plugins \
-d elasticsearch:7.4.2
```

-   3. 访问 elasticsearch 服务

访问：http://192.168.56.10:9200

返回的 reponse

``` json
{
  "name" : "8448ec5f3312",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "xC72O3nKSjWavYZ-EPt9Gw",
  "version" : {
    "number" : "7.4.2",
    "build_flavor" : "default",
    "build_type" : "docker",
    "build_hash" : "2f90bbf7b93631e52bafb59b3b049cb44ec25e96",
    "build_date" : "2019-10-28T20:40:44.881551Z",
    "build_snapshot" : false,
    "lucene_version" : "8.2.0",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
```

访问：http://192.168.56.10:9200/_cat 访问节点信息

``` sh
127.0.0.1 62 90 0 0.06 0.10 0.05 dilm * 8448ec5f3312
```

#### 3.2. 搭建 Kibana 环境

``` sh
docker pull kibana:7.4.2

docker run --name kibana -e ELASTICSEARCH_HOSTS=http://192.168.56.10:9200 -p 5601:5601 -d kibana:7.4.2

```

访问 kibana: http://192.168.56.10:5601/

![kibana](http://cdn.jayh.club/blog/20200618/KdLmdaHR2etK.png?imageslim)

### 4、初阶检索玩法

#### 4.1._cat 用法

``` sh
GET /_cat/nodes: 查看所有节点
GET /_cat/health: 查看 es 健康状况
GET /_cat/master: 查看主节点
GET /_cat/indices: 查看所有索引

查询汇总：
/_cat/allocation
/_cat/shards
/_cat/shards/{index}
/_cat/master
/_cat/nodes
/_cat/tasks
/_cat/indices
/_cat/indices/{index}
/_cat/segments
/_cat/segments/{index}
/_cat/count
/_cat/count/{index}
/_cat/recovery
/_cat/recovery/{index}
/_cat/health
/_cat/pending_tasks
/_cat/aliases
/_cat/aliases/{alias}
/_cat/thread_pool
/_cat/thread_pool/{thread_pools}
/_cat/plugins
/_cat/fielddata
/_cat/fielddata/{fields}
/_cat/nodeattrs
/_cat/repositories
/_cat/snapshots/{repository}
/_cat/templates
```

#### 4.2. 索引一个文档 ( 保存 )

例子：在 `customer` 索引下的 `external` 类型下保存标识为 `1` 的数据。

-   使用 Kibana 的 Dev Tools 来创建

``` sh
PUT member/external/1

{
"name":"jay huang"
}
```

Reponse:

``` json
{
    "_index": "member", //在哪个索引
    "_type": "external",//在那个类型
    "_id": "2",//记录 id
    "_version": 7,//版本号
    "result": "updated",//操作类型
    "_shards": {
        "total": 2,
        "successful": 1,
        "failed": 0
    },
    "_seq_no": 9,
    "_primary_term": 1
}
```

-   也可以通过 Postman 工具发送请求来创建记录。

![创建一条记录](http://cdn.jayh.club/blog/20200617/Kab9WijNRF8t.png?imageslim)

注意：

PUT 和 POST 都可以创建记录。

POST：如果不指定 id，自动生成 id。如果指定 id，则修改这条记录，并新增版本号。

PUT：必须指定 id，如果没有这条记录，则新增，如果有，则更新。

#### 4.3 查询文档

``` json
请求：http://192.168.56.10:9200/member/external/2

Reposne:
{
    "_index": "member",   //在哪个索引
    "_type": "external",  //在那个类型
    "_id": "2",           //记录 id
    "_version": 7,        //版本号
    "_seq_no": 9,         //并发控制字段，每次更新就会+1，用来做乐观锁
    "_primary_term": 1,   //同上，主分片重新分配，如重启，就会变化
    "found": true,
    "_source": { //真正的内容
        "name": "jay huang"
 }
}
```

_seq_no 用作乐观锁

每次更新完数据后，_seq_no 就会+1，所以可以用作并发控制。

当更新记录时，如果_seq_no 与预设的值不一致，则表示记录已经被至少更新了一次，不允许本次更新。

用法如下：

``` json
请求更新记录 2: http://192.168.56.10:9200/member/external/2?if_seq_no=9&&if_primary_term=1
返回结果：
{
    "_index": "member",
    "_type": "external",
    "_id": "2",
    "_version": 9,
    "result": "updated",
    "_shards": {
        "total": 2,
        "successful": 1,
        "failed": 0
    },
    "_seq_no": 11,
    "_primary_term": 1
}
```

_seq_no 等于 10，且_primary_term=1 时更新数据，执行一次请求后，再执行上面的请求则会报错：版本冲突

``` json
{
    "error": {
        "root_cause": [
 {
                "type": "version_conflict_engine_exception",
                "reason": "[2]: version conflict, required seqNo [10], primary term [1]. current document has seqNo [11] and primary term [1]",
                "index_uuid": "CX6uwPBKRByWpuym9rMuxQ",
                "shard": "0",
                "index": "member"
 }
        ],
        "type": "version_conflict_engine_exception",
        "reason": "[2]: version conflict, required seqNo [10], primary term [1]. current document has seqNo [11] and primary term [1]",
        "index_uuid": "CX6uwPBKRByWpuym9rMuxQ",
        "shard": "0",
        "index": "member"
    },
    "status": 409
}
```

#### 4.4 更新文档

-   用法

POST 带 `_update` 的更新操作，如果原数据没有变化，则 repsonse 中的 result 返回 noop ( 没有任何操作 ) ，version 也不会变化。

请求体中需要用 `doc` 将请求数据包装起来。

```
POST 请求：http://192.168.56.10:9200/member/external/2/_update
{
    "doc":{
        "name":"jay huang"
 }
}
响应：
{
    "_index": "member",
    "_type": "external",
    "_id": "2",
    "_version": 12,
    "result": "noop",
    "_shards": {
        "total": 0,
        "successful": 0,
        "failed": 0
    },
    "_seq_no": 14,
    "_primary_term": 1
}
```

使用场景：对于大并发更新，建议不带 `_update`。对于大并发查询，少量更新的场景，可以带_update，进行对比更新。

-   更新时增加属性

  请求体中增加 `age` 属性

``` json
http://192.168.56.10:9200/member/external/2/_update
request:
{
    "doc":{
        "name":"jay huang",
        "age": 18
 }
}
response:
{
    "_index": "member",
    "_type": "external",
    "_id": "2",
    "_version": 13,
    "result": "updated",
    "_shards": {
        "total": 2,
        "successful": 1,
        "failed": 0
    },
    "_seq_no": 15,
    "_primary_term": 1
}
```

#### 4.5 删除文档和索引

-   删除文档

``` json
DELETE 请求：http://192.168.56.10:9200/member/external/2
response:
{
    "_index": "member",
    "_type": "external",
    "_id": "2",
    "_version": 2,
    "result": "deleted",
    "_shards": {
        "total": 2,
        "successful": 1,
        "failed": 0
    },
    "_seq_no": 1,
    "_primary_term": 1
}
```

-   删除索引

``` json
DELETE 请求：http://192.168.56.10:9200/member
repsonse:
{
    "acknowledged": true
}
```

-   没有删除类型的功能

#### 4.6 批量导入数据

  使用 kinaba 的 dev tools 工具，输入以下语句

``` json
POST /member/external/_bulk
{"index":{"_id":"1"}}
{"name":"Jay Huang"}
{"index":{"_id":"2"}}
{"name":"Jackson Huang"}
```

执行结果如下图所示：

![批量插入数据](http://cdn.jayh.club/blog/20200619/uqJhXNxRa4Dp.png?imageslim)

-   拷贝官方样本数据

  ``` http
  https://raw.githubusercontent.com/elastic/elasticsearch/master/docs/src/test/resources/accounts.json
  ```

  ![官方样本数据](http://cdn.jayh.club/blog/20200619/iye5YjQSE8EI.png?imageslim)

-   在 kibana 中执行脚本

``` json
POST /bank/account/_bulk
{"index":{"_id":"1"}}
{"account_number":1,"balance":39225,"firstname":"Amber","lastname":"Duke","age":32,"gender":"M","address":"880 Holmes Lane","employer":"Pyrami","email":"amberduke@pyrami.com","city":"Brogan","state":"IL"}
{"index":{"_id":"6"}}
......
```

![批量插入样本数据的执行结果](http://cdn.jayh.club/blog/20200619/MQn9QhpBHr3W.png?imageslim)

-   查看所有索引

  ![查看所有索引](http://cdn.jayh.club/blog/20200619/sbe64743CK9W.png?imageslim)

可以从返回结果中看到 bank 索引有 1000 条数据，占用了 440.2kb 存储空间。

### 5. 高阶检索玩法

#### 5.1 两种查询方式

##### 5.1.1  URL 后接参数

``` json
GET bank/_search?q=*&sort=account_number: asc
```

```/_search?q=*&sort=account_number: asc`

查询出所有数据，共 1000 条数据，耗时 1ms，只展示 10 条数据 ( ES 分页 )

![URL 后接参数](http://cdn.jayh.club/blog/20200620/BvHAoaDumBk7.png?imageslim)

  属性值说明：

``` javascript
took – ES 执行搜索的时间 ( 毫秒 )
timed_out – ES 是否超时
_shards – 有多少个分片被搜索了，以及统计了成功/失败/跳过的搜索的分片
max_score – 最高得分
hits.total.value - 命中多少条记录
hits.sort - 结果的排序 key 键，没有则按 score 排序
hits._score - 相关性得分
参考文档：
https://www.elastic.co/guide/en/elasticsearch/reference/current/getting-started-search.html
```

##### 5.1.2 URL 加请求体进行检索 ( QueryDSL )

请求体中写查询条件

语法：

```json
GET bank/_search
{
  "query":{"match_all": {}},
  "sort": [
    {"account_number": "asc" }
 ]
}
```

示例：查询出所有，先按照 accout_number 升序排序，再按照 balance 降序排序

![URL 加请求体进行检索](http://cdn.jayh.club/blog/20200620/HaSgoLuCjamf.png?imageslim)

#### 5.2 详解 QueryDSL 查询

> DSL: Domain Specific Language

##### 5.2.1 全部匹配 match_all

示例：查询所有记录，按照 balance 降序排序，只返回第 11 条记录到第 20 条记录，只显示 balance 和 firstname 字段。

``` json
GET bank/_search
{
  "query": {
    "match_all": {}
  },
  "sort": [
 {
      "balance": {
        "order": "desc"
 }
 }
  ],
  "from": 10,
  "size": 10,
  "_source": ["balance", "firstname"]
}
```

##### 5.2.2 匹配查询 match

-   基本类型 ( 非字符串 ) ，精确匹配

``` json
GET bank/_search
{
  "query": {
    "match": {"account_number": "30"}
 }
}
```

-   字符串，全文检索

``` json
GET bank/_search
{
  "query": {
    "match": {
      "address": "mill road"
 }
 }
}
```

![字符串全文检索](http://cdn.jayh.club/blog/20200623/OKvUum6PodWJ.png?imageslim)

> 全文检索按照评分进行排序，会对检索条件进行分词匹配。
>
> 查询 `address` 中包含 `mill` 或者 `road` 或者 `mill road` 的所有记录，并给出相关性得分。

查到了 32 条记录，最高的一条记录是 Address = "990 Mill Road"，得分：8.926605. Address="198 Mill Lane" 评分 5.4032025，只匹配到了 Mill 单词。

##### 5.2.3 短语匹配 match_phase

将需要匹配的值当成一个整体单词 ( 不分词 ) 进行检索

``` json
GET bank/_search
{
  "query": {
    "match_phrase": {
      "address": "mill road"
 }
 }
}
```

> 查出 address 中包含 `mill road` 的所有记录，并给出相关性得分

##### 5.2.4 多字段匹配 multi_match

``` json
GET bank/_search
{
  "query": {
    "multi_match": {
      "query": "mill land",
      "fields": [
        "state",
        "address"
 ]
 }
 }
}
```

> multi_match 中的 query 也会进行分词。
>
> 查询 `state` 包含 `mill` 或 `land` 或者 `address` 包含 `mill` 或 `land` 的记录。

##### 5.2.5 复合查询 bool

> 复合语句可以合并任何其他查询语句，包括复合语句。复合语句之间可以相互嵌套，可以表达复杂的逻辑。

搭配使用 must,must_not,should

must: 必须达到 must 指定的条件。 ( 影响相关性得分 )

must_not: 必须不满足 must_not 的条件。 ( 不影响相关性得分 )

should: 如果满足 should 条件，则可以提高得分。如果不满足，也可以查询出记录。 ( 影响相关性得分 )

示例：查询出地址包含 mill，且性别为 M，年龄不等于 28 的记录，且优先展示 firstname 包含 Winnie 的记录。

``` json
GET bank/_search
{
  "query": {
    "bool": {
      "must": [
 {
          "match": {
            "address": "mill"
 }
        },
 {
          "match": {
            "gender": "M"
 }
 }
      ],
      "must_not": [
 {
          "match": {
            "age": "28"
 }
 }
      ],
      "should": [
 {
          "match": {
            "firstname": "Winnie"
 }
 }
 ]
 }
 }
}
```

##### 5.2.6 filter 过滤

> 不影响相关性得分，查询出满足 filter 条件的记录。
>
> 在 bool 中使用。

``` json
GET bank/_search
{
  "query": {
    "bool": {
      "filter": [
 {
          "range": {
            "age": {
              "gte":18,
              "lte":40
 }
 }
 }
 ]
 }
 }
}
```

##### 5.2.7 term 查询

> 匹配某个属性的值。
>
> 全文检索字段用 match，其他非 text 字段匹配用 term
>
> keyword：文本精确匹配 ( 全部匹配 )
>
> match_phase：文本短语匹配

``` json
非 text 字段精确匹配
GET bank/_search
{
  "query": {
    "term": {
      "age": "20"
 }
 }
}
```

##### 5.2.8 aggregations 聚合

> 聚合：从数据中分组和提取数据。类似于 SQL GROUP BY 和 SQL 聚合函数。
>
> Elasticsearch 可以将命中结果和多个聚合结果同时返回。

聚合语法：

``` json
"aggregations" : {
    "<聚合名称 1>" : {
        "<聚合类型>" : {
            <聚合体内容>
        }
        [,"元数据" : {  [<meta_data_body>] }]?
        [,"aggregations" : { [<sub_aggregation>]+ }]?
    }
    [,"聚合名称 2>" : { ... }]*
}
```

-   示例 1：搜索 address 中包含 big 的所有人的年龄分布 ( 前 10 条 ) 以及平均年龄，以及平均薪资

``` json
GET bank/_search
{
  "query": {
    "match": {
      "address": "mill"
 }
  },
  "aggs": {
    "ageAggr": {
      "terms": {
        "field": "age",
        "size": 10
       }
    },
    "ageAvg": {
      "avg": {
        "field": "age"
      }
    },
    "balanceAvg": {
      "avg": {
        "field": "balance"
      }
   }
 }
}
```

检索结果如下所示：

hits 记录返回了，三种聚合结果也返回了，平均年龄 34 随，平均薪资 25208.0，品骏年龄分布：38 岁的有 2 个，28 岁的有一个，32 岁的有一个

![示例 1](http://cdn.jayh.club/blog/20200629/amT7fuehc6yr.png?imageslim)

如果不想返回 hits 结果，可以在最后面设置 size:0

``` json
GET bank/_search
{
  "query": {
    "match": {
      "address": "mill"
 }
  },
  "aggs": {
    "ageAggr": {
      "terms": {
        "field": "age",
        "size": 10
      }
    }
  },
  "size": 0
}
```

-   示例 2：按照年龄聚合，并且查询这些年龄段的平均薪资

从结果可以看到 31 岁的有 61 个，平均薪资 28312.9，其他年龄的聚合结果类似。

![示例 2](http://cdn.jayh.club/blog/20200629/6BVJ9lMdQPM3.png?imageslim)

-   示例 3：按照年龄分组，然后将分组后的结果按照性别分组，然后查询出这些分组后的平均薪资

``` json
GET bank/_search
{
  "query": {
    "match_all": {
 }
  },
  "aggs": {
    "ageAggr": {
      "terms": {
        "field": "age",
        "size": 10
      },
      "aggs": {
        "genderAggr": {
          "terms": {
            "field": "gender.keyword",
            "size": 10
          },
          "aggs": {
            "balanceAvg": {
              "avg": {
                "field": "balance"
          }
        }
      }
    }
  }
 }
  },
  "size": 0
}
```

从结果可以看到 31 岁的有 61 个。其中性别为 `M` 的 35 个，平均薪资 29565.6，性别为 `F` 的 26 个，平均薪资 26626.6。其他年龄的聚合结果类似。

![聚合结果](http://cdn.jayh.club/blog/20200629/fHRH5q2CDMSs.png?imageslim)

##### 5.2.9 Mapping 映射

> Mapping 是用来定义一个文档 ( document ) ，以及它所包含的属性 ( field ) 是如何存储和索引的。

-   定义哪些字符串属性应该被看做全文本属性 ( full text fields )
-   定义哪些属性包含数字，日期或地理位置
-   定义文档中的所有属性是否都能被索引 ( _all 配置 )
-   日期的格式
-   自定义映射规则来执行动态添加属性

Elasticsearch7 去掉 tpye 概念：

关系型数据库中两个数据库表示是独立的，即使他们里面有相同名称的列也不影响使用，但 ES 中不是这样的。elasticsearch 是基于 Lucence 开发的搜索引擎，而 ES 中不同 type 下名称相同的 field 最终在 Lucence 中的处理方式是一样的。

为了区分不同 type 下的同一名称的字段，Lucence 需要处理冲突，导致检索效率下降

ES7.x 版本：URL 中的 type 参数为可选。

ES8.x 版本：不支持 URL 中的 type 参数

所有类型可以参考文档：https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping-types.html

-   查询索引的映射

如查询 my-index 索引的映射

``` json
GET /my-index/_mapping
返回结果：
{
  "my-index" : {
    "mappings" : {
      "properties" : {
        "age" : {
          "type" : "integer"
        },
        "email" : {
          "type" : "keyword"
        },
        "employee-id" : {
          "type" : "keyword",
          "index" : false
        },
        "name" : {
          "type" : "text"
      }
    }
  }
 }
}
```

-   创建索引并指定映射

如创建 my-index 索引，有三个字段 age,email,name，指定类型为 interge, keyword, text

``` json
PUT /my-index
{
  "mappings": {
    "properties": {
      "age": { "type": "integer" },
      "email": { "type": "keyword"  },
      "name": { "type": "text" }
    }
 }
返回结果：
{
  "acknowledged" : true,
  "shards_acknowledged" : true,
  "index" : "my-index"
}

```

-   添加新的字段映射

如在 my-index 索引里面添加 employ-id 字段，指定类型为 keyword

``` json
PUT /my-index/_mapping
{
  "properties": {
    "employee-id": {
      "type": "keyword",
      "index": false
    }
 }
}
```

-   更新映射

> 我们不能更新已经存在的映射字段，必须创建新的索引进行数据迁移。

-   数据迁移

``` json

POST _reindex
{
  "source": {
    "index": "twitter"
  },
  "dest": {
    "index": "new_twitter"
 }
}
```

### 6. 中文分词

ES 内置了很多种分词器，但是对中文分词不友好，所以我们需要借助第三方中文分词工具包。

#### 6.1 ES 中的分词的原理

##### 6.1.1 ES 的分词器概念

ES 的一个分词器 ( tokenizer ) 接收一个字符流，将其分割为独立的词元 ( tokens ) ，然后输出词元流。

ES 提供了很多内置的分词器，可以用来构建自定义分词器 ( custom ananlyzers )

##### 6.1.2 标准分词器原理

比如 stadard tokenizer 标准分词器，遇到空格进行分词。该分词器还负责记录各个词条 ( term ) 的顺序或 position 位置 ( 用于 phrase 短语和 word proximity 词近邻查询 ) 。每个单词的字符偏移量 ( 用于高亮显示搜索的内容 ) 。

##### 6.1.3 英文和标点符号分词示例

查询示例如下：

``` json
POST _analyze
{
  "analyzer": "standard",
  "text": "Do you know why I want to study ELK? 2 3 33..."
}
```

查询结果：

``` sh
do, you, know, why, i, want, to, study, elk, 2,3,33
```

从查询结果可以看到：

（1）标点符号没有分词。

（2）数字会进行分词。

![英文句子分词](http://cdn.jayh.club/blog/20200708/msWLHBLAdo3c.png?imageslim)

##### 6.1.4 中文分词示例

但是这种分词器对中文的分词支持不友好，会将词语分词为单独的汉字。比如下面的示例会将 ` 悟空聊架构 ` 分词为 ` 悟 `,` 空 `,` 聊 `,` 架 `,` 构 `，期望分词为 ` 悟空 `，` 聊 `，` 架构 `。

``` json
POST _analyze
{
  "analyzer": "standard",
  "text": "悟空聊架构"
}
```

![中文分词悟空聊架构](http://cdn.jayh.club/blog/20200708/I8dhOuSVoXem.png?imageslim)

我们可以安装 ik 分词器来更加友好的支持中文分词。

#### 6.2  安装 ik 分词器

##### 6.2.1 ik 分词器地址

ik 分词器地址：

``` js
https://github.com/medcl/elasticsearch-analysis-ik/releases
```

先检查 ES 版本，我安装的版本是 `7.4.2`，所以我们安装 ik 分词器的版本也选择 7.4.2

``` json
http://192.168.56.10:9200/
{
  "name" : "8448ec5f3312",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "xC72O3nKSjWavYZ-EPt9Gw",
  "version" : {
    "number" : "7.4.2",
    "build_flavor" : "default",
    "build_type" : "docker",
    "build_hash" : "2f90bbf7b93631e52bafb59b3b049cb44ec25e96",
    "build_date" : "2019-10-28T20:40:44.881551Z",
    "build_snapshot" : false,
    "lucene_version" : "8.2.0",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
```

![选择 ik 分词器](http://cdn.jayh.club/blog/20200709/MdL36AGYEYDg.png?imageslim)

##### 6.2.2 安装 ik 分词器的方式

###### 6.2.2.1 方式一：容器内安装 ik 分词器

-   进入 es 容器内部 plugins 目录

``` sh
docker exec -it <容器 id> /bin/bash
```

-   获取 ik 分词器压缩包

``` sh
wget https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.4.2/elasticsearch-analysis-ik-7.4.2.zip
```

-   解压缩 ik 压缩包

``` sh
unzip 压缩包
```

-   删除下载的压缩包

``` sh
rm -rf *.zip
```

###### 6.2.2.2 方式二：映射文件安装 ik 分词器

进入到映射文件夹

```sh
cd /mydata/elasticsearch/plugins
```

下载安装包

```sh
wget https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.4.2/elasticsearch-analysis-ik-7.4.2.zip
```

-   解压缩 ik 压缩包

``` sh
unzip 压缩包
```

-   删除下载的压缩包

``` sh
rm -rf *.zip
```

###### 6.2.2.3 方式三：Xftp 上传压缩包到映射目录

先用 XShell 工具连接虚拟机 ( 操作步骤可以参考之前写的文章 [02. 快速搭建 Linux 环境-运维必备](http://www.passjava.cn/#/05.安装部署篇/01.环境搭建篇)) ，然后用 Xftp 将下载好的安装包复制到虚拟机。

![Xftp 上传压缩包](http://cdn.jayh.club/blog/20200712/aE30LCn3xzXj.png?imageslim)

#### 6.3 解压 ik 分词器到容器中

-   如果没有安装 unzip 解压工具，则安装 unzip 解压工具。

```sh
apt install unzip
```

-   解压 ik 分词器到当前目录的 ik 文件夹下。

命令格式：unzip <ik 分词器压缩包>

实例：

``` sh
unzip ELK-IKv7.4.2.zip -d ./ik
```

![解压 ik 分词器](http://cdn.jayh.club/blog/20201007/nkVKAH22jB5a.png?imageslim)

-   修改文件夹权限为可读可写。

``` sh
chmod -R 777 ik/
```

-   删除 ik 分词器压缩包

``` sh
rm ELK-IKv7.4.2.zip
```

#### 6.4 检查 ik 分词器安装

-   进入到容器中

``` sh
docker exec -it <容器 id> /bin/bash
```

-   查看 Elasticsearch 的插件

``` sh
elasticsearch-plugin list
```

结果如下，说明 ik 分词器安装好了。是不是很简单。

``` sh
ik
```

![ik 分词器插件](http://cdn.jayh.club/blog/20201007/qf0NGUF7PBKo.png?imageslim)

然后退出 Elasticsearch 容器，并重启 Elasticsearch 容器

``` sh
exit
docker restart elasticsearch
```

#### 6.5 使用 ik 中文分词器

ik 分词器有两种模式

-   智能分词模式 ( ik_smart )

-   最大组合分词模式 ( ik_max_word )

我们先看下 ` 智能分词 ` 模式的效果。比如对于 ` 一颗小星星 ` 进行中文分词，得到的两个词语：` 一颗 `、` 小星星 `

我们在 Dev Tools Console 输入如下查询

``` json
POST _analyze
{
  "analyzer": "ik_smart",
  "text": "一颗小星星"
}
```

得到如下结果，被分词为 一颗和小星星。

![一颗小星星分词结果](http://cdn.jayh.club/blog/20201007/BGK3x4H9dY9F.png?imageslim)

再来看下 ` 最大组合分词模式 `。输入如下查询语句。

``` json
POST _analyze
{
  "analyzer": "ik_max_word",
  "text": "一颗小星星"
}
```

` 一颗小星星 ` 被分成了 6 个词语：一颗、一、颗、小星星、小星、星星。

![一颗小星星分词结果](http://cdn.jayh.club/blog/20201007/mEXbb8SfTjhB.png?imageslim)

我们再来看下另外一个中文分词。比如搜索悟空哥聊架构，期望结果：悟空哥、聊、架构三个词语。

实际结果：悟、空哥、聊、架构四个词语。ik 分词器将悟空哥分词了，认为 ` 空哥 ` 是一个词语。所以需要让 ik 分词器知道 ` 悟空哥 ` 是一个词语，不需要拆分。那怎么办做呢？

![悟空哥聊架构分词](http://cdn.jayh.club/blog/20201007/D3PCPzGSeR6g.png?imageslim)

#### 6.6 自定义分词词库

##### 6.6.1 自定义词库的方案

-   方案

  新建一个词库文件，然后在 ik 分词器的配置文件中指定分词词库文件的路径。可以指定本地路径，也可以指定远程服务器文件路径。这里我们使用远程服务器文件的方案，因为这种方案可以支持热更新 ( 更新服务器文件，ik 分词词库也会重新加载 ) 。

-   修改配置文件

ik 分词器的配置文件在容器中的路径：

``` sh
/usr/share/elasticsearch/plugins/ik/config/IKAnalyzer.cfg.xml。
```

修改这个文件可以通过修改映射文件，文件路径：

``` sh
/mydata/elasticsearch/plugins/ik/config/IKAnalyzer.cfg.xml
```

编辑配置文件：

``` sh
vim /mydata/elasticsearch/plugins/ik/config/IKAnalyzer.cfg.xml
```

配置文件内容如下所示：

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
<properties>
    <comment>IK Analyzer 扩展配置</comment>
    <!--用户可以在这里配置自己的扩展字典 -->
    <entry key="ext_dict">custom/mydict.dic;custom/single_word_low_freq.dic</entry>
     <!--用户可以在这里配置自己的扩展停止词字典-->
    <entry key="ext_stopwords">custom/ext_stopword.dic</entry>
     <!--用户可以在这里配置远程扩展字典 -->
    <entry key="remote_ext_dict">location</entry>
     <!--用户可以在这里配置远程扩展停止词字典-->
    <entry key="remote_ext_stopwords">http://xxx.com/xxx.dic</entry>
</properties>
```

修改配置 `remote_ext_dict` 的属性值，指定一个 远程网站文件的路径，比如 http://www.xxx.com/ikwords.text。

这里我们可以自己搭建一套 nginx 环境，然后把 ikwords.text 放到 nginx 根目录。

##### 6.6.2 搭建 nginx 环境

方案：首先获取 nginx 镜像，然后启动一个 nginx 容器，然后将 nginx 的配置文件拷贝到根目录，再删除原 nginx 容器，再用映射文件夹的方式来重新启动 nginx 容器。

-   通过 docker 容器安装 nginx 环境。

``` sh
docker run -p 80:80 --name nginx -d nginx:1.10
```

-   拷贝 nginx 容器的配置文件到 mydata 目录的 conf 文件夹

``` sh
cd /mydata
docker container cp nginx:/etc/nginx ./conf
```

-   mydata 目录 里面创建 nginx 目录

``` sh
mkdir nginx
```

-   移动 conf 文件夹到 nginx 映射文件夹

``` sh
mv conf nginx/
```

-   终止并删除原 nginx 容器

``` sh
docker stop nginx
docker rm <容器 id>
```

-   启动新的容器

```sh
docker run -p 80:80 --name nginx \
-v /mydata/nginx/html:/usr/share/nginx/html \
-v /mydata/nginx/logs:/var/log/nginx \
-v /mydata/nginx/conf:/etc/nginx \
-d nginx:1.10
```

-   访问 nginx 服务

``` sh
192.168.56.10
```

报 403 Forbidden, nginx/1.10.3 则表示 nginx 服务正常启动。403 异常的原因是 nginx 服务下没有文件。

-   nginx 目录新建一个 html 文件

``` sh
cd /mydata/nginx/html
vim index.html
hello passjava
```

-   再次访问 nginx 服务

  浏览器打印 hello passjava。说明访问 nginx 服务的页面没有问题。

-   创建 ik 分词词库文件

``` sh
cd /mydata/nginx/html
mkdir ik
cd ik
vim ik.txt
```

填写 ` 悟空哥 `，并保存文件。

-   访问词库文件

``` sh
http://192.168.56.10/ik/ik.txt
```

浏览器会输出一串乱码，可以先忽略乱码问题。说明词库文件可以访问到。

-   修改 ik 分词器配置

```sh
cd /mydata/elasticsearch/plugins/ik/config
vim IKAnalyzer.cfg.xml
```

![修改 ik 分词器配置](http://cdn.jayh.club/blog/20201008/G8VyYGe9wf9d.png?imageslim)

-   重启 elasticsearch 容器并设置每次重启机器后都启动 elasticsearch 容器。

``` sh
docker restart elasticsearch
docker update elasticsearch --restart=always
```

-   再次查询分词结果

可以看到 ` 悟空哥聊架构 ` 被拆分为 ` 悟空哥 `、` 聊 `、` 架构 ` 三个词语，说明自定义词库中的 ` 悟空哥 ` 有作用。

![自定义词库后的分词结果](http://cdn.jayh.club/blog/20201008/3g6L6SLJ0GVg.png?imageslim)

### 7. 写在最后
中篇和下篇继续肝，加油冲呀！
- 中篇： 实战 ES 应用。
- 下篇： ES 的集群部署。

我是悟空哥，努力变强，变身超级赛亚人！我们下期见！


# 八、压测调优篇

## 8.1 压测、性能监控、性能调优

![本文主要内容](https://img-blog.csdnimg.cn/img_convert/0ead02dc0f4529736802d962985ef0cd.png)

> 开源项目 PassJava 地址：https://github.com/Jackson0714/PassJava-Platform
>
> 本文已收录至：www.passjava.cn

### 1. 何为压力测试

#### 1.1、 大白话解释

- 性能压测是什么：就是考察当前`软件`和`硬件`环境下，系统所能承受的`最大负荷`，并帮助找出系统的`瓶颈`所在。

- 性能压测的目的：为了系统在线上的`处理能力`和`稳定性`维持在一个`标准范围`内，做到知己知彼，百战不殆。还可以发现内存泄漏、并发与同步的问题。

#### 1.2、性能指标

- RepsonseTime - RT：响应时间，用户从客户端发起一个请求开始计算，到客户端接收到服务端的响应结束，整个过程所耗费的时间。
- Hits Per Second - HPS：用户每秒点击次数，也就是每秒向后台发送的请求次数。
- QPS：系统每秒内处理查询的次数。
- MaxRT：最大响应时间，指用户发出请求到服务端返回响应的最大时间。
- MiniRT：最少响应时间，指用户发出请求到服务端返回响应的最少时间。
- 90%响应时间：将所有用户的响应时间进行升序排序，取 90 % 的位置。
- 性能测试关注点：
  - 吞吐量：每秒钟系统能处理的请求数、任务数。
  - 响应时间：服务处理一个请求或一个任务的耗时。
  - 错误率：一批请求中结果出过错的请求所占比例。

### 2. Jmeter 压测工具

#### 1、Jmeter 工具

- 下载和安装 Jmeter 工具

```bash
下载地址：https://jmeter.apache.org/download_jmeter.cgi
我下载的版本是 apache-jmeter-5.3
```

![](https://img-blog.csdnimg.cn/img_convert/8b33973211e6af588cea4d66427864ed.png)

- 运行 JMeter 程序

打开批处理文件：\apache-jmeter-5.3\bin\jmeter.bat

![](https://img-blog.csdnimg.cn/img_convert/9394eb8e9e21b096dd718aece354d155.png)

- 添加线程组

![添加线程组](https://img-blog.csdnimg.cn/img_convert/fcb5e7b525cf592cbbe2b061cced6914.png)

- 1s 内启动 200 个线程，循环次数 100 次。2w 个请求。

![](https://img-blog.csdnimg.cn/img_convert/343068fbe24af2f51949faa088efa800.png)

- 测试 HTTP 请求

![](https://img-blog.csdnimg.cn/img_convert/2fb320d0fefdfe8c72a9d629b69efc15.png)

配置要测试的协议、服务器地址、端口号

协议：http

服务器名称或 IP: www.baidu.com (只是为了演示)

端口号：80

![](https://img-blog.csdnimg.cn/img_convert/968761e1e6249c12cfca25af6f9e875f.png)

- 添加察看结果树、汇总报告和聚合报告

![](https://img-blog.csdnimg.cn/img_convert/fa8614816e1e6e04df6730796917c895.png)

- 开始压力测试

  点击播放按钮就开始启动了。注意启动之前需要先设置线程组的参数配置和 HTTP 请求的配置。

![](https://img-blog.csdnimg.cn/img_convert/244d6d62e872037e7ee3de8bb6d20c47.png)

- 查看每个请求结果

![](https://img-blog.csdnimg.cn/img_convert/dad8b755fee01265db1ea22e57db3fa2.png)

- 查看汇总报告

  主要关心平均值和吞吐量。

  200 个线程，每个线程调用 100 次，总共 2 w 次，可以看到下图中表格中的样本列也是 2 w，请求所耗费的时间是 151 ms，吞吐量是 880 个请求每秒。

![](https://img-blog.csdnimg.cn/img_convert/e630f82324d4be550eb4c4dc70b06f17.png)

- 查看聚合报告

主要看中位数和90%百分位，如下图所示，

**中位数**是 59 ms，说明大部分请求的响应时间是 59 ms。

**90 % 的请求** 都是在 271 ms 以内响应完成的。

**异常 0.41%** 说明 2 w 个请求中有 82 个请求异常（20000 * 0.0041 = 82 ）。

**吞吐量 880.2/sec** 说明百度这个网站每秒能处理 880 个请求。性能还算可以。

![](https://img-blog.csdnimg.cn/img_convert/5e5089d18ba60620c051fc945f01485c.png)

- 查看汇总图

查看汇总图时，需要先勾选想要查看的信息

![](https://img-blog.csdnimg.cn/img_convert/501784df9c1aba0599899c5a0535e3de.png)

然后查看图形汇总：

![](https://img-blog.csdnimg.cn/img_convert/cf6d85851b1984343598910d3e0a41c0.png)

可以看到勾选的几列在图表中是用不同颜色表示的，比如绿色的柱状条就是 90 % 百分位。



我们来测试下 佳必过的管理后台的性能，吞吐量接近 2000/s。

![](https://img-blog.csdnimg.cn/img_convert/308de4ba0b94a7f9667780c2e7797e3e.png)

### 3. 性能监控之 jconsole

jconsole 和 jvisualvm 是 Java JDK 的两个小工具，用来监控内存泄漏、跟踪垃圾回收、执行时的内存情况、对 CPU 进行分析、线程的分析。都可以通过命令行启动，而且可以监控本地和远程应用。而 jvisualvm 是升级版的 jconsole。我们先来看下 jconsole 的使用。

首先用 cmd 命令行的方式启动 jconsole。

#### 3.1 启动 jconsole

![命令行启动 jconsole](https://img-blog.csdnimg.cn/img_convert/4d2f4df5b6fea0d0625bf65e86489817.png)

#### 3.2 选择监控哪个应用

然后选择 passjava 项目的 question 服务。

![选择 passjava-question 微服务](https://img-blog.csdnimg.cn/img_convert/8475056b049e5d8a124472bd7255620b.png)

对应的就是下面这个微服务： passjava-question

![对应 passjava-question 微服务](https://img-blog.csdnimg.cn/img_convert/b6f719d9d74b2294bd2d36333a834f09.png)

#### 3.3 概览

从监控界面上有 6 个菜单，首先看到的是概览功能，上面有堆内存使用量、线程数、类的使用情况、CPU 占用率，都是用趋势图来表示的，能很方便的看出当前性能的概览。注意：这些监控都是实时的。

![概览](https://img-blog.csdnimg.cn/img_convert/d96c05f6fa49da0dcdf2e27ae9a929f8.png)

#### 3.4 内存

下面是内存的使用情况，可以从下图中看到有个下拉框，里面可以选择不同的内存维度，然后下面的图标和柱状图也会跟着选择的维度而展示不同。

![](https://img-blog.csdnimg.cn/img_convert/3779a386c80c7ff619a7d36731e87a70.png)

#### 3.5 线程

下面是线程的使用情况，可以看到线程峰值和活动线程的总数量，目前看到的峰值是59，活动线程数是 57。下半部分可以看到具体是哪些线程，以及线程的堆栈信息，非常详细。

![线程使用情况](https://img-blog.csdnimg.cn/img_convert/41add8f3062004f5bbfa0a9f85740f32.png)

#### 3.6 类

下面是类的加载和卸载情况，已加载类总数是 10679，而已卸载的类是 1 个，所以当前已加装当前类的总数是 10679 - 1 = 10678 个。

![类的加载和卸载情况](https://img-blog.csdnimg.cn/img_convert/f3a8d1b410a99abc32f473b41b7df05b.png)

#### 3.7 VM 概要

我们再来看下VM（虚拟机）的情况。如下图所示，可以看到虚拟机情况，线程、类、堆的概要信息，以及 VM 的参数，是不是很方便呀~

![VM 概要](https://img-blog.csdnimg.cn/img_convert/f3ecca538e4d0d613c76d9770e820e25.png)

#### 3.8 MBean 信息

接下来我们来看下 MBean 信息。对于 MBean，可能很多同学不知道是啥，下面做个解释：

MBean就是一种规范的JavaBean，通过集成和实现一套标准的Bean接口，这种叫MBean。MBean可以用来干嘛？就是可以有一套JDK级别的对外的服务接口。比如，你写了一个JVM允许状态辅助查询的Bean,你希望别人下载一个Jconsole就可以看到你写的杰作。那你就可以考虑用MBean规范来实现。很多垃圾收集器算法Bean就这么干的（说的就是这个类sun.management.MemoryImpl）。

![MBean 信息](https://img-blog.csdnimg.cn/img_convert/ac523e4d74a703c41ffba7b2d2d57bee.png)

### 4. 性能监控之 jvisualvm

jvisualvm 比 jconsole 更强大，界面展示的信息更丰富。

#### 4.1 启动 jvisualvm 和概述

启动方式和 jconsole 一样，也是通过 cmd 命令行启动。还是选择 passjava-question 微服务，然后选择第一个菜单栏：概述。可以看到 JVM 的版本，启动参数等信息。

![启动jvisualvm](https://img-blog.csdnimg.cn/img_convert/a187ba33454ebfc8ea6985805ea578b1.png)

#### 4.2 监视

监视 CPU、堆、类、线程的情况。整体显示的效果比 jconsole 更美观。

![监视](https://img-blog.csdnimg.cn/img_convert/06dde70962d0b051d50d05e88ac03854.png)

#### 4.3 线程

再来查下线程的情况。可以看到有 5 种状态的线程：

- 运行：正在运行的线程。
- 休眠：休眠状态的线程。
- 等待：等待执行的线程。
- 驻留：线程里面的空闲线程。
- 监视：阻塞的线程，正在等待锁。

![](https://img-blog.csdnimg.cn/img_convert/6c6041a687bfb735e305408bc0a8caaa.png)

#### 4.4 抽样器

另外我们也可以抽样器对 CPU 或内存进行抽样。如下图所示，对内存进行抽样。

![抽样](https://img-blog.csdnimg.cn/img_convert/5c793a79a47a6a0805a9f7127092ba88.png) 

#### 4.5 插件的使用

##### 4.5.1 安装Visual GC 插件

安装步骤：工具->插件->可用插件->Visual GC->安装。安装完成后，重启就可以使用插件功能了。

![](https://img-blog.csdnimg.cn/img_convert/00f53ce5f4c81d28222c0fcf6c2c8a53.png)

安装完成后，就可以看到

![Visual GC 插件](https://img-blog.csdnimg.cn/img_convert/f2ef239cd7fb7d75b82a77dfa9bc51fa.png)

下图是实时监控垃圾回收的情况。

![Visual GC](https://img-blog.csdnimg.cn/img_convert/0c5ad825560521e7abfcfc2a2bc0b2e0.png)

### 5. 对网关的性能测试

现在我想对 Passjava 系统的 question 微服务的接口进行一个压测，该如何进行呢？

首先我们来看下 passjava 的架构是怎么样的，如下图所示：

![](https://img-blog.csdnimg.cn/img_convert/25b921d7571d1060d55eb429206f4056.png)

客户端分为手机端和 PC 端，http 请求先经过 API Gateway，然后再转发到 question 微服务。其中涉及到了中间件：Gateway 网关。

我们来对 Gateway 网关进行压力测试。

网关的端口号是 8060，我们配置下 JMeter。如下图所示：

![](https://img-blog.csdnimg.cn/img_convert/3fb46db6fbb595828cc130e65f4695be.png)

配置每秒发送 200 个请求，一直循环执行，直到手动停止压测。如下图所示：

![](https://img-blog.csdnimg.cn/img_convert/a3ce15fcd12e71df4b4cb80ebc5b3a35.png)

可以看下执行结果，吞吐量在 2422 个每秒，还是比较高的。

吞吐量：2422/s 。

90% 响应时间：142 毫秒。

99% 响应时间：281 毫秒。

![](https://img-blog.csdnimg.cn/img_convert/1c71eae0ac70ff4dd1e8e76807bd1a77.png)

我们再来看看垃圾回收的情况，Eden 区垃圾回收用时 2.7 s，用时太长了吧，看看这里怎么能优化下。

通常的优化方向是增大新生代堆内存配置。

![](https://img-blog.csdnimg.cn/img_convert/6b5ff65b79ed67041846944e698deb3f.png)

### 6. 对微服务的性能测试

根据上面的架构原理图，我们知道客户端请求都是经过 Gateway 转发了一次的，如果我们想单独看下微服务的性能该怎么测试呢？下面我来演示下如何测试 passjava-question 微服务的性能。

首先需要在 passjava-question 微服务中添加一个测试方法：

![测试方法](https://img-blog.csdnimg.cn/img_convert/29cdc005a8e928b7c7ce7b7452568d9f.png)

有两种方式测试这个 api 是否添加正确。

第一种用 postman 测试下这个请求是否能正确响应，返回 “test” 则表示响应正确。

![test api 是否能正确响应](https://img-blog.csdnimg.cn/img_convert/fde60206467bfc8951ad6435e6b14a5c.png)

第二种通过浏览器进行测试。浏览器地址栏输入以下链接后，回车，看下浏览器窗口是否显示 “test”，是则表示响应正确。

然后我们需要用 Jmeter 压测工具来测试这个微服务下的 api 的性能究竟如何。

![单独压测微服务的 api的结果](https://img-blog.csdnimg.cn/img_convert/16f5eae40b8988c2730ddf5c97e2dedf.png)

吞吐量：3542/s 。

90% 响应时间：100 毫秒。

99% 响应时间：152 毫秒。

### 7. 对网关+微服务的性能测试

如果我们想对这个整个请求链路进行性能测试该怎么做？

首先请求需要先经过网关，然后由网关转发到微服务。在之前的文章中，我已经将网关配置好了，所以要想通过网关转发到 test 请求，只需要对请求路径稍作修改即可，如下所示：

```HTML
http://localhost:8060/api/question/v1/admin/question/test
```

然后在浏览器输入该网址，返回 “test” 即表示响应正确。

然后我们还是用 Jmeter 压测工具测试下 test api 的性能。测试结果如下图所示：

![网关+微服务的压力测试结果](https://img-blog.csdnimg.cn/img_convert/792c42af8583125e1e5b84013ab14469.png)

从结果可以看到：

吞吐量：982/s 。

90% 响应时间：437 毫秒。

99% 响应时间：790毫秒。

这里做个横向对比：

![横向对比](https://img-blog.csdnimg.cn/img_convert/43c2e652bee5ebd5ee5a509ec76a8644.png)

说明微服务 api 经过网关转发一次后，性能至少下降了一半。可以得出结果：中间件越多，性能损失越大，大部分损失都是网络交互导致的。可以通过增强网络通信质量来减少网络的延迟。

### 8. 对数据库查询进行优化

一般情况下，出现性能问题更多的是业务中查询数据库的耗时。接下来看下如何优化数据的查询。

下面是一个查询问题列表的 api：通过问题类型 type 字段过滤问题列表。api 路径如下：

```html
http://localhost:11000/question/v1/admin/question/list?type=5
```

这个 api 的代码如下，很容易看懂。

![查询问题列表的 api](https://img-blog.csdnimg.cn/img_convert/899a7637f378aa37de27f72d50ebe45c.png)

我们加些测试代码：统计查询数据库的耗时。如下所示：

![耗时统计](https://img-blog.csdnimg.cn/img_convert/18e11d292f3589bc68f0923f64af96cc.png)

然后重启 passjava-question 服务，再次测试这个 api，耗时 43 ms

![](https://img-blog.csdnimg.cn/img_convert/f4f49bbdbed6360495dbc33438cf6051.png)

怎么对查询进行优化呢？很容易想到加索引，我们来试下加在 question 表加索引后的效果。给 type 字段加上普通索引，如下图所示：

![添加索引](https://img-blog.csdnimg.cn/img_convert/9bc76b5870c0a3b8480f03ec61d72480.png)

我们再来看下加了索引后的耗时情况：耗时 18 ms，确实比之前的 43 ms 快了很多。

![加了索引后的情况](https://img-blog.csdnimg.cn/img_convert/d9f8d38ae103359594134e47da6dd9cd.png)

### 9. 优化垃圾回收

我们可以通过 jvisulavm工具查看垃圾回收的情况，Eden 区频繁发生 GC，短时间（1分钟）内共造成了 480 次 stop the world。另外从压测工具中也可以看到，吞吐量为 275/s。

原因是 Eden 区的内存分配得太小了，只有 32 M，我们来调大一点。

![32M Eden 区频繁进行垃圾回收](https://img-blog.csdnimg.cn/img_convert/7704b030fba57010fbeb91334621e14a.png)

#### 9.1 增大 Eden 区大小

通过在 IDEA 工具中配置以下参数，调整堆内存最大为 1024 M，新生代内存为 512 M。

```
-Xmx1024m -Xms1024m -Xmn512m
```

然后可以观察到在短时间（1分钟）内只进行了 92 次垃圾回收，说明垃圾回收的频率降低了。应用程序的性能也提升了。另外从压测工具中也可以看到，吞吐量为 347/s，吞吐量也有较大提升。

![](https://img-blog.csdnimg.cn/img_convert/86cbe05e08def8bbc92d30c9cf1c86e2.png)

### 10. 总结

本文通过压测工具 Jmeter 讲解压测如何实施，然后用性能监控工具 jconsole 和 jvisualvm 来监控 Java 应用程序的性能，以及如何用工具来优化开源项目 passjava 的性能，并且非常详细地介绍了每一步以及执行结果，通过对比的方式，更加清晰地知道如何做性能优化。

下面是对系统性能的常规优化手段：

- 中间件较多时，优化网络通信质量。

- 数据库查询耗时时，需要对查询进行优化，比如添加索引。
- 模板的渲染速度，可以通过设置模板缓存。
- 静态资源的获取，可以通过 Nginx 动静分离来解决。（下期再讲）
- 日志太多，需要减少不必要的打 log 操作。



巨人的肩膀：

https://blog.csdn.net/u010833547/article/details/92806510
https://www.bilibili.com/video/BV1np4y1C7Yf
https://github.com/Jackson0714/PassJava-Platform
www.passjava.cn

> **作者简介**：悟空，8年一线互联网开发和架构经验，用故事讲解分布式、架构设计、Java 核心技术。《JVM性能优化实战》专栏作者，开源了《Spring Cloud 实战 PassJava》项目，自主开发了一个 PMP 刷题小程序。