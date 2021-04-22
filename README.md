# com.tangel.springcloud 学习 - 难点整合

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