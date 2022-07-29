package Advances.Lambda.demo4;

// https://www.youtube.com/watch?v=dushR-wm_E8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=672

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    public static List<Employee> getEmployees(){

        List<Employee> list = new ArrayList<>();

        // add data
        list.add(new Employee(1001, "jack", 34, 700.1));
        list.add(new Employee(1002, "ryu", 3, 900));
        list.add(new Employee(1003, "yen", 10, 1001.1));
        list.add(new Employee(1004, "ken", 99, 9000));
        list.add(new Employee(1004, "ken", 99, 100000));
        list.add(new Employee(1005, "ken", 99, 7000));

        return list;
    }

}
