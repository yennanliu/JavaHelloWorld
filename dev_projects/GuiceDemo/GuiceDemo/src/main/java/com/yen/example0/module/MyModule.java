package com.yen.example0.module;

import com.google.inject.AbstractModule;
import com.yen.example0.service.MyInterface;
import com.yen.example0.service.impl.Implementation_A;

public class MyModule extends AbstractModule {

    /**
     * binding interface and implementation
     * <p>
     * https://jimwayne.blogspot.com/2015/09/guice-dependency-imjection.html
     */
    @Override
    protected void configure() {
        //super.configure();
        bind(MyInterface.class).to(Implementation_A.class);
    }

}
