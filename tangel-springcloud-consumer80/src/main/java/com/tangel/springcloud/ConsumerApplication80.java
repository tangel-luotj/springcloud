package com.tangel.springcloud;

import cn.hutool.json.JSONObject;
import com.tangel.ribbonrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 消费者80启动类
 */
@EnableSwagger2
@EnableEurekaServer
@SpringBootApplication
//@RibbonClient(name = "TANGEL-SPRINGCLOUD-PROVIDER", configuration = MySelfRule.class)
public class ConsumerApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication80.class, args);
    }

}
