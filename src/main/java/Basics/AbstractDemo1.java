package Basics;

// https://www.youtube.com/watch?v=6cORJLJQ1KY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=342

/**
 * Abstract
 *
 * <p>1) Can decorate - class - method
 *
 * <p>2) abstract class - CAN NOT BE instantiated - STILL NEED CONSTRUCTOR (used in sub class) - in
 * development, we always offer sub class that can instantiate via above
 *
 * <p>3) abstract method - ONLY has method declare, has NO code body (method implementation) -
 * inference : if a class has abstract method -> this class must be an ABSTRACT CLASS - Abstract
 * class can has NO abstract method - if sub class overwrites all abstract methods in super class ->
 * sub class CAN instantiate - if sub class NOT overwrites all abstract methods in super class ->
 * sub class CAN NOT instantiate, this sub class is also an abstract class
 */
public class AbstractDemo1 {
  public static void main(String[] args) {
    // run
    // wrong : 'Person3' is abstract; cannot be instantiated
    // Person3 p1 = new Person3();
    // p1.eat();

    Student3 s1 = new Student3();
    s1.eat();
    s1.study();
  }
}

abstract class Creature {
  public abstract void breath();
}

abstract class Person3 extends Creature {
  // attr
  String name;
  int age;

  // constructor -> can be used in subclass
  public Person3() {}

  public Person3(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // method

  // below is NOT an abstract method
  public void _eat() {}

  // below is an abstract method
  public abstract void eat();

  public void walk() {
    System.out.println("person walk !!!");
  }
}

class Student3 extends Person3 {
  // attr

  // constructor
  public Student3() {
    super();
  }

  public Student3(String name, int age) {
    super(name, age);
  }

  // method
  @Override
  public void eat() {
    System.out.println("Student3 eat !!!!!");
  }

  public void study() {
    System.out.println("Student3 study !!!!!");
  }

  @Override
  public void breath() {
    System.out.println("Student3 breath !!!!!");
  }
}

// also an abstract class
abstract class Student3_abs extends Person3 {}
