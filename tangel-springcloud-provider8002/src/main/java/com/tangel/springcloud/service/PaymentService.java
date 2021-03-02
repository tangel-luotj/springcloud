package com.tangel.springcloud.service;

import com.tangel.springcloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment queryPaymentBy(Long id);

}
