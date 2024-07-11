package Basics;

/** for loop demo 2 : ArrayList */
import java.util.ArrayList;
import java.util.Iterator;

public class forLoop2 {
  public static void main(String[] args) {
    ArrayList col1 = new ArrayList();

    col1.add(123);
    col1.add(456);
    col1.add("abc");

    /** for loop method 1 : basic */
    for (int i = 0; i < col1.toArray().length; i++) {
      System.out.println(col1.toArray()[i]);
    }

    System.out.println("================");

    /** for loop method 2 : enhanced for loop */
    for (Object o : col1) {
      System.out.println(o);
    }

    System.out.println("================");

    /** for loop method 3: iterator */
    Iterator iterator = col1.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
