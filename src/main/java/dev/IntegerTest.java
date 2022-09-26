package dev;

import org.junit.jupiter.api.Test;

public class IntegerTest {

    @Test
    public void test1(){
        System.out.println(2 == 2);
        System.out.println(new Integer(2).equals(2));
    }
}
