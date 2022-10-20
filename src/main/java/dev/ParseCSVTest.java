package dev;

import org.junit.jupiter.api.Test;
import utils.IFileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ParseCSVTest {

    @Test
    public void test1() throws FileNotFoundException {

        String csvFile = "test.csv";

        /**
         *  default java load file from /resources
         *      https://stackoverflow.com/questions/15749192/how-do-i-load-a-file-from-resource-folder
         */
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(csvFile).getFile());
        //InputStream inputStream = new FileInputStream(file);

        IFileUtils IFileUtils = new IFileUtils();
        List<List<String>> data = IFileUtils.loadCSVFile(file);

        System.out.println(data.toArray().length);
        data.stream().forEach(x -> System.out.println(x));
    }

    @Test
    public void test2() throws FileNotFoundException {

        String csvFile = "test2.csv";

        IFileUtils IFileUtils = new IFileUtils();
        List<List<String>> data = IFileUtils.loadCSVFile(IFileUtils.getResourceDirFile(csvFile));

        System.out.println(data.toArray().length);

        data.stream().skip(1).forEach(x -> System.out.println(x.toString().replace("\"", "0")));

        System.out.println("==============");

        data.stream().skip(1).forEach(x -> {
            String id = x.get(0).replace("\"", "0");
            String name = x.get(1).replace("\"", "0");
            String balance = x.get(2).replace("\"", "0");

            System.out.println("id = " + id + " name = " + name + " balance = " + balance);
        });

        System.out.println("==============");

        // String x = r1.getId() == null ? "0.0" : r1.getId();

        data.stream().skip(1).forEach(x -> {
            String id = x.get(0).equals("") ? "0" : x.get(0);
            String name = x.get(1).length() < 1 ? "0" : x.get(1); // this one works
            String balance = x.get(2) == "" ? "0" : x.get(2);

            System.out.println("id = " + id + " name = " + name + " balance = " + balance);
        });

    }

}
