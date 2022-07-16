package Advances.Lambda.demo4;

// https://www.youtube.com/watch?v=dushR-wm_E8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=672
// https://www.youtube.com/watch?v=jVfmtHhrKgA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=672
// https://www.youtube.com/watch?v=0lufoYMLsF4&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=674

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
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
     *   Example 2 :  obj :: instance-method
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

    /**
     *   Example 3 : class :: static-method
     *
     *    -> Comparator's int compare(T t1, T t2)
     *    -> Integer's int compare(T t1, T t2)
     */
    @Test
    public void test3(){

        // V1 : lambda expression
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(1,100));

        System.out.println("==================");

        // V2 : Method reference
        Comparator<Integer> com2 = Integer :: compare; // NOTE : we DON'T need to have param (t1, t2) here, since the method we use here is AS SAME AS the lambda expression it refers
        System.out.println(com2.compare(1,100));
    }

    /**
     *   Example 4
     *    -> Function's R apply(T t)
     *    -> Math's Long round(Double d)
     */
    @Test
    public void test4(){

        // V0 : tradition method
        Function<Double, Long> func0 = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };

        // V1 : lambda expression
        Function<Double, Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(10.01));

        System.out.println("==================");

        // V2 : Method reference
        Function<Double, Long> func2 = Math :: round;
        System.out.println(func2.apply(10.01));
    }

    /**
     *   Example 5  (a bit hard)
     *    -> class :: instance-method
     *    -> comparator's int compare(T t1, T t2)
     *    -> String's t1.compareTo(t2)
     *    -> (if 1st arg (xx) is xx.compareTo, then we can use Method reference)
     */
    @Test
    public void test5(){

        // V1 : lambda expression
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "de"));

        // V2 : Method reference
        Comparator<String> com2 = String :: compareTo;
        System.out.println(com2.compare("abc", "de"));
    }

    /**
     *   Example 6
     *      -> BiPredicate's boolean test(T t1, T t2);
     *      -> String's boolean t1.equals(t2)
     */
    @Test
    public void test6(){

        // V1 : lambda expression
        BiPredicate<String, String> pre1 = (s1, s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc", "abc"));

        // V2 : Method reference
        BiPredicate<String, String> pre2 = String :: equals;
        System.out.println(pre2.test("abc", "abc"));
    }

    /**
     *   Example 7
     *      -> Function's R apply(T t)
     *      -> Employee's String getName():
     */
    @Test
    public void test7(){

        Employee e1 = new Employee(101, "AMY", 17, 2000 );

        // V1 : lambda expression
        Function<Employee, String> func1 = e -> e.getName();
        System.out.println(func1.apply(e1));

        System.out.println("======================");

        // V2 : Method reference
        Function<Employee, String> func2 = Employee :: getName;
        System.out.println(func2.apply(e1));
    }

}
