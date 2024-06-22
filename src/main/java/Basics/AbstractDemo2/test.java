package Basics.AbstractDemo2;

// https://www.youtube.com/watch?v=Cwv1ssWVB6Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=345

public class test {
  public static void main(String[] args) {
    // run
    Manager manager1 = new Manager("Bezos", 1001, 999, 9999);
    manager1.work();

    System.out.println("===================");

    // *** polymorphism
    // pattern : superclass p1 = new subclass();
    Employee manager2 = new Manager("Mark", 1002, 777, 7777);
    manager2.work();

    System.out.println("===================");

    CommonEmployee commonEmployee = new CommonEmployee();
    commonEmployee.work();

    // *** down casting
    /**
     * pattern // MUST do upperCasting first (?) superclass p1 = new subclass(); // then do
     * downcasting subclass x1 = (subclass) p1;
     */
    Manager Manager3 = (Manager) manager2;
    Manager3.work();
  }
}
