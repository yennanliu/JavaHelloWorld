package dev;

import org.junit.jupiter.api.Test;
import utils.FileUtils;

import java.io.File;
import java.util.List;

public class FileIOTest {

    @Test
    public void test1(){

        //FileUtils.writeByteArrayToFile(new File(CSV_FILE), csv_data);
    }

    @Test
    public void test2(){

        String csvFile = "classpath:test.csv";
        //File file = new File(getClass().getResource("/test.csv").getFile());
        File file = new File(getClass().getResource("/templates/test1.ftl").getFile());
        String resources_file_path = getClass().getResource("/templates/test1.ftl").getFile();

        FileUtils fileUtils = new FileUtils();
        List<List<String>> res = fileUtils.loadCSVFile(file);

        System.out.println(">>> resources_file_path = " + resources_file_path);

        System.out.println("============");

        res.forEach(x -> System.out.println(x));
    }

}
