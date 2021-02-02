package com.tangel.springcloud.config;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author create by luotj
 * @Date: 2021/1/29 6:43 下午
 **/
@EnableSwagger2
@Primary
@Component
public class SwaggerConfig implements SwaggerResourcesProvider {

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
                    resources.add(this.swaggerResource(it, "/" + it + "/v2/api-docs", "2.0"));
                });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource resource = new SwaggerResource();
        resource.setLocation(location);
        resource.setName(name);
        resource.setSwaggerVersion(version);
        return resource;
    }

}
