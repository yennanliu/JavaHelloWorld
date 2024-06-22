package Advances.IOFlow;

// https://www.youtube.com/watch?v=bksGRkSwEBM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=596

import org.junit.jupiter.api.Test;

import java.io.*;

/** File encrypt/decrypt demo */
public class demo8 {
  /** encrypt picture */
  @Test
  public void encryptTest() {

    FileInputStream fis = null;
    FileOutputStream fos = null;

    try {
      fis = new FileInputStream("src/main/java/Advances/IOFlow/java.png");
      fos = new FileOutputStream("src/main/java/Advances/IOFlow/java_encrypted.png");

      byte[] buffer = new byte[20];
      int len;
      while ((len = fis.read(buffer)) != -1) {
        /**
         * ---------------------------------------- encrypt !!! via modifying byte data
         * ----------------------------------------
         */

        // wrong !!!, we are NOT modifying byte data
        //            for (byte b: buffer){
        //                b = (byte) (b ^ 5);
        //            }

        // correct
        for (int i = 0; i < len; i++) {
          buffer[i] = (byte) (buffer[i] ^ 5);
        }
        fos.write(buffer, 0, len);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {

      // close resources
      if (fos != null) {
        try {
          fos.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      if (fis != null) {
        try {
          fis.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  /** decrypt picture */
  @Test
  public void decryptTest() {

    FileInputStream fis = null;
    FileOutputStream fos = null;

    try {
      fis = new FileInputStream("src/main/java/Advances/IOFlow/java_encrypted.png");
      fos = new FileOutputStream("src/main/java/Advances/IOFlow/java_decrypted.png");

      byte[] buffer = new byte[20];
      int len;
      while ((len = fis.read(buffer)) != -1) {
        /**
         * ---------------------------------------- decrypt !!! via modifying byte data
         * ----------------------------------------
         */

        /**
         * Below op is correct
         *
         * <p>Xor (異或) example : -> m = 12, n = 5 -> m ^ n ^ n = 12
         *
         * <p>DEMO : In [1]: m=12
         *
         * <p>In [2]: n=5
         *
         * <p>In [3]: m ^ n Out[3]: 9
         *
         * <p>In [4]: m ^ n ^ n Out[4]: 12
         *
         * <p>In [5]: m ^ n ^ n ^ n Out[5]: 9
         *
         * <p>In [6]: m ^ n ^ n ^ n ^ n Out[6]: 12
         */
        for (int i = 0; i < len; i++) {
          buffer[i] = (byte) (buffer[i] ^ 5);
        }
        fos.write(buffer, 0, len);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {

      // close resources
      if (fos != null) {
        try {
          fos.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      if (fis != null) {
        try {
          fis.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
