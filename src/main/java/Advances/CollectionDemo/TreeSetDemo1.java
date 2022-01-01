package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=8Wxnw17OpYs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=539
// https://www.youtube.com/watch?v=SzLxAGZwnj4&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=540

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
 *  4) custom ordering :
 *      - compare if 2 elements are the same : "compare() method returns 0", not using "equals()" anymore
 *
 *
 *  5) Compare "comparision" in different classes:
 *     Set, HashSet :  hashCode(), equals()
 *     TreeSet : compareTo(), compare()
 *
 */

import org.junit.jupiter.api.Test;

import java.util.Comparator;
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

    @Test
    public void test3(){
        /** create custom Comparator (for custom ordering) */
        Comparator com = new Comparator() {
            // order by age (small -> big) (if same age, neglect)
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }else{
                    throw new RuntimeException("input type not match !");
                }
            }
        };

        /**
         *  without param -> natural ordering (e.g. TreeSet set1 = new TreeSet();)
         *  with param -> custom ordering (e.g. TreeSet set1 = new TreeSet(com);)
         */
        TreeSet set1 = new TreeSet(com);

        set1.add(new User("zack", 99));
        set1.add(new User("kk", 10));
        set1.add(new User("jessy", 30));
        set1.add(new User("amy", 20));
        set1.add(new User("amy", 23));
        set1.add(new User("betty", 23));

        Iterator iterator = set1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
