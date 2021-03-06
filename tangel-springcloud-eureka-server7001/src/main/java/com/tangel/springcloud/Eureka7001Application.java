package com.tangel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka注册中心启动类
 *
 * @author create by luotj
 * @Date: 2021/1/28 11:07 上午
 **/
@EnableEurekaServer
@SpringBootApplication
public class Eureka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7001Application.class);
    }

}
