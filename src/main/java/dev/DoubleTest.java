package dev;

import org.junit.jupiter.api.Test;

public class DoubleTest {

  @Test
  public void test1(){

    Double d1 = 1.001;
    Double d2 = 3.14;

    System.out.println(d1 > d2);

    String s1 = "1.001";
    String s2 = " 3.14";
    System.out.println(Double.parseDouble(s1) - Double.parseDouble(s2));
    System.out.println(Double.parseDouble(s1) > Double.parseDouble(s2));
  }


}
