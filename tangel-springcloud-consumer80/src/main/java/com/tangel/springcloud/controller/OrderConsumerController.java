package com.tangel.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.tangel.springcloud.entities.Payment;
import com.tangel.springcloud.entities.PaymentResult;
import com.tangel.springcloud.lb.LoadBalance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Api(tags = "01. 支付(消费者)")
@RestController
public class OrderConsumerController {

    private final static String PROVIDER_URL = "http://TANGEL-SPRINGCLOUD-PROVIDER";

    @Autowired
    private RestTemplate template;

    @Autowired
    private LoadBalance mLoadBalance;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @ApiOperation("获取订单数据(根据entity方式请求接口)")
    @GetMapping("/api/cousumer/query/entity/{id}")
    public PaymentResult queryPaymenyInfoByEntity(
            @PathVariable
            @ApiParam(value = "订单Id", required = true, example = "1") Long id) {
        ResponseEntity<PaymentResult> entity =
                template.getForEntity(PROVIDER_URL + "/api/payment/query/" + id, PaymentResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            //成功请求接口
            return entity.getBody();
        } else {
            return new PaymentResult().setMessage("请求失败").setCode(444).setData(null);
        }
    }

    //新增支付数据
    @ApiOperation("新增订单(根据entity方式请求接口)")
    @GetMapping("/api/consumer/create/entity")
    public PaymentResult createPaymentInfoByEntity(Payment payment) {
        ResponseEntity<PaymentResult> entity =
                template.postForEntity(PROVIDER_URL + "/api/payment/create", payment, PaymentResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new PaymentResult().setCode(444).setMessage("请求失败").setData(null);
        }
    }

    @ApiOperation("测试自定义手写负载均衡")
    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances =
                discoveryClient.getInstances("TANGEL-SPRINGCLOUD-PROVIDER");

        if (instances == null || instances.size() == 0) {
            return null;
        }

        ServiceInstance serviceInstance = mLoadBalance.getInstant(instances);

        URI uri = serviceInstance.getUri();
        return template.getForObject(uri + "/payment/lb", String.class);
    }

}
