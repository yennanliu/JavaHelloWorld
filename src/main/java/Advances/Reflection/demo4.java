package Advances.Reflection;

// https://www.youtube.com/watch?v=x6tmNMxMmZo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=648
// https://www.youtube.com/watch?v=E8iPgoskpZU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=649

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

/** Reflection demo4 : get attr, class name, data type, permission (running class instance) */
public class demo4 {

  /**
   * Field test
   *
   * <p>1) get all attr (fields) from running class instance
   */
  @Test
  public void test1() {

    Class clazz = Advances.Reflection.Person2.class;

    /**
     * get attr -> getFields() : get all (public) attr from running class instance -> attr needs to
     * be public (parent attr is NOT included)
     */
    Field[] fields = clazz.getFields();
    for (Field f : fields) {
      System.out.println(f);
    }

    System.out.println("==================");

    /**
     * get attr -> getDeclaredFields() : get all (any permission) attr from running class instance
     * -> attr can be any permission (private, protected, public...)
     */
    Field[] declaredField = clazz.getDeclaredFields();
    for (Field f : declaredField) {
      System.out.println(f);
    }
  }

  /** permission annotation : data type, variable name */
  @Test
  public void test2() {

    Class clazz = Advances.Reflection.Person2.class;
    Field[] declaredField = clazz.getDeclaredFields();
    for (Field f : declaredField) {

      // 1) permission annotation
      int modifier = f.getModifiers();
      // System.out.println(modifier);  // 0, 1, 2 ...
      System.out.println(Modifier.toString(modifier)); // private, public ...

      // 2) data type
      Class type = f.getType();
      System.out.println(type.getName());

      // 3) variable name
      String fName = f.getName();
      System.out.println(fName);

      System.out.println("==================");
    }
  }
}
