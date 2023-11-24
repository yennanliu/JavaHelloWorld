package com.yen.config;

// https://www.javachinna.com/jersey-rest-crud-api/

import com.yen.controller.ProductController;
import com.yen.repository.ProductRepository;
import com.yen.service.ProductService;
import com.yen.service.impl.ProductServiceImpl;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class AppConfig extends ResourceConfig {

    // constructor
    public AppConfig(){
        register(ProductController.class);
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(ProductServiceImpl.class).to(ProductService.class);
                bind(ProductRepository.class).to(ProductRepository.class);
            }
        });

        // send validation error to client ??? // TODO : check
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }

}
