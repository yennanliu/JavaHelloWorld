package dev;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import utils.DateTimeUtils;

public class DateTimeUtilsTest {

  @Test
  public void test1(){

    String yesterday = DateTimeUtils.getNDayBeforeDate(1);
    System.out.println("yesterday = " + yesterday);

    // https://stackoverflow.com/questions/7488643/how-to-convert-comma-separated-string-to-list
    List<String> x = Arrays.asList(yesterday.split("-"));
    String y = x.get(0) + "-" + x.get(1) + "-" + "01";
    System.out.println("y = " + y);
  }

}
