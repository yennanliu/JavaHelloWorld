package dev;

// https://github.com/yennanliu/til
// "optional" : https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/Optional/demo1.java
// java ternary operator : https://yubin551.gitbook.io/java-note/basic_java_programming/operator/ternary_instanceof

import dev.bean.Report;
import org.junit.jupiter.api.Test;

public class getDefaultIfNull {

    @Test
    public void test1() {

        Report r1 = new Report();
        System.out.println(">>> r1 = " + r1);
        System.out.println(">>> r1.getName() = " + r1.getName());
        //System.out.println(">>> r1.getName() = " + r1.getName().length()); // java.lang.NullPointerException

        System.out.println();

        Report r2 = new Report("", "", 0, 1.0);
        System.out.println(">>> r2 = " + r2);
        System.out.println(">>> r2.getName() = " + r2.getName());
        System.out.println(">>> r2.getName() = " + r2.getName().length());
    }

    @Test
    public void test2() {

        Report r1 = new Report("xxx", null, 0, 2.0);
        System.out.println(">>> r1 = " + r1);
        System.out.println(">>> r1.getName() = " + r1.getName());

        System.out.println();

        System.out.println(">>> r1.getId() = " + r1.getId());

        /** so if r1.getId() is null, we can still get default val via ternary operator */
        String x = r1.getId() == null ? "0.0" : r1.getId();
        System.out.println(Double.parseDouble(x));
        System.out.println(Double.parseDouble(r1.getId() == null ? "0.0" : r1.getId()));
    }

    @Test
    public void test3() {

        Report r1 = new Report("xxx", null, 0, 2.0);
        System.out.println(
                Double.parseDouble(r1.getId() == null ? "1.0" : r1.getId()) +
                        Double.parseDouble(r1.getId() == null ? "2.1" : r1.getId()) +
                        3.2
        );

    }

}
