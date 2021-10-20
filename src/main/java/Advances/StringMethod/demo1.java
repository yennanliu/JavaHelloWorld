package Advances.StringMethod;

// https://www.youtube.com/watch?v=K81mkUjimds&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=456

import org.junit.jupiter.api.Test;

public class demo1 {

    @Test
    public void test1(){
        String s1 = "helloword";
        String s1_ = "";

        // length of string
        System.out.println(s1.length());

        //*** charAt :  get string element by index
        System.out.println(s1.charAt(0)); // h
        System.out.println(s1.charAt(1)); // i

        System.out.println(s1.isEmpty()); // false
        System.out.println(s1_.isEmpty()); // true

        System.out.println(s1.toUpperCase());

        System.out.println("=================");

        String s3 = " he llowo rld ";

        // trim can remove blank at beginning and end of string
        System.out.println(s3.trim()); //he llowo rld
    }

    @Test
    public void test2(){
        String s1 = "HELLOWORLD";
        String s2 = "helloworld";

        System.out.println(s1.equals(s2));  // false
        System.out.println(s1.equalsIgnoreCase(s2)); // true

        String s3 = "123";
        String s4 = "ijk";

        System.out.println(s3.concat(s4)); // 123ijk
        System.out.println(s3 + s4);  // 123ijk

        String s5 = "abc";
        String s6 = "abd";

        // compareTo : compare each element in the string
        //            -> use case : string ordering
        System.out.println(s5.compareTo(s6)); // -1
        System.out.println(s5.compareTo(s5)); // 0

        String s7 = "tokyo japan";
        System.out.println(s7.substring(2)); // kyo japan
        System.out.println(s7.substring(6)); // japan
        // s7.substring(i,j) -> substring with index in [i,j)  (including i, not include j)
        System.out.println(s7.substring(3,6)); // yo
    }
}
