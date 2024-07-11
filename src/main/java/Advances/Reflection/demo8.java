package Advances.Reflection;

// https://www.youtube.com/watch?v=hMoeW6hyE0Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=655

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

/**
 * get specific structure from running class
 *
 * <p>-> e.g. attribute, method, constructor
 */
public class demo8 {

  /** get fields : V1 */
  @Test
  public void test1() throws Exception {

    Class clazz = Person2.class;

    // get running class instance
    Person2 p = (Person2) clazz.newInstance();

    // get defined attr (attr has to be "public")
    // (we seldom use this approach, plz check test2 for better one)
    Field id = clazz.getField("id");

    // set current attr value.
    // pattern : set(instanceName, attrVal)
    id.set(p, 1009);

    // get current class instance attr val
    // pattern : get(instanceName)
    int pid = (int) id.get(p);
    System.out.println(">>> pid = " + pid);
  }

  /**
   * get fields : V2
   *
   * <p>set, get running class instance attr
   */
  @Test
  public void test2() throws Exception {

    Class clazz = Person2.class;

    // get running class instance
    Person2 p = (Person2) clazz.newInstance();

    // get defined attr (attr don's have to be "public")
    // pattern : getDeclaredField(String fieldName)
    Field name = clazz.getDeclaredField("name");

    // MAKE sure attr is accessible
    // NOTE !!! we HAVE to make setAccessible true, so we can set val to attr
    name.setAccessible(true);

    // set attr val
    name.set(p, "jack");
    System.out.println(name.get(p));
  }
}
