package Basics.TimeZone;

import org.junit.jupiter.api.Test;

public class demo2 {

  @Test
  public void test1() {
    String tz = "GMT+0";
    System.out.println(tz);

    String val = tz.replaceAll("GMT", "").replaceAll("\\+-", "").replaceAll("\\++", "");

    System.out.println(Integer.valueOf(val));
  }
}
