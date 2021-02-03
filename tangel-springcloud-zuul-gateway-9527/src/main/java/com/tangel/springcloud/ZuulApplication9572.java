package com.tangel.springcloud;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * 网关管理启动类
 *
 * @author create by luotj
 * @Date: 2021/1/29 6:12 下午
 **/
@EnableEurekaClient
@EnableSwagger2Doc
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication9572 {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication9572.class);
    }

    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }

}
