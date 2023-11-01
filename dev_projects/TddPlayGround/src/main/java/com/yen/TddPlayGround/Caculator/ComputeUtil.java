package com.yen.TddPlayGround.Caculator;

public class ComputeUtil {

    public Integer add(int x, int y){
        return x + y;
    }

    public Integer minus(int x, int y){
        return x - y;
    }

    public Integer product(int x, int y){
        return x * y;
    }

    public Integer divide(int x, int y) throws ArithmeticException{
        return x / y;
    }

}
