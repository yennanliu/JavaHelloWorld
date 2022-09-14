package dev;

// https://www.youtube.com/watch?v=I4d3hXQu7Dw&list=PLmOn9nNkQxJGVG1ktTV4SedFWuyef_Pi0&index=73

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

public class DateTimeZoneTest {

    @Test
    public void test1(){
        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println(zbj);
    }

}
