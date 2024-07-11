package Advances.MapDemo;

// https://www.youtube.com/watch?v=eCLnvAplhNI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=554
// https://www.youtube.com/watch?v=OmWTqukxSzU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=555

/** Map demo 2 : methods */
import java.util.*;
import org.junit.jupiter.api.Test;

/**
 * Map : double array data structure -> key-value record
 *
 * <p>Structure : ....
 *
 * <p>1) .. 2) .. plz check Advances.MapDemo.Hungry.java
 *
 * <p>7) Methods 7-1) add, remove, modify 7-1') put, get 7-2) find 7-3) source view op - keySet() -
 * valueSet() - Set entrySet
 */
public class demo2 {
  /** add, delete, modify methods */
  @Test
  public void test1() {
    // init HashMap
    Map map = new HashMap();

    // add
    map.put(123, "aa");
    map.put(456, "bb");
    map.put("cc", 789);

    System.out.println(map);

    // modify
    map.put("cc", 101112);

    System.out.println(map);

    System.out.println("==================");

    // putAll
    Map map2 = new HashMap();
    map2.put("cc", 123);
    map2.put("dd", 123);
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
  public void test2() {
    /** get, containsKey, containsValue methods */
    // init HashMap
    Map map = new HashMap();

    // add
    map.put(123, "aa");
    map.put(456, "bb");
    map.put("cc", 789);

    System.out.println("==================");

    // get
    System.out.println(map.get("cc"));
    System.out.println(map.get("zz")); // null

    // containsKey
    System.out.println(map.containsKey("cc"));

    // containsValue
    System.out.println(map.containsValue(123));
  }

  @Test
  public void test3() {
    /** keySet, valueSet, entrySet methods */
    // init HashMap
    Map map = new HashMap();

    // add
    map.put(123, "aa");
    map.put(456, "bb");
    map.put("cc", 789);

    // KeySet() : loop over all keys
    Set set = map.keySet();
    Iterator iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    System.out.println("==================");

    // valueSet() : loop over all value
    Collection values = map.values();
    for (Object obj : values) {
      System.out.println(obj);
    }

    System.out.println("==================");

    // entrySet() : loop over all key-value
    // method 1) : entrySet
    Set entrySet = map.entrySet();
    Iterator iterator1 = entrySet.iterator();
    while (iterator1.hasNext()) {
      Object obj = iterator1.next();
      // elements in entrySet collection are all entry
      Map.Entry entry = (Map.Entry) obj;
      System.out.println(entry.getKey() + "  ---> " + entry.getValue());
    }

    System.out.println("==================");

    // method 2) : KeySet
    Set KeySet = map.keySet();
    Iterator iterator2 = KeySet.iterator();
    while (iterator2.hasNext()) {
      Object key = iterator2.next();
      Object value = map.get(key);
      System.out.println(key + "  ---> " + value);
    }
  }
}
