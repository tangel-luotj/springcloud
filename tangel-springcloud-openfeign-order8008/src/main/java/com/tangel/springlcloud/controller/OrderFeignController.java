package com.tangel.springlcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.tangel.springcloud.entities.PaymentResult;
import com.tangel.springlcloud.service.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tangel
 * @date : 2021:05:05 01:04
 */
@RestController
public class OrderFeignController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private OrderFeignService mOrderFeignService;

    @GetMapping("/api/query/{id}")
    public PaymentResult queryPaymentBy(@PathVariable Long id) {
        return mOrderFeignService.queryPaymentBy(id);
    }

    @GetMapping("/api/timeout/payment/{id}")
    public String paymentTimeout(@PathVariable Long id) {
        //默认Feign调用等待1秒钟，超过1秒则超时报错
        return mOrderFeignService.paymentTimeout(id);
    }

}
