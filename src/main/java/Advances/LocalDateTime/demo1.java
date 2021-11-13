package Advances.LocalDateTime;

// https://www.youtube.com/watch?v=8qumOKGQ7PA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=484

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * LocalDate, LocalTime, LocalDateTime demo 1
 *
 *   1) LocalDateTime used more often than LocalDate, LocalDateTime
 *
 *   2) LocalDate, LocalTime, LocalDateTime are UNCHANGEABLE
 *
 *   3) similar to Calendar class
 */

public class demo1 {
    @Test
    public void test1(){
        // now() : get current date, time, or date+time
        LocalDate localDate = LocalDate.now();
        LocalTime localTime =  LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        System.out.println("--------------------");

        // of() : we can define year, month, day... WITHOUT OFFSET
        LocalDateTime localDateTime1 = LocalDateTime.of(2021,01,01,00,10,10);

        System.out.println(localDateTime1);

        System.out.println("--------------------");

        // getXXX()
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getDayOfMonth());

        System.out.println("--------------------");

        // with()
        //  LocalDate, LocalTime, LocalDateTime are UNCHANGEABLE
        System.out.println(localDateTime.getDayOfMonth());
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime2.getDayOfMonth());

        System.out.println("--------------------");

        // plus()
        // UNCHANGEABLE
        System.out.println(localDateTime);
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime3);

        System.out.println("--------------------");

        // minus
        // UNCHANGEABLE
        System.out.println(localDateTime);
        LocalDateTime localDateTime4 = localDateTime.minusMonths(3);
        System.out.println(localDateTime4);
    }
}
