- Redis是基于C语言编写的，所有安装Redis之前需要gcc依赖               

  ```cmd
  yum install -y gcc tcl
  ```

  把安装包放入 usr目录，下载好的安装包直接拖入即可             

  ```cmd
      cd /usr
  ```

  解压                                                                  

  ```cmd
   tar -zxvf redis-7.0.12.tar.gz
  ```

  进入redis7.0.12                                           
  
  ```cmd
  cd redis-7.0.12
  ```
  
  使用make 命令进行编译将.c文件编译成.o文件                          
  
  ```cmd
   make
  ```
  
  编译成功之后会出现“It's a good idea to run 'make test'”的提示
  
  ![image-20230719170524352](http://cdn.jayh.club/uPic/image-20230719170524352z0MdFj.png)
  
  使用命令 进行安装                                                            
  
  ```cmd
  make PREFIX=/usr/local/redis install
  ```
  
  
  
  ![image-20230719170534030](http://cdn.jayh.club/uPic/image-20230719170534030CmDU1k.png)
  
  安装完后，在/usr/local/redis/bin下有几个可执行文件可以查看               
  
  ```xml
   ll /usr/local/redis/bin
  ```
  
  
  
  ![image-20230719170539158](http://cdn.jayh.club/uPic/image-20230719170539158yBxBzr.png)
  
  
  
  ## Redis启动需要一个配置文件，可以修改端口号等信息**

安装目录下将redis.conf文件拷贝到/usr/local/redis目录中           

```cmd
cp redis.conf /usr/local/redis
```

进入  /usr/local/redis                                    

```cmd
cd /usr/local/redis
```

修改配置文件redis.conf                                  

```cmd
vim redis.conf
```

   

```xml
  将bind 127.0.0.1 -::1 替换为 bind 0.0.0.0                   
  将 daemonize on 替换成 daemonize yes 
  requirepass xxxx  设置密码
  将protected-mode yes 改为no            
  日志logfile   “./redis.log”      
    masterauth xxxx  <设置密码>
```

   

```xml
注意：从服务器把修改replicaof <主服务器ip  端口>             ----------------**主服务器不用配**
```

保存                                                  

```cmd
：wq
```

加权限                                                   

```cmd
 chmod 777 redis.conf
```

使用bin/redis-server ./redis.conf启动redis服务          

```cmd
./bin/redis-server ./redis.conf
```

使用命令ps -ef|grep redis查看已经启动的redis服务关闭redis服务     ps -ef|grep redis

![image-20230719170603498](http://cdn.jayh.club/uPic/image-202307191706034987Eyitm.png)

使用./bin/redis-cli 命令进入到redis的客户端                        

```cmd
./bin/redis-cli
```

测试安装是否成功

![image-20230719170610152](http://cdn.jayh.club/uPic/image-20230719170610152gpO2NU.png)

修改/usr/redis-7.0.12/sentinel.conf中的配置

哨兵配置

```cmd
#护模式关闭，这样其他服务起就可以访问此台redis
protected-mode no

#端口
port 26379

# 哨兵模式是否后台启动，默认no，改为yes
daemonize yes

pidfile "/var/run/redis-sentinel.pid"

# log日志保存位置
logfile  "/usr/local/redis/sentinel/redis-sentinel.log"

# 工作目录
dir "/usr/redis-7.0.12"

# master主机ip地址 
sentinel monitor mymaster <主服务器机ip> 6379 2

# master中redis的密码

sentinel auth-pass mymaster XXXX

# 哨兵从master节点宕机后，等待多少时间（毫秒），认定master不可用。默认30s
sentinel down-after-milliseconds mymaster 30000

#如果报错注释掉 acllog-max-len 128
acllog-max-len 128


# 当替换主节点后，剩余从节点重新和新master做同步的并行数量，默认为 1
sentinel parallel-syncs mymaster 1


# 主备切换的时间，若在3分钟内没有切换成功，换另一个从节点切换
sentinel failover-timeout mymaster 180000


#如果报错注释掉下面内容根据情况注释
sentinel deny-scripts-reconfig yes

SENTINEL resolve-hostnames no

SENTINEL announce-hostnames no

SENTINEL master-reboot-down-after-period mymaster 0
```

创建日志文件夹

```cmd
cd  /usr/local/redis   

mkdir sentinel
```

启动所有哨兵

```cmd
cd /usr/local/redis/bin/

./redis-sentinel /usr/redis-7.0.12/sentinel.conf
```

哨兵日志

```cmd
cd /usr/local/redis/sentinel/

tail -100f redis-sentinel.log

```

![image-20230719170616509](http://cdn.jayh.club/uPic/image-20230719170616509tGq1KF.png)

启动命令合集

```cmd
#redis启动
cd /usr/local/redis
./bin/redis-server ./redis.conf

#哨兵启动
cd /usr/local/redis/bin/
./redis-sentinel /usr/redis-7.0.12/sentinel.conf

#redis客户端登录
cd /usr/local/redis
./bin/redis-cli

#redis 哨兵日志
cd /usr/local/redis/sentinel/
tail -100f redis-sentinel.log

#redis日志
cd /usr/local/redis
tail -100f redis
```

​                                                                                                    