package Advances.IOFlow3;

// https://www.youtube.com/watch?v=YwR1vvjO3Xo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=604

import java.io.*;
import org.junit.jupiter.api.Test;

/**
 * IOFlow3 demo 2: DataInputStream, DataOutputStream
 *
 * <p>1) use cases : -> for easily deal with "basic data structure", and "String" in Java ->
 * read/write basic data type, String data type
 *
 * <p>2) DataInputStream common methods: readBoolean() readChar() readByte() readFloat() ....
 *
 * <p>3) DataOutputStream common methods:
 */
public class demo2 {

  /** demo 1 : write file via DataOutputStream */
  @Test
  public void test1() throws IOException {

    DataOutputStream dos =
        new DataOutputStream(new FileOutputStream("src/main/java/Advances/IOFlow3/data.txt"));
    dos.writeUTF("ann");
    dos.flush(); // flush, so every write op will be reflected to output file
    dos.writeInt(17);
    dos.flush();
    dos.writeBoolean(false);
    dos.flush();

    // close resource
    dos.close();
  }

  /**
   * demo 2 : read file via DataInputStream
   *
   * <p>1) read basic data type in disk via DataInputStream 2) read data type (code) should be same
   * as data type in disk
   */
  @Test
  public void test2() throws IOException {

    DataInputStream dis =
        new DataInputStream(new FileInputStream("src/main/java/Advances/IOFlow3/data.txt"));

    String name = dis.readUTF();
    int age = dis.readInt();
    boolean isMale = dis.readBoolean();

    System.out.println("name = " + name + " age = " + age + " isMale = " + isMale);

    dis.close();
  }
}
