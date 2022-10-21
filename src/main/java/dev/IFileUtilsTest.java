package dev;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import utils.IFileUtils;
import org.apache.commons.io.FileUtils;

public class IFileUtilsTest {

  @Test
  public void test1(){

    System.out.println(123);
    IFileUtils fileUtils = new IFileUtils();
    List<String> srcFiles = new ArrayList<>();

    srcFiles.add("src/main/resources/" + "test.csv");
    srcFiles.add("src/main/resources/" + "test2.csv");
    srcFiles.add("src/main/resources/" + "test1.txt");

    //String destZipFiles = "src/main/resources/" + "zipEncryptFile.zip";
    String destZipFiles = "src/main/resources" + ".zip";
    fileUtils.encryptFile(srcFiles, destZipFiles, "123");
  }

  @Test
  public void test2() throws IOException {
    String srcFile = "src/main/resources/" + "test.csv";
    String copiedFile = "src/main/resources/" + "test_copy.csv";
    FileUtils.copyFile(new File(srcFile), new File(copiedFile));
  }

}
