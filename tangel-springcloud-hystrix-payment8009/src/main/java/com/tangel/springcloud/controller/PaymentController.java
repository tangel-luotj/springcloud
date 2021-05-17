package com.tangel.springcloud.controller;

import com.tangel.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
