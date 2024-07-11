package Advances.Generic;

// https://www.youtube.com/watch?v=Lws0GkOTckQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=569

/** demo4 : generic method */
import java.util.List;
import org.junit.jupiter.api.Test;

public class demo4 {
  @Test
  public void test1() {
    Order<String> order = new Order<>();
    Integer[] arr = new Integer[] {1, 2, 3, 4};
    // call generic method, and define its attr with generic type
    List<Integer> list = order.copyFromArrayList(arr);

    System.out.println(list);
  }
}
