# Spring Cloud 实战项目 - 从理论到落地

## 公众号：悟空聊架构

![公众号](http://cdn.jayh.club/blog/20200910/8cQn6wSJtQND.png?imageslim)

## 加我好友

![加我好友](http://cdn.jayh.club/blog/20210318/1vj9qu7DUYej.png?imageslim)

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




