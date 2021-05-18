package com.tangel.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 回调逻辑
 * @author tangel
 * @date : 2021:05:18 14:30
 */
@Component
public class OrderHystrixServiceImpl implements OrderHystrixService {

    @Override
    public String paymentOk(Long id) {
        return "-----OrderHystrixServiceImpl fail fallback--paymentOk id=" + id;
    }

    @Override
    public String paymentTimeout(Long id) {
        return "-----OrderHystrixServiceImpl fail fallback--paymentTimeout id=" + id;
    }
}
