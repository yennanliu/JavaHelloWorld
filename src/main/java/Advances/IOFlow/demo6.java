package Advances.IOFlow;

// https://www.youtube.com/watch?v=Rxm-W6-AK1c&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=593
// https://www.youtube.com/watch?v=l7xOFkOQS7w&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=594

import org.junit.jupiter.api.Test;

import java.io.*;

/** Buffered IO flow demo1
 *
 *  1) Buffered IO flow : for RAISING file IO efficiency
 *       -> why ? java offers "buffer space" internally
 *       -> so each time java will load batch of data into "buffer space", then other file io flow can start from there -> better efficiency
 *
 *  2) Buffered IO flow:
 *      - BufferedInputStream
 *      - BufferedOutputStream
 *      - BufferedReader
 *      - BufferedFileWriter
 *
 *
 *  Ref) I/O flow structure
 *
 *       abstract class  |  節點流             |  緩衝流
 *       InputStream    |  FileInputStream   |  BufferedInputStream
 *       OutputStream   |  FileOutputStream  |  BufferedOutputStream
 *       Reader         |  FileReader        |  BufferedReader
 *       Writer         |  FileWriter        |  BufferedFileWriter
 */


public class demo6 {
    /** file IO with non-txt file */
    @Test
    public void test1() throws IOException {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try{
            // step 1) init File
            File srcFile = new File("src/main/java/Advances/IOFlow/java.png");
            File destFile = new File("src/main/java/Advances/IOFlow/java4.png");

            // step 2) init flow
            //  -> step 2.1) init 節點流 (FileInputStream, FileOutputStream)
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //  -> step 2.2) init BufferedInputStream, BufferedOutputStream
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // step 3) copy op, readIn, writeOut
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
                /** NOTE !!! we can refresh buffered space explicitly (via below code) */
                //bos.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {

            // step 4) resources closing
            // -> closing ordering : outer (layer) first, then inner (layer)
            if (bis != null){
                bis.close();
            }

            if (bos != null){
                bos.close();
            }

            // after outer (layer) (e.g. bis, bos) are closed, java will close inner (layer) (e.g. fos, fis) automatically
            //fos.close();
            //fis.close();
        }
    }

    @Test
    public void copyFileWithBufferedTest1() throws IOException {
        String src_file = "src/main/java/Advances/IOFlow/java.png";
        String dest_file = "src/main/java/Advances/IOFlow/java5.png";

        copyFileWithBuffered(src_file, dest_file);
    }

    /** method : copy file from src to dest via Buffered IO flow */
    public void copyFileWithBuffered(String srcPath, String destPath) throws IOException {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try{
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
                /** NOTE !!! we can refresh buffered space explicitly (via below code) */
                //bos.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {

            if (bis != null){
                bis.close();
            }

            if (bos != null){
                bos.close();
            }
        }
    }
}
