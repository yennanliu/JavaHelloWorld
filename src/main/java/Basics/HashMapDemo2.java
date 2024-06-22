package Basics;

import java.util.HashMap;

public class HashMapDemo2 {
  public static void main(String[] args) {

    /** 1. getOrDefault key https://stackoverflow.com/questions/18378934/check-null-value-of-map */
    HashMap myMap1 = new HashMap();
    myMap1.put("a", "123");
    myMap1.put("b", "000");
    myMap1.put("c", "456");

    System.out.println(myMap1.get("a"));
    System.out.println(myMap1.get("b"));
    System.out.println(myMap1.get("c"));

    //        String myVal1 = (myMap1.get("z").toString() == "") ?  myMap1.get("a").toString() :
    // "324";
    //        System.out.println("myVal1 = " + myVal1);

    String myVal2;
    if (myMap1.containsKey("z")) {
      myVal2 = myMap1.get("z").toString();
    } else {
      myVal2 = myMap1.get("a").toString(); // use default key
    }

    System.out.println("myVal2 = " + myVal2);
  }
}
