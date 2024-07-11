package Advances.DateTimeFormatterApi;

// https://www.youtube.com/watch?v=L7v95dEtsd8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=485

/**
 * DateTimeFormatterApi
 *
 * <p>1) for date, time formatting, parsing 2) similar as simpleDateFormat 3) instantiation methods
 * 3-1) default : e.g. ISO_LOCAL_DATE_TIME, ISO_LOCAL_DATE 3-2) localization relative: e.g. :
 * ofLocalizeDateTime (FormatStyle.Long. FormatStyle.MEDIUM, FormatStyle.SHORT) 3-3) user-defined
 * (common usage) : e.g. : offPattern("yyyy-mm-dd")
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import org.junit.jupiter.api.Test;

public class demo1 {
  @Test
  public void test1() {

    /** 3-1) default : e.g. ISO_LOCAL_DATE_TIME, ISO_LOCAL_DATE */
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    // formatting : dateTime -> string
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime); // dateTime
    System.out.println(formatter.format(localDateTime)); // string

    System.out.println("=======================");

    // parse : string -> dateTime
    // NOTE : input string should fit formatter pattern (yyyy-mm-ddTzoneHr:mm:sec in this example)
    System.out.println(
        formatter.parse(
            "2021-11-20T08:58:06.391899")); // {},ISO resolved to 2021-11-20T08:58:06.391899
  }

  @Test
  public void test2() {

    /** 3-2) localization relative: e.g. : ofLocalizeDateTime (FormatStyle.Long) */
    DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
    LocalDateTime localDateTime = LocalDateTime.now();
    String str1 = formatter1.format(localDateTime);
    System.out.println(str1); // 11/20/21, 9:05 AM

    System.out.println("=======================");

    DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    String str2 = formatter2.format(LocalDate.now());
    System.out.println(str2); // Saturday, November 20, 2021
  }

  @Test
  public void test3() {

    /** 3-3) user-defined : e.g. : offPattern("yyyy-MM-dd") */
    DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String str3 = formatter3.format(LocalDate.now());
    System.out.println(str3); // 2021-11-20

    System.out.println("=======================");

    // parse
    TemporalAccessor parse1 = formatter3.parse("2021-01-01");
    System.out.println(parse1); // {},ISO resolved to 2021-01-01
  }
}
