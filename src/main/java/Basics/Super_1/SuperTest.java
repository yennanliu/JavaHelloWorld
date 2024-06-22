package Basics.Super_1;

// https://www.youtube.com/watch?v=ieTLbX0nExI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=275

/**
 * Super
 *
 * <p>1) super can be recognized about "superclass relative" 2) super can be called : attr, method,
 * constructor 3) using : 3-1) we can call method in superclass explicitly via super.method_name
 * 3-2) If method name are different in superclass and subclass -> we can call method in superclass
 * (current class) via method_name 3-3) If method name are same in superclass and subclass -> we
 * need to call method in superclass (current class) explicitly via super.method_name
 */
public class SuperTest {
  public static void main(String[] args) {
    Student s = new Student();
    s.show();

    // student's eat method
    s.eat();
    // person's eat method
    s.super_eat();
  }
}
