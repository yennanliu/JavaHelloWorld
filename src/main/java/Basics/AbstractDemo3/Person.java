package Basics.AbstractDemo3;

// https://www.youtube.com/watch?v=ArTiU9HR5Kw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=259
// https://www.youtube.com/watch?v=UNJC8BrE0Is&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=260

public abstract class Person {
  // attr
  String name;
  int age;

  // constructor
  public Person() {}

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // method
  public abstract void eat();

  public abstract void sleep();

  private void private_sleep() { // note :  private method CAN'T be called in subclass (child class)
    System.out.println("sleep !!!!!");
  }

  public void walk() {
    System.out.println("walk !!!!!");
  }

  // getter, setter
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
