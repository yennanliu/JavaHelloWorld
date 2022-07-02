package Advances.Lambda;

// https://www.youtube.com/watch?v=m_1FoxG9EvY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=667

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 *  Lambda expression demo 2
 *
 *   1) example 1:  (o1, o2) -> Integer.compare(o1, o2);
 *
 *   2) format:
 *      -> : lambda operator
 *      "-> left" : lambda param (abstract method param)
 *      "-> right" : lambda body (overridden abstract method body)
 *
 *   3) lambda expression : (6 form)
 *      -> form 1) No param, No return value
 *      -> form 2) need one param, No return value
 *
 *   4) (in java only) lambda essence : as interface instance
 *
 */

public class demo2 {

    /** form 1: No param, No return value */
    @Test
    public void test1(){

        // v1 : tradition style
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(">>> I love JP");
            }
        };

        r1.run();

        System.out.println("================");

        // v2 : lambda style
        // "->" : lambda expression
        Runnable r2 = () -> {
            System.out.println(">>> I love UK");
        };

        r2.run();
    }

    /**  form 2) need one param, No return value  */
    @Test
    public void test2(){

        // v1 : tradition style
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con.accept("xxx");

        System.out.println("================");

        // v2 : lambda style
        Consumer<String> con2 = (String s) -> {
            System.out.println(s);
        };

        con2.accept("yyy");

    }

}
