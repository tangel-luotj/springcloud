package com.tangel.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tangel
 * @date : 2021:05:05 16:41
 */
@SpringBootApplication
@EnableFeignClients
public class HystrixOrderApplication8010 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderApplication8010.class, args);
    }
}
