package Advances.StringTransform;

// https://www.youtube.com/watch?v=n3c6H3FAJvs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=459

/**
 *   String class <---> other class Demo 1
 *
 *   1) String <--> Integer
 *   2) String <--> char[]
 */

import org.junit.jupiter.api.Test;

public class demo1 {

    /**
     *  (review)
     *  1) String -> basic data type, wrapper class (static method): parseXXX(str)
     *  2) basic data type, wrapper class -> String : String override valueOf(xxx)
     */
    @Test
    public void test1(){
        String str1 = "123";
        //int num = (int) str1;  // wrong
        int num1 = Integer.parseInt(str1);
        System.out.println(num1);

        System.out.println("================");

        String str1_ =  String.valueOf(num1);
        System.out.println(str1_);
    }

    /**
     *   String <---> char[]
     *   1) String --> char[] : String's toCharArray method
     *   2) char[] --> String : via String's constructor
     */
    @Test
    public void test2(){
        String s1 = "abc123";
        char[] charArray1 = s1.toCharArray();
        for (int i=0; i < charArray1.length; i++){
            System.out.println(charArray1[i]);
        }

        System.out.println("================");

        char[] arr2 = new char[]{'x','y','z'};
        String s2 = new String(arr2);
        System.out.println(s2);
    }
}
