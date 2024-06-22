package Basics.Overwrite_demo2;

// https://www.youtube.com/watch?v=z4jVMvyf1D8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=272

public class PersonStudentTest {
  public static void main(String[] args) {
    // run
    Student s = new Student("CS");
    // from superclass
    s.eat();
    s.walk(1000);

    // from subclass
    s.study();
  }
}
