package com.yen.example0.service.impl;

// https://youtu.be/fe1n8VIXZ-k?si=wUM5aVKv1zqjynL7&t=547

import com.yen.example0.service.Calculator;

import javax.inject.Inject;

/** Injector demo */
public class CalculatorService {

    @Inject
    private Calculator calculator;

    public int calculate(int a, int b, String op){
        if(op.equals("add")){
            return calculator.addition(a,b);
        }

        System.out.println("op = " + op + " is not supported");
        return 0;
    }
}
