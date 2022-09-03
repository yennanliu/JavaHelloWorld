package dev;

// https://github.com/yennanliu/til

import dev.bean.Report;
import org.junit.jupiter.api.Test;

public class getDefaultIfNull {

    @Test
    public void test1(){

        Report r1 = new Report();
        System.out.println(">>> r1 = " + r1);
        System.out.println(">>> r1.getName() = " + r1.getName());
        //System.out.println(">>> r1.getName() = " + r1.getName().length()); // java.lang.NullPointerException

        System.out.println();

        Report r2 = new Report("","",0,1.0);
        System.out.println(">>> r2 = " + r2);
        System.out.println(">>> r2.getName() = " + r2.getName());
        System.out.println(">>> r2.getName() = " + r2.getName().length());
    }

    @Test
    public void test2(){

        Report r1 = new Report("xxx",null,0,2.0);
        System.out.println(">>> r1 = " + r1);
        System.out.println(">>> r1.getName() = " + r1.getName());
        //System.out.println(">>> r1.getName() = " + r1.getName().length()); // java.lang.NullPointerException

        System.out.println(Double.parseDouble(r1.getId()));
    }

}
