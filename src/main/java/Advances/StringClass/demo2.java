package Advances.StringClass;

// // https://www.youtube.com/watch?v=aAKyixOtfYc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=452

import org.junit.jupiter.api.Test;

/**
 *  String class demo 2 : string instantiate example
 *
 *  method 1) via literal:
 *      - String str1 = "abc;
 *
 *  method 2) via new + constructor:
 *      - String str2 = new String("abc");
 */

public class demo2 {
    /**
     *
     *
     *
     *
     */
    @Test
    public void test2(){

        // method 1) via literal:
        // s1, s2 are defined in java's string constant pool
        String s1 = "scala";
        String s2 = "scala";

        // method 2) via new + constructor:
        // s3, s3 are defined in address in java's stack space
        String s3 = new String("scala");
        String s4 = new String("scala");


        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); // false
        System.out.println(s3 == s4); // false

        System.out.println("===============");


        // equals `this.value = new char[0];`
        String s1_ = new String();

        // this.value = original.value;
        String str = "helo";
        String s2_ = new String(str); // (String str);

        // this.value = Arrays.copyOf(value, value.length);
        //String s3 = new String(char[] a);

        //String s4 = new String(char[] a, int startIndex, int count);
    }
}
