package com.tangel.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * 负载均衡注解: 默认是轮训算法
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
