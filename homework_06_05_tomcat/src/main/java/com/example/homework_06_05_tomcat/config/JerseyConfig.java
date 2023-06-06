package com.example.homework_06_05_tomcat.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        packages("com.example.homework_06_05_tomcat.controller.REST");
    }
}
