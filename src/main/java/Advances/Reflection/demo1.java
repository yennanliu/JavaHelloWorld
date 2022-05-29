package Advances.Reflection;

// https://www.youtube.com/watch?v=UdZie846898&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=636
// https://www.youtube.com/watch?v=4V-cslz9BpM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=637
// https://www.youtube.com/watch?v=V9UjC0JvqrY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=638
// https://www.youtube.com/watch?v=ny4F6MUv0hw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=639
// https://www.youtube.com/watch?v=Q0NvegR4sNY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=639

import Advances.Generic.SubOrder;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  Reflection demo 1
 *
 *   1) main common API
 *      - java.lang.Class : represent a class
 *      - java.lang.reflect.Method :  represent a class method
 *      - java.lang.reflect.Field : represent a class attr
 *      - java.lang.reflect.Constructor : represent a class constructor
 *      ..
 *
 *   2) Question:
 *      2-1) Reflection conflicts with OOP Encapsulation (封裝) ? explain ?
 *          -> NO conflict
 *          -> different purposes
 *
 *
 *      2-2) in general dev, which one we should use ? : "new <class>" or "reflection" ?
 *          -> use "new <class>" is better
 *          -> reflection is for "dynamic". so if we are NOT sure which class need to init, have to decide till runtime -> use "reflection"
 *              - example :  /login, /add ... endpoints via java servlet
 *
 *    3) java.lang.class understanding
 *      - 3-1) java class loading steps
 *          - 1) java.exe runs, creates .class (字節碼文件), then use java.exe parses and executes .class file (load .class to memory)
 *          - 2) we call in-memory class above as "run-time class", which is a class instance
 *
 *    4) So, `Class clazz = Person.class;`
 *       -> Class is a "run-time class
 *
 *    5) in Java, everything is an instance
 */

public class demo1 {

    /**
     * test 1: Before reflection, op we can do on Person class
     */
    @Test
    public void test1(){
        // 1) create Person class (init)
        Person p1 = new Person("kate",17);

        // 2) via instance, use its method
        p1.age = 20;
        System.out.println(p1.toString());

        p1.show();

        // can't use Person instance's private method, attr.. outside Person class
    }

    /**
     * test 2: After reflection, op we can do on Person class
     */
    @Test
    public void test2() throws Exception {

        // 1) create an instance via reflection
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("kate", 17);
        System.out.println(obj.toString());

        // DownCasting (強轉)
        Person p = (Person) obj;
        System.out.println(p.toString());

        // 2) call attr. via reflection
        Field age = clazz.getDeclaredField("age");
        age.set(p, 100);
        System.out.println(p.toString());

        // 3) call method via reflection
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        // 4) get class' private structure (attr, method..) via reflection
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("trek");
        System.out.println(p1);

        // use private attr
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "athena");
        System.out.println(p1);

        // use private method
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        // compare : p1.showNation("japan"); -> instance call method
        // below is : "Method showNation" call instance -> still instance call method
        showNation.setAccessible(true); // note !!! we need this, so can access private method
        String nation = (String) showNation.invoke(p1, "japan"); // similar as String nation = p1.showNation();
        System.out.println("nation = " + nation);

    }
}
