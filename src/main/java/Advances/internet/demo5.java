package Advances.internet;

// https://www.youtube.com/watch?v=NdnJMytRW04&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=626

import java.io.*;
import java.net.*;
import org.junit.jupiter.api.Test;

/**
 *   UDP intro & demo 1
 *
 *   1) DatagramSocket, DatagramPacket class help UDP program implementation
 *   2) UDP info via DatagramSocket send and receiver.
 *      -> However, system NOT Grantee when/whether such info can be sent to client side
 *
 *   3) DatagramPacket encapsulates UDP data msg, sender ip, address,  receiver ip, address are included
 *
 *   4) Every UCP protocol has address info, so NO NEED to set up connection (with receiver), similar as delivery service
 *
 */

public class demo5 {

    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();

        String str = "this is UDP msg";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);

        socket.close();
    }

    @Test
    public void receiver() throws IOException {

        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(),0, packet.getLength()));

        socket.close();
    }
}
