package Basics;

// 1) Call the constructor via "this"
// 2) Call the method via "this"
// https://www.youtube.com/watch?v=ko6vdH5_y-I&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=233

public class thisDemo4 {
  public static void main(String[] args) {
    // run
    Person4 p1 = new Person4("jack", 20);
    System.out.println(p1.age);
    System.out.println(p1.name);
  }
}

// define a class
class Person4 {
  // attribution
  String name;
  int age = 1;
  boolean isMale;

  // constructor
  public Person4() {
    this.eat();
    String info = "init Person4() ...";
    System.out.println(info);
  }

  public Person4(String name) {
    /** call the constructor Person4() via this() */
    this();
    this.name = name;
  }

  public Person4(int age) {
    /** call the constructor Person4() via this() */
    this();
    this.age = age;
  }

  public Person4(String name, int age) {
    /** call the constructor Person4(int age) via this(age) */
    this(age);
    this.name = name;
  }

  // method
  public void eat() {
    System.out.println(this.name + " is eating  !");
  }

  public void sleep() {
    System.out.println(this.name + "is sleeping  !");
  }
}
