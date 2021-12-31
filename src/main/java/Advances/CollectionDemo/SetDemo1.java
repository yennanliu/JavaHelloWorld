package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=fbmCqWoecsI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=534
// https://www.youtube.com/watch?v=8Zg6QDXSSAc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=535

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *  Set Demo 1
 *
 *   0) Set is an interface, we need to implement it before use it
 *      plz check below implemented classes
 *
 *   1) Collection framework:
 *      ....
 *       |--- Set interface :  storage non-ordering, non-repeatable element
 *         |--- HashSet, LinkedHastSet, TreeSet
 *
 *   2) 3 implemented classes (Set)
 *      - HashSet  :  main implemented class (Set interface), thread Un-safety, can save `null` value
 *        - LinkedHastSet : "HashSet"'s sub class. hashset with linkedlist structure. make looping/add/delete elements more efficient
 *      - TreeSet : use "Red–black tree" in low level. can ordering input elements based on their properties
 *
 *   3) There are NO extra defined methods in Set -> all methods it (Set) has are as SAME as Collections's (methods)
 */

public class SetDemo1 {

    @Test
    public void test1(){
        /**
         *  Set :  storage non-ordering, non-duplicated
         *    (taking HashSet as an example)
         *
         *    1) non-ordering :
         *      - non-equal to randomness
         *      - ordering in storage space is NOT based on input ordering, BUT on record's hash value
         *
         *    2) non-duplicated
         *      - check duplicated or not (added elements) based on "equals()" method
         *      - Need to overwrite "equals", "hashCode" methods for user-defined class
         *      - can only add "one" same element into HashSet
         *      - plz check below "set.add(new User("ann",20))" example
         */

        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123); // only storage one "123", since HashSet is non-duplicated
        set.add("aa");
        set.add("bb");
        set.add(new Person("tim",11));
        set.add(new Person("tim",11));
        set.add(new User("ann",20));
        set.add(new User("ann",20)); // NOTE : will still be on "User("ann",20)" if we overwrite "equals", "hashCode" method in User class

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
