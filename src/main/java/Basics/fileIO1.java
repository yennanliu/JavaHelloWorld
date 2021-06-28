package Basics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// https://www.w3schools.com/java/java_files_create.asp

public class fileIO1 {
    public static void main(String[] args) {
        String path = "fileIO1_output.txt";
        // create file
        try {
            File myObj = new File(path);
            FileWriter fWriter = new FileWriter(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
