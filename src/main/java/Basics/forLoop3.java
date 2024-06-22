package Basics;

import java.util.*;

/** for loop demo 3: hashmap */

// https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/MapDemo/demo2.java

public class forLoop3 {
  public static void main(String[] args) {

    Map myMap = new HashMap();

    myMap.put("a", 123);
    myMap.put("b", 456);
    myMap.put("c", 789);

    /** for loop method 1 : basic */

    /** for loop method 2 : enhanced for loop */
    Set k_set = myMap.keySet();
    for (Object k : k_set) {
      System.out.println(myMap.get(k));
    }

    System.out.println("================");

    /** for loop method 3: iterator */
    Iterator iterator = k_set.iterator();
    while (iterator.hasNext()) {
      System.out.println(myMap.get(iterator.next()));
    }
  }
}
