package Advances.ComparableComparator;

// https://www.youtube.com/watch?v=n3xOIVricqQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=490

/**
 *  Comparable Comparator demo1
 *
 *  1) default in Java, we can only do `==` or `!=`, but not `>` or `<`.
 *     . However, in some cases, we need to ordering (compare) the instances.
 *     -> `Comparable`, and `Comparator` are the interface for that
 *
 *  2) Comparable interface
 *
 *  3) Comparator interface
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class demo1 {
    @Test
    public void demo1(){

        /**
         *
         *  2) Comparable interface demo
         *
         *    2-1) String implements Comparable interface, override compareTo() method
         *      -> so it can compare instances (> or <)
         *
         *    2-2) String, wrapper class' override compareTo()
         *      -> will return smallest -> biggest
         *
         *    2-3) String, wrapper class' override compareTo() rules:
         *      -> if current instance (this.xxx) > obj : return positive int
         *      -> if current instance (this.xxx) < obj : return negative int
         *      -> if current instance (this.xxx) < obj : return 0
         */
        String[] arr1 = new String[]{"dd","aa","cc","bb"};
        Arrays.sort(arr1);

        System.out.println(Arrays.toString(arr1)); // [aa, bb, cc, dd]
    }
}
