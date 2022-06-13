package Advances.Reflection;

// https://www.youtube.com/watch?v=Exf2IxnQL3E&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=650
// https://www.youtube.com/watch?v=BlwTpjp-9Pw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=650

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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

    /**
     *  How can we get "@XXXyyy" ?
     *
     *  @XXXyyy
     *  permission-annotation return-type method-name(type1 arg1 ...) throws xxxException(..){}
     *
     */
    @Test
    public void test2(){

        Class clazz = Person2.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){

            // 1) get method declared annotation
            Annotation[] annos = m.getAnnotations();
            for (Annotation a: annos){
                System.out.println(">>> method = " + a);
            }

            // 2) get permission annotation
            System.out.println(">>> permission" + Modifier.toString(m.getModifiers()));

            // 3) get method return type
            System.out.println(">>> return type = " + m.getReturnType().getName());

            // 4) get method name
            System.out.println(">>> method = " +  m.getName());

            // 5) get param list
            Class[] parameterTypes = m.getParameterTypes();
            // if there is param list
            if ( !(parameterTypes == null && parameterTypes.length == 0) ){
                for (int i = 0; i < parameterTypes.length; i++){
                    System.out.println(">>> parameterTypes = " + parameterTypes[i].getName()+ " args_" + i);
                }
            }

            System.out.println("================");

        }

    }

}
