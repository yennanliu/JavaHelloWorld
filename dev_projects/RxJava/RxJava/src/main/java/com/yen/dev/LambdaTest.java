package com.yen.dev;

import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.Test;

// import rx.functions.Function;

public class LambdaTest {

  /**
   * Predicate -> a functional interface that takes one argument and returns a boolean. It’s often
   * used for filtering data.
   *
   * <p>how to run ? xxx.test()
   */
  @Test
  public void test1() throws Throwable {
    // System.out.println(123);
    Predicate<Integer> isEven = number -> number % 2 == 0;
    System.out.println(isEven.test(1));
    System.out.println(isEven.test(2));
  }

  /**
   * Function -> is a functional interface that takes one argument and returns a result.
   *
   * <p>how to run ?
   *
   * <p>xxx.apply()
   */
  @Test
  public void test2() throws Throwable {

    /**
     * NOTE !!!
     *
     * <p>Function<String, Integer>
     *
     * <p>String is input type, Integer is output type
     */
    Function<String, Integer> stringLen = s -> s.length();
    System.out.println(stringLen.apply("abc"));
    System.out.println(stringLen.apply(""));
  }

  @Test
  public void test3() throws Throwable {

    Function<Integer, Integer> stringLen = s -> s * 10;
    System.out.println(stringLen.apply(0));
    System.out.println(stringLen.apply(12));
  }

  /**
   * Supplier -> is a functional interface that doesn’t take any arguments and returns a result.
   *
   * <p>how to run ?
   *
   * <p>xxx.get()
   */
  @Test
  public void test4() throws Throwable {
    Supplier<Double> randomSupplier = () -> Math.random();

    System.out.println(randomSupplier.get());
    System.out.println(randomSupplier.get());
  }

  /**
   * Consumer
   *
   * <p>-> is a functional interface that takes one argument and returns no result (it “consumes”
   * the input).
   *
   * <p>how to run ?
   *
   * <p>xxx.accept()
   */
  @Test
  public void test5() throws Throwable {

    Consumer<String> printConsumer = s -> System.out.println("res = " + s);

    printConsumer.accept("ohhhh");
    printConsumer.accept("yaaaaa");
  }

  /**
   * BinaryOperator
   *
   * <p>-> is a functional interface that takes two arguments of the same type and returns a result
   * of the same type.
   *
   * <p>how to run ?
   *
   * <p>xxx.apply()
   */
  @Test
  public void test6() throws Throwable {

    BinaryOperator<Integer> sum = (a, b) -> a + b;
    System.out.println(sum.apply(1, 10));
    System.out.println(sum.apply(1, 2));
  }

  /** Consumer example (advanced) */
  @Test
  public void test7() throws Throwable {

    Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
    Consumer<String> printlower = s -> System.out.println(s.toLowerCase());

    // TODO : fix below
    //        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
    //        Consumer<String> printLowerCase = s -> System.out.println(s.toLowerCase());
    //
    //        // Chaining consumers
    //        Consumer<String> combinedConsumer = printUpperCase.andThen(printLowerCase);

  }

  @Test
  public void test8() throws Throwable {

    Function<String, String> trim = String::trim;
    Function<String, String> toUpperCase = String::toUpperCase;
      Function<String, String> addExclamation = s -> s + "!";

    // TODO : fix below
    // Composing functions
    //        Function<String, String> composedFunction =
    // trim.andThen(toUpperCase).andThen(addExclamation);
    //
    //        // Applying the composed function
    //        System.out.println(composedFunction.apply("  hello world  ")); // "HELLO WORLD!"
  }

  @Test
  public void test9() throws Throwable {

    List<Integer> list2 = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      list2.add(i);
    }

    Function<Integer, Integer> stringLen = s -> s * 10;
    BinaryOperator<Integer> sum2 = (a, b) -> a + b;

    // TODO : fix below
    //
    //        // Creating the list using a stream and lambda
    //        List<Integer> list = IntStream.range(0, 5)
    //                .boxed()
    //                .collect(Collectors.toList());
    //
    //        // Defining the Function and BinaryOperator
    //        Function<Integer, Integer> multiplyByTen = s -> s * 10;
    //        BinaryOperator<Integer> sum = Integer::sum;
    //
    //        // Using the function within the Flux operation
    //        Flux.fromIterable(list)
    //                .map(multiplyByTen)
    //                .reduce(sum)
    //                .subscribe(result -> System.out.println("Sum of all elements after
    // multiplication: " + result));

  }
}
