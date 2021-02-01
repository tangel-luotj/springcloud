package com.tangel.springcloud;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 提供者
 */
@EnableSwagger2Doc
@EnableEurekaServer
@SpringBootApplication
public class Application8001 {

    public static void main(String[] args) {
        SpringApplication.run(Application8001.class, args);
    }

}
