# Spring Cloud 实战项目 - 从理论到落地

# 一、PassJava 项目简介

- PassJava-Learning 项目是 PassJava（佳必过）项目的学习教程。对架构、业务、技术要点进行讲解。
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

![mark](../../../../../01_Project/10_SCRM/wh/knowledge/database/elasticsearch/images/using_es/7QiFgCOVD0OC.png)

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

![mark](../../../../../01_Project/10_SCRM/wh/knowledge/database/elasticsearch/images/using_es/3edTHcpOsU46.png)

- 查看docker容器

  mysql容器已启动

![mark](../../../../../01_Project/10_SCRM/wh/knowledge/database/elasticsearch/images/using_es/99jqOmq2tshz.png)

### 4.连接数据库

- 用Workbench连接数据库

![mark](../../../../../01_Project/10_SCRM/wh/knowledge/database/elasticsearch/images/using_es/vj81LmpK9zEn.png)

- 查看数据库

![mark](../../../../../01_Project/10_SCRM/wh/knowledge/database/elasticsearch/images/using_es/hkkUN9VUCNR4.png)

### 5.进入mysql 容器

``` sh
sudo docker exec -it mysql /bin/bash
```

![mark](../../../../../01_Project/10_SCRM/wh/knowledge/database/elasticsearch/images/using_es/ruh1ghIj40QA.png)

### 6.查看虚拟机映射文件

``` sh
cd /mydata/mysql
ls
```

![mark](../../../../../01_Project/10_SCRM/wh/knowledge/database/elasticsearch/images/using_es/wzdOsRaOi2D8.png)

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

## 5.2 初始化数据库和表

## 5.3 搭建管理后台

## 5.4 自动生成前后端代码

## 5.5 整合MyBatis-Plus实现CRUD

## 5.6 生成所有微服务的CRUD代码

## 5.7 管理后台-题目类型功能

# 六、PassJava 高级实践篇

## 6.1 Spring Cloud Alibaba 组件简介

## 6.2 SpringCloud整合Alibaba-Nacos注册中心

## 6.3 SpringCloud整合Alibaba-Nacos配置中心

## 6.4 SpringCloud整合Gateway网关

## 6.5 整合OSS对象存储

## 6.6 整合统一异常处理


# 七、中间件进阶篇

## 7.1 Elasticsearch上篇（原理）
