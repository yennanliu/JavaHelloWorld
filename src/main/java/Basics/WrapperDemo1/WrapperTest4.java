package Basics.WrapperDemo1;

// https://www.youtube.com/watch?v=OcfbUF_WmtA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=306

import org.junit.jupiter.api.Test;

public class WrapperTest4 {
  /** basic type, wrapper -> String class */
  @Test
  public void test() {

    int num1 = 10;

    // method 1 (concatenation)
    String str1 = num1 + "";

    // method 2 (String's valueOf)
    float f1 = 12.3f;
    String str2 = String.valueOf(f1);

    Double d1 = new Double(12.34);
    String str3 = String.valueOf(d1);
  }

  /** String class -> basic type, wrapper */
  @Test
  public void test2() {
    String str1 = "123";
    // below are wrong
    // int num1 = (int) str1;
    // Integer in1 = (Integer) str1;

    // method 1 (parseInt)
    int num2 = Integer.parseInt(str1);
    System.out.println(num2 + 1);

    String str2 = "true";
    Boolean b1 = Boolean.parseBoolean(str2);
    System.out.println(b1);
  }
}
