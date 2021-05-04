package com.tangel.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author tangel
 * @date : 2021:05:01 01:36
 */
public interface LoadBalance {

    ServiceInstance getInstant(List<ServiceInstance> instances);

}
