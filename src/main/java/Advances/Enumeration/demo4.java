package Advances.Enumeration;

// https://walkonnet.com/archives/8013
// https://www.runoob.com/java/java-enum.html

import org.junit.jupiter.api.Test;

public class demo4 {

  @Test
  public void test1() {

    Color1 c1 = Color1.RED;
    System.out.println(">>> c1 = " + c1);

    for (Color1 c : Color1.values()) {
      System.out.println(">>> c.name = " + c.name + " c.index = " + c.index);
    }
  }

  @Test
  public void test2() {

    for (Car c : Car.values()) {
      System.out.println(">>> c.nominalName = " + c.nominalName + " c.name = " + c.name);
    }
  }

  /** values(), ordinal(), and valueOf() demo */
  @Test
  public void test3() {

    Car[] arr = Car.values();

    for (Car c : arr) {
      System.out.println(">>> c = " + c);
    }

    // get enum val via valueOf(), if key not existed, throw IllegalArgumentException
    System.out.println(Car.valueOf("Benz"));
    System.out.println(Car.valueOf("Bmw"));

    try {
      System.out.println(Car.valueOf("xx"));
    } catch (Exception e) {
      System.out.println("key not existed");
    }
  }

  public enum Color1 {
    RED("紅色", 1),
    GREEN("綠色", 2),
    BLANK("白色", 3),
    YELLOW("黃色", 4);

    // 成員變量
    private final String name;
    private final int index;

    // 構造方法
    Color1(String name, int index) {
      this.name = name;
      this.index = index;
    }

    // 覆蓋方法
    @Override
    public String toString() {
      return this.index + "_" + this.name;
    }
  }

  public enum Car {
    Benz("BENZ", "benz"),
    Bmw("BMW", "bmw"),
    Tesla("TESLA", "tesla");

    private final String nominalName;
    private final String name;

    Car(String nominalName, String name) {
      this.nominalName = nominalName;
      this.name = name;
    }

    @Override
    public String toString() {
      return this.nominalName + "-" + this.name;
    }
  }
}
