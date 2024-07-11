package Basics;

// https://www.youtube.com/watch?v=cLt6ZnZewDE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=225
// https://www.youtube.com/watch?v=5VWJOYNVOBg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=225

public class Constructor1 {
  public static void main(String[] args) {
    /*
     *  Constructor NOTE :
     *  Intro :
     *   1. create class instance (*** here the "Person_1" is the DEFAULT CONSTRUCTOR; rather than class)
     *   2. (if there no given constructor, java will have a default one)
     *   3. -> create class instance = new + "constructor"
     *   4. java will not offer "default" constructor anymore once we have already define a constructor explicitly
     *
     *  Use case :
     *   1. create class instance
     *   2. *** Initialize the instance attr
     */

    // run 1 (with default constructor (Person_1()))
    Person_1 p = new Person_1();
    p.eat();
    p.study();

    System.out.println("=====================");

    // run 2 (with Person_1(String name, int age) constructor)
    Person_1 p2 = new Person_1("jack", 10);
    System.out.println(p2.name);
    System.out.println(p2.age);

    System.out.println("=====================");

    // run 3 (with Person_1(String name, int age) constructor)
    Person_1 p3 = new Person_1("kate");
    System.out.println(p3.name);
    System.out.println(p3.age);
  }
}

class Person_1 {
  // attr
  String name;
  int age;

  // constructor (constructor has to be in the same name with class)
  // below constructor are also "overriding" constructor
  public Person_1() { // constructor1
  }

  public Person_1(String name) { // constructor2
    this.name = name;
  }

  public Person_1(String name, int age) { // constructor3
    this.name = name;
    this.age = age;
  }

  // method
  public void eat() {
    System.out.println("people eat !!!");
  }

  public void study() {
    System.out.println("people study !!!");
  }
}
