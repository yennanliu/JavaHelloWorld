package Advances.Reflection;

// https://www.youtube.com/watch?v=HSDlxdr7bXw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=654

import org.junit.jupiter.api.Test;
import java.lang.annotation.Annotation;

public class demo7 {

    /** get running class implemented interface */
    @Test
    public void test1(){

        Class clazz = Person2.class;

        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces){
            System.out.println(c);
        }

        // get running class' super class' interfaces
        System.out.println("================");
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1){
            System.out.println(c);
        }
    }

    /** get running class package */
    @Test
    public void test2(){

        Class clazz = Person2.class;

        Package pack = clazz.getPackage();
        System.out.println("package = " + pack);
    }

    /** get running class annotation  */
    @Test
    public void test3(){

        Class clazz = Person2.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations){
            System.out.println(a);
        }
    }

}
