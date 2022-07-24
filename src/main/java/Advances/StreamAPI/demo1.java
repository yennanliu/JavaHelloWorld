package Advances.StreamAPI;

// https://www.youtube.com/watch?v=2jCET8QnQXw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=676
// https://www.youtube.com/watch?v=u_w1zQvYV3I&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=677

import Advances.Lambda.demo4.Employee;
import Advances.Lambda.demo4.EmployeeData;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  Stream API demo 1
 *
 *     stream initiation op
 *
 *    1) Stream API : for data manipulation (deal with CPU)
 *    2) Stream API VS collection
 *      -> collection focus on data storage (deal with memory)
 *    3) stream will NOT storage elements
 *    4) stream will NOT change source instance; they return result to the other new stream
 *    5) stream op is "lazy" operation, it will NOT be executed until result is called
 *    6) stream op steps:
 *          -> step 1) stream initiation
 *          -> step 2) stream op (filter, mapping..)
 *          -> step 3) terminate op
 *
 *    7) once terminated, stream result CAN NOT BE retrieved again
 */
public class demo1 {

    /**
     *  Create stream method 1 : via collection
     */
    @Test
    public void test1(){

        // default Stream<E> stream() : return an ordering stream
        List<Employee> employees =  EmployeeData.getEmployees();

        // default Stream<E> parallelStream() : return a parallel stream
        Stream<Employee> employees2 = employees.parallelStream();
    }

    /**
     *  Create stream method 2 : via Array
     */
    @Test
    public void test2(){

        // init
        int[] arr = new int[]{1,2,3,4,5,6};

        // call Array class's static method : Stream <T> Stream <T> Stream(T[] array) : return a stream
        IntStream stream1 = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "jim");
        Employee e2 = new Employee(2002, "jack");
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream2 = Arrays.stream(arr1);
    }

    /**
     *  Create stream method 3 : via Stream API 's of
     */
    @Test
    public void test3(){

        // init
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
    }

    /**
     *  Create stream method 4 : via un-bound stream
     */
    @Test
    public void test4(){

        // V1 : iteration
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        // for loop first 10 even numbers
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out :: println);
        //Stream.iterate(0, t -> t + 2).forEach(System.out :: println);

        System.out.println("===============");

        // V2 : generate
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math :: random).limit(10).forEach(System.out :: println);
        //Stream.generate(Math :: random);
    }

}
