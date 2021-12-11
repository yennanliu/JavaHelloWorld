package Advances.CollectionDemo;

/** Demo 2 */

// https://www.youtube.com/watch?v=WO-54GprY0M&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=519


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *  Collection interface method demo
 *
 *  1) if we add user-defined-class obj to Collection -> we need to override obj class' equals() method
 */



public class demo2 {

    @Test
    public void test1(){

        /** contains */

        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add("yooooo");
        col1.add(new String("kate"));
        Person p = new Person("tom", 20);
        col1.add(p);
        col1.add(new Person("kyo", 19));

        System.out.println(col1.contains(123));
        System.out.println(col1.contains(000));

        // Contains(Object obj) : check if current collections has obj
        // *** Will use obj class' `equals()` when check above
        // --> if needed, we can override obj class' `equals()`
        System.out.println(col1.contains(new String("kate"))); // true

        System.out.println(col1.contains(new Person("tom", 20))); // false (true : after override equals methods in Person class )
        System.out.println(col1.contains(p)); // true

        System.out.println(col1.contains(new Person("kyo", 19))); // false (true : after override equals methods in Person class )
    }

    @Test
    public void test2(){

        /** containsAll */

        Collection col1 = Arrays.asList(123,456);
        System.out.println(col1.containsAll(col1)); // true
    }
}
