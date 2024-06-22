package Advances.internet;

// https://www.youtube.com/watch?v=XLRQQa_8E_I&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=628

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * URL programming intro 2
 *
 * <p>-> download file from server via URL
 */
public class demo7 {
  public static void main(String[] args) {

    InputStream is = null;
    FileOutputStream fos = null;
    HttpURLConnection urlConnection = null;

    try {
      String srcFile = "http//localhost:8088/test.txt";
      String destFile = "http//localhost:8088/test2.txt";
      URL url = new URL(srcFile);

      // download file from server
      urlConnection = (HttpURLConnection) url.openConnection();
      urlConnection.connect();

      is = urlConnection.getInputStream();
      fos = new FileOutputStream(destFile);

      byte[] buffer = new byte[1024];
      int len;
      while ((len = is.read(buffer)) != -1) {
        fos.write(buffer, 0, len);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // close resources
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (urlConnection != null) {
        urlConnection.disconnect();
      }
    }
  }
}
