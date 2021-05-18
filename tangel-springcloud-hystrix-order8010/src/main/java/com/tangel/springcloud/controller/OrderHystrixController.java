package com.tangel.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tangel.springcloud.service.OrderHystrixService;
import jdk.nashorn.internal.ir.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author tangel
 * @date : 2021:05:05 16:43
 */
@RestController
@RequestMapping("/api/order/hystrix")
@DefaultProperties(defaultFallback = "default_fallback")
public class OrderHystrixController {

    @Resource
    private OrderHystrixService mOrderHystrixService;

    @RequestMapping(value = "/ok/{id}", method = RequestMethod.GET)
    public String paymentOk(@PathVariable("id") Long id) {
        return mOrderHystrixService.paymentOk(id);
    }

    @RequestMapping(value = "/timeout/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "orderPayment_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentTimeout(@PathVariable("id") Long id) throws Exception {
        int sleepTime = 2;
        TimeUnit.SECONDS.sleep(sleepTime);
        return mOrderHystrixService.paymentTimeout(id);
    }

    @RequestMapping(value = "/timeout/error/{id}", method = RequestMethod.GET)
    @HystrixCommand
    public String paymentOrderErrorAndFallback(@PathVariable("id") Long id) {
        int i = 10 / 0;
        return mOrderHystrixService.paymentTimeout(id);
    }

    /**
     * @param id
     * @return
     */
    private String orderPayment_fallback(Long id) {
        return "客户端服务降级-消费者的配置优先于生产者服务端, id=" + id;
    }

    /**
     * 全局默认方法，当前方法不带参数
     * @return  响应数据
     */
    public String default_fallback() {
        return "客户端服务降级-全局默认降级方法";
    }
}
