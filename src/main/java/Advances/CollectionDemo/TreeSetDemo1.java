package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=8Wxnw17OpYs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=539

/** TreeSet demo 1 */

/**
 *  0) red-black tree as low level structure
 *
 *  1) CAN ONLY add SAME CLASS elements into TreeSet
 *
 *  2) 2 ordering types:
 *      - natural ordering
 *      - custom ordering
 *
 *  3) natural ordering :
 *      - compare if 2 elements are the same : "compareTo() method returns 0", not using "equals()" anymore
 *
 */

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo1 {
    @Test
    public void test1(){
        TreeSet set1 = new TreeSet();

    // can only add same class elements
    //        set1.add(123);
    //        set1.add(456);
    //        set1.add("abc");

        set1.add(123);
        set1.add(345);
        set1.add(7);
        set1.add(-107);

        Iterator iterator = set1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        TreeSet set1 = new TreeSet();

        set1.add(new User("zack", 99));
        set1.add(new User("kk", 10));
        set1.add(new User("jessy", 30));
        set1.add(new User("amy", 20));
        set1.add(new User("amy", 23));

        Iterator iterator = set1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
