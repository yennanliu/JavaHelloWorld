package com.yen.dev;

import java.util.function.Function;

/**
 *  Example of java.util.function.Function
 *
 * The Function interface in the java.util.function package
 * is a functional interface that represents a function
 * that takes one argument and produces a result.
 *
 * Importing Function: We import java.util.function.Function.
 *
 * Creating a Function: We create a Function<String, Integer> that takes a String as input and returns an Integer (the length of the string).
 *
 * Using apply Method: We use the apply method to pass a test string to the function, which returns its length.
 *
 * Output: The result is printed to the console.
 *
 */
public class FunctionTest {
    public static void main(String[] args) {

        String myWord = "hello world";

        // TEST 1
        Function<String, Integer> stringIntegerFunction = str -> str.length();
        System.out.println(stringIntegerFunction.apply(myWord));

        // TEST 2
        Function<String, String> myPrint = x -> "result = " + x;
        System.out.println(myPrint.apply(myWord));

        // TEST 3 : chain
        Function<Integer, Integer> doubleFunction = length -> length * 2;
        Function<String, Integer> combinedFunction = stringIntegerFunction.andThen(doubleFunction);

        System.out.println(combinedFunction.apply(myWord));
    }
}
