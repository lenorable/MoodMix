package com.example.manager;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("restservices")
public class config extends ResourceConfig{
    public config(){
        packages("com.example.webservices", "com.example.manager", "com.example.listner");
        register(RolesAllowedDynamicFeature.class);

    }
}
