# springcloud 学习

####！<b>提供者服务</b>
######1、创建提供者子模块服务,tangel-springcloud-provider8001
######2、引入依赖相关依赖，可见pom.xml文件
######3、配置服务端口为8001,并完成在yml文件中做好相关数据库等配置
######4、书写dao、service、controller功能逻辑
######5、本实例访问接口
* 请求获取数据:http://localhost:8001/api/payment/query?id=1
* 新增数据接口:http://localhost:8001/api/payment/create?serial=xxxxx
######6、测试通过则完成提供者服务

####！<b>消费者服务</b>
######1、创建消费者子模块服务,tangel-springcloud-consumer80
######2、引入依赖相关依赖，可见pom.xml文件
######3、配置服务端口为80
######4、书写Bean,配置RestTemplate
######4、书写controller功能逻辑，根据RestTemplate请求提供者服务提供的接口
######5、本实例访问接口
* 请求获取数据:http://localhost/api/consumer/query/1
* 新增数据接口:http://localhost/api/consumer/create?serial=123456789
######6、测试通过则完成放消费者服务

####!  <b>公共服务</b>
#### 描述:整合服务之间公用的实体类、方法包等逻辑
######1、创建公共服务,cloud-api-commons
######2、修改pom.xml文件，引入需要的工具包
######3、服务tangel-springcloud-provider8001引入自定义的api通用包，可以使用Payment支付Entity（详见pom.xml文件）
######4、服务tangel-springcloud-consumer80引入自定义的api通用包，可以使用Payment支付Entity（详见pom.xml文件）
######5、服务直接调用api通用包中的PaymentResult和Payment实体

####!   <b>Eureka服务</b>
#### 描述:Eureka提供所有服务进行注册和被发现
######1、创建服务,cloud-eureka-server7001
######2、修改pom.xml文件，引入eureka依赖(org.springframework.cloud:spring-cloud-starter-netflix-eureka-server)
######3、新增修改yml文件,配置服务端口7001,并配置并配置eureka信息
######4、新增Eureka服务启动类（Eureka7001Application.class）
######5、为启动类增加注解(@EnableEurekaServer)开启服务
######6、启动项目
######7、访问路径（显示eureka控制台页面）:http://localhost:7001
######8、公共api服务，新增引入eureka依赖(org.springframework.cloud:spring-cloud-starter-netflix-eureka-server)
######9、服务tangel-springcloud-provider8001启动类注册入Eureka（@EnableEurekaServer）
######10、服务tangel-springcloud-provider8001启动类注册入Eureka（@EnableEurekaServer）