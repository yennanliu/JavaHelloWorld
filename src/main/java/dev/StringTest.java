package dev;

import java.text.DecimalFormat;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class StringTest {
  public static void main(String[] args) {

    String s3Link = "s3://my-bucket/my-task/yyyy/2022-08-04/zz/202208040145.zip";
    String[] l1 = s3Link.split("/");
    Arrays.stream(l1).forEach(x -> System.out.println(x));

    System.out.println("==============");
    String[] l2 = s3Link.split("my-task");
    Arrays.stream(l2).forEach(x -> System.out.println(x));

    System.out.println(">>> " + "/" + l1[2] + l2[1]);

    System.out.println("==============");

    System.out.println(l1[2]);

    // https://stackoverflow.com/questions/39860739/how-to-get-first-and-last-element-in-an-array-in-java
    // Array of doubles
    double[] array_doubles = {2.5, 6.2, 8.2, 4846.354, 9.6};

    // First position
    double firstNum = array_doubles[0]; // 2.5
  }

  @Test
  public void test2() {

    String s3Link =
        "s3://xxx/data-download-task/zzz/2022-08-19/41a10b1e-1f5e-11ed-92e6-0617fbf35557/202208190128.zip";
    String s3CSVBucket = s3Link.split("/")[2];
    String s3CSVPath = "data-download-task" + s3Link.split("data-download-task")[1];

    System.out.println(">>> s3Link = " + s3Link);
    System.out.println(">>> s3CSVBucket = " + s3CSVBucket);
    System.out.println(">>> s3CSVPath = " + s3CSVPath);
  }

  @Test
  public void test3() {

    String s3Link = "";
    String s3LinkCleaned = s3Link.split("\\\\?X-Amz")[0].replace("?", "");
    String s3CSVBucket = s3LinkCleaned.split("/")[2].replace(".s3.amazonaws.com", "");
    String s3CSVPath = "data-download-task" + s3LinkCleaned.split("data-download-task")[1];

    System.out.println(">>> s3Link = " + s3Link);
    System.out.println(">>> s3LinkCleaned = " + s3LinkCleaned);
    System.out.println(">>> s3CSVBucket = " + s3CSVBucket);
    System.out.println(">>> s3CSVPath = " + s3CSVPath);
  }

  @Test
  public void test4() {

    String param = "";
    System.out.println(param);
    System.out.println(param.split("majorUserId")[0]);
    System.out.println(param.split("majorUserId")[1]);
    System.out.println(
        param
            .split("majorUserId")[1]
            .split(",")[0]
            .replace("[", "")
            .replace("]", "")
            .replaceAll("\"", "")
            .replace(":", ""));

    System.out.println(
        Long.parseLong(
            param
                .split("majorUserId")[1]
                .split(",")[0]
                .replace("[", "")
                .replace("]", "")
                .replaceAll("\"", "")
                .replace(":", "")));
  }

  @Test
  public void test5() {

    String id = "000";
    System.out.println(Long.parseLong(id));
  }

  @Test
  public void test6() {
    String[] data = new String[] {"a", "b", "c"};
    System.out.println(data);
    Arrays.stream(data).forEach(x -> System.out.println(x));

    System.out.println();

    String[] data2 = new String[] {"a", "b", "c", "", "d", "e", "f", "g"};
    Arrays.stream(data2).filter(x -> x.length() > 0).forEach(x -> System.out.println(x));

    String[] data3 = new String[] {"a", "b", "c", "", "d", null, "e", "f", "g", null};
    // TODO : do same on data3
  }

  @Test
  public void test7() {
    String snapShotUTC = null;
    snapShotUTC.replace(" ", " 23:59:59 ");
  }

  @Test
  public void test8() {
    String snapShotUTC = "";
    snapShotUTC.replace(" ", " 23:59:59 ");
  }

  @Test
  public void test9() {
    String x = "Account s";
    String y = "v_account_s";

    String x_1 = "v" + x.toLowerCase().replace(" ", "_");
    System.out.println("x_1 = " + x_1);

    System.out.println(y.contains(x_1.toLowerCase()));
  }

  @Test
  public void test10() {
    String x = "xxxx";

    String[] x_ = x.split("\\?");
    System.out.println(x_[0]);
    System.out.println(x_[1]);
    System.out.println(x_.length);
    System.out.println(x.contains("?"));

    System.out.println();

    String x2 = x.replaceAll("^[!@#?\\$%\\^\\&*\\)\\(+=._-]", "");
    System.out.println(x2);

    System.out.println();

    String y = "wdvever";
    String[] y_ = y.split("\\?");
    System.out.println(y_[0]);
    //        System.out.println(y_[1]);
    System.out.println(y.contains("?"));
  }

  @Test
  public void test11() {

    // https://www.delftstack.com/zh-tw/howto/java/how-to-print-a-float-with-2-decimal-places-in-java/

    float Pi = 3.1415f;
    System.out.println(Pi);
    // Get only 2 decimal points
    System.out.printf("%.2f", Pi);

    System.out.println("------------");

    float Pi2 = 3.1415f;
    System.out.println(Pi2);
    // Get only 2 decimal points
    String str = String.format("%.02f", Pi2);
    Pi2 = Float.valueOf(str);
    System.out.println(Pi2);
  }

  @Test
  public void test12() {

    // https://www.delftstack.com/zh-tw/howto/java/how-to-round-a-double-to-two-decimal-places-in-java/

    double val1 = 6482.236789;
    System.out.println("Double value: " + val1);

    DecimalFormat df = new DecimalFormat("###.##");
    System.out.println("Rounded Double value (DecimalFormat): " + df.format(val1));

    String val2 = df.format(val1);
    System.out.println("val2 = " + val2);

    String val1_ = "6482.236789";
    String val2_ = df.format(Double.parseDouble(val1_));
    System.out.println("val2_ = " + val2_);
  }

  @Test
  public void test13() {

    // String fileName = "xxx.pdf";
    String fileName = "xxx.csv";
    String fileNameUpdated = fileName.replace("pdf", "zip");
    System.out.println(fileNameUpdated);
  }

  @Test
  public void test14() {

    String x = "abc";
    String msg =
        String.valueOf(new StringBuffer().append("123").append(" >>>>").append(" x = ").append(x));

    System.out.println(">>> msg = " + msg);
  }

  @Test
  public void test15() {

    // https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
    // https://stackoverflow.com/questions/20774951/bigdecimal-string-formatting-with-thousands-separator
    DecimalFormat formatter1 = new DecimalFormat("###,###");

    String num1 = "10000000";
    String num1_ = formatter1.format(Double.parseDouble(num1));
    System.out.println("num1_ = " + num1_);

    String num2 = "100";
    String num2_ = formatter1.format(Double.parseDouble(num2));
    System.out.println("num2_ = " + num2_);

    //        String num3 = null;
    //        String num3_ = formatter1.format(Double.parseDouble(num3));
    //        System.out.println("num3_ = " + num3_);

    String num4 = "10000000.001";
    String num4_ = formatter1.format(Double.parseDouble(num4));
    System.out.println("num4_ = " + num4_);

    DecimalFormat formatter2 = new DecimalFormat("###,###.###");

    String num4_2 = formatter2.format(Double.parseDouble(num4));
    System.out.println("num4_2 = " + num4_2);

    String num5 = "0.001";
    String num5_2 = formatter2.format(Double.parseDouble(num5));
    System.out.println("num5_2 = " + num5_2);

    String num6 = "10000";
    String num6_2 = formatter2.format(Double.parseDouble(num6));
    System.out.println("num6_2 = " + num6_2);
  }

  @Test
  public void test16() {
    Object x = null;
    // System.out.println(x.toString());
    System.out.println(x);

    Object y = "123";
    System.out.println(y);
  }

  @Test
  public void test17() {

    String url = "xxx";

    System.out.println(url);

    String[] x = url.split("\\\\?X-Amz");
    System.out.println(x.toString());
    System.out.println();
    // Arrays.stream(x).forEach(y -> System.out.println(y));

    String cleanedURL = x[0].replace("?", "");
    System.out.println(cleanedURL);

    System.out.println();
    String[] y = cleanedURL.split("/");
    Arrays.stream(y).forEach(k -> System.out.println(k));

    System.out.println("--> bucket = " + y[3]);
    System.out.println("--> bucket = " + cleanedURL.replace("//", "/").split("/")[2]);

    //        List<String> key = Arrays.stream(cleanedURL
    //            .replace("//", "/")
    //            .split("/")).collect(Collectors.toList());

    String text =
        "\"OR\\n\\nThe Central Site Engineering\\u2019s \\u201cfrontend\\u201d, where developers turn to\"";

    //        text = text.replaceAll("(\\\\n)+"," ")
    //            .replaceAll("\\\\u[0-9A-Ha-h]{4}", "");
    //
    //        System.out.println(text);

    String url_x =
        url.replaceAll("\\b.*?amazonaws.com.*?\\b", "")
            .split("X-Amz-Algorithm")[0]
            .replace("?", "");

    System.out.println("url_x = " + url_x);

    String url_y = url.split("pdf-download-task")[1].split("X-Amz-Algorithm")[0].replace("?", "");

    System.out.println("url_y  = " + url_y);
  }

  @Test
  public void test18() {
    String mystr = "xxx-portal-ttt.s3.ap-northeast-1.amazonaws.com";
    String[] x = mystr.split("\\.");
    System.out.println(x.length);
    System.out.println(x[0]);
  }
}
