package com.tangel.springcloud.controller;

import com.tangel.springcloud.entities.Payment;
import com.tangel.springcloud.entities.PaymentResult;
import com.tangel.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Api(tags = "01. 支付模块")
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Resource
    private PaymentService mPaymentService;
    @Resource
    private DiscoveryClient discoveryClient;

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

    @ApiOperation("服务发现")
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(it -> {
            log.info("element:{}", it);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("TANGEL-SPRINGCLOUD-PROVIDER");
        instances.forEach(it ->{
            log.info("host:{}, instantId:{}, port:{}", it.getHost(), it.getInstanceId(), it.getPort());
        });
        return this.discoveryClient;
    }

    @ApiOperation("测试负载均衡")
    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/timeout/{id}")
    public String paymentTimeout(@PathVariable Long id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return serverPort;
    }

}
