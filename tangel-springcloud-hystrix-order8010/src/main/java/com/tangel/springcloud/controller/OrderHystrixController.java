package com.tangel.springcloud.controller;

import com.netflix.discovery.converters.Auto;
import com.tangel.springcloud.service.OrderHystrixService;
import jdk.nashorn.internal.ir.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tangel
 * @date : 2021:05:05 16:43
 */
@RestController
@RequestMapping("/api/order/hystrix")
public class OrderHystrixController {

    @Resource
    private OrderHystrixService mOrderHystrixService;

    @RequestMapping(value = "/ok/{id}", method = RequestMethod.GET)
    public String paymentOk(@PathVariable("id") Long id){
        return mOrderHystrixService.paymentOk(id);
    }

    @RequestMapping(value = "/timeout/{id}", method = RequestMethod.GET)
    public String paymentTimeout(@PathVariable("id") Long id) {
        return mOrderHystrixService.paymentTimeout(id);
    }
}
