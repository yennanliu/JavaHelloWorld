package Basics.Overwrite_demo2;

// https://www.youtube.com/watch?v=z4jVMvyf1D8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=272

public class Student extends Person {
  // attr
  String major;

  // constructor
  public Student() {}

  public Student(String major) {
    this.major = major;
  }

  // method
  public void study() {
    System.out.println("hello !!! my major is " + major);
  }

  public void eat() { // overwrite method from superclass
    System.out.println("**** Student is eating !!!");
  }

  // overwrite method from Person
  // and here we can use different type,
  // since String is the sub class of Object
  public String info() {
    return null;
  }

  // overwrite method from Person
  // for "basic data type",
  // it need to be same in superclass's return_value_type and subclass's return_value_type (both
  // Double)
  public Double info_1() {
    return 3.14;
  }
}
