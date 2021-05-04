package com.tangel.springlcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;

/**
 * @author tangel
 * @date : 2021:05:05 01:51
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
//        return Logger.Level.NONE;         //  默认不显示日志
//        return Logger.Level.BASIC;        //  仅记录请求方法，url、响应状态码及执行时间
//        return Logger.Level.HEADERS;      //  除Basic中定义的信息外，还有请求和响应的头信息
        return Logger.Level.FULL;           //  除Headers中定义的信息外，还有请求和响应的正文及元数据
    }

}
