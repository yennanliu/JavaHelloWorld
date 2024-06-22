package Basics.AbstractDemo3;

// https://www.youtube.com/watch?v=nxd54QjNDfo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=346

/** Anonymous subclass in abstract class */
public class PersonTest {
  public static void main(String[] args) {
    // run

    // anonymous class ( new Student() )
    method(new Student());

    System.out.println("================");

    Worker2 worker2 = new Worker2();

    // non anonymous class, non anonymous instance
    method1(worker2);

    System.out.println("================");

    // non anonymous class, anonymous instance
    method1(new Worker2());

    System.out.println("================");

    /**
     * ------------------------------------------------------- create an anonymous sub class'
     * instance (its superclass : Person). -------------------------------------------------------
     */
    Person p =
        new Person() {
          @Override
          public void eat() {
            System.out.println("new eat !!");
          }
          ;

          @Override
          public void sleep() {
            System.out.println("new sleep !!");
          }
          ;
        };

    method1(p);

    System.out.println("================");

    /**
     * ----------------------------------------------------------------------------- create an
     * anonymous sub class' anonymous instance (its superclass : Person).
     * -----------------------------------------------------------------------------
     */
    method1(
        new Person() {
          @Override
          public void eat() {
            System.out.println("anonymous sub class' anonymous instance eat");
          }

          @Override
          public void sleep() {
            System.out.println("anonymous sub class' anonymous instance sleep");
          }
        });
  }

  // method
  public static void method(Student s) {}

  public static void method1(Person p) {
    p.eat();
    p.sleep();
  }
}

class Worker2 extends Person {
  @Override
  public void eat() {}
  ;

  @Override
  public void sleep() {}
  ;
}
