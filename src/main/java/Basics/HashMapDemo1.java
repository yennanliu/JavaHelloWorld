package Basics;

// https://stackoverflow.com/questions/14743516/create-map-in-java

import java.util.Map;
import java.util.HashMap;

public class HashMapDemo1 {
    public static void main(String[] args) {

        HashMap<String, Integer> myHashMap  = new HashMap<String, Integer>(1, 1);
        System.out.println("myHashMap = " + myHashMap);

        myHashMap.put("abc", 123);

        System.out.println("myMap = " + myHashMap);
        System.out.println("keys =" + myHashMap.keySet());
        System.out.println("values =" + myHashMap.values());

        System.out.println("=======================");

        Map<String, Integer> myMap  = new HashMap<String, Integer>(1, 1);
        System.out.println("myMap = " + myMap);

        myMap.put("abc", 123);

        System.out.println("keys =" + myMap.keySet());
        System.out.println("values =" + myMap.values());
    }
}
