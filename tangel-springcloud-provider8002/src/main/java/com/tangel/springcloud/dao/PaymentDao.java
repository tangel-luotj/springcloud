package com.tangel.springcloud.dao;

import com.tangel.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment queryPaymentBy(@Param("id") Long id);

}
