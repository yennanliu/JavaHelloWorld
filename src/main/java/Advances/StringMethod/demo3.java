package Advances.StringMethod;

// https://www.youtube.com/watch?v=UY2QlCZzPgs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=458

import org.junit.jupiter.api.Test;

public class demo3 {

    @Test
    public void test1(){

        String s1 = "london tokyo new-york";

        System.out.println(s1.replace("new", "old"));

        System.out.println("================");

        String s2 = "32432432 dffsfg 3454312133 dvfd5436t5436 ???";

        // \\d+ : find all `digits`
        System.out.println(s2.replaceAll("\\d+", ","));  // , dffsfg , dvfd,t, ???

        // "^,|,$"
        //       -> ^, : find `,` at beginning
        //       -> ,$ : find `,` at the end
        System.out.println(s2.replaceAll("\\d+", ",").replaceAll("^,|,$", "")); //  dffsfg , dvfd,t, ???

        System.out.println("================");

        String s3 = "0900123123";

        // check if elements in s3 are all digits
        System.out.println(s3.matches("\\d+")); // true

        System.out.println("================");

        String s4 = "0900-1231234";

        // check if
        //   1) s3 starts from `0900-`
        //   2) there are ~ 7 or 8 digits after `-` in s4
        System.out.println(s4.matches("0900-\\d{7,8}")); // true

        System.out.println(s4.matches("0900-\\d{5,6}")); // false

        System.out.println("================");

        String s5 = "hello|world|scala";

        // split by `|`
        String[] array5_ = s5.split("\\|");

        for (int i = 0; i < array5_.length; i++){
            System.out.println(array5_[i]);
        }

        System.out.println("================");

        String s6 = "hello.world.scala";

        // split by `.`
        String[] array6_ = s6.split("\\.");

        for (int i=0; i < array6_.length; i ++){
            System.out.println(array6_[i]);
        }
    }
}
