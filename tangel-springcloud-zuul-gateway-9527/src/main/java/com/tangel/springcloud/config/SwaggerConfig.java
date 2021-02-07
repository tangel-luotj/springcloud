package com.tangel.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author create by luotj
 * @Date: 2021/2/4 4:34 下午
 **/
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket creteRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(mApiInfo())
                .enable(true);
    }

    private ApiInfo mApiInfo() {
        return new ApiInfoBuilder()
                .title("测试玩意")
                .description("测试着玩呢")
                .contact(new Contact("tangel", "http://baidui.com", "949379865@qq.com"))
                .version("2.0")
                .build();
    }

}
