package Advances.StringBufferStringBuilder1;

// https://www.youtube.com/watch?v=dLw2jCYcET8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=464

/**
 *  StringBuffer and StringBuilder : demo1
 */


import org.junit.jupiter.api.Test;

public class demo1 {

    /**
     *  1) String, StringBuffer, StringBuilder same and difference
     *
     *  String :
     *      - unchangeable array
     *      - underline storage : char[]
     *
     *  StringBuffer :
     *      - changeable array
     *      - since jdk 1.0
     *      - thready safety (methods are with `synchronized`)
     *      - low efficiency
     *      - underline storage : char[]
     *
     *  StringBuilder :
     *      - changeable array
     *      - since jdk 1.5
     *      - thready un-safety (methods without `synchronized`)
     *      - good efficiency
     *      - underline storage : char[]
     *
     *
     *   2)
     *
     *
     */
    @Test
    public void test1(){
        StringBuffer str1 = new StringBuffer("abc");
        System.out.println(str1);

        str1.setCharAt(0,'x');
        System.out.println(str1);

    }
}
