package Advances.RandomAccessFile;

// https://www.youtube.com/watch?v=_SvhcNMsyO8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=615

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *  RandomAccessFile demo 1
 *
 *  1) RandomAccessFile is directly below java.lang.Object class,
 *     implement DataInput, DataOutput interface
 *
 *  2) RandomAccessFile can be BOTH input, and output flow
 *     (but have to init 2 java instances)
 *
 *  3) while RandomAccessFile DataOutput,
 *      3-1) if output file not existed, RandomAccessFile will automatically make a new one
 *      3-2) if output file already existed, will OVERWRITE original file (write from beginning)
 *
 *
 */
public class demo1 {
    @Test
    public void test1() throws IOException {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try{

            // step 1)
            raf1 = new RandomAccessFile(new File("src/main/java/Advances/RandomAccessFile/input1.txt"),"r");
            raf2 = new RandomAccessFile(new File("src/main/java/Advances/RandomAccessFile/output1.txt"),"rw");

            // step 2)
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                raf2.write(buffer, 0, len);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {

            // step 3)
            if (raf1 != null){
                try{
                    raf1.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if (raf2 != null){
                try{
                    raf2.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = null;

        raf1 = new RandomAccessFile(new File("src/main/java/Advances/RandomAccessFile/output2.txt"),"rw");

        raf1.write("ababba".getBytes());

        raf1.close();
    }
}
