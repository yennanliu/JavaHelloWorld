package Advances.ClassLoader;

// https://www.youtube.com/watch?v=rePjvHVWnQ0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=643

import org.junit.jupiter.api.Test;

public class demo1 {

    @Test
    public void test1(){

        // for user-defined class, java use "system ClassLoader" load it
        ClassLoader classLoader = demo1.class.getClassLoader();
        System.out.println(">>> classLoader = " + classLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // via getParent, we get "ExtensionClassLoader"
        // ExtensionClassLoader is for java-core class loading
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(">>> classLoader1 = " + classLoader1); // sun.misc.Launcher$ExtClassLoader@701fc37a

        // Not able to get "BootstrapClassLoader", since it's NOT visible to users
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(">>> classLoader2 = " + classLoader2); // null

        // "BootstrapClassLoader"
        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(">>> classLoader3 = " + classLoader3); // null


    }

}
