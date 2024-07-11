package dev;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class TimeStampTest {

  @Test
  public void test1() {

    long unixTimeNow = (System.currentTimeMillis()) / 1000L;

    System.out.println(">>> unixTimeNow = " + unixTimeNow);
  }

  @Test
  public void test2() {

    long DAY_IN_MS = 1000 * 60 * 60 * 24;
    long unixTimeThreeDaysAgo = (System.currentTimeMillis() - (3 * DAY_IN_MS)) / 1000L;
    long unixTimeTenMinAgo = (System.currentTimeMillis() - (1000 * 60)) / 1000L;

    System.out.println(">>> unixTimeThreeDaysAgo = " + unixTimeThreeDaysAgo);
    System.out.println(">>> unixTimeTenMinAgo = " + unixTimeTenMinAgo);
  }

  @Test
  public void test3() {

    // https://www.javatpoint.com/java-get-current-date
    // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    System.out.println(formatter.format(date));
  }
}
