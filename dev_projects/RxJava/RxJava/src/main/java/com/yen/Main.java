package com.yen;

import com.yen.Util.FileUtil;

public class Main {
  public static void main(String[] args) {

    System.out.println("RX Hello world!");
    //
    //    System.out.println(FileUtil.getFileList(""));
    //    System.out.println(FileUtil.getFileList("src/main/java/com/yen/dev"));

    FileUtil.getFileListRx("src/main/java/com/yen/dev")
        .subscribe(
            file -> {
              System.out.println("file = " + file);
            });
  }

}