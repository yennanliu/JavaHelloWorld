package org.example.StaticProxy;

// 靜態代理類
// https://youtu.be/gVpjE2dYD3w?si=YPJDxxZiInA3-q2Z&t=266

import org.example.Calculator;

/**
 * 靜態代理
 *
 * -> NOT solving the "code correlated"
 * -> logging code is till binding to the core logic code
 *
 */
public class CalculatorStaticProxy implements Calculator {

    /**
     *  pass the "proxied" class (被代理對象)
     *  to here (via constructor)
     *
     */
    // attr
    private Calculator calculator;

    // constructor
    public CalculatorStaticProxy(Calculator calculator){
        this.calculator = calculator;
    }


    @Override
    public int add(int i, int j) {
        // (non-core logic) logging
        System.out.println("--> [Log] before method");

        // (core logic) call target class to execute the biz logic
        int res = calculator.add(i, j);

        System.out.println("--> [Log] after method, res = " + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
