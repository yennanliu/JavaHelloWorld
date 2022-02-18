package Advances.IOFlow;

// https://www.youtube.com/watch?v=jzqstfIodNA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=590
// https://www.youtube.com/watch?v=jQHfKvXhugw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=591

import org.junit.jupiter.api.Test;

import java.io.*;

/**  IOFlow demo 4 : FileReader & FileWriter : read/load picture */

public class demo4 {
    @Test
    public void test1() throws IOException {

        // NOTE : we use 字節流 (inputStream, outputStream) for binary file IO
        FileInputStream fr = null;
        FileOutputStream fw = null;

        try {

            // step 1) create file instance, define read-in and write-out file
            File srcFile = new File("src/main/java/Advances/IOFlow/java.png");
            File destFile = new File("src/main/java/Advances/IOFlow/java2.png");

            // step 2) create input flow, and output flow instance
            // NOTE !! we CAN'T use 字符流 (FileReader, FileWriter)  for binary file IO (e.g. picture, video)
            // -> we should use 字節流 (inputStream, outputStream) instead
            fr =  new FileInputStream(srcFile);
            fw = new FileOutputStream(destFile);

            // step 3) data read-in and write out op
            // NOTE !! we use byte for binary file IO here
            byte[] buffer = new byte[5];
            int len; // record read-in char number (to cbuf) every time
            while ((len = fr.read(buffer))!= -1){
                // NOTE !!! write len char each time
                String str = new String(buffer, 0, len);
                System.out.println(str);
                fw.write(buffer, 0, len);
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
