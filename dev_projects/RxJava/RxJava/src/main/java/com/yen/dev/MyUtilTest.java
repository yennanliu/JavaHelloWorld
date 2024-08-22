package com.yen.dev;

import org.junit.jupiter.api.Test;


public class MyUtilTest {

    @Test
    public void test1(){
        MyUtil.myCall();
        MyUtil.myPrint();
        MyUtil.add(1,2);
        MyUtil.isNullOrEmpty(null);
    }

}
