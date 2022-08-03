package Basics.Regex;

import org.junit.jupiter.api.Test;

public class demo1 {

    @Test
    public void test1(){

        String htmlString = "<h1>{name}</h1><h1>{name1}</h1><h1>{name2}</h1>";
        System.out.println(">>> htmlString = " + htmlString);

        String dataKey = "name";
        String value = "xxx";
        String htmlStringUpdated = htmlString.replaceAll("\\{" + dataKey + "\\}", value);
        System.out.println(">>> htmlStringUpdated = " + htmlStringUpdated);
    }

    @Test
    public void test2(){

        String htmlString = "<h1>{name}</h1><h1>{name1}</h1><h1>{name2}</h1>";
        System.out.println(">>> htmlString = " + htmlString);

        String dataKey1 = "name";
        String value1 = "xxx";
        String dataKey2 = "name1";
        String value2 = "yyy";
        String htmlStringUpdated = htmlString
                .replaceAll("\\{" + dataKey1 + "\\}", value1)
                .replaceAll("\\{" + dataKey2 + "\\}", value2);
        System.out.println(">>> htmlStringUpdated = " + htmlStringUpdated);
    }

}
