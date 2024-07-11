package Advances.StringTransform;

// https://www.youtube.com/watch?v=n3c6H3FAJvs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=459
// https://www.youtube.com/watch?v=c4RArt8F2KY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=460
// https://www.youtube.com/watch?v=c4RArt8F2KY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=461

/**
 * String class <---> other class Demo 1
 *
 * <p>1) String <--> Integer 2) String <--> char[] 3) String <--> byte[]
 */
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class demo1 {

  /**
   * String <--> Integer:
   *
   * <p>1) String -> basic data type, wrapper class (static method): parseXXX(str) 2) basic data
   * type, wrapper class -> String : String override valueOf(xxx)
   */
  @Test
  public void test1() {
    String str1 = "123";
    // int num = (int) str1;  // wrong
    int num1 = Integer.parseInt(str1);
    System.out.println(num1);

    System.out.println("================");

    String str1_ = String.valueOf(num1);
    System.out.println(str1_);
  }

  /**
   * String <---> char[]
   *
   * <p>1) String --> char[] : String's toCharArray method 2) char[] --> String : via String's
   * constructor
   */
  @Test
  public void test2() {
    String s1 = "abc123";
    char[] charArray1 = s1.toCharArray();
    for (int i = 0; i < charArray1.length; i++) {
      System.out.println(charArray1[i]);
    }

    System.out.println("================");

    char[] arr2 = new char[] {'x', 'y', 'z'};
    String s2 = new String(arr2);
    System.out.println(s2);
  }

  /**
   * String <--> byte[] 1) String -> byte[] : via String's getBytes() method
   *
   * <p>note: String --encode--> byte (binary code) byte --decode--> String
   */
  @Test
  public void test3() throws UnsupportedEncodingException {
    String str1 = "xyz123世界";
    byte[] bytes_1 = str1.getBytes(); // use default encode (e.g. utf-8)

    System.out.println(bytes_1);
    System.out.println(
        Arrays.toString(bytes_1)); // [120, 121, 122, 49, 50, 51, -28, -72, -106, -25, -107, -116]

    System.out.println("================");

    byte[] bytes_2 = str1.getBytes("gbk"); // use gbk encode

    System.out.println(bytes_2);
    System.out.println(Arrays.toString(bytes_2)); // [120, 121, 122, 49, 50, 51, -54, -64, -67, -25]

    System.out.println("================");

    String str2 = new String(bytes_1);
    System.out.println(str2); // xyz123世界

    // if encode with "gbk", then we also need to decode with "gbk", or decode can't work properly
    String str2_ = new String(bytes_2);
    System.out.println(str2_); // xyz123����

    String str3_ = new String(bytes_2, "gbk");
    System.out.println(str3_); // xyz123世界
  }
}
