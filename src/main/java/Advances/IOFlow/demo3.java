package Advances.IOFlow;

// https://www.youtube.com/watch?v=bgMNw70CVrw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=589

import org.junit.jupiter.api.Test;

import java.io.*;

/**  IOFlow demo 2 : FileReader & FileWriter */

public class demo3 {
    @Test
    public void test1() throws IOException {

        FileReader fr = null;
        FileWriter fw = null;

        try {

            // step 1) create file instance, define read-in and write-out file
            File srcFile = new File("src/main/java/Advances/IOFlow/hello.txt");
            File destFile = new File("src/main/java/Advances/IOFlow/hello3.txt");

            // step 2) create input flow, and output flow instance
            fr =  new FileReader(srcFile);
            fw = new FileWriter(destFile);

            // step 3) data read-in and write out op
            char[] cbuf = new char[5];
            int len; // record read-in char number (to cbuf) every time
            while ((len = fr.read(cbuf))!= -1){
                // NOTE !!! write len char each time
                fw.write(cbuf, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // step 4) close down IO flow resources

            // close fr
            if (fr != null){
                try{
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            // close fw
            if (fw != null){
                try{
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
