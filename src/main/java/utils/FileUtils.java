package utils;

import java.io.*;

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

    /** method : copy file from src to dest */
    // https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/IOFlow/demo5.java#L44
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

    /** method : copy file from src to dest via Buffered IO flow */
    // https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/IOFlow/demo6.java#L86
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
