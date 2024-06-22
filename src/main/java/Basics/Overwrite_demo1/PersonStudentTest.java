package Basics.Overwrite_demo1;

/**
 * Overwrite 1) subclass can overwrite the same method in superclass (same method name, same param)
 * 2) Note : same method name, same param are needed ( for overwrite) 3) use case : when subclass
 * extends from superclass, it can overwrite methods in superclass for different purposes in cases
 * 4) Note : Overwrite VS. OverLoad
 */

// https://www.youtube.com/watch?v=rLMYy4U9SvM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=271

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
