package com.tangel.springlcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tangel
 * @date : 2021:05:05 00:59
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignApplication8008 {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication8008.class, args);
    }

}
