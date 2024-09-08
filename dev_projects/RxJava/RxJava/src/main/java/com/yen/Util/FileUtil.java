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
    // V1
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

    // V2 (without lambda)
//      return Single.fromCallable(new Callable<List<Path>>() {
//          @Override
//          public List<Path> call() throws Exception {
//              //  NOTE !! : java.nio.file.Files
//              return Files.list(Paths.get(dir))
//                      .filter(new Predicate<Path>() {
//                          @Override
//                          public boolean test(Path file) {
//                              return !Files.isDirectory(file);
//                          }
//                      })
//                      .map(new Function<Path, Path>() {
//                          @Override
//                          public Path apply(Path file) {
//                              System.out.println("file = " + file + " filename = " + file.getFileName());
//                              return file;
//                          }
//                      })
//                      .collect(Collectors.toList());
//          }
//      }).onErrorReturn(new Function<Throwable, List<Path>>() {
//          @Override
//          public List<Path> apply(Throwable e) {
//              System.out.println("(RX) get file list exception: " + e.getMessage());
//              return List.of(); // return an empty list if an error occurs
//          }
//      });

  }

}
