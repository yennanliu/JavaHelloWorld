package com.yen.Util;

import reactor.core.publisher.Flux;

import java.io.IOException;
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
        try{
            fileList = Files.list(Paths.get(dir))
                    .filter(file -> !Files.isDirectory(file))
                    .map(file -> {
                        System.out.println("file = " + file + " filename = " + file.getFileName());
                        return file;
                    }).collect(Collectors.toList());
        }catch (Exception e){
            System.out.println("get file list exception : " + e.getMessage());
        }
        return fileList;
    }


}
