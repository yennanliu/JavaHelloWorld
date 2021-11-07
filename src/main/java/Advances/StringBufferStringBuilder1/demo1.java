package Advances.StringBufferStringBuilder1;

// https://www.youtube.com/watch?v=dLw2jCYcET8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=464
// https://www.youtube.com/watch?v=jJkIgazP6ok&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=466
// https://www.youtube.com/watch?v=H9iLq_2ctYY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=467

/**
 *  StringBuffer and StringBuilder : demo1
 *      - diff between String, StringBuffer, and StringBuilder
 *      - common methods in SpringBuffer / SpringBuilder
 */

import org.junit.jupiter.api.Test;

public class demo1 {

    /**
     *  1) String, StringBuffer, StringBuilder same and difference :
     *
     *   String :
     *      - unchangeable array
     *      - underline storage : char[]
     *
     *   StringBuffer :
     *      - changeable array
     *      - since jdk 1.0
     *      - thread safety (methods are with `synchronized`)
     *      - low efficiency
     *      - underline storage : char[]
     *
     *   StringBuilder :
     *      - changeable array
     *      - since jdk 1.5
     *      - thread un-safety (methods without `synchronized`)
     *      - good efficiency
     *      - underline storage : char[]
     *
     *   2) Source code analysis:
     *
     *      // string
     *      String str = new String(); // underline : new char[0];
     *      String str1 = new String("abc"); // underline : new char[]{'a','b','c'};
     *
     *      // StringBuffer
     *      StringBuffer sb1 = new StringBuffer(); // underline (create a length = 16 char array) : char[] value = new char[16];
     *      sb1.append('a'); // underline : value[0] = 'a';
     *      sb1.append('b'); // underline : value[1] = 'a';
     *
     *      StringBuffer sb2 = new StringBuffer("abc"); // underline (create a length = 16 + "abc".length() char array)  : char[] value = new char["abc".length() + 16];
     *
     *   3) Questions:
     *      3-1) size ?
     *       System.out.println(sb2.length()); // 0
     *       System.out.println(sb2.length()); // 3
     *
     *      3-2) extension ?
     *       -> StringBuffer:
     *          if StringBuffer can't storage new values, we need to expand it
     *          by default, size will be expanded to "2 times + 2" ( e.g. : size += (size + 2) )
     *
     *       -> better to use StringBuffer(int capacity) when dev
     *          avoid extension op which would affect performance, use extra memory
     *
     *   4) Performance:
     *      - StringBuilder > StringBuffer > String
     */
    @Test
    public void test1(){
        StringBuffer str1 = new StringBuffer("abc");
        System.out.println(str1);

        str1.setCharAt(0,'x');
        System.out.println(str1);

        System.out.println("=================");

        StringBuffer sb1 = new StringBuffer();
        System.out.println(sb1.length());
    }

    // common methods in SpringBuffer / SpringBuilder
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("");
        StringBuffer s2 = new StringBuffer("abcde");

        // append
        System.out.println(s1.append(s2));
        System.out.println(s1.append(1));
        System.out.println(s1.append('1'));

        System.out.println("=================");

        // delete
        StringBuffer s3 = new StringBuffer("abcde");

        System.out.println(s3.delete(0,1));
        System.out.println(s3.delete(0,2));
        System.out.println(s3.delete(1,2));

        System.out.println("=================");

        // replace
        StringBuffer s4 = new StringBuffer("hello");
        System.out.println(s4.replace(0,1,"x"));

        System.out.println("=================");

        // insert
        StringBuffer s5 = new StringBuffer("hello");
        System.out.println(s5.insert(0,"!!!"));

        System.out.println("=================");

        // reverse
        StringBuffer s6 = new StringBuffer("hello");
        System.out.println(s6.reverse());

        System.out.println("=================");

        // indexOf
        StringBuffer s7 = new StringBuffer("hello");
        System.out.println(s7.indexOf("e"));

        System.out.println("=================");

        // substring
        StringBuffer s8 = new StringBuffer("hello");
        System.out.println(s8.substring(1,3));
    }
}
