package com.tangel.springcloud.controller;

import com.tangel.springcloud.entities.Payment;
import com.tangel.springcloud.entities.PaymentResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Api(tags = "01. 支付(消费者)")
@RestController
public class OrderConsumerController {

    private final static String PROVIDER_URL = "http://TANGEL-SPRINGCLOUD-PROVIDER";

    @Autowired
    private RestTemplate template;

    //获取支付数据
    @ApiOperation("获取订单数据")
    @GetMapping("/api/consumer/query/{id}")
    public PaymentResult queryPaymentInfoBy(@PathVariable Long id) {
        return template.getForObject(PROVIDER_URL + "/api/payment/query/" + id, PaymentResult.class);
    }

    //新增支付数据
    @ApiOperation("新增订单")
    @GetMapping("/api/consumer/create")
    public PaymentResult createPaymentInfo(Payment payment) {
        return template.postForObject(PROVIDER_URL + "/api/payment/create", payment, PaymentResult.class);
    }


}
