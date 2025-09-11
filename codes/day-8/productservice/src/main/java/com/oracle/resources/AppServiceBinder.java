package com.oracle.resources;
import org.glassfish.hk2.api.JustInTimeInjectionResolver;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import jakarta.ws.rs.ext.Provider;

@Provider
public class AppServiceBinder extends AbstractBinder {

    @Override
    protected void configure() {
        // bind(Repository.class).to(new TypeLiteral<RepositoryContract>() {
        // });
        this.bind(JustInTimeServiceResolver.class)
                .to(JustInTimeInjectionResolver.class);
    }

}
