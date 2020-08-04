package com.tangel.springcloud.controller;

import com.tangel.springcloud.entities.Payment;
import com.tangel.springcloud.entities.PaymentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderConsumerController {

    private final static String PROVIDER_URL = "http://localhost:8001";


    @Autowired
    private RestTemplate template;

    //获取支付数据
    @GetMapping("/api/consumer/query/{id}")
    public PaymentResult queryPaymentInfoBy(@PathVariable Long id){
        return template.getForObject(PROVIDER_URL + "/api/payment/query/" + id, PaymentResult.class);
    }

    //新增支付数据
    @GetMapping("/api/consumer/create")
    public PaymentResult createPaymentInfo(Payment payment){
        return template.postForObject(PROVIDER_URL + "/api/payment/create", payment, PaymentResult.class);
    }


}
