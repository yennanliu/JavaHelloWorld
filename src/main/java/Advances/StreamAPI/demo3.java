package Advances.StreamAPI;

// https://www.youtube.com/watch?v=yjiiB2d4Dic&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=680
// https://www.youtube.com/watch?v=o1wJWA_R9i8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=683

import Advances.Lambda.demo4.Employee;
import Advances.Lambda.demo4.EmployeeData;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * Stream API demo 3
 *
 * <p>Stream terminate op
 *
 * <p>1) allMatch(Predicate p) : check if match all elements 2) allMatch(Predicate p) : check if
 * match at least one element 3) noneMatch(Predicate p) : check if Not match all elements 4)
 * findFirst() : return 1st element 5) findAny() : return any element from current stream 6) count :
 * return total elements count from stream 7) max : return max from stream 8) min : return min from
 * stream 9) forEach(Consumer c) : internal iteration - external iteration: (for classType t : x){
 * .... } 10) collect(Collector c) : via Collector method, transform stream into other form, and
 * return it
 */
public class demo3 {

  @Test
  public void test1() {

    // init
    List<Employee> list = EmployeeData.getEmployees();

    // allMatch
    boolean allMatch = list.stream().allMatch(e -> e.getAge() > 18);
    System.out.println(allMatch);

    System.out.println("===================");

    // anyMatch
    boolean anyMatch = list.stream().anyMatch(e -> e.getAge() > 18);
    System.out.println(anyMatch);

    System.out.println("===================");

    // noneMatch
    boolean noneMatch = list.stream().noneMatch(e -> e.getName().startsWith("ken"));
    System.out.println(noneMatch);

    System.out.println("===================");

    // findFirst
    // Optional (a container), we will discuss this class later
    Optional<Employee> employee = list.stream().findFirst();
    System.out.println(employee);

    System.out.println("===================");

    // findAny
    Optional<Employee> employee1 = list.stream().findAny();
    System.out.println(employee1);
  }

  @Test
  public void test2() {

    // init
    List<Employee> list = EmployeeData.getEmployees();

    // count
    long count = list.stream().filter(e -> e.getSalary() > 1000).count();
    System.out.println(count);

    System.out.println("===================");

    // max
    Stream<Double> salaryStream = list.stream().map(e -> e.getSalary());
    list.stream().map(e -> e.getSalary());
    // via static method
    Optional<Double> maxSalary = salaryStream.max(Double::compare);
    System.out.println(maxSalary);

    System.out.println("===================");

    // min
    // via lambda expression
    Optional<Employee> minSalary =
        list.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
    System.out.println(minSalary);

    System.out.println("===================");

    // forEach demo 1 : with stream
    list.stream().forEach(System.out::println);

    System.out.println("===================");

    // forEach demo 2 : with collection
    list.forEach(System.out::println);
  }

  /**
   * collect(Collector c)
   *
   * <p>-> get all employees who has salary > 6000, return result as List or Set
   *
   * <p>Note !!! -> we use Collectors.toList() here
   */
  @Test
  public void test3() {

    // init
    List<Employee> employees = EmployeeData.getEmployees();
    // get as List<T>
    List<Employee> employeeList =
        employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());

    employeeList.forEach(System.out::println);

    System.out.println("===================");

    // get as Set<T>
    Set<Employee> employeeSet =
        employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());

    employeeSet.forEach(System.out::println);
  }
}
