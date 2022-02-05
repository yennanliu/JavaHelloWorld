package Advances.FileIO;

// https://www.youtube.com/watch?v=qGibCZce_bI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=579

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class demo3 {

    @Test
    public void test1() throws IOException {
        File file = new File("hello.txt");
        File destFile = new File(file.getParent(), "hello2.txt");
        boolean newFile = destFile.createNewFile();

        if(newFile){
            System.out.println("crate file OK");
        }
    }

    @Test
    public void test2(){
        File dir = new File("/Users/yennanliu/JavaHelloWorld/src/main/java/Advances");
        printSubFile(dir);
    }

    @Test
    public void test3(){
        // if we want to delete path, there MUST be NO files, sub paths under it
        File file = new File("hello2.txt");
        System.out.println(file.delete());
    }

    // help func
    public static void printSubFile(File dir){
        // print sub files
        File[] subfiles = dir.listFiles();

        for (File f: subfiles){
            if (f.isDirectory()){  // if directory
                printSubFile(f);
            }else{ // if file
              System.out.println(f.getAbsolutePath());
            }
        }
    }

    public void deleteDirectory(File file){
        // if file is file, then delete
        // if file is a path, then NEED to delete all its sub files/paths, then delete the current path
        if (file.isDirectory()) {
            File[] all = file.listFiles();
            // for loop and delete path/file in next level
            for (File f: all){
                deleteDirectory(f);
            }
        }
        // delete current path
        file.delete();
    }
}
