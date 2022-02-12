package Advances.IOFlow;

// https://www.youtube.com/watch?v=p-hBYK_NMXo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=588

import org.junit.jupiter.api.Test;

import java.io.*;

/**  IOFlow demo 2 : FileWriter */

public class demo2 {
    /** FileWriter demo 1
     *
     *  1) write in-memory data to file in disk
     *
     *  2)  if outfile not existed,
     *        -> FileWriter will make a new one automatically
     *      if outfile existed,
     *        -> FileWriter will overwrite current content (new FileWriter(file, false);)
     *        -> FileWriter will append new data to current content (new FileWriter(file, true);)
     *
     *
     *
     */
    @Test
    public void test1() throws IOException {

        // step 1) offer file class object, declare plan-to-write file
        File file = new File("src/main/java/Advances/IOFlow/hello2.txt");

        // step 2) offer FileWriter object, for data writing
        //FileWriter fw = new FileWriter(file, true); // append to current file (NOT overwrite)
        FileWriter fw = new FileWriter(file, false); // NOT append to current file (overwrite)

        // step 3) writing op
        fw.write(">>> start >>> \n");
        fw.write("this is Advances.IOFlow.FileWriter output!!!\n");
        fw.write(">>> end >>> ");

        // step 4) I/O flow close (close FileWriter)
        fw.close();
    }
}

