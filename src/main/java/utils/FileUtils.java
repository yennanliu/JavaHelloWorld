package utils;

import java.io.File;

public class FileUtils {

    // methods
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
