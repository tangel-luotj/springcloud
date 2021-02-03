package com.tanlgel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author create by luotj
 * @Date: 2021/2/3 2:24 下午
 **/
@EnableEurekaServer
@SpringBootApplication
public class Eureka7002Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7002Application.class);
    }

}
