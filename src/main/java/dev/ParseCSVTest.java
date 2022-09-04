package dev;

import org.junit.jupiter.api.Test;
import utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ParseCSVTest {

    @Test
    public void test() throws FileNotFoundException {

        String csvFile = "test.csv";

        /**
         *  default java load file from /resources
         *      https://stackoverflow.com/questions/15749192/how-do-i-load-a-file-from-resource-folder
         */
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(csvFile).getFile());
        //InputStream inputStream = new FileInputStream(file);

        FileUtils fileUtils = new FileUtils();
        List<List<String>> data = fileUtils.loadCSVFile(file);

        System.out.println(data.toArray().length);
        data.stream().forEach(x -> System.out.println(x));
    }
    
}
