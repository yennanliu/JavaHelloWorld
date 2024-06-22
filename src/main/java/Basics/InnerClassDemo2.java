package Basics;

// https://www.youtube.com/watch?v=qjGy50cSiCQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=362
// https://www.youtube.com/watch?v=LrcEVyq2uBI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=363

/**
 * Inner Class
 *
 * <p>.....
 *
 * <p>plz refer
 * https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Basics/InnerClassDemo1.java
 *
 * <p>4) Note : below questions 4-1) how to instantiate object inside inner local class ? 4-2) how
 * to use external structure inside inner local class ? 4-3) in development, how to use local class
 * ? -> plz check Basic.InnerClassDemo3.java
 */
public class InnerClassDemo2 {
  public static void main(String[] args) {
    // run

    // create Dog instance (static member's inner local class)
    Person_inner2.Dog dog = new Person_inner2.Dog();
    dog.show();

    System.out.println("=================");

    // create Bird instance (Non-static member's inner local class)
    // wrong
    // Person_inner2.Bird bird = new Person_inner2.Bird();
    Person_inner2 p = new Person_inner2();
    Person_inner2.Bird bird = p.new Bird(); // *** NOTE HERE !
    bird.sing();

    System.out.println("=================");

    bird.display("EAGLE");
  }
}

class Person_inner2 {
  // attr
  String name = "JACK";
  int age;

  // code block
  {
    class BB { // local class (局部內部類)
    }
  }

  // constructor
  public Person_inner2() {
    class CC { // local class (局部內部類)
    }
  }

  // method
  public void eat() {
    System.out.println("ppl eat !!");
  }

  // method
  public void method() {
    class AA { //  local class (局部內部類)
    }
  }

  // inner local class (成員內部類)
  static class Dog {
    // attr
    String name;
    int age;

    // method
    public void show() {
      System.out.println("Lucky is a dog !");
    }
  }

  class Bird {
    // attr
    String name = "birdy";

    // constructor
    public Bird() {}

    // method
    public void sing() {
      System.out.println("Bird is singing !");
      Person_inner2.this.eat(); // call external class' non-static method
    }

    public void display(String name) {
      System.out.println("name = " + name); // method param ( display(String name) )
      System.out.println("this.name = " + this.name); // inner class' attr
      System.out.println(
          "Person_inner2.this.name = " + Person_inner2.this.name); // external class' attr
    }
  }
}
