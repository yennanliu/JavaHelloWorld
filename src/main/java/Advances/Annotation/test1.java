package Advances.Annotation;

// https://www.youtube.com/watch?v=97y91HqV2Xo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=504

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class test1 {
    private static Object[] array;
    private static int total;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("BeforeAll ...");
    }

    @Test
    public void myTest1(){
        System.out.println("myTest1 ...");
        int int1 = 10;
        assert (int1==10);
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("AfterAll ...");
    }
}
