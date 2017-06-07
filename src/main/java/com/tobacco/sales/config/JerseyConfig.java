package com.tobacco.sales.config;

import com.tobacco.sales.ws.OrderResource;
import com.tobacco.sales.ws.TobaccoResource;
import com.tobacco.sales.ws.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/ws")
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(UserResource.class);
        register(TobaccoResource.class);
        register(OrderResource.class);
    }

}
