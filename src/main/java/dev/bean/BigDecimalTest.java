package dev.bean;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void test1(){

        // https://stackoverflow.com/questions/60810045/convert-string-to-double-without-scientific-notation

        String yourString = "7.234348087737378E8";
        BigDecimal value = new BigDecimal(yourString);
        double doubleValue = value.doubleValue();

        System.out.println(value);
        System.out.println(value.toString());
        System.out.println(doubleValue);
    }

}
