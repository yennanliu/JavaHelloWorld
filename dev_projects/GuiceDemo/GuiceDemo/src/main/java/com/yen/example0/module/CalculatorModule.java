package com.yen.example0.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.yen.example0.service.Calculator;
import com.yen.example0.service.impl.Implementation_A;

// https://youtu.be/fe1n8VIXZ-k?si=LrKQXWec3aGJfCA_&t=271

public class CalculatorModule extends AbstractModule {
    @Override
    protected void configure() {
        // super.configure();

        /**
         *  NOTE !!!
         *
         *   when setup interface,
         *   we need to bind interface to its impl,
         *   instead of binding interface itself
         *
         *   https://youtu.be/fe1n8VIXZ-k?si=uZi9Syg5YWrWMQ-m&t=415
         **/
        //bind(Calculator.class);
        // set as singleton
        // https://youtu.be/fe1n8VIXZ-k?si=KTFK0Q8rr5-sLuMJ&t=461
        bind(Calculator.class).to(Implementation_A.CalculatorImpl.class).in(Singleton.class);
    }

}
