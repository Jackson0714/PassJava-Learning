# Ubuntu16.04安装最新版nodejs

##### 更新ubuntu软件源

```shell
sudo apt-get update
sudo apt-get install -y python-software-properties software-properties-common
sudo add-apt-repository ppa:chris-lea/node.js
sudo apt-get update
```

##### 安装nodejs

```shell
sudo apt-get install nodejs
sudo apt install nodejs-legacy
sudo apt install npm
```

##### 更新npm的包镜像源，方便快速下载

```shell
sudo npm config set registry https://registry.npm.taobao.org
sudo npm config list
```

##### 全局安装n管理器(用于管理nodejs版本)

```
sudo npm install n -g
```

##### 安装最新的nodejs（stable版本）

```shell
sudo n stable
sudo node -v
```
