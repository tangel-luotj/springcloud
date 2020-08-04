package com.tangel.springcloud.service.impl;

import com.tangel.springcloud.dao.PaymentDao;
import com.tangel.springcloud.entities.Payment;
import com.tangel.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao mPaymentDao;

    @Override
    public int create(Payment payment){
        return mPaymentDao.create(payment);
    }

    @Override
    public Payment queryPaymentBy(Long id){
        return mPaymentDao.queryPaymentBy(id);
    }

}
