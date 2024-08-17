package com.yen.dev;

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
            .flatMap(x -> {
                String name = x.getName();
                Car newCar = new Car();
                newCar.setId(x.id+10);
                newCar.setName(name + " ohhh");
                //return Flux.just(name);
                return Flux.just(newCar);
            })
            .subscribe(x -> System.out.println(x));
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
          return "Car{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  '}';
      }
  }

}
