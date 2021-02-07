package com.tangel.springcloud.config;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;

/**
 * @author create by luotj
 * @Date: 2021/1/29 6:43 下午
 **/
@Primary
@Component
public class DocumentationConfig implements SwaggerResourcesProvider {

    @Autowired
    private DiscoveryClient mDiscoveryClient;
    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = Lists.newArrayList();
        mDiscoveryClient.getServices()
                .stream()
                .filter(it -> !it.equalsIgnoreCase(applicationName))
                .forEach(it -> {
                    resources.add(this.swaggerResource(it, "/" + it + "/v2/api-docs"));
                });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource resource = new SwaggerResource();
        resource.setLocation(location);
        resource.setName(name);
        resource.setSwaggerVersion("2.0");
        return resource;
    }

}
