package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
