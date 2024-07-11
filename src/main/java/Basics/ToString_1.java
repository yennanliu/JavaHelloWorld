package Basics;

// https://www.youtube.com/watch?v=-R8A8FYJ6Mg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=300

import java.util.Date;

/**
 * Object's toString() method
 *
 * <p>1) When we print out one class's instance -> it actually calls the class's toString() method
 *
 * <p>2) Object's toString method (default) definition -> public String toString() { return
 * getClass().getName() + "@" + Integer.toHexString(hashCode()); }
 *
 * <p>3) Some classes such String, Date, File ... already RE-WRITE objects' toString() method -> so
 * when we call toString() within those class, it will return "actual" content
 *
 * <p>4) if we want to do above, we need to re-write toString() method as well
 */
public class ToString_1 {
  public static void main(String[] args) {

    // example 1
    CustomerX cust1 = new CustomerX("JIM", 19);
    System.out.println(cust1); // Basics.CustomerX@33c7353a (before rewrite toString)
    System.out.println(cust1); // Basics.CustomerX@33c7353a (before rewrite toString)

    System.out.println("=====================");

    // example 2
    String str1 = "USA";
    System.out.println(str1);

    System.out.println("=====================");

    // example 3
    Date date1 = new Date(23534534534L);
    System.out.println(date1);
    System.out.println(date1);
  }
}

class CustomerX {
  // attr
  private final String name;
  private final int id;

  // constructor
  public CustomerX(String name, int id) {
    this.id = id;
    this.name = name;
  }

  // method
  // re-write thString()
  @Override
  public String toString() {
    return "Customer id = " + id + ", name = " + name;
  }
}
