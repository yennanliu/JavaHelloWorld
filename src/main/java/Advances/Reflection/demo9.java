package Advances.Reflection;

// https://www.youtube.com/watch?v=Y2vkfcQZ8Es&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=655
// https://www.youtube.com/watch?v=nJOZw59z4WI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=657

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

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
    // make sure accessible
    showDest.setAccessible(true);
    // if there is no return val, res will be null
    Object res2 = showDest.invoke(Person2.class);
    System.out.println(">>> res2 = " + res2);
  }

  /** call running class defined constructor */
  @Test
  public void test2() throws Exception {

    Class clazz = Person2.class;

    // 1)  get constructor
    // pattern : clazz.getDeclaredConstructor(class-type)
    Constructor constructor = clazz.getDeclaredConstructor(String.class);

    // 2) make sure accessible
    constructor.setAccessible(true);

    // 3) create running class instance
    Person2 p2 = (Person2) constructor.newInstance("jack");
    System.out.println(">>> p2 = " + p2);
  }
}
