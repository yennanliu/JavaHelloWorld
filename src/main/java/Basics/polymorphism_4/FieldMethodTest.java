package Basics.polymorphism_4;

// https://www.youtube.com/watch?v=fKkOGyYSzaQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=289

public class FieldMethodTest {
  public static void main(String[] args) {
    Sub s = new Sub();
    System.out.println(s.count);
    s.display();

    System.out.println("==============");

    /**
     * Note : 1) if subclass Override superclass' method -> will only use method in subclass 2) But,
     * above case NOT work for attr -> e.g. polymorphism NOT working on attr -> attr will still use
     * superclass' attr -> example : -> Base b = s; -> b.count // Base's count
     */

    // example 1
    Base b = s; // polymorphism   // compare it :  Base b = new Sub()
    // *** here, the == is for reference types
    // so == is comparing "ADDRESS LOCATION" rather than value
    System.out.println(b == s); // true, since "Base b = s" will point s to Base type
    System.out.println(b.count); // 10, polymorphism NOT working on attr
    b.display(); // 20, since it's polymorphism, will use subclass' method

    System.out.println("==============");

    // example 2
    Base b2 = new Sub();
    System.out.println(b2 == s);
    System.out.println(b2.count);
    b2.display();
  }
}

class Base {
  int count = 10;

  public void display() {
    System.out.println(this.count);
  }
}

class Sub extends Base {
  int count = 20;

  @Override
  public void display() {
    System.out.println(this.count);
  }
}
