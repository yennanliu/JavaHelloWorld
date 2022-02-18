package Advances.IOFlow;

// https://www.youtube.com/watch?v=OsfY3Y5ZDGM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=592

import org.junit.jupiter.api.Test;

import java.io.*;

public class demo5 {

    /** test copyFile method (binary file) */
    @Test
    public void testCopyFile1(){

        long start = System.currentTimeMillis();

        String src_path = "src/main/java/Advances/IOFlow/java.png";
        String dest_path = "src/main/java/Advances/IOFlow/java3.png";
        copyFile(src_path, dest_path);

        long end = System.currentTimeMillis();

        System.out.println("copyFile cost time :" + (end - start));
    }

    /** test copyFile method (txt file) */
    @Test
    public void testCopyFile2(){

        long start = System.currentTimeMillis();

        // FileInputStream, FileOutputStream can be used on txt file IO as well
        // It works fine if we don't print content during copy (transferred in binary format)
        String src_path = "src/main/java/Advances/IOFlow/hello.txt";
        String dest_path = "src/main/java/Advances/IOFlow/hello4.txt";
        copyFile(src_path, dest_path);

        long end = System.currentTimeMillis();

        System.out.println("copyFile cost time :" + (end - start));
    }


    /** method : copy (binary) file from src to dest */
    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis =  new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int len; // record read-in char number (to cbuf) every time
            while ((len = fis.read(buffer))!= -1){
                // NOTE !!! write len char each time
                String str = new String(buffer, 0, len);
                //System.out.println(str);
                fos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close fis
            if (fis != null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            // close fos
            if (fos != null){
                try{
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

