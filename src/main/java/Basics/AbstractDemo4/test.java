package Basics.AbstractDemo4;

// https://www.youtube.com/watch?v=3VqFJPmA3wg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=348

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        // run
        // method 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("plz input current month");
        int month = scanner.nextInt();

        // method 2
        //Calendar calendar = Calendar.getInstance();
        // get current month
        //calendar.get(Calendar.MONTH);

        Employee[] emps = new Employee[2];

        // wrong : 'Employee' is abstract; cannot be instantiated
        // emps[0] = new Employee()

        // polymorphism
        emps[0] = new SalaryEmployee("jack", 1001, new MyDate(1990,11,1), 1000);
        emps[1] = new HourlyEmployee("Amy", 1002, new MyDate(1992,2,2), 100, 30);

        for (int i=0; i < emps.length; i++){
            System.out.println(emps[i]);
            double salary = emps[i].earnings();
            System.out.println("MONTH salary = " + salary);

            if (month == emps[i].getBirthday().getMonth()){
                System.out.println("happy B-day !!, here is bonus 100000");
            }
        }
    }
}
