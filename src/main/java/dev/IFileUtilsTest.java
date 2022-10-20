package dev;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import utils.IFileUtils;

public class IFileUtilsTest {

  @Test
  public void test1(){

    System.out.println(123);
    IFileUtils fileUtils = new IFileUtils();
    List<String> srcFiles = new ArrayList<>();

    srcFiles.add("src/main/resources/" + "test.csv");
    srcFiles.add("src/main/resources/" + "test2.csv");
    srcFiles.add("src/main/resources/" + "test1.txt");
    
    String destZipFiles = "src/main/resources/" + "zipEncryptFile.zip";
    fileUtils.encryptFile(srcFiles, destZipFiles, "123");
  }

}
