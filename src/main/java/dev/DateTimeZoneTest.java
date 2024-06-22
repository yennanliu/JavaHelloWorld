package dev;

// https://www.youtube.com/watch?v=I4d3hXQu7Dw&list=PLmOn9nNkQxJGVG1ktTV4SedFWuyef_Pi0&index=73

import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;

public class DateTimeZoneTest {

  @Test
  public void test1() {
    ZonedDateTime zbj = ZonedDateTime.now();
    System.out.println(zbj);
  }
}
