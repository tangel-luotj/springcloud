package com.tangel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 提供者
 */
@EnableSwagger2
@EnableEurekaServer
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication8002.class, args);
    }

}
