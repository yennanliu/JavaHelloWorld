package com.yen.Util;

import io.reactivex.rxjava3.core.Single;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

  // list file under path
  // https://www.baeldung.com/java-list-directory-files
  public static List<Path> getFileList(String dir) {
    System.out.println("dir = " + dir);
    List<Path> fileList = null;
    try {
      //  java.nio.file.Files
      fileList =
          Files.list(Paths.get(dir))
              .filter(file -> !Files.isDirectory(file))
              .map(
                  file -> {
                    System.out.println("file = " + file + " filename = " + file.getFileName());
                    return file;
                  })
              .collect(Collectors.toList());
    } catch (Exception e) {
      System.out.println("get file list exception : " + e.getMessage());
    }
    return fileList;
  }

  public static Single<List<Path>> getFileListRx(String dir) {
    System.out.println("(RX) dir = " + dir);

    /** NOTE !!!
     *
     *  Single.fromCallable
     *
     *  -> Wraps the code that retrieves the file list into a Single.
     *     It will execute the file listing operation in a reactive way.
     *     If the operation succeeds, the Single will emit the list of files;
     *     otherwise, it will trigger an error.
     */
    return Single.fromCallable(
            () ->
                //  NOTE !! : java.nio.file.Files
                Files.list(Paths.get(dir))
                    .filter(file -> !Files.isDirectory(file))
                    .map(
                        file -> {
                          System.out.println(
                              "file = " + file + " filename = " + file.getFileName());
                          return file;
                        })
                    .collect(Collectors.toList()))
        .onErrorReturn(
            e -> {
              System.out.println("(RX) get file list exception: " + e.getMessage());
              return List.of(); // return an empty list if an error occurs
            });
  }
}
