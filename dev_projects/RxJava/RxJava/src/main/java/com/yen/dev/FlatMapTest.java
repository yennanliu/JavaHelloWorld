package com.yen.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FlatMapTest {

  @Test
  public void test1() {

    // System.out.println(123);

    Flux.just("jack walker", "Jotaro Kujo")
        // split name with space, print all first name, and last name
        .flatMap(
            x -> {
              String[] y = x.split(" ");
              return Flux.fromArray(y); // transform array to a multi element stream
            })
        // .log()
        .subscribe(x -> System.out.println(x));
  }

  @Test
  public void test2() {
    Flux.just(1, 2, 3)
        .flatMap(
            x -> {
              Integer y = x + 1;
              // NOTE !!! use Flux.just(int) as return type
              return Flux.just(y);
            })
        .subscribe(x -> System.out.println(x));
  }

  @Test
  public void test3() {
    List<Integer> res =
        Flux.just(new Integer[] {1, 2, 3}, new Integer[] {7, 8, 9})
            .flatMap(
                x -> {
                  Integer[] y = x;
                  // NOTE !!! use Flux.just(int) as return type
                  return Flux.just(y);
                })
            .toStream()
            .collect(Collectors.toList());

    // res = [1, 2, 3, 7, 8, 9]
    System.out.println("res = " + res);
  }

  @Test
  public void test4() {
    Car c1 = new Car(1, "a-car");
    Car c2 = new Car(2, "b-car");
    Car c3 = new Car(3, "c-car");

    Flux.just(c1, c2, c3)
        .flatMap(
            x -> {
              String name = x.getName();
              Car newCar = new Car();
              newCar.setId(x.id + 10);
              newCar.setName(name + " ohhh");
              // return Flux.just(name);
              return Flux.just(newCar);
            })
        .subscribe(x -> System.out.println(x));
  }

  /** flatMap with custom method 1 */
  @Test
  public void test5() {

    Flux.just(1, 2, 3).flatMap(this::repeatValue).subscribe(x -> System.out.println(x));
  }

  /** flatMap with custom method 2 */
  @Test
  public void test6() {

    Flux.just(1, 2, 3).flatMap(this::prepareList).subscribe(x -> System.out.println(x));
  }

  /** flatMap with custom method 3 */
  @Test
  public void test7() {

    Flux.just(1, 2, 3)
        .flatMap(this::prepareList)
        .flatMap(
            x -> {
              int val = x.get(0);
              return Flux.just(val);
            })
        .map(y -> y + 10)
        .subscribe(x -> System.out.println(x));
  }

  /** flatMap with custom method 4 */
  @Test
  public void test8() {

    List<String> data =
        Flux.just("Jolyne Cujoh", "Jotaro Kujo", "Dio Brando")
            .flatMap(
                x -> {
                  String[] res = x.split(" ");
                  return Flux.fromArray(res);
                })
            .flatMap(this::toUpperCase)
            //                .map(x -> {
            //                    return x.length();
            //                })
            .toStream()
            .collect(Collectors.toList());
    // .subscribe(x -> System.out.println(x));

    // [Jolyne, Cujoh, Jotaro, Kujo, Dio, Brando]
    // data = [JOLYNE, CUJOH, JOTARO, KUJO, DIO, BRANDO]
    System.out.println("data = " + data);
  }

  /** FlatMap Flux.fromIterable demo */
  // https://youtu.be/E-9UjhOu8Ps?si=Bi_l-ujqu22Jj5W7&t=2105
  @Test
  public void test9() throws InterruptedException {
    Flux.range(1, 100)
        // NOTE !!! set batch size as 10
        .buffer(10)
        .flatMap(
            list -> {
              /**
               * NOTE !!!
               *
               * <p>list can be used with Flux.fromIterable(list);
               */
              return Flux.fromIterable(list);
            })
        .subscribe(x -> System.out.println("--> x = " + x));

    Thread.sleep(20000);
  }

  // define custom method
  // Custom function that returns a Flux<String>
  public Flux<String> repeatValue(int number) {
    return Flux.range(1, number).map(i -> "Value: " + number);
  }

  public Flux<List<Integer>> prepareList(int number) {
    List<Integer> list = new ArrayList<>();
    for (int i = number; i < number + 3; i++) {
      list.add(i);
    }
    return Flux.just(list);
  }

  public Flux<String> toUpperCase(String name) {
    return Flux.just(name.toUpperCase());
  }

  class Car {
    private int id;
    private String name;

    Car() {}

    Car(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "Car{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
  }
}
