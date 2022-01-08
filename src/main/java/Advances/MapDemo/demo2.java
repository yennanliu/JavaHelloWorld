package Advances.MapDemo;

// https://www.youtube.com/watch?v=eCLnvAplhNI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=554

/** Map demo 2 : methods */

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *   Map : double array data structure -> key-value record
 *
 *    Structure : ....
 *
 *    1) ..
 *    2) ..
 *    plz check Advances.MapDemo.demo1.java
 *
 *
 *    7) Methods
 *      7-1) add, delete, modify
 *      7-2) find
 *      7-3) collection
 *
 *
 *
 *
 */

public class demo2 {
    /** add, delete, modify methods */
    @Test
    public void test1(){
        // init HashMap
        Map map = new HashMap();

        // add
        map.put(123,"aa");
        map.put(456,"bb");
        map.put("cc",789);

        System.out.println(map);

        // modify
        map.put("cc",101112);

        System.out.println(map);

        System.out.println("==================");

        // putAll
        Map map2 = new HashMap();
        map2.put("cc",123);
        map2.put("dd",123);
        map2.putAll(map);

        System.out.println(map2);

        // remove(Object key)
        Object value = map.remove("cc");
        System.out.println(value);
        System.out.println(map);

        Object value2 = map.remove("zzz");
        System.out.println(value2);

        System.out.println("==================");

        // clear
        map.clear(); // after op, map == {}
        System.out.println(map); // [}
        System.out.println(map.size()); // 0
    }

    @Test
    public void test2(){
        // init HashMap
        Map map = new HashMap();

        // add
        map.put(123,"aa");
        map.put(456,"bb");
        map.put("cc",789);

        System.out.println("==================");

        // get
        System.out.println(map.get("cc"));
        System.out.println(map.get("zz")); // null

        // containsKey
        System.out.println(map.containsKey("cc"));

        // containsValue
        System.out.println(map.containsValue(123));
    }
}
