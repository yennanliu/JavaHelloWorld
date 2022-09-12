package dev;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;
import org.junit.jupiter.api.Test;

public class CSV2Json {

    // https://dzone.com/articles/how-to-convert-csv-to-json-in-java
    @Test
    public void test1(){

    }

    // https://www.tutorialspoint.com/convert-csv-to-json-using-the-jackson-library-in-java
    @Test
    public void test2(){

            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            System.out.println("Current absolute path is: " + s);

            //String csvFile = "classpath:test.csv";
            String csvFile = "src/main/resources/" + "test.csv";
            File input = new File(csvFile);
            try {
                CsvSchema csv = CsvSchema.emptySchema().withHeader();
                CsvMapper csvMapper = new CsvMapper();

                MappingIterator<Map<?, ?>> mappingIterator =
                        csvMapper.reader().forType(Map.class).with(csv).readValues(input);

                List<Map<?, ?>> list = mappingIterator.readAll();
                System.out.println(list);
            } catch(Exception e) {
                e.printStackTrace();
       }
    }

}
