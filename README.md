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
