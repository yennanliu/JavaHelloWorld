package Basics;

/** for loop demo 1 : endless for loop */
public class forLoop1 {
  public static void main(String[] args) {
    // this will cause an ENDLESS looping
    for (; ; ) {
      System.out.println("== I AM ENDLESS LOOP ==");
    }
  }
}
