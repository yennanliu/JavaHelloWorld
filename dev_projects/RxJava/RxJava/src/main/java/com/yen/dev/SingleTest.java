package com.yen.dev;

import io.reactivex.rxjava3.core.Single;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class SingleTest {

  @Test
  public void test1() {

    Single<String> single = Single.just("Hello, RxJava!");
    //Flux<String> single = Flux.just("Hello, RxJava!", "ohhhhh");

    // v1
    single.subscribe(
        value -> System.out.println("Value: " + value), // onSuccess
        error -> System.err.println("Error: " + error) // onError
        );

    // v2
    single.subscribe(x -> System.out.println("-> Value: " + x));

    // v3 : blockingGet
    System.out.println(single.blockingGet());
  }

  @Test
  public void test2() {

    // Single<Integer> single = Single.just(1);
    // Single<List<Integer>> single = Single.just(Arrays.asList(1,2,3));
    Single<User> single = Single.just(new User(1, "jay"));

    single.subscribe(
        value -> System.out.println("Value: " + value), // onSuccess
        error -> System.err.println("Error: " + error));
  }

  @Test
  public void test3() {

    // Single<Integer> single = Single.just(1);
    // Single<List<Integer>> single = Single.just(Arrays.asList(1,2,3));
    Single<User> single = Single.just(new User(1, "jay"));

    single.subscribe(
        value -> System.out.println("Value: " + value), // onSuccess
        error -> System.err.println("Error: " + error));
  }

  // Single<Stream<T>>
  @Test
  public void test4() {

    // Create a Single<Stream<String>> object
    Single<Stream<String>> singleStream = Single.just(Stream.of("One", "Two", "Three"));

    // Subscribe to the Single and print each element in the Stream
    singleStream.subscribe(stream ->
                    stream.forEach(System.out::println),
            error -> System.err.println("Error: " + error)
    );
  }

  @Test
  public void test5() {

    // Create a Single<Stream<String>> object
    Single<Stream<String>> singleStream = Single.just(Stream.of("One", "Two", "Three"));

    // Subscribe to the Single and print each element in the Stream
    // v1
    singleStream.subscribe(stream ->
                    stream.forEach(System.out::println));

    //singleStream.subscribe(x -> System.out.println("--> x = " + x));

    // v2
    singleStream.subscribe(stream -> {
      List<String> list = stream.collect(Collectors.toList());
      list.forEach(System.out::println);
    });

    // v3
    singleStream.subscribe(stream -> {
      String[] array = stream.toArray(String[]::new);
      for (String s : array) {
        System.out.println(s);
      }
    });
    
  }

  class User {
    private int id;

    private String name;

    public User() {}

    public User(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
  }

}
