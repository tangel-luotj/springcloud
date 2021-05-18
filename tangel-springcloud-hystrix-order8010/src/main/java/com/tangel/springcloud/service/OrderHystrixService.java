package com.tangel.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tangel
 * @date : 2021:05:05 16:43
 */
@Service
@FeignClient(value = "TANGEL-SPRINGCLOUD-HYSTRIX", fallback = OrderHystrixServiceImpl.class)
public interface OrderHystrixService {

    @RequestMapping(value = "/api/hystrix/ok/{id}", method = RequestMethod.GET)
    String paymentOk(@PathVariable("id") Long id);

    @RequestMapping(value = "/api/hystrix/timeout/{id}", method = RequestMethod.GET)
    String paymentTimeout(@PathVariable("id") Long id);

}
