package com.yen.module;

import com.google.inject.AbstractModule;
import com.yen.service.MyInterface;
import com.yen.service.impl.Implementation_A;

public class MyModule extends AbstractModule {

    /**
     * binding interface and implementation
     *
     *  https://jimwayne.blogspot.com/2015/09/guice-dependency-imjection.html
     */
    @Override
    protected void configure() {
        //super.configure();
        bind(MyInterface.class).to(Implementation_A.class);
    }

}
