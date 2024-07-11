package dev;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import utils.IFileUtils;

public class IFileUtilsTest {

  @Test
  public void test1() {

    System.out.println(123);
    IFileUtils fileUtils = new IFileUtils();
    List<String> srcFiles = new ArrayList<>();

    srcFiles.add("src/main/resources/" + "test.csv");
    srcFiles.add("src/main/resources/" + "test2.csv");
    srcFiles.add("src/main/resources/" + "test1.txt");

    // String destZipFiles = "src/main/resources/" + "zipEncryptFile.zip";
    String destZipFiles = "src/main/resources" + ".zip";
    fileUtils.encryptFile(srcFiles, destZipFiles, "123");
  }

  @Test
  public void test2() throws IOException {
    String srcFile = "src/main/resources/" + "test.csv";
    String copiedFile = "src/main/resources/" + "test_copy.csv";
    FileUtils.copyFile(new File(srcFile), new File(copiedFile));
  }

  @Test
  public void test3() throws IOException {

    IFileUtils fileUtils = new IFileUtils();
    List<String> files = new ArrayList<>();

    String unzipFilePath = "src/main/resources/" + "test.csv";
    String copiedFile = "src/main/resources/" + "test3.csv";
    String destZipFiles = "src/main/resources/" + "test3_copied.zip";
    FileUtils.copyFile(new File(unzipFilePath), new File(copiedFile));

    files.add(copiedFile);
    // files.add(copiedFile);

    System.out.println(">>> files = " + files);

    // String encryptFileUrl = fileUtils.encryptFile(files, uploadPath + tempFile, password);
    fileUtils.encryptFile(files, destZipFiles, "123");
  }

  @Test
  public void test4() {
    System.out.println(">>>  File.separator = " + File.separator);
  }

  @Test
  public void test5() throws IOException {

    String srcFile = "src/main/resources/" + "test.csv";
    FileUtils.copyFileToDirectory(new File(srcFile), new File("src/main/resources/" + "backup"));

    // FileUtils.listFiles(new File("XXX"));
  }
}
