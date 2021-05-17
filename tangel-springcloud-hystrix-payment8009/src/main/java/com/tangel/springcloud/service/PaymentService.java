package com.tangel.springcloud.service;

/**
 * @author tangel
 * @date : 2021:05:05 14:58
 */
public interface PaymentService {

    String paymentOk(Long id);

    String paymentTimeout(Long id) throws Exception;

}
