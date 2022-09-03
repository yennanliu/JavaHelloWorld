package dev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


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
    public void test2(){

        String s3Link = "s3://xxx/data-download-task/zzz/2022-08-19/41a10b1e-1f5e-11ed-92e6-0617fbf35557/202208190128.zip";
        String s3CSVBucket = s3Link.split("/")[2];
        String s3CSVPath = "data-download-task" + s3Link.split("data-download-task")[1];

        System.out.println(">>> s3Link = "+ s3Link);
        System.out.println(">>> s3CSVBucket = "+ s3CSVBucket);
        System.out.println(">>> s3CSVPath = "+ s3CSVPath);

    }

    @Test
    public void test3(){

        String s3Link = "";
        String s3LinkCleaned = s3Link.split("\\\\?X-Amz")[0].replace("?", "");
        String s3CSVBucket = s3LinkCleaned.split("/")[2].replace(".s3.amazonaws.com", "");
        String s3CSVPath = "data-download-task" + s3LinkCleaned.split("data-download-task")[1];

        System.out.println(">>> s3Link = "+ s3Link);
        System.out.println(">>> s3LinkCleaned = "+ s3LinkCleaned);
        System.out.println(">>> s3CSVBucket = "+ s3CSVBucket);
        System.out.println(">>> s3CSVPath = "+ s3CSVPath);
    }

    @Test
    public void test4(){

        String param = "";
        System.out.println(param);
        System.out.println(param.split("majorUserId")[0]);
        System.out.println(param.split("majorUserId")[1]);
        System.out.println(
                param.split("majorUserId")[1].split(",")[0]
                      .replace("[","")
                      .replace("]","")
                      .replaceAll("\"","")
                      .replace(":","")
        );

        System.out.println(
                Long.parseLong(
                param.split("majorUserId")[1].split(",")[0]
                        .replace("[","")
                        .replace("]","")
                        .replaceAll("\"","")
                        .replace(":",""))
        );

    }

    @Test
    public void test5(){

        String id = "000";
        System.out.println(Long.parseLong(id));
    }

    @Test
    public void test6(){
        String[] data = new String[]{"a","b","c"};
        System.out.println(data);
        Arrays.stream(data).forEach(x -> System.out.println(x));

        System.out.println();

        String[] data2 = new String[]{"a","b","c","","d","e","f","g"};
        Arrays.stream(data2)
              .filter( x ->  x.length() > 0)
              .forEach(x -> System.out.println(x));

        String[] data3 = new String[]{"a","b","c","","d",null,"e","f","g", null};
        // TODO : do same on data3
    }

}
