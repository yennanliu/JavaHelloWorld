package Advances.Reflection;

// https://www.youtube.com/watch?v=A4oHXSAlmFg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=652

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class demo6 {

    /**
     *  get constructor from runtime class
     */
    @Test
    public void test1() throws NoSuchMethodException {

        Class clazz = Person.class;

        // getConstructors() :  get public constructors from current running class
        Constructor[] constructors =  clazz.getConstructors();

        for (Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println("================");

        // getDeclaredConstructors() : get ALL constructors from current running class
        Constructor[] declaredConstructors =  clazz.getDeclaredConstructors();

        for (Constructor c : declaredConstructors){
            System.out.println(c);
        }
    }

}
