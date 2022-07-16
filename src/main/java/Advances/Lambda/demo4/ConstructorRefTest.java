package Advances.Lambda.demo4;

// https://www.youtube.com/watch?v=e9K5R0jygsY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=674

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *   Constructor Ref demo 1
 *
 *     1)  Constructor ref
 *        -> similar as "method ref"
 *        -> lambda expression abstract method's args have to be AS SAME AS Constructor's args
 *        -> lambda expression return type is SAME as Constructor's type
 *
 *     2) array ref
 *        -> recognize array as a "special class", so use case is similar as "constructor ref"
 */

public class ConstructorRefTest {

    /**
     *   Example 1
     *    -> Supplier's T get()
     *    -> Employee's null arg constructor : Employee()
     *      -> since T get() has no arg, has return val
     *      -> and Employee has null arg constructor : Employee()
     *      -> so we can recognize "Employee()" as a method
     */
    @Test
    public void test1(){

        // V0 : tradition version
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };

        // V1 : lambda expression
        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());

        // V2 : constructor ref
        Supplier<Employee> sup2 = Employee :: new;
    }

    /**
     *   Example 2
     *     -> Function's R apply(T t)
     */
    @Test
    public void test2(){

        // V1 : lambda expression
        Function<Integer, Employee> func1 = id -> new Employee(id);
        Employee emp1 = func1.apply(1001);
        System.out.println(emp1);

        System.out.println("===============");

        // V2 : constructor ref
        Function<Integer, Employee> func2 = Employee :: new;
        Employee emp2 = func1.apply(1002);
        System.out.println(func1.apply(1002));
        System.out.println(emp2);
        System.out.println(emp2.getId());
    }

    /**
     *   Example 3
     *     -> BiFunction's R apply(T t, U u)
     */
    @Test
    public void test3(){

        // V1 : lambda expression
        BiFunction<Integer, String, Employee> func1 = (id, name) -> new Employee(id, name);
        System.out.println(func1.apply(99, "lynn"));

        // V2 : constructor ref
        BiFunction<Integer, String, Employee> func2 = Employee :: new;
        System.out.println(func2.apply(99, "lynn"));
    }

    /**
     *   Example 4 : Array reference
     *     -> Function's apply(T t)
     */
    @Test
    public void test4(){

        // V1 : lambda expression
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        // V2 : Array ref
        Function<Integer, String[]> func2 = String[] :: new;
        String[] arr2 = func1.apply(10);
        System.out.println(Arrays.toString(arr2));
    }

}
