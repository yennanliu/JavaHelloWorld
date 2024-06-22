package Advances.Reflection;

// https://www.youtube.com/watch?v=wXRHrDoR6lI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=647

import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 *   Reflection demo3  :  reflection dynamic
 *
 */

public class demo3 {

    /** create a class instance with classPath (declare class name) */
    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

    /**
     *   reflection dynamic !!!
     *      -> via reflection, We can get class instance dynamically during Runtime
     *      -> used A LOT in backend framework
     */
    @Test
    public void test1(){
        int num = new Random().nextInt(3);
        String  classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                //classPath = "java.sql.Date"; // can't use this, since "java.sql.Date" has NO non-param constructor
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "Advances.Reflection.Person";
                break;
        }

        try {
            Object obj = getInstance(classPath);
            System.out.println(">>> obj = " + obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
