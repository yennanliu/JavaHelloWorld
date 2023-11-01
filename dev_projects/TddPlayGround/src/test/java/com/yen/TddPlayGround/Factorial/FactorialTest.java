package com.yen.TddPlayGround.Factorial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void testRun(){
        assertEquals(Factorial.run(5), 120);
        assertEquals(Factorial.run(1), 1);
        assertEquals(Factorial.run(0), 0);
        assertEquals(Factorial.run(10), 3628800);
        assertEquals(Factorial.run(20), 2432902008176640000L);
    }

}