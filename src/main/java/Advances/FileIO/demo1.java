package Advances.FileIO;

// https://www.youtube.com/watch?v=QPSOYtdlC4M&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=576

import org.junit.jupiter.api.Test;
import java.io.File;

/** File IO demo 1 : File class
 *
 *  1) File class object : represents a doc or doc path (file)
 *  2) File class is under java.io classs
 */

public class demo1 {

    /** test1 :
     *
     *  1) how to create file class instance
     *  2) relative VS absolute path
     */
    @Test
    public void test1(){
        // constructor 1
        File file = new File("hello.txt"); // relative path (current module)
        File file2 = new File("/Users/yennanliu/JavaHelloWorld/src/main/java/Advances/FileIO/demo1.java"); // absolute path

        System.out.println(file);
        System.out.println(file2);

        // constructor 2
        File file3 = new File("/JavaHelloWorld/src/main/java/Advances", "FileIO"); // parent, child
        System.out.println(file3);

        // constructor 3
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }
}
