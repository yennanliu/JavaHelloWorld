package Advances.IOFlow2;

// https://www.youtube.com/watch?v=ITikQNDAYEc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=599
// https://www.youtube.com/watch?v=JE-Vpvvdzr0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=600

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *  IOFlow2 demo1 : Transformation flow :
 *              -> transform between 字節流 (byte, 8 bits) & 字符流 (char, 16 bits)
 *
 *   1) Types: (belongs to 字符流 (char, 16 bits))
 *       InputStreamReader : byte input to char input
 *       OutputStreamWriter : char output to byte output
 *
 *   2) use cases : byte <-> char
 *
 *   3) decode : byte, byte array -> char, char array
 *      encode : char, char array -> byte, byte array
 */

public class demo1 {

    /**
     *  demo 1:
     *
     *  1) Exception handling : we should still use try-catch-finally as standard style
     *  2) demo how to use InputStreamReader : byte input -> char input transformation
     */
    @Test
    public void test1() throws IOException {

        FileInputStream fis = new FileInputStream("src/main/java/Advances/IOFlow2/hello.txt");
        InputStreamReader isr = new InputStreamReader(fis); // use system default char setting
        //InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); // use UTF-8 char type explicitly

        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf)) != -1){
            String str = new String(cbuf, 0, len);
            System.out.println(str);
        }
        // close resources
        isr.close();
        fis.close();
    }

    /**
     *  demo 2 : InputStreamReader and OutputStreamWriter
     *
     *  1) Exception handling : we should still use try-catch-finally as standard style
     *
     */
    @Test
    public void test2() throws IOException {

        // step 1) make doc, flow
        File file1 = new File("src/main/java/Advances/IOFlow2/hello.txt");
        File file2 = new File("src/main/java/Advances/IOFlow2/hello2.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");

        // step 2) read, write data
        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1){
            osw.write(cbuf, 0, len);
        }

        // step 3) close resources
        isr.close();
        osw.close();
        fis.close();
        fos.close();
    }
}
