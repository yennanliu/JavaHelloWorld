package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=Qqxj6k1xI5I&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=526

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *  foreach : for looping over collection, array
 *
 *  1) since JDK 5.0
 *
 *  2) general form :
 *     -> for(element-type local-variable : collection-object)
 */

public class foreachDemo1 {

    @Test
    public void test1(){

        Collection col1 = new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add(789);
        col1.add("yooooo");
        col1.add(new String("kate"));
        col1.add(new Person("kyo", 19));
        col1.add(false);

        // for ( element-type(in collection) local-variable : collection-object )
        // still use iterator internally
        for(Object obj: col1){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){

        int[] arr = new int[]{1,2,3,4,5};
        // for (element-type local-variable: array-object)
        for (int i : arr){
            System.out.println(i);
        }
    }

    @Test
    public void test3(){

        String[] arr = new String[]{"aa","aa","aa"};
        String[] arr2 = new String[]{"aa","aa","aa"};

        // method 1 : dispense value via basic for loop
        for (int i = 0; i < arr.length; i++){
            arr[i] = "AA";
        }

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]); // "AA", since we dispense value to array element itself
        }

        System.out.println("-----------------");

        // method 2
        for (String s: arr2){
            s = "AA";
        }

        for (int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i]); // still "aa", since we dispense value (AA) to local variable we extract, but not array element itself
        }
    }
}
