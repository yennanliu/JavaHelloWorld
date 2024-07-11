package Advances.Lambda;

// https://www.youtube.com/watch?v=m_1FoxG9EvY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=667
// https://www.youtube.com/watch?v=zBCTy62MTfU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=669
// https://www.youtube.com/watch?v=bI2bXJs28Ok&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=670

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

/**
 * Lambda expression demo 2
 *
 * <p>0) lambda expression = functional interface instance
 *
 * <p>1) example 1: (o1, o2) -> Integer.compare(o1, o2);
 *
 * <p>2) format: -> : lambda operator "left -> " : - lambda param (abstract method param) - class
 * type can be omitted (type inference (類型推斷)) - ( if there is only one param, bracket can be
 * omitted as well) "-> right" : - lambda body (overridden abstract method body) - should use a big
 * bracket ({}) - if only one line lambda body, return, and bracket can be omitted
 *
 * <p>3) lambda expression : (6 form) -> form 1) No param, No return value -> form 2) need one
 * param, No return value -> form 3) omit data type, use type inference (類型推斷) -> form 4) if only
 * one param, param bracket can be omitted -> form 5) two or more params, have return value -> form
 * 6) if only one line lambda body, return, and bracket can be omitted
 *
 * <p>4) (java only) lambda essence : as (functional) interface instance
 *
 * <p>5) what's functional interface instance ? -> if there is ONLY ONE abstract method declared in
 * an interface -> this is a functional interface. -> usually has "@FunctionalInterface" annotation
 * (optional) -> plz check example : Advances.Lambda.MyInterface.java -> can create its instance via
 * lambda expression -> java8 defines lots of functional interfaces at java.util.function pkg
 *
 * <p>6) OOP (物件導向編程) VS OOF (函數式編程) -> at general OOF, method is 1st tier. -> However, in java,
 * lambda expression is STILL an object -> it belongs a special type -- functional interface
 *
 * <p>7) all anonymous classes can be implemented via lambda expression
 */
public class demo2 {

  /** form 1) No param, No return value */
  @Test
  public void test1() {

    // v1 : tradition style
    Runnable r1 =
        new Runnable() {
          @Override
          public void run() {
            System.out.println(">>> I love JP");
          }
        };

    r1.run();

    System.out.println("================");

    // v2 : lambda style
    // "->" : lambda expression
    Runnable r2 =
        () -> {
          System.out.println(">>> I love UK");
        };

    r2.run();
  }

  /** form 2) need one param, No return value */
  @Test
  public void test2() {

    // v1 : tradition style
    Consumer<String> con =
        new Consumer<String>() {
          @Override
          public void accept(String s) {
            System.out.println(s);
          }
        };

    con.accept("xxx");

    System.out.println("================");

    // v2 : lambda style
    Consumer<String> con2 =
        (String s) -> {
          System.out.println(s);
        };

    con2.accept("yyy");
  }

  /** form 3) omit data type, use type inference (類型推斷) */
  @Test
  public void test3() {

    // v1 : lambda expression I
    Consumer<String> con1 =
        (String s) -> {
          System.out.println(s);
        };

    // v2 : lambda expression II : use type inference
    Consumer<String> con2 =
        (s) -> { // omit "s" 's type
          System.out.println(s);
        };

    System.out.println("======= Review : type inference ========");

    // example 1
    ArrayList<String> list = new ArrayList<>(); // ArrayList<>, type inference

    // example 2
    int[] arr1 = new int[] {1, 2, 3};
    // is same as below
    int[] arr2 = {1, 2, 3}; // type inference
  }

  /** form 4) if only one param, param bracket can be omitted */
  @Test
  public void test4() {

    // v1 : lambda expression
    Consumer<String> con2 =
        (s) -> { // omit s's type
          System.out.println(s);
        };

    con2.accept("zzzz");
    System.out.println("================");

    // v2 : lambda expression II
    Consumer<String> con3 =
        s -> { // omit s's type
          System.out.println(s);
        };
  }

  /** form 5) two or more params, have return value */
  @Test
  public void test5() {

    // v1 : tradition style
    Comparator<Integer> com1 =
        new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
          }
        };

    System.out.println(com1.compare(100, 200));

    System.out.println("=================");

    // v2 : lambda style
    Comparator<Integer> com2 =
        (o1, o2) -> {
          System.out.println(o1);
          System.out.println(o2);
          return o1.compareTo(o2);
        };

    System.out.println(com2.compare(-1, -2));
  }

  /** form 6) if only one line lambda body, return bracket can be omitted */
  @Test
  public void test6() {

    // v1 : lambda style
    Comparator<Integer> com2 =
        (o1, o2) -> {
          return o1.compareTo(o2);
        };

    // v2 : lambda style II
    Comparator<Integer> com3 = (o1, o2) -> o1.compareTo(o2);
  }

  // form 6) advanced demo
  @Test
  public void test7() {

    // v1 : lambda expression
    Consumer<String> con3 =
        s -> { // omit s's type
          System.out.println(s);
        };

    // v2 : lambda expression II
    Consumer<String> con4 = s -> System.out.println(s);
  }
}
