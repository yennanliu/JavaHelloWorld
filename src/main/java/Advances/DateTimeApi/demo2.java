package Advances.DateTimeApi;

// https://www.youtube.com/watch?v=H9gTaWyWwig&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=479

/**
 * DateTimeApi demo2 : DateTime API before JDK 8 - class - java.text.SimpleDateFormat - Calendar
 * -method - format - parse
 */
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo2 {

  /**
   * java.text.SimpleDateFormat - format and parse on the Date instance
   *
   * <p>1) 2 op - format : dateTime --> string - parse : string --> dateTime
   *
   * <p>2) instantiate java.text.SimpleDateFormat
   */
  @Test
  public void test1()
      throws
          ParseException { // we need this ParseException, since defined format/parse pattern may be
    // wrong
    // instantiation
    SimpleDateFormat sdf = new SimpleDateFormat();

    // format : dateTime --> string
    Date d1 = new Date();
    System.out.println(d1); // Sun Nov 07 09:06:52 CST 2021

    String f1 = sdf.format(d1);
    System.out.println(f1); // 11/7/21, 9:06 AM

    System.out.println("================");

    // parse  : string --> dateTime
    // String str1 = "2021-11-01"; // wrong, java.text.ParseException: Unparseable date:
    // "2021-11-01"
    String str1 = "11/7/21, 9:06 AM"; // correct, default format
    Date parsed_d1 = sdf.parse(str1); // Sun Nov 07 09:06:00 CST 2021
    System.out.println(parsed_d1);

    System.out.println("================");

    // NOT use default constructor, but with pattern
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    String str2 = "2021-11-01";
    Date parsed_d2 = sdf2.parse(str2);
    System.out.println(parsed_d2); // Mon Nov 01 00:00:00 CST 2021

    System.out.println("================");

    // NOT use default constructor, but with pattern
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String str3 = "2021-11-01 01:01:01";
    Date parsed_d3 = sdf3.parse(str3);
    System.out.println(parsed_d3); // Mon Nov 01 01:01:01 CST 2021

    System.out.println("================");

    // parse
    Date sdf2_date = sdf2.parse("2021-11-01"); // Date type
    System.out.println(sdf2_date);
  }
}
