package com.tangel.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tangel
 * @date : 2021:04:22 21:07
 */
@RestController
@Slf4j
@RequestMapping("/api/order")
public class OrderConsulController {

    public static final String Invoke_Url = "http://tangel-springcloud-consul-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("payment")
    public String paymentInfo() {
        String result = restTemplate.getForObject(Invoke_Url + "/api/payment/consul", String.class);
        return result;
    }

}
