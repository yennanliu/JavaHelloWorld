package Advances.IOFlow;

// https://www.youtube.com/watch?v=jzqstfIodNA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=590
// https://www.youtube.com/watch?v=jQHfKvXhugw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=591
// https://www.youtube.com/watch?v=XHXEBJxJ3bo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=591

import java.io.*;
import org.junit.jupiter.api.Test;

/** FileInputStream & FileOutputStream : (binary file IO) demo */
public class demo4 {
  @Test
  public void test1() throws IOException {

    // NOTE : we use 字節流 (inputStream, outputStream) for binary file IO
    FileInputStream fis = null;
    FileOutputStream fos = null;

    try {

      // step 1) create file instance, define read-in and write-out file
      File srcFile = new File("src/main/java/Advances/IOFlow/java.png");
      File destFile = new File("src/main/java/Advances/IOFlow/java2.png");

      // step 2) create input flow, and output flow instance
      // NOTE !! we CAN'T use 字符流 (FileReader, FileWriter)  for binary file IO (e.g. picture, video)
      // -> we should use 字節流 (inputStream, outputStream) instead
      fis = new FileInputStream(srcFile);
      fos = new FileOutputStream(destFile);

      // step 3) data read-in and write out op
      // NOTE !! we use byte for binary file IO here
      byte[] buffer = new byte[5];
      int len; // record read-in char number (to cbuf) every time
      while ((len = fis.read(buffer)) != -1) {
        // NOTE !!! write len char each time
        String str = new String(buffer, 0, len);
        System.out.println(str);
        fos.write(buffer, 0, len);
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {

      // step 4) close down IO flow resources

      // close fis
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      // close fos
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
