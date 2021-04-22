package com.tangel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author create by luotj
 * @Date: 2021/2/3 2:25 下午
 **/
@EnableEurekaServer
@SpringBootApplication
public class Eureka7003Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7003Application.class);
    }

}
