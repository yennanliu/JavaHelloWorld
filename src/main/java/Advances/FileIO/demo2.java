package Advances.FileIO;

// https://www.youtube.com/watch?v=4d426JMTXhc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=577

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Date;


/** File IO demo 2 : File common methods
 */

public class demo2 {
    @Test
    public void test1(){
        File file1 = new File("hello.txt");
        File file2 = new File("/Users/yennanliu/JavaHelloWorld/src/main/java/Advances/FileIO/hello2.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
        System.out.println(new Date(file1.lastModified()));

        System.out.println("====================");

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
        System.out.println(new Date(file2.lastModified()));
    }

    @Test
    public void test2(){
        File file = new File("/Users/yennanliu/JavaHelloWorld/src/main/java/Advances");

        String[] list = file.list();
        for (String s: list){
            System.out.println(s); // file name : e.g. : BigIntegerBigDecimalDemo1.java
        }

        System.out.println("====================");

        File[] files = file.listFiles();
        for (File f: files){
            System.out.println(f); // absolute path : e.g. /Users/yennanliu/JavaHelloWorld/src/main/java/Advances/InstantApi ...
        }
    }

    /** public boolean renameTo(File dest) : rename file to given file path
     *
     *  e.g. : file1.renameTo(file2)
     */
    @Test
    public void test3(){
        File file1 = new File("hello.txt");
        File file2 = new File("hello2.txt");

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }
}
