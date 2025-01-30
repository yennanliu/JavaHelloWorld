package org.example.AnnotationAop;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        //System.out.println("--> before");
        int res = i + j;
        //System.out.println("--> after");

        // for `AfterThrowing` testing only
        //int x = 1 / 0;

        return res;
    }

    @Override
    public int sub(int i, int j) {
        //System.out.println("--> before");
        int res = i - j;
        //System.out.println("--> after");
        return res;
    }

    @Override
    public int mul(int i, int j) {
        //System.out.println("--> before");
        int res = i * j;
        //System.out.println("--> after");
        return res;
    }

    @Override
    public int div(int i, int j) {
        if (j == 0){
            return 0;
        }
        //System.out.println("--> before");
        int res = i / j;
        //System.out.println("--> after");
        return res;
    }
}
