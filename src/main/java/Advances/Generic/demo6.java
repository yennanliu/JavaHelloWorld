package Advances.Generic;

// https://www.youtube.com/watch?v=nEutJOatwyc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=570
// https://www.youtube.com/watch?v=_53WGmiijGA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=572
// https://www.youtube.com/watch?v=UWwPoU_SId0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=573

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** demo6 : generic
 *
 *  1) generic with inheritance
 *      - 1-1) : class A is class B's super class,
 *               -> however, there is NO super-sub class relation in G<A> and G<B>
 *               -> G<A> and G<B> are in the SAME LAYER
 *               -> plz check test2
 *               extra : A is B's super class
 *                       -> A<G> is B<G>'s super class as well
 *
 *  2) generic type with wildcard
 *      - https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html
 *      - sign : "?"
 *
 */


public class demo6 {

    /** demo 1 : generic with inheritance */
    @Test
    public void test1(){

        // example 1
        Object obj = null;
        String str = null;

        obj = str; // assign sub class object (str) to its super class (obj). Polymorphism

        // example 2
        Object arr1 = null;
        String[] arr2 = null;
        arr1 = arr2; // assign sub class object (arr2) to its super class (arr1). Polymorphism

        // example 3
        List<Object> list1 = null;
        List<String> list2 = null;

        // There is NO relationship (super-sub class) within list1, list2's class type
        //list1 = list2; // wrong.
    }

    @Test
    public void test2(){
        List<String> list1 = null;
        ArrayList<String> list2 = null;
        list1 = list2; // this one is OK
     }

     /** generic type with wildcard */
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        // wildcard
        List<?> list3 = null;

        // BOTH as OK (via wildcard trick)
        list3 = list1;
        list3 = list2;

        myPrint(list1);
        myPrint(list2);
    }


    /** generic type with wildcard 2 */
    @Test
    public void test4(){
        List<String> list3 = new ArrayList<>();

        list3.add("aa");
        list3.add("bb");
        list3.add("cc");

        List<?> list = null;
        list = list3;

        // write : we CAN'T add any value (any type) to list<?> (generic type)
        // However, we can add null to it
        //list.add("dd");
        //list.add("?");
        list.add(null);

        System.out.println(list);

        // read : it's OK that we can read list<?>, read object type : Object
        Object o1 = list.get(0);
        System.out.println(o1);

        System.out.println(list.get(3));
    }

// use wildcard in method
public void myPrint(List<?> list){
    Iterator<?> iterator = list.iterator();
    while (iterator.hasNext()){
        // NOTE : we use Object type here, since Object is sub class of all class
        Object obj = iterator.next();
        System.out.println(obj);
        }
    }
}
