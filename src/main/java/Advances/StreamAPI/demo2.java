package Advances.StreamAPI;

// https://www.youtube.com/watch?v=vL23nxrQWuI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=678

import Advances.Lambda.demo4.Employee;
import Advances.Lambda.demo4.EmployeeData;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 *  Stream API demo 2
 *
 *   Stream intermedia op
 *      1) filter, sampling
 *      2)
 *      3)
 */

public class demo2 {

    /**
     *  demo 1 :
     *      -> filter(Predicate p) : accept Lambda, filter elements from stream
     *      -> limit(n) : only get element with limit count
     *      -> skip(n) : neglect elements : return a stream neglect first n elements
     *      -> distinct : via hashCode(), and equals() de-duplicate elements and return
     */
    @Test
    public void test1(){

        // init
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();

        // filter
        stream.filter(e -> e.getSalary() > 100)
              .forEach(System.out::println);

        System.out.println("================");

        // limit
        // below is wrong, CAN'T do limit op on already closed stream (java.lang.IllegalStateException: stream has already been operated upon or closed)
        //stream.limit(2).forEach(System.out::println);
        list.stream().limit(2).forEach(System.out::println);

        System.out.println("================");

        // skip
        // below is wrong, CAN'T do limit op on already closed stream (java.lang.IllegalStateException: stream has already been operated upon or closed)
        // stream.skip(2).forEach(System.out::println);
        list.stream().skip(3).forEach(System.out::println);

        System.out.println("================");

        // distinct
        // add duplicated data
        list.add(new Employee(1001, "jack", 34, 700.1));
        list.add(new Employee(1001, "jack", 34, 700.1));
        list.add(new Employee(1001, "jack", 34, 700.1));
        list.add(new Employee(1001, "jack", 34, 700.1));

        list.stream().distinct().forEach(System.out::println);
    }

}
