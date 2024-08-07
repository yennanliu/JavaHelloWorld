package Advances.IOFlow;

// https://www.youtube.com/watch?v=kqG8IQNMN_s&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=584
// https://www.youtube.com/watch?v=lms-HDCYCvQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=586

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * - FileReader demo
 *
 * <p>1) I/O : input/output. for data transferred (across devices) 2) Java does data transfer via
 * "stream" 3) java.io package offers various "stream" class, and interfaces -> for different data
 * type -> use STDIN, STDOUT in general
 *
 * <p>- Types of I/O flow
 *
 * <p>1) based on unit: 字節流 (8 bit), 字符流 (16 bit) -> 字節流 (8 bit) : byte : for picture, video files
 * (non-text files) -> 字符流 (16 bit) : char (2 byte) : for text files
 *
 * <p>2) based in flow : inputStream, outputStream 3) based on roles : 節點流, 處理流
 *
 * <p>4) I/O flow structure - 1 abstract class | 字節流 | 字符流 輸入流 | inputStream | Reader 輸出流 |
 * outputStream | Writer
 *
 * <p>5) I/O flow structure - 2
 *
 * <p>abstract class | 節點流 | 緩衝流 InputStream | FileInputStream (read(byte[] buffer)) |
 * BufferedInputStream (read(byte[] buffer)) OutputStream | FileOutputStream (write(byte[] buffer,
 * 0, len) | BufferedOutputStream (write(byte[] buffer, 0, len) Reader | FileReader (read(char[]
 * cbuf)) | BufferedReader (read(char[] cbuf)) Writer | FileWriter (write(char[] cbuf, 0, len) |
 * BufferedFileWriter (write(char[] cbuf, 0, len)
 *
 * <p>6) Summary
 *
 * <p>6-1) For txt (.txt, .java, .cpp..) file : - use 字符流 (FileReader, FileWriter) or - use 字節流
 * (FileInputStream, FileOutputStream)
 *
 * <p>6-2) For non-txt (binary) (.jpg, .mps, .avi) : - use 字節流 (FileInputStream, FileOutputStream)
 */
public class demo1 {

  public static void main(String[] args) {
    File file = new File("hello.txt"); // under current project !!!
    System.out.println(file.getAbsolutePath()); // /Users/yennanliu/JavaHelloWorld/hello.txt
  }

  /**
   * FileReader demo 1
   *
   * <p>1) read() : return read char, if meet END of file, return -1 2) exception handling : for
   * CLOSING file conn in final step, we MUST use try-catch-finally (instead of throw Exception) ->
   * make sure file conn is always closed
   */
  @Test
  public void test1() {
    FileReader fr = null;
    try {
      // step 1) instantiate file class object, declare the file we are going to operate
      // File file = new File("hello.txt"); // under current module
      File file = new File("src/main/java/Advances/IOFlow/hello.txt");
      System.out.println(file.getAbsolutePath()); // /Users/yennanliu/JavaHelloWorld/hello.txt

      // step 2) offer flow (file IO flow)
      fr = new FileReader(file);

      // step 3) data read in  (V1)
      // read() : return read char, if meet END of file, return -1
      //            int data = fr.read(); // char mapping to an integer
      //            while (data != -1){
      //                System.out.print((char) data); // should be char data type
      //                data = fr.read(); // read next record  (similar as iterator)
      //            }

      // step 3) data read in (V2)
      int data;
      while ((data = fr.read()) != -1) {
        System.out.print((char) data);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        // step 4) close flow
        if (fr != null) {
          fr.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
