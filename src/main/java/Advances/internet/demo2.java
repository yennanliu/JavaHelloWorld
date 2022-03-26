package Advances.internet;

// https://www.youtube.com/watch?v=GEGJuUUM_Zo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=623

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *   Implement TCP internet protocol : demo 2
 *
 *   1) client sends msg, server shows msg on terminal
 */


public class demo2 {

    // client
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try{

            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 9999);

            os = socket.getOutputStream();
            os.write("hellooo \n".getBytes());
            os.write("this is client side".getBytes());

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (os != null){
                try{
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try{
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    // server
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try{
            ss = new ServerSocket(9999);

            socket = ss.accept();

            is = socket.getInputStream();

            // method 1) : not recommended : may have decode issue
//        byte[] buffer = new byte[20];
//        int len;
//        while((len = is.read(buffer)) != -1){
//            String str = new String(buffer, 0, len);
//            System.out.println(str);
//        }

            // method 2)
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());
            System.out.println("receive msg from client : " + socket.getInetAddress().getHostAddress());

        }catch (IOException e){
            e.printStackTrace();
            // close resources
        }finally {
            if (baos != null){
                try{
                    baos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (is != null){
                try{
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try{
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (ss != null){
                try{
                    ss.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
