# Spring Cloud实战项目-从理论到落地

# 一、PassJava 项目简介

- PassJava-Learning项目是PassJava（佳必过）项目的学习教程。对架构、业务、技术要点进行讲解。
- PassJava 是一款Java`面试刷题`的开源系统，可以用零碎时间利用小程序查看常见面试题，夯实Java基础。
- PassJava 项目可以教会你如何搭建SpringBoot项目，Spring Cloud项目
- 采用流行的技术，如 SpringBoot、MyBatis、Redis、 MySql、 MongoDB、 RabbitMQ、Elasticsearch，采用Docker容器化部署。

## 项目地址

* [后台平台]https://github.com/Jackson0714/PassJava-Platform
* [后台管理]https://github.com/Jackson0714/PassJava-Portal
* [学习教程]https://github.com/Jackson0714/PassJava-Learning

## 项目演示

- 后台管理系统

![添加题目管理菜单](http://cdn.jayh.club/uPic/image-2020091816532744149rB2M.png)

- 小程序

![mark](http://cdn.jayh.club/blog/20200405/ik8h4UItdnSA.jpg?imageslim)

![mark](http://cdn.jayh.club/blog/20200405/pjfJNfuiXVnF.gif)

## PassJava 中使用的技术

SpringBoot、MyBatis、Redis、 MySql、 MongoDB、 RabbitMQ、Elasticsearch

## PassJava实现的功能概览



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

> 由于PassJava项目涉及到很多知识点，希望大家先补下功课，推荐的书籍如下。

## 推荐资料

### IDEA

《IntelliJ-IDEA-Tutorial》：[https://github.com/judasn/IntelliJ-IDEA-Tutorial](https://github.com/judasn/IntelliJ-IDEA-Tutorial)

### Spring

《Spring实战（第4版）》：[https://book.douban.com/subject/26767354/](https://book.douban.com/subject/26767354/)

### SpringBoot

《Spring Boot实战》：[https://book.douban.com/subject/26857423/](https://book.douban.com/subject/26857423/)

### MyBatis

《MyBatis从入门到精通》：[https://book.douban.com/subject/27074809/](https://book.douban.com/subject/27074809/)

### MySql

《深入浅出MySQL》：[https://book.douban.com/subject/25817684/](https://book.douban.com/subject/25817684/)

### Linux

《循序渐进Linux（第2版）》：[https://book.douban.com/subject/26758194/](https://book.douban.com/subject/26758194/)

### Elasticsearch

《Elasticsearch 权威指南》：[https://www.elastic.co/guide/cn/elasticsearch/guide/current/index.html](https://www.elastic.co/guide/cn/elasticsearch/guide/current/index.html)

《Elasticsearch 技术解析与实战》：[https://book.douban.com/subject/26967826/](https://book.douban.com/subject/26967826/)

### Mongodb

《MongoDB实战(第二版)》：[https://book.douban.com/subject/27061123/](https://book.douban.com/subject/27061123/)

### Docker

《Spring Cloud与Docker微服务架构实战》：[https://book.douban.com/subject/27028228/](https://book.douban.com/subject/27028228/)

# 四、环境搭建篇

# Vagrant快速搭建Ubuntu虚拟机环境

## 1.开启虚拟机服务

Windows启动配置：Intel Virtualization Technology -> Enabled

## 2.下载安装VirtualBox 

VirtualBox：虚拟机管理软件

https://www.virtualbox.org/wiki/Downloads

## 3.下载安装Vagrant 

Vagrant：创建和管理虚拟机

Vagrant 软件：https://www.vagrantup.com/downloads.html

Vagrant 官方镜像：https://app.vagrantup.com/boxes/search

![mark](http://cdn.jayh.club/blog/20200407/Islf9HWK5dpm.png?imageslim)

- check是否安装好了vagrant

命令行输入 vagrant

```shell
vagrant
```

![mark](http://cdn.jayh.club/blog/20200407/RbGapilevUic.png?imageslim)

## 4.安装 vagrant ubuntu 国内镜像

```
# ubuntu 18.04 LTS:
vagrant box add https://mirrors.tuna.tsinghua.edu.cn/ubuntu-cloud-images/bionic/current/bionic-server-cloudimg-amd64-vagrant.box --name ubuntu18

# ubunt 16.04 LTS：
vagrant box add https://mirrors.tuna.tsinghua.edu.cn/ubuntu-cloud-images/xenial/current/xenial-server-cloudimg-amd64-vagrant.box --name ubuntu16

# ubuntu14：
vagrant box add https://mirrors.tuna.tsinghua.edu.cn/ubuntu-cloud-images/vagrant/trusty/current/trusty-server-cloudimg-amd64-vagrant-disk1.box --name ubuntu14
```

安装ubuntu 18

```shell
vagrant box add https://mirrors.tuna.tsinghua.edu.cn/ubuntu-cloud-images/bionic/current/bionic-server-cloudimg-amd64-vagrant.box --name ubuntu18
```

![mark](http://cdn.jayh.club/blog/20200407/g6qNmBtq4DdX.png?imageslim)

- 创建vagrant配置文件

```
vagrant init
```

- 打开C:\Users\Administrator\Vagrantfile文件

``` powershell
config.vm.box = "base" 修改为
config.vm.box = "ubuntu18"
```

## 5.启动虚拟机

``` shell
vagrant up
```

![mark](http://cdn.jayh.club/blog/20200407/F8SfLKFfJgph.png?imageslim)

![mark](http://cdn.jayh.club/blog/20200407/ToVOBfPMuFzV.png?imageslim)

## 6.连接虚拟机

```
vagrant ssh
```

![mark](http://cdn.jayh.club/blog/20200407/E9vL6MlHcEvf.png?imageslim)



## 7.配置密码登录

- 配置密码登录vagrant

```sh
Vagrant ssh进入系统之后
sudo su
编辑 sshd_config
vi /etc/ssh/sshd_config
PasswordAuthentication no 改为 PasswordAuthentication yes 
PermitRootLogin prohibit-password改为PermitRootLogin yes
重启服务
service sshd restart
```

- 安装XShell工具和XFTP工具

- XShell连接虚拟机

  账号：root

  密码：vagrant

- ![mark](http://cdn.jayh.club/blog/20200712/CVipwCrtRTaC.png?imageslim)

  

![连接成功](http://cdn.jayh.club/blog/20200712/L898uNJPtYmE.png?imageslim)









# 五、PassJava架构篇

# 六、PassJava业务篇

# 七、SpringBoot学习篇

