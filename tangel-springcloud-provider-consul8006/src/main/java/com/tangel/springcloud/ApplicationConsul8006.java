package com.tangel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationConsul8006 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsul8006.class);
    }

}
