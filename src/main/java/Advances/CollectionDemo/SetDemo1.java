package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=fbmCqWoecsI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=534
// https://www.youtube.com/watch?v=8Zg6QDXSSAc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=535
// https://www.youtube.com/watch?v=FPxF4UR5EGE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=536
// https://www.youtube.com/watch?v=fWaabv-UgCs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=537

/** Set demo 1 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 *  Set Demo 1
 *
 *   0) "Set" is an interface, we need to implement it before using.
 *      plz check below implemented classes
 *
 *   1) Collection framework:
 *      ....
 *       |--- Set interface :  storage non-ordering, non-repeatable elements
 *         |--- HashSet, LinkedHastSet, TreeSet
 *
 *   2) 3 implemented classes (Set)
 *      - HashSet  :  main implemented class (Set interface), thread Un-safety, can save `null` value
 *        - LinkedHastSet : "HashSet"'s sub class. hashset with linkedlist structure. make looping/add/delete elements more efficient
 *      - TreeSet : use "Red–black tree" in low level. can ordering input elements based on their properties
 *
 *   3) There are NO extra defined methods in Set -> all methods it (Set) has are as SAME as Collections's (methods)
 *
 *   4) requirement :
 *      - when add element to HashSet -> we need to Overwrite hashCode() and equals() methods
 *      - Overwritten hashCode() and equals() methods should be "consistency" -> e.g. same elements SHOULD have SAME hash value
 */

public class SetDemo1 {

    @Test
    public void test1(){
        /**
         *  Set :  storage non-ordering, non-duplicated (HashSet)
         *
         *    0) HashSet : array + linked list (low level structure)
         *
         *    1) non-ordering :
         *      - non-ordering != randomness
         *      - ordering in storage space is NOT based on input ordering, BUT on record's hash value
         *
         *    2) non-duplicated
         *      - check duplicated or not (added elements) based on "equals()" method
         *      - Need to overwrite "equals", "hashCode" methods if user-defined class
         *      - can only add "one" same element into HashSet
         *      - plz check below "set.add(new User("ann",20))" example
         *
         *   3) adding element steps (HashSet)
         *      - step 1) when we add element a to HashSet
         *      - step 2) get its hash value via its class' hashCode() method
         *      - step 3) then get storage address (in storage space) via hash value above
         *      - step 4) check if there is already element on the address
         *                 - if False : add element a OK
         *                 - if True  : compare element a and b's hash value (if there is already an element b on the address) //(case 1)
         *                     - if False: add element a OK
         *                     - if True: call class' equals() method, compare every part in element a and element b //(case 2)
         *                          - if True (equals()): add element a Failed  //(case 3)
         *                          - if False (equals()): add element a OK
         *
         *     - (for success case 2, case 3, element a will be saved as Linked list form)
         *     - (JDK 7 : put element a into array, point a -> original element)
         *     - (JDK 8 : point original element -> element a)
         */

        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123); // only storage one "123", since HashSet is non-duplicated
        set.add("aa");
        set.add("bb");
        set.add(new Person("tim",11));
        set.add(new Person("tim",11)); // NOTE : will storage 2 "Person("tim",11)" since we haven't overwritten "equals", "hashCode" methods in Person class
        set.add(new User("ann",20));
        set.add(new User("ann",20)); // NOTE : only storage 1 "User("ann",20)" if we overwrite "equals", "hashCode" methods in User class

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
