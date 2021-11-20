package Advances.ComparableComparator;

// https://www.youtube.com/watch?v=n3xOIVricqQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=490
// https://www.youtube.com/watch?v=iCKc2-vslbg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=491

/**
 *  Comparable Comparator demo1
 *
 *  1) default in Java, we can only do `==` or `!=`, but not `>` or `<`.
 *     . However, in some cases, we need to ordering (compare) the instances.
 *     -> `Comparable`, and `Comparator` are the interface for that
 *
 *  2) Comparable interface demo (natural ordering)
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
 *
 *    2-4) For user-defined class, if we need to ordering it,
 *        -> we need to implement Comparable interface, override compareTo(obj) method
 *        -> we need to implement  `how to sorting` logic in compareTo(obj)
 *
 *  3) Comparator interface
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class demo1 {
    @Test
    public void demo1(){

        /** Ordering string array */
        String[] arr1 = new String[]{"dd","aa","cc","bb"};
        Arrays.sort(arr1);

        System.out.println(Arrays.toString(arr1)); // [aa, bb, cc, dd]
    }

    @Test
    public void demo2(){
        /** Ordering customized class (Goods class) (Advances.ComparableComparator.Goods.java) */
        Goods[]arr = new Goods[4];
        arr[0] = new Goods("iphone", 1000);
        arr[1] = new Goods("pixel", 800);
        arr[2] = new Goods("x11", 200);
        arr[3] = new Goods("samsung", 100);

        System.out.println(Arrays.toString(arr)); // [Good{name='iphone', price=1000.0}, Good{name='pixel', price=800.0}, Good{name='x11', price=200.0}, Good{name='samsung', price=100.0}]

        // sort
        // will case `java.lang.ClassCastException: class Advances.ComparableComparator.Goods cannot be cast to class java.lang.Comparable (Advances.ComparableComparator.Goods is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')` error
        // if not implement Comparable or Comparator
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr)); // [Good{name='samsung', price=100.0}, Good{name='x11', price=200.0}, Good{name='pixel', price=800.0}, Good{name='iphone', price=1000.0}]
    }
}
