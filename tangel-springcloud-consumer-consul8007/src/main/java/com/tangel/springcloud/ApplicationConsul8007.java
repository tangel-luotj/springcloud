package com.tangel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tangel
 * @date : 2021:04:22 21:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationConsul8007 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsul8007.class);
    }

}
