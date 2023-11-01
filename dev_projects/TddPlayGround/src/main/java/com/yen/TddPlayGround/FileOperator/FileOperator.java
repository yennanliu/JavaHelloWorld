package com.yen.TddPlayGround.FileOperator;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// https://www.w3schools.com/java/java_files_read.asp

public class FileOperator {

    public List<String> listFiles(String path){
        return null;
    }

    public String readFile(String fileName) throws FileNotFoundException{

        String res = null;
        File obj = new File(fileName);
        Scanner scanner = new Scanner(obj);
        while (scanner.hasNextLine()){
            String data = scanner.nextLine();
            res += data;
        }

        scanner.close();
        return res;
    }

    public String CreateFile(String path){
        return null;
    }

    public String deleteFile(String path){
        return null;
    }

}
