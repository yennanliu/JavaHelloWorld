package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;

public class IFileUtils {

    // methods
    public static void printSubFile(File dir) {
        // print sub files
        File[] subfiles = dir.listFiles();

        for (File f : subfiles) {
            if (f.isDirectory()) {  // if directory
                printSubFile(f);
            } else { // if file
                System.out.println(f.getAbsolutePath());
            }
        }
    }

    public static void deleteDirectory(File file) {
        // if file is file, then delete
        // if file is a path, then NEED to delete all its sub files/paths, then delete the current path
        if (file.isDirectory()) {
            File[] all = file.listFiles();
            // for loop and delete path/file in next level
            for (File f : all) {
                deleteDirectory(f);
            }
        }
        // delete current path
        file.delete();
    }

    /**
     * method : copy file from src to dest
     */
    // https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/IOFlow/demo5.java#L44
    public void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int len; // record read-in char number (to cbuf) every time
            while ((len = fis.read(buffer)) != -1) {
                // NOTE !!! write len char each time
                String str = new String(buffer, 0, len);
                //System.out.println(str);
                fos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close fis
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // close fos
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * method : copy file from src to dest via Buffered IO flow
     */
    // https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/IOFlow/demo6.java#L86
    public void copyFileWithBuffered(String srcPath, String destPath) throws IOException {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bis != null) {
                bis.close();
            }

            if (bos != null) {
                bos.close();
            }
        }
    }

    public List<List<String>> loadCSVFile(File fileName) {
        final String COMMA_DELIMITER = ",";

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }

    public List<List<String>> loadCSV(String fileName) {
        File file = new File(fileName);
        return loadCSVFile(file);
    }

    public File getResourceDirFile(String fileName) {

        // https://stackoverflow.com/questions/15749192/how-do-i-load-a-file-from-resource-folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file;
    }

    /** compress file with password */
    public String encryptFile(List<String> srcFiles, String destZipFiles, String password){

        try {
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setEncryptFiles(true);
            zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
            zipParameters.setEncryptionMethod(EncryptionMethod.AES);
            List<File> files = new ArrayList<>();
            srcFiles.forEach(file -> {
                files.add(new File(file));
            });
            ZipFile zipFile = new ZipFile(destZipFiles, password.toCharArray());
            zipFile.addFiles(files, zipParameters);
            System.out.println("encryptFile OK,  destZipFiles : " + destZipFiles);
            return destZipFiles;
            // Catch exceptions
        } catch (ZipException e) {
            System.out.println("encryptFile failed, exception:" + e);
        }
        return null;
    }

}
