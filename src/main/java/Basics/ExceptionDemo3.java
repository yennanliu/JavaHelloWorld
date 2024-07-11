package Basics;

// https://www.youtube.com/watch?v=7tZRMKAsiUA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=377
// https://www.youtube.com/watch?v=VkXeBUI98mY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=379

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ExceptionDemo3 : throws
 *
 * <p>1) throws + exception
 *
 * <p>1.1) will point out the possible exception at the method declaration place, when the method is
 * executed. 1.2) if there is an exception happen when method run. there will be an exception
 * instance raised. this exception instance then be thrown by throw 1.3) the code after "exception",
 * will NOT be executed, which is different from try-catch-finally
 *
 * <p>2) There are only 2 ways deal with exception:
 *
 * <p>2.1) try-catch-exception -> Really deal with the exception on place 2.2) throws -> NOT really
 * deal with the exception, only "throws" the exception to the upper layer. (upper layer still need
 * to deal with such exception)
 *
 * <p>3) when to use try-catch-finally or throws ?
 *
 * <p>3.1) if there is NO throws in the overridden method in superclass -> method in subclass CAN'T
 * use throws as well -> so method in subclass must use try-catch-finally 3.2) if in the running
 * code, there are several methods been used, and those methods dependent on each other. In such
 * case, we suggest use `throws` in the methods, and use `try-catch-finally` in the running code. ->
 * So the running code will raise exception if there is an exception in the method that make the
 * program not work as expected
 */
public class ExceptionDemo3 {

  // NOTE : DON'T throw exception when in method
  // since it's already the highest layer of the program
  // -> here we need to use try-catch-finally instead
  // NOTE : compare here with ExceptionDemo4
  public static void main(String[] args) {
    try {
      method2();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void method2()
      throws
          IOException { // or throws IOException only, since IOException is FileNotFoundException's
    // superclass
    method1();
  }

  public static void method1() throws IOException {
    File file = new File("test.txt");
    FileInputStream fis = new FileInputStream(file);
    int data = fis.read();
    while (data != -1) {
      System.out.println((char) data);
      data = fis.read();
    }
    fis.close();

    System.out.println("zzzzzzZZZZZZ");
  }
}
