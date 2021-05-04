# com.tangel.springcloud 学习 - 难点整合

``` java
1、Eureka自我保护机制的理解：属于正常现象，即心跳检测检测当前服务是否不可用，不可用的情况下不会进行立刻清除（某时刻某一个微服务不可用了，Eureka不会立刻清理，依旧会对该微服务的信息进行保存）
```

#### 安装consul
   * 下载安装consul`https://www.consul.io/downloads`
   * 安装完成会有一个consul.exe的启动文件,启动完成之后在exe文件中输入命令`consul agent -dev`启动成功
   * 访问`http://localhost:8500/ui/dc1/services`地址可以看到启动后的consul图形化界面
 ```java
 consul 常用命令
  1、启动consul: consul agent -dev
  2、查看当前consul的版本号: consul --version
  3、查看节点信息: consul members
  4、查看节点详情信息: consul members -detailed
  5、关闭consul: consul leave
 ``` 
  
``` java
    rabbin负载均衡注意事项:
    1、配置rabbin算法自定义类不能放在@ComponentScan所扫描的当前报下以及子包下
       否则我们自定义的配置类就会被所有的ribbon客户端所共享，达不到特俗定制化的目的
    2、@消费者启动类种加上@RibbonClient()注解并替换为自定义的负载算法，有两个参数:
        name = "xxx",   example: name = "TANGEL-SPRINGCLOUD-PROVIDER", 参数必须和restTemplate请求的服务名称相同
        configuration = xxx.class   example: configuration = MySelfRule.class   参数配置获取自定义类文件
    3、轮训算法原理    请求次数的 % 服务提供者服务总数 = 余数(下标index)      
                      serivice.get(index)获取对应的服务，每次重启的时候重新开始计数获取下标
```