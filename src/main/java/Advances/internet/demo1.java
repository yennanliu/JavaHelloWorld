package Advances.internet;

// https://www.youtube.com/watch?v=dSQoWwhzZYU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=622

/**
 * TCP VS UDP - ref : https://github.com/yennanliu/JavaHelloWorld/tree/main/doc/pic/tcp_udp_1.png
 *
 * <p>1) TCP : 1-1: before using TCP, we need to construct TCP connection (as data transfer channel)
 * 1-2: use "3 times handshake", make sure point-to-point transfer is reliable 1-3: can be used for
 * large amount data transfer 1-4: need to release connected channel, low efficiency
 *
 * <p>2) UDP : 2-1: transform data, source, destination to "data package", no need to setup
 * connection 2-2: size of every data package is <= 64K 2-3: Don't care if receiver is ready -> not
 * reliable 2-4: can broadcast sending 2-5: No need to release resources (e.g. channel), less
 * resources needed, faster speed
 */
public class demo1 {}
