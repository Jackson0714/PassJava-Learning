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



# 五、PassJava 架构篇

# 六、PassJava 业务篇

# 七、SpringBoot 学习篇

