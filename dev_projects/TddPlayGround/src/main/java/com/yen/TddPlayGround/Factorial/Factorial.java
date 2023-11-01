package com.yen.TddPlayGround.Factorial;

// https://www.liaoxuefeng.com/wiki/1252599548343744/1304048154181666

public class Factorial {

    public static long run(long x){

        //return null;
        if (x == 0){
            return 0;
        }

        long res = 1;

        for (int i = 1; i < x+1; i++){
           res = res * i;
        }

        return res;
    }

}
