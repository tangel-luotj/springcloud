package com.tangel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 消费者80启动类
 */
@EnableEurekaServer
@SpringBootApplication
public class Application80 {

    public static void main(String[] args) {
        SpringApplication.run(Application80.class, args);
    }

}
