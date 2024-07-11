package Advances.internet;

// https://www.youtube.com/watch?v=Dqyr7TZrkg0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=624
// https://www.youtube.com/watch?v=Dqyr7TZrkg0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=625

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.junit.jupiter.api.Test;

/**
 * Implement TCP internet protocol : demo 4
 *
 * <p>1) client sends doc, server saves it to local, and return "success" to client, then close
 * connection
 */
public class demo4 {

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

    // NOTE !!! : shutdown socket when file transmitted completed (or will block socket)
    socket.shutdownOutput();

    // step 5) receive server's response, and print on terminal
    InputStream is = socket.getInputStream();
    // decode
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buffer2 = new byte[20];
    int len2;
    while ((len2 = fis.read(buffer2)) != -1) {
      baos.write(buffer2, 0, len2);
    }

    System.out.println("client msg >>>");
    // TODO : fix this
    System.out.println(baos);
    // System.out.println("file received !! (msg from server)");
    System.out.println("client msg >>>");

    // step 6) close resources
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

    String destFile = "src/main/java/Advances/internet/data_output2.txt";

    // step 4) create file output stream
    FileOutputStream fos = new FileOutputStream(destFile);

    // step 5) read, write op
    byte[] buffer = new byte[1024];
    int len;
    while ((len = is.read(buffer)) != -1) {
      fos.write(buffer, 0, len);
    }

    // step 6) send response to client
    OutputStream os = socket.getOutputStream();
    System.out.println("file sent !! (server)");
    os.write("file received !! (msg from server)".getBytes());

    // step 7) close resources
    fos.close();
    is.close();
    socket.close();
    ss.close();
    os.close();
  }
}
