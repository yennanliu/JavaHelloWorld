package Advances.Lambda;

// https://www.youtube.com/watch?v=Lzq9O7_p9O0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=671

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *  Lambda expression demo 3
 *
 *   - Java's default 4 functional interfaces
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
 *      - 4) Predicate (斷言) interface:
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

    @Test
    public void test2(){

        // V1 : tradition way
        List<String> list = Arrays.asList("UK", "US", "JP", "TW", "UN");
        List<String> r1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("U");
            }
        });

        System.out.println("r1 = " + r1);

        System.out.println("=====================");

        // V2 : lambda expression
        List<String> r2 = filterString(list, s -> {return s.contains("U");});
        System.out.println("r2 = " + r2);

        // V3 : lambda expression II
        List<String> r3 = filterString(list, s ->  s.contains("U"));
        System.out.println("r3 = " + r3);

    }

    // method for test
    // based on condition, filter out string in array,
    // the condition is defined by Predicate method
    public List<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> filterList = new ArrayList<>();

        for (String s : list){
            if (pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;
    }

}
