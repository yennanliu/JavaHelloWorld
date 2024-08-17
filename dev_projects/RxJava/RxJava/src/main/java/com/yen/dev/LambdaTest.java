package com.yen.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class LambdaTest {

    /**
     *  Predicate
     *  -> a functional interface that takes one argument and
     *    returns a boolean. It’s often used for filtering data.
     *
     *
     *   how to run ?
     *    xxx.test()
     */
    @Test
    public void test1() throws Throwable {
        //System.out.println(123);
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(1));
        System.out.println(isEven.test(2));
    }

    /**
     *   Function
     *   -> is a functional interface
     *   that takes one argument and returns a result.
     *
     *   how to run ?
     *
     *   xxx.apply()
     */
    @Test
    public void test2() throws Throwable {

        /**
         * NOTE !!!
         *
         *  Function<String, Integer>
         *
         *   String is input type,
         *   Integer is output type
         */
        Function<String, Integer> stringLen = s -> s.length();
        System.out.println(stringLen.apply("abc"));
        System.out.println(stringLen.apply(""));
    }

    @Test
    public void test3() throws Throwable {

        Function<Integer, Integer> stringLen = s -> s * 10;
        System.out.println(stringLen.apply(0));
        System.out.println(stringLen.apply(12));
    }

    /**
     *  Supplier
     *  -> is a functional interface
     *     that doesn’t take any arguments
     *     and returns a result.
     *
     *     how to run ?
     *
     *     xxx.get()
     *
     */
    @Test
    public void test4() throws Throwable {
        Supplier<Double> randomSupplier = () -> Math.random();

        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());
    }

    /**
     *  Consumer
     *
     *  -> is a functional interface that takes one argument
     *  and returns no result (it “consumes” the input).
     *
     *   how to run ?
     *
     *   xxx.accept()
     *
     */
    @Test
    public void test5() throws Throwable {

        Consumer<String> printConsumer = s -> System.out.println("res = " + s);

        printConsumer.accept("ohhhh");
        printConsumer.accept("yaaaaa");
    }

    /**
     *
     * BinaryOperator
     *
     * -> is a functional interface that takes
     *    two arguments of the same type and returns
     *    a result of the same type.
     */
    @Test
    public void test6() throws Throwable {

        Consumer<String> printConsumer = s -> System.out.println("res = " + s);

        printConsumer.accept("ohhhh");
        printConsumer.accept("yaaaaa");
    }



}
