package Basics.Super_2;

// https://www.youtube.com/watch?v=lAuVKrKOxmw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=276

public class Person {
  // attr
  String name;
  int age;
  int id = 1001; // personal id

  // constructor (this one is needed for Student class (Student is subclass of Person class))
  public Person() {}

  public Person(String name) {
    this.name = name;
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // method
  public void eat() {
    System.out.println("i am eating !!!");
  }

  public void walk() {
    System.out.println("i am walking !!!");
  }
}
