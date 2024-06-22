package Advances.Properties;

// https://www.youtube.com/watch?v=97Ex4VCIqBI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=557

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties demo1
 *
 * <p>1) usually for config, setting - key, value are String type
 */
public class demo1 {
  public static void main(String[] args) {
    FileInputStream fis = null;
    try {

      Properties pros = new Properties();
      fis = new FileInputStream("src/mySetting.properties");
      pros.load(fis);

      String name = pros.getProperty("name");
      String pwd = pros.getProperty("pwd");
      String machine = pros.getProperty("machine");

      System.out.println("name = " + name);
      System.out.println("pwd = " + pwd);
      System.out.println("machine = " + machine);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fis != null) {
        // close resource
        try {
          fis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
