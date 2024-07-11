package Advances.FileIO;

// https://www.youtube.com/watch?v=4d426JMTXhc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=577
// https://www.youtube.com/watch?v=mPFq9hUP74c&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=578

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.junit.jupiter.api.Test;

/** File IO demo 2 : File common methods */
public class demo2 {
  @Test
  public void test1() {
    File file1 = new File("hello.txt");
    File file2 =
        new File("/Users/yennanliu/JavaHelloWorld/src/main/java/Advances/FileIO/hello2.txt");

    System.out.println(file1.getAbsolutePath());
    System.out.println(file1.getPath());
    System.out.println(file1.getName());
    System.out.println(file1.getParent());
    System.out.println(file1.length());
    System.out.println(file1.lastModified());
    System.out.println(new Date(file1.lastModified()));

    System.out.println("====================");

    System.out.println(file2.getAbsolutePath());
    System.out.println(file2.getPath());
    System.out.println(file2.getName());
    System.out.println(file2.getParent());
    System.out.println(file2.length());
    System.out.println(file2.lastModified());
    System.out.println(new Date(file2.lastModified()));
  }

  @Test
  public void test2() {
    File file = new File("/Users/yennanliu/JavaHelloWorld/src/main/java/Advances");

    String[] list = file.list();
    for (String s : list) {
      System.out.println(s); // file name : e.g. : BigIntegerBigDecimalDemo1.java
    }

    System.out.println("====================");

    File[] files = file.listFiles();
    for (File f : files) {
      System.out.println(f); // absolute path : e.g.
      // /Users/yennanliu/JavaHelloWorld/src/main/java/Advances/InstantApi ...
    }
  }

  /**
   * public boolean renameTo(File dest) : rename file to given file path
   *
   * <p>e.g. : file1.renameTo(file2)
   */
  @Test
  public void test3() {
    File file1 = new File("hello.txt");
    File file2 = new File("hello2.txt");

    boolean renameTo = file1.renameTo(file2);
    System.out.println(renameTo);
  }

  @Test
  public void test4() {
    File file1 = new File("hello.txt");

    System.out.println(file1.isDirectory());
    System.out.println(file1.isFile());
    System.out.println(file1.exists());
    System.out.println(file1.canRead());
    System.out.println(file1.canWrite());
    System.out.println(file1.isHidden());
  }

  @Test
  public void test5() throws IOException {
    // create file
    File file1 = new File("hello.txt");
    if (!file1.exists()) {
      file1.createNewFile();
      System.out.println("crate file OK");
    } else {
      file1.delete();
      System.out.println("delete file OK");
    }
  }

  @Test
  public void test6() {
    // create file path
    File file1 = new File("/Users/yennanliu/JavaHelloWorld/src/main/java/myTest");

    // mkdir : will create given path (NOT create all parent paths is NOT exist)
    boolean mkdir = file1.mkdir();
    if (mkdir) {
      System.out.println("create dir OK");
    }

    File file2 = new File("/Users/yennanliu/JavaHelloWorld/src/main/scala/myTest2");

    // mkdirs : if upper paths not exist, will CREATE ALL of them (upper paths) as well at once
    boolean mkdir2 = file2.mkdirs();
    if (mkdir2) {
      System.out.println("create dir OK");
    }
  }
}
