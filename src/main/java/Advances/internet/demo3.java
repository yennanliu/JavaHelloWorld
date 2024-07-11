package Advances.internet;

// https://www.youtube.com/watch?v=IOpiio4vub0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=623

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.junit.jupiter.api.Test;

/**
 * Implement TCP internet protocol : demo 3
 *
 * <p>1) client sends doc, server saves it to local
 */

// NOTE : should use "try-catch-finally" for exception handling (as demo2.java)
public class demo3 {

  // client
  @Test
  public void client() throws IOException {

    // step 1) create socket
    Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);

    // step 2) create output stream
    OutputStream os = socket.getOutputStream();

    String srcFile = "src/main/java/Advances/internet/data.txt";

    // step 3) read file
    FileInputStream fis = new FileInputStream(new File(srcFile));

    // step 4) actual read op
    byte[] buffer = new byte[1024];
    int len;
    while ((len = fis.read(buffer)) != -1) {
      os.write(buffer, 0, len);
    }

    // step 5) close resources
    fis.close();
    os.close();
    socket.close();
  }

  // server
  @Test
  public void server() throws IOException {

    // step 1) create ServerSocket
    ServerSocket ss = new ServerSocket(9999);

    // step 2) get client socket
    Socket socket = ss.accept();

    // step 3) get client input stream
    InputStream is = socket.getInputStream();

    String destFile = "src/main/java/Advances/internet/data_output.txt";

    // step 4) create file output stream
    FileOutputStream fos = new FileOutputStream(destFile);

    // step 5) read, write op
    byte[] buffer = new byte[1024];
    int len;
    while ((len = is.read(buffer)) != -1) {
      fos.write(buffer, 0, len);
    }

    // step 6) close resources
    fos.close();
    is.close();
    socket.close();
    ss.close();
  }
}
