package com.yen.example1;

import com.google.inject.AbstractModule;
import com.google.inject.Module;

// https://google.github.io/guice/api-docs/3.0/javadoc/com/google/inject/AbstractModule.html
public class AnimalModule extends AbstractModule {
    @Override
    protected void configure() {
        //super.configure();
        bind(Animal.class).to(Dog.class);
    }

//    @Override
//    protected void install(Module module) {
//        //super.install(module);
//        //bind(Animal.class).to(Dog.class);
//    }
    
}
