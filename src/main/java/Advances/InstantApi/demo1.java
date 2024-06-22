package Advances.InstantApi;

// https://www.youtube.com/watch?v=Mhi4rGPlUwo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=485

/** InstantApi demo1 : -> similar as java.util.Date class */
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneOffset;

public class demo1 {
  @Test
  public void test1() {
    // Instant.now() : UTC 0 time
    Instant instant = Instant.now();
    System.out.println(instant); // 2021-11-20T00:38:42.302599Z (UTC 0)

    // atOffset(ZoneOffset.ofHours(offSetHour)) : can add hour offset
    System.out.println(
        instant.atOffset(ZoneOffset.ofHours(8))); // 2021-11-20T08:38:42.302599+08:00 (UTC 8)

    System.out.println("----------------------");

    // toEpochMilli() : get milliSecond since 1970/1/1 0 hr 0 min 0 sec
    System.out.println(instant.toEpochMilli());

    System.out.println("----------------------");

    // make Instant instance via milliSecond
    Instant instant1 = Instant.ofEpochMilli(1637368898598L);
    System.out.println(instant1);
  }
}
