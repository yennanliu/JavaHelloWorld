package Advances.Lambda;

// https://www.youtube.com/watch?v=lZf5ojE6X4k&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=667

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 *  Lambda expression demo 1
 */

public class demo1 {

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
        Runnable r2 = () -> System.out.println(">>> I love UK");

        r2.run();
    }

    @Test
    public void test2(){

        // v1 : tradition style
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare1 = com1.compare(12,99);
        System.out.println(">>> compare1 = " + compare1);

        System.out.println("================");

        // v2 : lambda style
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

        int compare2 = com2.compare(100,-1);
        System.out.println(">>> compare2 = " + compare2);

        System.out.println("================");

        // v3 : lambda style II
        Comparator<Integer> com3 = Integer :: compare;

        int compare3 = com3.compare(100,-1);
        System.out.println(">>> compare3 = " + compare3);
    }

}
