package Advances.MapDemo;

// https://www.youtube.com/watch?v=ziY4_C8rxCg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=547

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/** Map demo 1 */

/**
 *   Map : double array data structure -> key-value record
 *
 *   Structure :
 *
 *     /--- Map
 *       /--- HashMap: as Map main implementation (class), used most often. Thread non-safety (good performance). CAN save null value (key or value is null is OK)
 *          /--- LinkedHashMap : keep same ordering (as adding) when looping. (via pointer (reference)). has better performance (add/edit/add..) compared to HashMap
 *       /--- TreeMap : ordering by added key-value, loop by ordering (natural/custom ordering). Low level storage : red-black tree
 *       /--- Hashtable: as "ancient" (old) implementation (class). Thread safety  (not good performance).  CAN'T save null value
 *          /--- Properties : usuallt used as "config file". key, value are string type
 *
 *   1) Map is an interface. we need to implement this (for using)
 *   2) Low level storage:
 *      - HashMap:
 *          - array + linked list (before JDK 7)
 *          - array + linked list + red-black tree (after JDK 8)
 *
 */

public class demo1 {

    @Test
    public void test1(){
        /** demo : HashMap CAN save null value */
        // init HashMap
        Map map = new HashMap();
        // add record
        map.put(null, 123);
        map.put(null, null);
        map.put("a",999);

        System.out.println(map);
    }

    @Test
    public void test2(){
        /** demo : Hashtable CAN'T save null value */
        Map map = new Hashtable();
        map.put(null, 123);  // java.lang.NullPointerException
        map.put(null, null); // java.lang.NullPointerException
        map.put("a",999);

        System.out.println(map);
    }
}
