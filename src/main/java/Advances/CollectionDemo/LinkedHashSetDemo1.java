package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=z8nlH3W1sBU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=538

/** LinkedHashSet demo 1 */

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class LinkedHashSetDemo1 {

    @Test
    public void test1(){
        /**
         *  LinkedHashSet demo 1
         *
         *  1) LinkedHashSet is HashSet's sub class
         *
         *  2) maintain 2 references when adding new element : pre element and next element
         *
         *  3) pros : good performance in looping, adding, deletion
         *
         *  4) cons :
         */

        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123); // only storage one "123", since HashSet is non-duplicated
        set.add("aa");
        set.add("bb");
        set.add(new Person("tim",11));
        set.add(new Person("tim",11)); // NOTE : will storage 2 "Person("tim",11)" since we haven't overwrote "equals", "hashCode" methods in Person class
        set.add(new User("ann",20));
        set.add(new User("ann",20)); // NOTE : only storage 1 "User("ann",20)" if we overwrite "equals", "hashCode" methods in User class

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
