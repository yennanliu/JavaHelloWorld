package Advances.Reflection;

// https://www.youtube.com/watch?v=A4oHXSAlmFg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=652
// https://www.youtube.com/watch?v=1cZzR0lmaPo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=652

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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

    /**
     *  get parent class from runtime class
     */
    @Test
    public void test2(){

        Class clazz = Person2.class;

        Class superclass = clazz.getSuperclass();

        System.out.println(">>> superclass = " + superclass);
    }

    /**
     *  get parent class (with generic type) from runtime class
     */
    @Test
    public void test3(){

        Class clazz = Person2.class;

        Type genericSuperclass = clazz.getGenericSuperclass();

        System.out.println(">>> genericSuperclass = " + genericSuperclass);
    }

    /**
     *  get parent class (with generic type)'s  generic type from runtime class
     */
    @Test
    public void test4(){

        Class clazz = Person2.class;

        Type genericSuperclass = clazz.getGenericSuperclass();

        // get ParameterizedType (implement 強轉 as well)
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        // get genetic type
        Type[] actualTypeArguments = paramType.getActualTypeArguments();

        System.out.println(">>> actualTypeArguments = " + actualTypeArguments[0]);
    }

}
