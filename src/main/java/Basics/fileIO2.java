package Basics;

// https://www.w3schools.com/java/java_files_create.asp

import java.io.FileWriter;
import java.io.IOException;

public class fileIO2 {
  public static void main(String[] args) {
    String path = "fileIO1_output.txt";
    // write to file
    try {
      FileWriter fileWriter = new FileWriter(path);
      fileWriter.write("abc abc lo lol 123 123 ~~~~~");
      fileWriter.close();
      System.out.println("write file OK ! " + path);
    } catch (IOException e) {
      System.out.println("Failed write to file");
      e.printStackTrace();
    }
  }
}
