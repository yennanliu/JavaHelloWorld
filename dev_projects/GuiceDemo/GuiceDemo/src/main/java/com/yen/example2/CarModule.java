package com.yen.example2;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.yen.example1.AnimalModule;

public class CarModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Car.class).to(Honda.class); // Binding within the module
    }

    @Override
    protected void install(Module module) {
        System.out.println(">>> start install module !!!");
        //super.install(module);
        install(new FoodModule());
    }
}
