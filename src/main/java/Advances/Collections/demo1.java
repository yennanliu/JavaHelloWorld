package Advances.Collections;

// https://www.youtube.com/watch?v=ATfSTvS60Gg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=558

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Collections demo 1
 *
 * <p>1) Collections is a tool class for operating data structures (e.g. Set, List, Map..) under
 * collection
 *
 * <p>2) difference between Collections VS Collections ? - Collection is an interface for data
 * structure - Collections is a tool for operating Collection
 *
 * <p>3) common methods
 *
 * <p>4) synchronizedXXX() methods -> can make implemented collection become "synchronized"
 * collection -> so can solve thready-safety issue in multi-thread
 */
public class demo1 {
  /** basic demo */
  @Test
  public void test1() {
    List list = new ArrayList();
    list.add(1);
    list.add(4321);
    list.add(51);
    list.add(17);
    list.add(43);

    System.out.println(list);

    // reverse
    Collections.reverse(list);
    System.out.println(list);

    // shuffle
    Collections.shuffle(list);
    System.out.println(list);

    // sort
    Collections.sort(list);
    System.out.println(list);

    // swap
    Collections.swap(list, 1, 2);
    System.out.println(list);
  }

  /** copy demo */
  @Test
  public void test2() {
    List srcList = new ArrayList();
    srcList.add(1);
    srcList.add(4321);
    srcList.add(51);
    srcList.add(17);
    srcList.add(43);

    // List dest = new ArrayList(); // wrong, dest without enough size for saving srcList's element
    /** NOTE : CREATE a list (dest) with list's size */
    List dest = Arrays.asList(new Object[srcList.size()]);
    System.out.println(dest); // [null, null, null, null, null]

    Collections.copy(
        dest, srcList); // java.lang.IndexOutOfBoundsException: Source does not fit in dest
    System.out.println(dest); // [1, 4321, 51, 17, 43]
  }

  /** synchronizedXXX() methods demo */
  @Test
  public void test3() {
    List srcList = new ArrayList();
    srcList.add(1);
    srcList.add(4321);
    srcList.add(51);
    srcList.add(17);
    srcList.add(43);

    // returned srcList2 is thread-safety
    List srcList2 = Collections.synchronizedList(srcList);
  }
}
