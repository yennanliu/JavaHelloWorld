package com.yen.example1;

public class ThirdPartyClass {

    private ThirdPartyClass() {
        System.out.println("ThirdPartyClass init!!!");
    }

    public static ThirdPartyClass create() {
        return new ThirdPartyClass();
    }

    public String print() {
        return "this is 3rd party print";
    }

}
