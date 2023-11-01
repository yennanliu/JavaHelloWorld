package com.yen.TddPlayGround.Caculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputeUtilTest {

    ComputeUtil computeUtil = new ComputeUtil();

    @Test
    void testAdd(){
        assertEquals(computeUtil.add(0, 1), 1);
        assertEquals(computeUtil.add(0, -1), -1);
        assertEquals(computeUtil.add(1, 2), 3);
        assertEquals(computeUtil.add(Integer.MAX_VALUE, 0), 2147483647);
    }

    @Test
    void testMinus(){
        assertEquals(computeUtil.minus(0, 1), -1);
        assertEquals(computeUtil.minus(1, 1), 0);
        assertEquals(computeUtil.minus(100, 20), 80);
        assertEquals(computeUtil.minus(Integer.MAX_VALUE, 2), 2147483645);
    }

    @Test
    void testProduct(){
        assertEquals(computeUtil.product(0, 1), 0);
        assertEquals(computeUtil.product(1, 1), 1);
        assertEquals(computeUtil.product(100, 20), 2000);
        assertEquals(computeUtil.product(Integer.MAX_VALUE, 2), -2); // ??
    }

    @Test
    void testDivide(){

        assertEquals(computeUtil.divide(0, 1), 0);

        // TODO : make it more elegant
        // https://www.baeldung.com/junit-assert-exception
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            computeUtil.divide(1, 0);
        });
        System.out.println(">>> exception = " + exception);
        System.out.println(">>> exception class = " + exception.getClass());
        assertEquals(exception.getClass().toString(), "class java.lang.ArithmeticException"); // TODO : optmize this

        assertEquals(computeUtil.divide(1, 1), 1);
        assertEquals(computeUtil.divide(100, 20), 5);
        assertEquals(computeUtil.divide(7, 2), 3); // ??
    }

}