package com.tangel.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author tangel
 * @date : 2021:05:05 14:58
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String paymentOk(Long id) {
        return "线程名:" + Thread.currentThread().getName() + " !id ="+ id +"!!! 端口号:" + serverPort + "-- 哈哈 ok";
    }

    @Override
    public String paymentTimeout(Long id) throws Exception {
        int sleepTime = 5;
        TimeUnit.SECONDS.sleep(sleepTime);
        return "线程名:" + Thread.currentThread().getName() + " !id ="+ id +"!!! 端口号:" + serverPort + "-- 失败啦:延迟时间:" + sleepTime + "秒";
    }
}
