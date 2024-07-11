package Basics.interfaceDemo6;

// https://www.youtube.com/watch?v=tiwGXRJcPIY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=358

/**
 * Interface
 *
 * <p>3.2) JDK 8 and after -> can HAVE - global constant - abstract method - static method - default
 * method
 */
public interface CompareA {

  // static method
  static void method1() {
    System.out.println("Compare A : N.Y.");
  }

  // default method
  default void method2() {
    System.out.println("Compare A : C.A.");
  }

  // default method
  default void method3() {
    System.out.println("Compare A : C.A.");
  }
}
