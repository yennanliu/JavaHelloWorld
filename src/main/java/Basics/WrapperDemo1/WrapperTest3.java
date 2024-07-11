package Basics.WrapperDemo1;

// https://www.youtube.com/watch?v=_yY_bJln63g&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=305

/**
 * // ------------- // After JDK 5.0 // ------------- -> We have "autoboxing", "unboxing" feature
 *
 * <p>1) autoboxing
 *
 * <p>2) unboxing
 */
import org.junit.jupiter.api.Test;

public class WrapperTest3 {

  /** autoboxing */
  int num2 = 10;

  Integer in1 = num2;

  /** unboxing */
  int num3 = in1;

  boolean b1 = true;
  Boolean b2 = b1;
  boolean b3 = b2;

  /** Basic type -> wrapper class */
  @Test
  public void test() {
    int num1 = 10;
    // Basic type -> wrapper class
    method(num1); // autoboxing
  }

  public void method(Object obj) {
    System.out.println(obj);
  }
}
