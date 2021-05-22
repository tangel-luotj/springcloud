package com.tangel.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tangel.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author tangel
 * @date : 2021:05:05 14:59
 */
@RestController
@RequestMapping("/api/hystrix")
public class PaymentController {

    @Autowired
    private PaymentService mPaymentService;

    @RequestMapping(value = "/ok/{id}", method = RequestMethod.GET)
    public String paymentOk(@PathVariable("id") Long id) {
        return mPaymentService.paymentOk(id);
    }

    @RequestMapping(value = "/timeout/{id}", method = RequestMethod.GET)
    public String paymentTimeout(@PathVariable("id") Long id) throws Exception {
        return mPaymentService.paymentTimeout(id);
    }

    /**
     * 断路器相关配置参数name可以参考配置文件HystrixCommandProperties.class
     * @see com.netflix.hystrix.HystrixCommandProperties
     */
    @RequestMapping(value = "/hystrix-circuit/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "circuit_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                      //是否开启链路器，默认false
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),         //请求次数次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")        //失败率达到设定值后跳闸
    })
    public String paymentCircuit(@PathVariable("id") Long id) {
        if (id < 0) {
            throw new RuntimeException("ID不能为负数");
        }
        return "当前线程名为 " + Thread.currentThread().getName() + "id = " + id + "随机字符串为:" + UUID.randomUUID().toString();
    }

    public String circuit_fallback(Long id) {
        return "链路调用失败~~~~呜呜呜呜呜";
    }

}
