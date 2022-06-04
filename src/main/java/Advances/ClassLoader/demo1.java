package Advances.ClassLoader;

// https://www.youtube.com/watch?v=rePjvHVWnQ0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=643
// https://www.youtube.com/watch?v=bpP8CE98MhE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=644

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

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

    /** properties : for load config files */
    // method 1 (load properties)
    @Test
    public void test2() throws Exception {

        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/Advances/ClassLoader/jdbc.properties");
        pros.load(fis);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println("user = " + user);
        System.out.println("password = " + password);
    }

    // method 2 (load properties)
    @Test
    public void test3() throws Exception {

        Properties pros = new Properties();
        ClassLoader classLoader = demo1.class.getClassLoader();
        // TODO : fix below (file path)
        // will load /src/jdbc.properties
        InputStream fis = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(fis);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println("user = " + user);
        System.out.println("password = " + password);
    }

}
