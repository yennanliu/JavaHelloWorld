package Advances.MapDemo;

// https://www.youtube.com/watch?v=ziY4_C8rxCg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=547
// https://www.youtube.com/watch?v=9UZEcCqhdI0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=548
// https://www.youtube.com/watch?v=pY4TlufD8aE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=549
// https://www.youtube.com/watch?v=lI08A3nYviM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=550
// https://www.youtube.com/watch?v=y-MDDtzyjKE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=552
// https://www.youtube.com/watch?v=8_yeocWxCqU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=553

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Map demo 1 : concepts, properties */

/**
 * Map : double array data structure -> key-value record
 *
 * <p>Structure :
 *
 * <p>/--- Map /--- HashMap: as Map main implementation (class), used most often. Thread non-safety
 * (good performance). CAN save null value (key or value is null is OK) /--- LinkedHashMap : keep
 * same ordering (as adding) when looping. (via pointer (reference)). has better performance
 * (add/edit/add..) compared to HashMap /--- TreeMap : ordering by added key-value, loop by ordering
 * (natural/custom ordering). Low level storage : red-black tree /--- Hashtable: as "ancient" (old)
 * implementation (class). Thread safety (not good performance). CAN'T save null value /---
 * Properties : usuallt used as "config file". key, value are string type
 *
 * <p>1) Map is an interface. we need to implement this (for using) 2) Low level storage: - HashMap:
 * - array + linked list (before JDK 7) - array + linked list + red-black tree (after JDK 8)
 *
 * <p>3) CurrentHashMap VS Hashtable ? -> CurrentHashMap for high concurrency
 *
 * <p>4) Map - key : non-ordering, non-duplicated, storage by "Set" --> Map (HashMap) class needs to
 * overwrite equals(), and hashCode() methods - value : non-ordering, can duplicated, storage by
 * "Collection" --> class needs to overwrite equals() method - a key-value : form an "entry"
 * instance - "entry" in Map : non-ordering, non-duplicated, storage by "Set"
 *
 * <p>5) HashMap low level mechanisms - JDK 7 - HashMap map = new HashMap(); - (after instantiation,
 * it creates a length=16 1-d array[] table) - map.put(key1, value1); - step 1) use key1's class's
 * hashCode() method get key1's hash value, then get entry's address in storage space - step 2) if
 * nothing on the address -> add key1-value1 success -- case 1 if sth on the address -> one (e.g.
 * key2-value2) or multiples key-value there -> check if hashCode(key1) == hashCode(key2) -> if
 * false : add key1-value1 success -- case 2 -> if true -> use equals() compare key1 and key 2 -> if
 * equals() true : add key1-value1 success -- case 3 -> if equals() false : REPLACE value2 with
 * value1
 *
 * <p>(Linked list is being used in case2, case3) - extension : extend 2x times (VS original
 * capacity), and copy original data to new structure
 *
 * <p>- JDK 8 - HashMap map = new HashMap() - there is NOT a length=16 1-d array[] table) being
 * created - when first call put() method -> create a length=16 1-d array[] - low level structure :
 * array + Node[] + read-black tree, instead of Entry[] - if 1) a index has > 8 elements and 2)
 * current array length > 64 -> all elements on this index will being storage in red-black tree
 *
 * <p>6) LinkedHashMap : low level structure (concept only)
 *
 * <p>source code: static class Entry<K,V> extends HashMap.Node<K,V> { Entry<K,V> before, after; //
 * record added element ordering Entry(int hash, K key, V value, Node<K,V> next) { super(hash, key,
 * value, next); } } 7) .. plz check Advances.MapDemo.demo2.java
 */
public class demo1 {

  @Test
  public void test1() {
    /** demo : HashMap CAN save null value */
    // init HashMap
    Map map = new HashMap();
    // add record
    map.put(null, 123);
    map.put(null, null);
    map.put("a", 999);

    System.out.println(map);
  }

  @Test
  public void test2() {
    /** demo : Hashtable CAN'T save null value */
    Map map = new Hashtable();
    map.put(null, 123); // java.lang.NullPointerException
    map.put(null, null); // java.lang.NullPointerException
    map.put("a", 999);

    System.out.println(map);
  }

  @Test
  public void test3() {
    /** demo : LinkedHashMap */
    // Map map = new HashMap<>();
    Map map = new LinkedHashMap();

    map.put(123, "aa");
    map.put(456, "bb");
    map.put(789, "cc");

    System.out.println(map); // LinkedHashMap can save elements in order
  }
}
