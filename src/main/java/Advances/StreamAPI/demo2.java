package Advances.StreamAPI;

// https://www.youtube.com/watch?v=vL23nxrQWuI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=678
// https://www.youtube.com/watch?v=jPjOW6f1_EA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=678

import Advances.Lambda.demo4.Employee;
import Advances.Lambda.demo4.EmployeeData;

import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 *  Stream API demo 2
 *
 *   Stream intermedia op
 *      1) filter, sampling
 *      2) mapping
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

    /**
     *  demo 2
     *      -> map(Function f) : receive a func as param,
     *                           transform elements with it
     *
     *      -> flatMap(Function f) : receive a func as param,
     *                               transform elements with it
     *                               if there are sub-streams
     *                               will put all of them into original stream ("flat")
     */
    @Test
    public void test2(){

        // init
        List<String> list = Arrays.asList("AA", "aa", "bb","cc", "dd");
        Stream<String> stream = list.stream();

        List<Employee> employees = EmployeeData.getEmployees();

        // map demo 1
        stream.map(str -> str.toUpperCase()).forEach(System.out::println);

        System.out.println("================");

        // map demo 2 : filter age > 3
        //employees.stream().map(str -> str.getAge() > 3).map(Employee::getName);
        Stream<String> namesStream = employees.stream().map(Employee::getName);
        namesStream.filter(name -> name.length() > 3).forEach(System.out::println);

        System.out.println("================");

        // flatMap demo 1
        // if still use map (not use flatMap)
        Stream<Stream<Character>> streamStream = list.stream().map(demo2::fromStringToStream);
        streamStream.forEach(System.out::println);

        System.out.println("================");

        Stream<Character> characterStream = list.stream().flatMap(demo2::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    /** transform char in string to stream */
    public static Stream<Character> fromStringToStream(String str){

        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    /**
     *  Review :
     *     -> list.add() VS list.addAll()
     *     -> similar as map VS flatMap
     */
    @Test
    public void test3(){

        ArrayList list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list1_ = new ArrayList<>();
        list1_.add(1);
        list1_.add(2);
        list1_.add(3);

        ArrayList list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        list1.add(list2);
        System.out.println("list1 = " + list1);

        list1_.addAll(list2);
        System.out.println("list1_ = " + list1_);
    }

}
