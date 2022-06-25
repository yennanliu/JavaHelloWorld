package Advances.Reflection;

// https://www.youtube.com/watch?v=Y2vkfcQZ8Es&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=655

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class demo9 {

    /** Get methods from running class instance (Important!!) */
    @Test
    public void test1() throws Exception {

        Class clazz = Person2.class;

        // get running class instance
        Person2 p = (Person2) clazz.newInstance();

        // step 1) get specific method
        // pattern :  getDeclaredMethod(methodName, return-type)
        Method show = clazz.getDeclaredMethod("show", String.class);

        // step 2) make sure method is accessible
        show.setAccessible(true);

        // step 3) invoke : call method
        // pattern :  invoke(method-class, attr-val)
        // invoke method has return value
        Object res = show.invoke(p, "JPY");
        System.out.println(">>> res = " + res);

        System.out.println("====== How to call static method ? =====");

        Method showDest = clazz.getDeclaredMethod("showDest");
        showDest.setAccessible(true);
        // if there is no return val, res will be null
        Object res2 = showDest.invoke(Person2.class);
        System.out.println(">>> res2 = " + res2);
    }

}
