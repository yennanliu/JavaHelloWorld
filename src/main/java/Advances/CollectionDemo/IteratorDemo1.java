package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=HA7LSr6-xls&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=525

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *  Iterator Demo1
 *   -> collection iteration op, via Iterator interface
 *
 *   1) internal method : hasNext(), and next()
 *   2) collection will return an Iterator obj when every call on iterator()
 *      (default idx is on the previous element)
 *   3) remove() method can remove element within iteration
 *      -> NOTE : Iterator's remove() is DIFFERENT from default remove method
 */

public class IteratorDemo1 {

    @Test
    public void test1(){

        /** remove() method in Iterator class */

        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(789);
        col1.add("yooooo");
        col1.add(new String("kate"));
        col1.add(new Person("kyo", 19));

        Iterator iterator = col1.iterator();

        while (iterator.hasNext()){
            Object obj = iterator.next();
            if ("kate".equals(obj)){
                iterator.remove();
            }
        }

        System.out.println(col1);
    }

    @Test
    public void test2(){

    }
}
