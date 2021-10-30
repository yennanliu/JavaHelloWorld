package Advances.StringTransform;

// https://www.youtube.com/watch?v=n3c6H3FAJvs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=459

/**
 *   String class <---> other class Demo 1
 *
 */

import org.junit.jupiter.api.Test;

public class demo1 {

    /**
     *  1) String -> basic data type, wrapper class (static method): parseXXX(str)
     *  2) basic data type, wrapper class -> String : String override valueOf(xxx)
     */
    @Test
    public void test1(){
        String str1 = "123";
        //int num = (int) str1;  // wrong
        int num1 = Integer.parseInt(str1);
        System.out.println(num1);

        String str1_ =  String.valueOf(num1);
        System.out.println(str1_);
    }
}
