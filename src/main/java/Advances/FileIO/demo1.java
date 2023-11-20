package Advances.FileIO;

// https://www.youtube.com/watch?v=QPSOYtdlC4M&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=576
// https://www.youtube.com/watch?v=mPFq9hUP74c&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=578

import org.junit.jupiter.api.Test;
import java.io.File;

/** File IO demo 1 : File class
 *
 *  1) File class object : represents a doc or doc path (file)
 *  2) File class is under java.io class
 *  3) File class can do file/file path create, delete, rename, modified time, file size...
 *     -> BUT CAN'T read or write File
 *     -> if we want read or write File -> need to use IO flow
 *  4) File class will be used as "parameter" and passed to IO flow as read, write "end point"
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
        File file2 = new File("/Users/yennanliu/JavaHelloWorld/src/main/java/Advances/FileIO/Hungry.java"); // absolute path

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
