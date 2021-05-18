package com.tangel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author tangel
 * @date : 2021:05:05 14:56
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ApplicationHystrix8009 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationHystrix8009.class, args);
    }

}
