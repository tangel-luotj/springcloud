package com.tangel.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tangel
 * @date : 2021:05:01 01:37
 */
@Slf4j
@Component
public class MyLoadBalance implements LoadBalance {

    //存储当前服务请求次数
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndSet() {
        int current;
        int next;
        do {
            //获取当前请求次数
            current = this.atomicInteger.get();
            //请求次数 + 1
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        log.info("请求次数:{}", next);
        return next;
    }

    @Override
    public ServiceInstance getInstant(List<ServiceInstance> instances) {
        //获取服务下标
        int index = this.getAndSet() % instances.size();

        //返回服务
        return instances.get(index);
    }
}
