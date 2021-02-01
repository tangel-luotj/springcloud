package com.tangel.springcloud.config;

import com.google.common.collect.Lists;
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
public class SwaggerConfig implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = Lists.newArrayList();
        resources.add(swaggerResource("tangel-springcloud-provider8001", "/api-a/v2/api-docs?userToken=123", "2.0"));
        resources.add(swaggerResource("app-service-b", "/api-b/v2/api-docs?userToken=123", "2.0"));
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
