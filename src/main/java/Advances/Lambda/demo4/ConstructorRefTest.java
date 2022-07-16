package Advances.Lambda.demo4;

// https://www.youtube.com/watch?v=e9K5R0jygsY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=674

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *   Constructor Ref demo 1
 *
 *     1)  Constructor ref
 *
 *     2) array ref
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
        Function<Integer, Employee> func1 = id -> new Employee();
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

    }


    @Test
    public void test4(){

    }

}
