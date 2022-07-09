package Advances.Lambda.demo4;

// https://www.youtube.com/watch?v=dushR-wm_E8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=672

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 *  Method reference demo 1
 *      1) use cases
 *          -> when op we want to pass lambda expression already been implemented
 *
 */

public class MethodRefTest {

    /**
     *  example 1 : obj :: instance-method
     *
     *   -> Consumer's void accept(T t)
     *   -> PrintStream's void println(T t)
     */
    @Test
    public void test1(){

        // V1 : lambda expression
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("tokyo");

        System.out.println("==================");

        // V2 : Method reference
    }

    @Test
    public void test2(){

    }

}
