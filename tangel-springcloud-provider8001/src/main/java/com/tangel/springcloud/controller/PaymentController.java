package com.tangel.springcloud.controller;

import com.tangel.springcloud.entities.Payment;
import com.tangel.springcloud.entities.PaymentResult;
import com.tangel.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Resource
    private PaymentService mPaymentService;

    //新增数据接口
    @PostMapping("/create")
    public PaymentResult create(@RequestBody Payment payment) {
        int result = mPaymentService.create(payment);
        if (result == 0) {
            PaymentResult paymentResult = new PaymentResult()
                    .setCode(400)
                    .setMessage("新增数据失败")
                    .setData(result);
            return paymentResult;
        } else {
            PaymentResult paymentResult = new PaymentResult()
                    .setCode(200)
                    .setMessage("新增数据成功")
                    .setData(result);
            return paymentResult;
        }
    }

    //请求获取数据
    @GetMapping("/query/{id}")
    public PaymentResult queryPaymentBy(@PathVariable Long id) {
         PaymentResult result = new PaymentResult()
                 .setCode(200)
                 .setMessage("请求数据成功111xxx")
                 .setData(mPaymentService.queryPaymentBy(id));
         return result;
    }


}
