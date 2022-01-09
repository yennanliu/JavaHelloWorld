package Advances.TreeMap;

// https://www.youtube.com/watch?v=d7sNFM8wL5A&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=556

import org.junit.jupiter.api.Test;

import java.util.*;

/** TreeMap demo 1 */

/**
 *  1) when add key-value to TreeMap, key needs to from the instances from SAME class
 *     -> since it will do ordering by key
 *          - natural ordering
 *          - custom ordering
 */

public class demo1 {
    /** demo : natural ordering */
    @Test
    public void test1(){
        TreeMap map = new TreeMap();

        User u1 = new User("kate",10);
        User u2 = new User("jane",20);
        User u3 = new User("rose",17);

        map.put(u1, 99);
        map.put(u2, 60);
        map.put(u3, 64);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            // elements in entrySet collection are all entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "  ---> " + entry.getValue());
        }
    }

    /** demo : custom ordering */
    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("input type mismatch");
            }
        });

        User u1 = new User("kate",10);
        User u2 = new User("jane",20);
        User u3 = new User("rose",17);

        map.put(u1, 99);
        map.put(u2, 60);
        map.put(u3, 64);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            // elements in entrySet collection are all entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "  ---> " + entry.getValue());
        }
    }
}
