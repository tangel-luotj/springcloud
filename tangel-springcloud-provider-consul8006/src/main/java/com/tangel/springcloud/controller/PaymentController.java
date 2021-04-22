package com.tangel.springcloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author tangel
 * @date : 2021:04:22 19:29
 */
@Api(tags = "01. 支付模块")
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @ApiOperation("consul")
    @GetMapping("/consul")
    public String create() {
        return "springcloud payment consul: server port: " + serverPort + ",random string: " + UUID.randomUUID().toString();
    }

}
