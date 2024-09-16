package com.yen.Util;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.io.*;
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

    /**
     * NOTE !!!
     *
     * <p>Single.fromCallable
     *
     * <p>-> Wraps the code that retrieves the file list into a Single. It will execute the file
     * listing operation in a reactive way. If the operation succeeds, the Single will emit the list
     * of files; otherwise, it will trigger an error.
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
    //                              System.out.println("file = " + file + " filename = " +
    // file.getFileName());
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

  public static Path createDir(String dir) {
    Path path = Paths.get(dir);
    Path createdPath = null;
    if (Files.isDirectory(path)) {
      System.out.println("dir already existed");
      return path;
    }
    try {
      createdPath = Files.createDirectory(path);
      System.out.println("new path is created : " + createdPath.getFileName());
      return createdPath;
    } catch (Exception e) {
      System.out.println("create path error : " + e.getStackTrace());
    }
    return path;
  }

  public static Single<Path> createDirRX(String dir) {
    //        Path path = Paths.get(dir);
    //        Path createdPath = null;
    //        if(Files.isDirectory(path)){
    //            System.out.println("dir already existed");
    //            return Single.fromCallable(null);
    //        }
    //        return Single.fromCallable(() ->
    //                Files.createDirectory(path)).onErrorReturn(e -> {
    //            System.out.println("create path error : " + e.getMessage());
    //            return createdPath;
    //        });

    Path path = Paths.get(dir);

    return Single.fromCallable(
            () -> {
              if (Files.isDirectory(path)) {
                System.out.println("Directory already exists: " + path);
                return path; // Return the existing directory
              } else {
                return Files.createDirectory(path);
              }
            })
        .onErrorResumeNext(
            e -> {
              System.out.println("Error creating directory: " + e.getMessage());
              return Single.just(path); // Return the original path even if creation failed
            });
  }

  public static OutputStream readFile(String fileName) throws IOException {
    InputStream inputStream = new FileInputStream(fileName);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    byte[] buffer = new byte[1024];
    int bytesRead;
    while ((bytesRead = inputStream.read(buffer)) != -1) {
      outputStream.write(buffer, 0, bytesRead);
    }

    inputStream.close();
    return outputStream;
  }

  public static Single<ByteArrayOutputStream> readFileRX(String fileName) throws IOException {
    return Single.create(
        emitter -> {
          try {
            InputStream inputStream = new FileInputStream(fileName);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
              outputStream.write(buffer, 0, bytesRead);
            }
            emitter.onSuccess(outputStream);
          } catch (IOException e) {
            emitter.onError(e);
          }
        });
  }

  // Alternative for a stream of bytes (might not be suitable for large files)
  public static Observable<Byte> readFileRxAsStream(String fileName) {
    return Observable.create(
        emitter -> {
          try (InputStream inputStream = new FileInputStream(fileName)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
              for (int i = 0; i < bytesRead; i++) {
                emitter.onNext(buffer[i]);
              }
            }
            emitter.onComplete();
          } catch (IOException e) {
            emitter.onError(e);
          }
        });
  }
}
