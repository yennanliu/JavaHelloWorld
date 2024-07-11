package Advances.DateTimeApi;

// https://www.youtube.com/watch?v=Zbr_gOK-3Go&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=480

/** DateTimeApi demo3 : String -> java.sql.Date (transform "2021-01-01" to java.sql.Date) */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class demo3 {

  @Test
  public void test1() throws ParseException {

    // transform "2021-01-01" to java.sql.Date
    String str1 = "2021-01-01";
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    Date parsed_str1 = sdf1.parse(str1);

    System.out.println(parsed_str1); // Fri Jan 01 00:00:00 CST 2021

    // but what we want it java.sql.Date, so
    java.sql.Date sql_date_str1 = new java.sql.Date(parsed_str1.getTime());

    System.out.println(sql_date_str1); // 2021-01-01
  }
}
