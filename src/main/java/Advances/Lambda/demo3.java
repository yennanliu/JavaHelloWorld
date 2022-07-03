package Advances.Lambda;

// https://www.youtube.com/watch?v=Lzq9O7_p9O0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=671

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 *  Lambda expression demo 3
 *
 *   - Java default 4 functional interface
 *
 *      - 1) Consumer interface :
 *          Consumer<T> void accept(T t)
 *
 *      - 2) Supplier interface:
 *          Supplier<T> T get()
 *
 *      - 3) Function interface:
 *          Function<T, R> R Apply(T t)
 *
 *      - 4) Predicate interface:
 *          Predicate<T> boolean test(T t)
 */

public class demo3 {

    @Test
    public void test1(){

        // V1 : tradition way
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(">>> have some happy hour, spend " + aDouble);
            }
        });

        System.out.println("=====================");

        // V2 : lambda expression
        happyTime(400, money -> {System.out.println(">>> have some happy hour, spend " + money);});

        System.out.println("=====================");

        // V3 : lambda expression II
        happyTime(400, money -> System.out.println(">>> have some happy hour, spend " + money));

    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

}
