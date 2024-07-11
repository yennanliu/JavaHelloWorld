package Advances.Reflection;

// https://www.youtube.com/watch?v=UdZie846898&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=636
// https://www.youtube.com/watch?v=4V-cslz9BpM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=637
// https://www.youtube.com/watch?v=V9UjC0JvqrY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=638
// https://www.youtube.com/watch?v=ny4F6MUv0hw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=639
// https://www.youtube.com/watch?v=Q0NvegR4sNY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=639
// https://www.youtube.com/watch?v=mH0oEYLXk-U&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=641
// https://www.youtube.com/watch?v=gqTCsLOIVRk&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=642

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

/**
 * Reflection demo 1 : basic
 *
 * <p>1) main common API - java.lang.Class : represent a class - java.lang.reflect.Method :
 * represent a class method - java.lang.reflect.Field : represent a class attr -
 * java.lang.reflect.Constructor : represent a class constructor ..
 *
 * <p>2) Question: 2-1) Reflection conflicts with OOP Encapsulation (封裝) ? explain ? -> NO conflict
 * -> different purposes
 *
 * <p>2-2) in general dev, which one we should use ? : "new <class>" or "reflection" ? -> use "new
 * <class>" is better -> reflection is for "dynamic". so if we are NOT sure which class need to
 * init, have to decide till runtime -> use "reflection" - example : /login, /add ... endpoints via
 * java servlet
 *
 * <p>3) java.lang.class understanding - 3-1) java class loading steps - 1) java.exe runs, creates
 * .class (字節碼文件), then use java.exe parses and executes .class file (load .class to memory) - 2) we
 * call in-memory class above as "run-time class", which is a class instance - 3) running class
 * instance (in-memory) will be cased in cache (for a period of time)
 *
 * <p>4) So, `Class clazz = Person.class;` -> Class is a "run-time class
 *
 * <p>5) in Java, everything is an instance
 *
 * <p>6) from which class we can get their Class (via reflection) - class (external class, internal
 * static class..) - interface - [] - enum - annotation (e.g. @interface..) - primitive type - void
 */
public class demo1 {

  /** test 1: Before reflection, op we can do on Person class */
  @Test
  public void test1() {
    // 1) create Person class (init)
    Person p1 = new Person("kate", 17);

    // 2) via instance, use its method
    p1.age = 20;
    System.out.println(p1);

    p1.show();

    // can't use Person instance's private method, attr.. outside Person class
  }

  /** test 2: After reflection, op we can do on Person class */
  @Test
  public void test2() throws Exception {

    // 1) create an instance via reflection
    Class clazz = Person.class;
    Constructor cons = clazz.getConstructor(String.class, int.class);

    Object obj = cons.newInstance("kate", 17);
    System.out.println(obj);

    // DownCasting (強轉)
    Person p = (Person) obj;
    System.out.println(p);

    // 2) call attr. via reflection
    Field age = clazz.getDeclaredField("age");
    age.set(p, 100);
    System.out.println(p);

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
    String nation =
        (String) showNation.invoke(p1, "japan"); // similar as String nation = p1.showNation();
    System.out.println("nation = " + nation);
  }

  /**
   * How to get Class instance ?
   *
   * <p>method 1) : Class<Person> clazz1 = Person.class; method 2) : via running class instance, via
   * getClass() method 3) : via Class' static method : forName(String classPath) (use most!!) method
   * 4) via "ClassLoader" (rarely use)
   */
  @Test
  public void test3() throws ClassNotFoundException {

    // method 1) : via running class attr (xxx.class)
    Class<Person> clazz1 = Person.class;
    System.out.println("clazz1 = " + clazz1);

    // method 2) : via running class instance, via getClass()
    Person p1 = new Person();
    Class clazz2 = p1.getClass();
    System.out.println("clazz2 = " + clazz2);

    // method 3): via Class' static method : forName(String classPath) (use most!!)
    Class clazz3 = Class.forName("Advances.Reflection.Person");
    System.out.println("clazz3 = " + clazz3);

    System.out.println(
        "clazz1 == clazz2 ? " + (clazz1 == clazz2)); // true, NOTE : clazz1, clazz2 are equal
    System.out.println(
        "clazz1 == clazz3 ? " + (clazz1 == clazz3)); // true, NOTE : clazz1, clazz3 are equal

    // method 4) via "ClassLoader"  (rarely use)
    ClassLoader classLoader = demo1.class.getClassLoader();
    Class clazz4 = classLoader.loadClass("Advances.Reflection.Person");
    System.out.println("clazz4 = " + clazz4);

    System.out.println(
        "clazz1 == clazz4 ? " + (clazz1 == clazz4)); // true, NOTE : clazz1, clazz4 are equal
  }

  /** class instance's structure demo */
  @Test
  public void test4() {
    Class c1 = Object.class;
    Class c2 = Comparable.class;
    Class c3 = String[].class;
    Class c4 = int[][].class;
    Class c5 = ElementType.class;
    Class c6 = Override.class;
    Class c7 = int.class;
    Class c8 = void.class;
    Class c9 = Class.class;

    int[] a = new int[10];
    int[] b = new int[100];
    Class c10 = a.getClass();
    Class c11 = b.getClass();

    // if array element type, and dimension are the same, they belong to the same class
    System.out.println(c10 == c11); // true
  }
}
