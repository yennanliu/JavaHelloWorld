package Basics.Super_2;

// https://www.youtube.com/watch?v=lAuVKrKOxmw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=276

/**
 * Super
 *
 * <p>1) super can be recognized about "superclass relative" 2) super can be called : attr, method,
 * constructor 3) using : 3-1) we can call method in superclass explicitly via super.method_name
 * 3-2) If method name are different in superclass and subclass -> we can call method in superclass
 * (current class) via method_name 3-3) If method name are same in superclass and subclass -> we
 * need to call method in superclass (current class) explicitly via super.method_name
 *
 * <p>4) Super call constructor 4-1) we can use superclass'constructor in subclass via "super
 * constructor" 4-2) "super constructor" need to be declared in 1ST LINE of subclass constructor
 * 4-3) in subclass, we can only choose either "this constructor" or "super constructor" (choose one
 * of them !) 4-4) if we don't declare any "this constructor" or "super constructor".. -> it will
 * use "super constructor" (super(), no argument) by default 4-5) for constructors in class, there
 * is at least constructor use "super constructor"
 */
public class SuperTest {
  public static void main(String[] args) {
    Student s = new Student();
    s.show();

    // student's eat method
    s.eat();
    // person's eat method
    s.super_eat();

    System.out.println("==================");

    Student s1 = new Student("iori", 19, "CS");
    s1.show();
  }
}
