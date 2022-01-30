package Advances.Generic;

// https://www.youtube.com/watch?v=cgsQbgB5egA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=566

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class demo2 {

    /** demo1 : natural ordering with generic type */
    @Test
    public void test1() {
        TreeSet<Employee> set = new <Employee>TreeSet();

        Employee e1 = new Employee("ANN", 20, new MyDate(1911, 10, 10));
        Employee e2 = new Employee("ben", 30, new MyDate(1999, 9, 5));
        Employee e3 = new Employee("wen", 54, new MyDate(1985, 3, 4));

        set.add(e1);
        set.add(e2);
        set.add(e3);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /** demo2 : custom ordering */
//    @Test
//    public void test2(){
//        TreeSet set = new TreeSet(new Comparator() {
//
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Employee && o2 instanceof Employee) {
//                    Employee e1 = (Employee) o1;
//                    Employee e2 = (Employee) o2;
//
//                    MyDate b1 = e1.getBirthday();
//                    MyDate b2 = e2.getBirthday();
//                    return 0;
//                }
//            }
//        }
//    }

}
