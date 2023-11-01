package com.yen.TddPlayGround.Caculator;

public class App {

    public static void main(String[] args) {

        ComputeUtil computeUtil = new ComputeUtil();
        System.out.println(computeUtil.add(1,2));
        System.out.println(computeUtil.minus(1,2));
        System.out.println(computeUtil.divide(1,2));
        System.out.println(computeUtil.product(1,2));

        try{
            computeUtil.divide(1,0);
        }catch (Exception e){
            System.out.println("divide failed, error : " + e);
        }

    }

}
