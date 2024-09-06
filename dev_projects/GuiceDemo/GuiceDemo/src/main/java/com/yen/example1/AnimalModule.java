package com.yen.example1;

import com.google.inject.AbstractModule;

public class AnimalModule extends AbstractModule {
    @Override
    protected void configure() {
        //super.configure();
        bind(Animal.class).to(Dog.class);
    }
}
