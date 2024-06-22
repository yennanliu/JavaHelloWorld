package dev;

import org.junit.jupiter.api.Test;

public class DoubleTest {

  @Test
  public void test1() {

    Double d1 = 1.001;
    Double d2 = 3.14;

    System.out.println(d1 > d2);

    String s1 = "1.001";
    String s2 = " 3.14";
    System.out.println(Double.parseDouble(s1) - Double.parseDouble(s2));
    System.out.println(Double.parseDouble(s1) > Double.parseDouble(s2));
  }

  @Test
  public void test2() {

    String s1 = "0.00000000";
    double x = Double.parseDouble(s1);
    System.out.println(Double.parseDouble(s1));
    System.out.println(Double.parseDouble(s1) == 0.0);
    System.out.println(Double.parseDouble(s1) == 0);
  }

  @Test
  public void test3() {

    String s1 = "3.23432.00000000";
    // Double x = Double.parseDouble(s1);
    // System.out.println(Double.parseDouble(s1));
    // System.out.println(x);

    String s2 = "2499.55831700";
    System.out.println(Double.parseDouble(s2));
  }

  @Test
  public void test4() {

    String totalBUSD1 = "0.001";
    String totalBUSD2 = "0.231";

    Double diff = (Double.parseDouble(totalBUSD2) - Double.parseDouble(totalBUSD1));

    System.out.println((Float.parseFloat(totalBUSD1)));
    System.out.println((Double.parseDouble(totalBUSD2)));
    System.out.println((Double.parseDouble(totalBUSD2) - Double.parseDouble(totalBUSD1)));
    System.out.println(diff);
  }
}
