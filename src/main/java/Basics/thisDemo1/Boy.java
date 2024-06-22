package Basics.thisDemo1;

// https://www.youtube.com/watch?v=PtVdxCPGDU4&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=234

public class Boy {
  // attr
  private String name;
  private int age;

  // constructor
  public Boy() {}

  public Boy(String name, int age) {
    this.name = name;
    this.age = age;
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

  // method
  public void marry(Girl girl) {
    System.out.println("I wanna marry to a girl ~ " + girl.getName());
  }

  public void shout() {
    if (this.age > 18) {
      System.out.println("I can marry !!!");
    } else {
      System.out.println("The girl is too young to marry");
    }
  }
}
