package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=ScNzqfIzkS8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=520

/** Collection demo 3 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;

public class demo3 {

  @Test
  public void test1() {

    /** hashCode() : return current object hash code */
    Collection col1 = new ArrayList();
    col1.add(123);

    System.out.println(col1.hashCode());
  }

  @Test
  public void test2() {

    /** collection --> array (toArray()) */
    Collection col1 = new ArrayList();
    col1.add(123);
    col1.add(456);
    col1.add(789);
    col1.add("yooooo");
    col1.add("kate");
    col1.add(new Person("kyo", 19));

    Object[] arr = col1.toArray();
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }

    System.out.println("-----------------");

    /** array --> collection ( via static method : Arrays.asList() ) */
    // Collection col1_ = Arrays.asList(arr);

    List<String> list_1 = Arrays.asList("aa", "bb", "cc");
    System.out.println(list_1);

    List<int[]> list_2 = Arrays.asList(new int[] {123, 456});
    System.out.println(list_2); // [[I@589b3632]

    List list_3 = Arrays.asList(123, 456);
    System.out.println(list_3); // [123, 456]

    List<Integer> list_4 = Arrays.asList(123, 456);
    System.out.println(
        list_4); // [123, 456], we need to use "Packaging class" (Integer) instead of basic data
                 // type (int)
  }

  @Test
  public void test3() {

    /**
     * iterator() : return Iterator interface instance, for visiting all elements in collection, ->
     * plz check details in src/main/java/Advances/CollectionDemo/IteratorDemo1.java
     */
  }
}
