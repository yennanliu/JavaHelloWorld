package Advances.Lambda.demo4;

// https://www.youtube.com/watch?v=dushR-wm_E8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=672

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *  Method reference demo 1
 *
 *      1) use cases
 *          -> when op we want to pass lambda expression already been implemented
 *
 *      2) Method reference is "lambda expression" essentially
 *         -> (lambda expression is implementation of functional interface)
 *         -> so Method reference is also implementation of functional interface
 *
 *      3) syntax
 *        -> class(or instance) :: method-class
 *
 *      4) 3 cases
 *          -> case 1:  instance :: non-static-method
 *          -> case 2:  class :: static-method
 *          -> case 3:  class: non-static-method
 *
 *      5) Requirement (when can use  Method reference)
 *          -> interface's abstract method param and return values
 *             should be AS SAME AS
 *             Method reference 's param and return values
 */

public class MethodRefTest {

    /**
     *  Example 1 : obj :: instance-method
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
        PrintStream ps = System.out;  // get class instance
        Consumer<String> con2 = ps :: println;
        con2.accept("osaka");
    }

    /**
     *   Example 2 :
     *
     *    -> Supplier's T get()
     *    -> Employee's String getName()
     */
    @Test
    public void test2(){

        Employee emp = new Employee(1001, "jack", 34, 700.1);

        // V1 : lambda expression
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        System.out.println("==================");

        // V2 : Method reference
        Supplier<String> sup2 = emp :: getName;
        System.out.println(sup2.get());
    }

    @Test
    public void test3(){

    }

    @Test
    public void test4(){

    }

    @Test
    public void test5(){

    }

    @Test
    public void test6(){

    }

}
