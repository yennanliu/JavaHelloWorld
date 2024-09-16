package com.yen;

import com.yen.Util.FileUtil;

import java.io.IOException;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("RX Hello world!");

        /** TEST 1 */

        //System.out.println(FileUtil.getFileList(""));
        //System.out.println(FileUtil.getFileList("src/main/java/com/yen/dev"));

        /** TEST 2 */
//        FileUtil.getFileListRx("src/main/java/com/yen/dev")
//                .subscribe(
//                        file -> {
//                            System.out.println("file = " + file);
//                        });

        /** TEST 3 */
        //System.out.println(FileUtil.createDir("zzz"));


        /** TEST 4 */
//        FileUtil.createDirRX("zzz").subscribe(
//                path -> {
//                    System.out.println("path = " + path);
//                }
//        );


        /** TEST 5 */
//        OutputStream outputStream = FileUtil.readFile("pom.xml");
//        System.out.println(outputStream.toString());

        /** TEST 6 */
        // readFileRX
        FileUtil.readFileRX("pom.xml")
                .subscribe(System.out::println);

        /** TEST 7 */
//        FileUtil.readFileRxAsStream("pom.xml")
//                .subscribe(System.out::println); // TODO : fix this

    }

}