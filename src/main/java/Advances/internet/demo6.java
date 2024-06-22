package Advances.internet;

// https://www.youtube.com/watch?v=92p9nzfPhsw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=628

import java.net.*;

/**
 * URL programming intro 1
 *
 * <p>1) URL (Uniform Resource Location), means a specific address in internet 2) via an URL, we can
 * locate and annotate how to access it 3) via URL, we can access various internet resources. e.g.
 * website, ftp 4) basic URL syntax: ->
 * <protocol>://<host_name>:<port>/<doc_name>#portition_name?param
 */
public class demo6 {
  public static void main(String[] args) {
    try {
      // just a url for testing
      URL url = new URL("http//localhost:8088/test.txt");

      System.out.println(url.getProtocol());
      System.out.println(url.getHost());
      System.out.println(url.getPort());
      System.out.println(url.getPath());
      System.out.println(url.getFile());
      System.out.println(url.getQuery());

    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }
}
