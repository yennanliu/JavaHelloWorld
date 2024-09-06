package com.yen.example0.service.impl;

import com.yen.example0.service.Calculator;
import com.yen.example0.service.MyInterface;

// https://jimwayne.blogspot.com/2015/09/guice-dependency-imjection.html

public class Implementation_A implements MyInterface {

    @Override
    public String getClassName() {
        return "this is Implementation_A";
    }

    public static class CalculatorImpl implements Calculator {

      public int addition(int a, int b) {
        return a + b;
      }

    }
}
