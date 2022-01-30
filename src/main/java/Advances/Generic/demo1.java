package Advances.Generic;

// https://www.youtube.com/watch?v=FIta2Jr0EVQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=564
// https://www.youtube.com/watch?v=iwh5wKKp3rs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=565
// https://www.youtube.com/watch?v=kRiy9mS2B9A&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=567

/**
 *   Generic demo 1
 *
 *     1) since JDK 5.0
 *
 *     2) use Generic in collections
 *        -> 2.1) Interface are all in "Generic version" since JDK 5.0
 *        -> 2.2) we can define generic type when initialize collection class
 *        -> 2.3) after initialize class with generic type,
 *                -> ALL internal structure/val are with SAME generic type
 *                -> w.g.  add(E e) --initialize--> add (Integer e)
 *        -> 2.4) Generic type myst be a "Class" (can't use basic type (e.g. int, float))
 *        -> 2.5) if NOT use generic when initialize, will use default type : java.Lang.Object
 *
 *     3) define custom generic type
 *        -> 2.1) generic class, generic interface, generic method
 *        -> Advances.Generic.demo3.java
 *
 *     4) generic type CAN'T be used in static class
 *          - but generic type CAN be used in static method
 *          - copyFromArrayList method in Advances.Generic.Order class
 *     5) generic type CAN'T be used in exception class
 */

import org.junit.jupiter.api.Test;

import java.util.*;

public class demo1 {
    @Test
    public void test1(){
        ArrayList list1 = new ArrayList();

        list1.add(10);
        list1.add(75);
        list1.add(87);
        //list1.add("tom"); // problem 1 : type unsafe

        for (Object score: list1){
            // problem 2 : java.lang.ClassCastException may happen when Downcasting
            //          -> e.g. :java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
            int stuScore = (Integer) score;
            System.out.println(score);
        }
    }

    /** Generic demo 1 */
    @Test
    public void test2(){
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        //ArrayList list1 = new ArrayList<int>(); // can't use "basic type" as generic. e.g. : Type argument cannot be of primitive type

        list1.add(10);
        list1.add(75);
        list1.add(87);
        //list1.add("tom"); // this one can't even pass compile, since we already used generic type ( ArrayList<Integer> list1 = new ArrayList<Integer>();)

        // loop 1
        for (Object score: list1){
            // Downcasting is not needed anymore
            //int stuScore = (Integer) score;
            System.out.println(score);
        }

        System.out.println("==================");

        // loop2
        Iterator<Integer> iterator1 =  list1.iterator();
        while (iterator1.hasNext()){
            int stuScore = iterator1.next();
            System.out.println(stuScore);
        }
    }

    @Test
    public void test3(){
        Map<String,Integer> map1 = new HashMap<String,Integer>();

        map1.put("a",123);
        map1.put("b",777);
        map1.put("c",544);
        map1.put("d",665);

        // loop1
        // Map's entry is <Map.Entry<String,Integer>> type
        Set <Map.Entry<String,Integer>> entry1 = map1.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator1 = entry1.iterator();
        while (iterator1.hasNext()){
            Map.Entry<String,Integer> e =  iterator1.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "----> " + value);
        }
    }
}
