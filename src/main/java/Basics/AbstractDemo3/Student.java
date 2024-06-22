package Basics.AbstractDemo3;

// https://www.youtube.com/watch?v=ArTiU9HR5Kw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=259

public class Student extends Person {
  // attr  (we can use the attr, method that Person already defined)
  String major;

  // constructor
  public Student() {}

  public Student(String name, int age, String major) {
    this.name = name;
    this.age = age;
    this.major = major;
  }

  @Override
  public void eat() {
    System.out.println("student eat !!!!");
  }

  @Override
  public void sleep() {
    System.out.println("student sleep !!!!");
  }

  // method  (we can use the attr, method that Person already defined)
  public void study() {
    System.out.println("i am study ~~~~");
  }
}
