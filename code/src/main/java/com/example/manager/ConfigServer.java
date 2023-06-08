package com.example.manager;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("restservices")
public class ConfigServer extends ResourceConfig{
    public ConfigServer(){
        packages("com.example.webservices", "com.example.manager", "com.example.listner");
        register(RolesAllowedDynamicFeature.class);

    }
}
