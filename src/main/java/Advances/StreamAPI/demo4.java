package Advances.StreamAPI;

// https://www.youtube.com/watch?v=oSWwc-O0xUc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=682

import Advances.Lambda.demo4.Employee;
import Advances.Lambda.demo4.EmployeeData;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * Stream API demo 4
 *
 * <p>Stream reduce op
 *
 * <p>1) reduce(T identity, BinaryOperator) : can aggregate all elements from stream and return
 * final result
 *
 * <p>2) reduce(BinaryOperator) : can aggregate all elements from stream and return Option<T> as
 * final result
 */
public class demo4 {

  @Test
  public void test1() {

    /**
     * 1) reduce(T identity, BinaryOperator)
     *
     * <p>-> get sum from 1 - 10
     */
    // init
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // style 1
    int res1 = list.stream().reduce(0, (a, b) -> Integer.sum(a, b));

    // style 2
    int res2 = list.stream().reduce(0, Integer::sum);
    System.out.println(">>> res1 = " + res1);
    System.out.println(">>> res2 = " + res2);

    System.out.println("=================");

    /**
     * 2) reduce(BinaryOperator)
     *
     * <p>-> get sum of employees salary
     */
    // init
    List<Employee> employees = EmployeeData.getEmployees();
    Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);

    // style 1
    // Optional<Double> res3 = salaryStream.reduce((a,b) -> Double.sum(a,b));
    Optional<Double> res3 = salaryStream.reduce((a, b) -> a + b);
    System.out.println(">>> res3 = " + res3);

    // style 2
    Stream<Double> salaryStream2 = employees.stream().map(Employee::getSalary);
    Optional<Double> res4 = salaryStream2.reduce(Double::sum);
    System.out.println(">>> res4 = " + res4);
  }
}
