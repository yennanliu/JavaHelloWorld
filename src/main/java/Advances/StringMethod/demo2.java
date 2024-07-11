package Advances.StringMethod;

// https://www.youtube.com/watch?v=sfxWtpR6T7s&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=457

import org.junit.jupiter.api.Test;

public class demo2 {

  @Test
  public void test1() {

    String str1 = "hello-world";

    System.out.println(str1.endsWith("d"));
    System.out.println(str1.endsWith("rld"));
    System.out.println(str1.endsWith("x"));

    System.out.println("================");

    System.out.println(str1.startsWith("h"));
    System.out.println(str1.startsWith("hel"));
    System.out.println(str1.startsWith("x"));

    System.out.println("================");

    System.out.println(str1.startsWith("h"));
    System.out.println(str1.startsWith("h", 1));

    System.out.println("================");

    String str2 = "wo";

    System.out.println(str1.contains(str2));

    System.out.println("================");

    System.out.println(str1.indexOf("ll")); // 2
    System.out.println(str1.indexOf("x")); // -1

    System.out.println("================");

    System.out.println(str1.indexOf("ll")); // 2
    System.out.println(str1.indexOf("ll", 3)); // -1

    System.out.println("================");

    System.out.println(str1.lastIndexOf("ll", 0)); // -1
    System.out.println(str1.lastIndexOf("ll", 9)); // 2
  }
}
