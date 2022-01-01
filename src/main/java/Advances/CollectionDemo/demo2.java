package Advances.CollectionDemo;

/** Collection demo 2 */

// https://www.youtube.com/watch?v=WO-54GprY0M&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=519
// https://www.youtube.com/watch?v=hyj5uygJyLU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=520
// https://www.youtube.com/watch?v=hyj5uygJyLU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=520

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

    @Test
    public void test3(){

        /** remove */

        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add("yooooo");
        col1.add(new String("kate"));
        col1.add(new Person("kyo", 19));

        System.out.println(col1.remove(123));
        System.out.println(col1.remove(new Person("terry",10)));

    }

    @Test
    public void test4(){

        /** removeAll */
        Collection col1 = Arrays.asList(123,456);
        //col1.removeAll(col1);

        System.out.println(col1);
    }

    @Test
    public void test5(){

        /** retainAll : get overlap within collections */

        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add("yooooo");

        Collection col2 = Arrays.asList(123, 789,000);
        col1.retainAll(col2);

        System.out.println(col1);
    }

    @Test
    public void test6(){

        /** equals(Object obj) : check if two collections are equal */

        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add("yooooo");

        Collection col2 = new ArrayList();
        col2.add(123);
        col2.add(456);
        col2.add("yooooo");

        System.out.println(col1.equals(col2)); // true
    }

    @Test
    public void test7(){

        /** remove(Object obj) : remove obj element from current collection */

        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(789);
        col1.add("yooooo");
        col1.add(new String("kate"));
        col1.add(new Person("kyo", 19));

        col1.remove(123);
        System.out.println(col1);

        System.out.println("-----------------");

        col1.remove(new Person("kyo", 19));
        System.out.println(col1);

        System.out.println("-----------------");

        /** removeAll(collection col1) : remove all elements from current collection */

        Collection col2 = Arrays.asList(456, 789);
        col1.removeAll(col2);
        System.out.println(col1);
    }

    @Test
    public void test8(){

        /** retainAll : get overlap over 2 collections (in-place) */

        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(789);
        col1.add("yooooo");
        col1.add(new String("kate"));
        col1.add(new Person("kyo", 19));

        Collection col2 = Arrays.asList(456, 789);

        col1.retainAll(col2);

        System.out.println(col1);
    }

    @Test
    public void test9(){

        /** equals (Object obj) */

        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(789);
        col1.add("yooooo");
        col1.add(new String("kate"));
        col1.add(new Person("kyo", 19));

        Collection col2 = Arrays.asList(456, 789);
        Collection col3 = Arrays.asList(456, 789);
        Collection col4 = Arrays.asList(789, 456);

        System.out.println(col1.equals(col2)); // false
        System.out.println(col2.equals(col3)); // true
        System.out.println(col3.equals(col4)); // false !! (ArrayList is ordering)
    }
}
