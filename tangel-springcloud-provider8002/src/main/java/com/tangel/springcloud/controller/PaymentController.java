package com.tangel.springcloud.controller;

import com.tangel.springcloud.entities.Payment;
import com.tangel.springcloud.entities.PaymentResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.tangel.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Api(tags = "01. 支付模块")
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Resource
    private PaymentService mPaymentService;

    @Value("${server.port}")
    private String serverPort;

    //新增数据接口
    @ApiOperation("新增支付")
    @PostMapping("/create")
    public PaymentResult create(@RequestBody Payment payment) {
        int result = mPaymentService.create(payment);
        if (result == 0) {
            PaymentResult paymentResult = new PaymentResult()
                    .setCode(400)
                    .setMessage("新增数据失败,serverPort:" + serverPort)
                    .setData(result);
            return paymentResult;
        } else {
            PaymentResult paymentResult = new PaymentResult()
                    .setCode(200)
                    .setMessage("新增数据成功,serverPort:" + serverPort)
                    .setData(result);
            return paymentResult;
        }
    }

    //请求获取数据
    @ApiOperation("获取支付结果")
    @GetMapping("/query/{id}")
    public PaymentResult queryPaymentBy(@PathVariable Long id) {
        PaymentResult result = new PaymentResult()
                .setCode(200)
                .setMessage("请求数据成功111xxx,serverPort:" + serverPort)
                .setData(mPaymentService.queryPaymentBy(id));
        return result;
    }


}
