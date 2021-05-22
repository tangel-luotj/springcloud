package com.tangel.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

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

    /**
     * 开启dashboard需要添加当前注册bean完成对服务的初始化
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);

        registrationBean.setLoadOnStartup(1);
        //定义服务url映射如: http://localhost:8009/test.stream
        registrationBean.addUrlMappings("/test.stream");
        registrationBean.setName("HystreamMetricsStreamServlet");

        return registrationBean;
    }

}
