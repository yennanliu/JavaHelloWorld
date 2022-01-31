package Advances.Generic;

// https://www.youtube.com/watch?v=nEutJOatwyc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=570

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/** demo6 : generic
 *
 *  1) generic with inheritance
 *      - 1-1) : class A is class B's super class,
 *               -> however, there is NO super-sub class relation in G<A> and G<B>
 *               -> G<A> and G<B> are in the SAME LAYER
 *               extra : A is B's super class
 *                       -> A<G> is B<G>'s super class as well
 *
 *  2) generic type with wildcard
 *      - https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html
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
}


