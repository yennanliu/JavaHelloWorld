package Advances.Reflection;

// https://www.youtube.com/watch?v=Exf2IxnQL3E&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=650

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 *   Reflection demo5 : get method (running class instance)
 *
 */

public class demo5 {

    @Test
    public void test1(){

        Class clazz = Person2.class;

        /** getMethods() : get all methods (with public permission) (parent's methods are NOT included) */
        Method[] methods = clazz.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }
        System.out.println("================");

        /** getDeclaredMethods() : get all declared methods in running class instance*/
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.println(m);
        }

        // there are similar methods for getting constructor...
    }

}
