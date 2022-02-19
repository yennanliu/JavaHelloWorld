package Advances.IOFlow;

// https://www.youtube.com/watch?v=ssHMy0qJtCA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=597

import org.junit.jupiter.api.Test;

import java.io.*;

/** BufferedReader, BufferedFileWriter demo */

public class demo7 {

    /** demo : do txt file copy via BufferedReader, BufferedFileWriter */
    @Test
    public void test1() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            // step 1) init IO flow
            br = new BufferedReader(new FileReader(new File("src/main/java/Advances/IOFlow/hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("src/main/java/Advances/IOFlow/hello5.txt")));

            // step 2) IO op
            char[] cbuf = new char[1024];
            int len;
            while ((len = br.read(cbuf)) != -1){
                bw.write(cbuf, 0, len);
                //bw.flush(); // refresh cache (buffered space), not necessary
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {

            // step 3) close resources
            if (bw != null){
                try{
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if (br != null){
                try{
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
