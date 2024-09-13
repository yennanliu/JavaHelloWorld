package com.yen.example2;

import com.google.inject.AbstractModule;
public class FoodModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Food.class).to(Meat.class); // Binding in a separate module
    }
}