package com.tangel.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
        return "线程名:" + Thread.currentThread().getName() + " !id =" + id + "!!! 端口号:" + serverPort + "-- 哈哈 ok";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeout_fallback",     //设置兜底方法
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")     //线程超时-毫秒
            })
    @Override
    public String paymentTimeout(Long id) throws Exception {
//        int sleepTime = 5;
//        TimeUnit.SECONDS.sleep(sleepTime);
//        return "线程名:" + Thread.currentThread().getName() + " !id =" + id + "!!! 端口号:" + serverPort + "-- 失败啦:延迟时间:" + sleepTime + "秒";
        int i = 10 / 0;
        return "线程名:" + Thread.currentThread().getName() + " !id =" + id + "!!! 端口号:" + serverPort + "-- 失败啦";
    }

    /**
     * 服务超时/服务错误调用兜底方法
     *
     * @param id 参数-与原方法的参数类型一致
     * @return 兜底返回结果
     */
    public String paymentTimeout_fallback(Long id) {
        return "线程名:" + Thread.currentThread().getName() + " !id =" + id + "!!! 端口号:" + serverPort + "-- 服务器忙,请稍后再试";
    }
}
