package com.tangel.springlcloud.service;

import com.tangel.springcloud.entities.PaymentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author tangel
 * @date : 2021:05:05 01:00
 */
@Component
@FeignClient(value = "TANGEL-SPRINGCLOUD-PROVIDER")
public interface OrderFeignService {

    @GetMapping("/api/payment/query/{id}")
    PaymentResult queryPaymentBy(@PathVariable("id") Long id);

    @GetMapping("/api/payment/timeout/{id}")
    String paymentTimeout(@PathVariable("id") Long id);

}
