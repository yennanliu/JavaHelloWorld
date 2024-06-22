package dev;

import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import utils.IFileUtils;

public class FileTest {

    @Test
    public void test1(){

        ArrayList<String> files = new ArrayList<>();
        files.add("file_unzip/part-00000-92b76207-f477-48f5-a510-85dd0269ec01-c000.csv");
        files.add("file_unzip/part-00000-f8ee8e0f-deca-4beb-8d01-7696c6137a83-c000.csv");
        files.add("file_unzip/part-00000-9b9fb1b7-5464-491a-83ef-101ef112b863-c000.csv");

        files.stream().forEach(System.out::println);

        // Use String#matches (with regexp)
//        result = Stream.of(strings).filter(str -> str.matches("^" + prefix + ".*$"))
//                .collect(Collectors.toSet()).toArray(new String[0]);
//        Stream.of(result).forEach(System.out::println);  //-> adjnrj adcfd
//

    }

    @Test
    public void test2(){

        String CSV_ZIP_FILE = "some_file";
        IFileUtils.deleteDirectory(new File(CSV_ZIP_FILE));

        for (int i =1; i<5 ; i+=1){
            System.out.println(">>> " + i);
        }
    }

    @Test
    public void test3(){
        String x = "[1001]";
        String y = x.replace("[","").replace("]","");
        System.out.println(y);
    }

}
