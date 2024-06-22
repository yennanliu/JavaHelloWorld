package Basics;

// https://www.youtube.com/watch?v=7tZRMKAsiUA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=377

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/** ExceptionDemo4 : throws */
public class ExceptionDemo4 {

  // since we already catch exception via try-catch-finally in method3
  // so there is NO need to do any extra handling for exception
  public static void main(String[] args) {
    method3();
  }

  // NOTE : compare here with ExceptionDemo3
  public static void method3() {
    try {
      method2();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void method2()
      throws FileNotFoundException,
          IOException { // or throws IOException only, since IOException is FileNotFoundException's
                        // superclass
    method1();
  }

  public static void method1() throws FileNotFoundException, IOException {
    File file = new File("test.txt");
    FileInputStream fis = new FileInputStream(file);
    int data = fis.read();
    while (data != -1) {
      System.out.println((char) data);
      data = fis.read();
    }
    fis.close();
  }
}
