package Advances.Generic;

// https://www.youtube.com/watch?v=FIta2Jr0EVQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=564

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class demo1 {
    @Test
    public void test1(){
        // case 1
        ArrayList list1 = new ArrayList();

        list1.add(10);
        list1.add(75);
        list1.add(87);
        //list1.add("tom"); // problem 1 : type unsafe

        for (Object score: list1){
            // problem 2 : java.lang.ClassCastException may happen when Downcasting
            //          -> e.g. :java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
            int stuScore = (Integer) score;
            System.out.println(score);
        }
    }
}
