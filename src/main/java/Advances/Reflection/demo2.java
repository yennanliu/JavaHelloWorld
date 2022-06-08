package Advances.Reflection;

// https://www.youtube.com/watch?v=hbxp9kCa9zM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=646

import org.junit.jupiter.api.Test;

/**
 *   Reflection demo2  : Create running class instance via reflection
 *
 */

public class demo2 {

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {

        Class clazz = Person.class;

        /**
         *  newInstance()
         *      1) via this method, we get running class instance
         *      2) call no param constructor (e.g. Person()) internally
         *      3) in order to use newInstance properly
         *          - running class has no param constructor
         *          - running class is accessible ("public" for most cases)
         *      4) for java beans, we have to offer no param constructor
         *          - let others can get its (java beans) running class instance via reflection
         *          - when this class is inherited, make sure parent class has constructor when "super" is called
         */
        Object obj = clazz.newInstance();
        System.out.println(">>> obj = " + obj);

        Person p1 = (Person) clazz.newInstance();
        System.out.println(">>> p1 = " + p1);

        // if use generic type, we don't need to use 強轉 ("Person p1 = (Person) clazz.newInstance();")
        Class<Person> clazz2 = Person.class;
        Person p2 = clazz2.newInstance();
        System.out.println(">>> p2 = " + p2);
    }


}
