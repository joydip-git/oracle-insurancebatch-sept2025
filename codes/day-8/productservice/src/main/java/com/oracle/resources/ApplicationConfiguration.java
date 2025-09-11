package com.oracle.resources;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfiguration extends ResourceConfig {
    public ApplicationConfiguration() {
        this.register(new AppServiceBinder());
    }
}
