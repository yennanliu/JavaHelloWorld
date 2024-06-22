package Basics;

// https://www.youtube.com/watch?v=r_-6A8XD-Gg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=226
// Constructor practice 1

public class Constructor2 {
  public static void main(String[] args) {
    // run 1
    Person_2 p1 = new Person_2();
    p1.getAge();
    System.out.println(p1.getAge());

    p1.setAge(12);
    System.out.println(p1.getAge());

    // run 2
    Person_2 p2 = new Person_2("iori", 99);
    p2.getAge();
    System.out.println(p2.getName());
    System.out.println(p2.getAge());
  }
}

class Person_2 {
  // attr
  private int age;
  private String name;

  // constructor
  public Person_2() {
    // set default age = 18
    this.age = 18;
  }

  public Person_2(String n, int a) {
    // set default age = 18
    this.age = a;
    this.name = n;
  }

  public int getAge() {
    return this.age;
  }

  // method (getter, setter)
  // age
  public void setAge(int a) {
    if (a < 0 || a > 100) {
      // or you could throw exception
      // throw new RuntimeException("input age is not validated !");
      System.out.println("input age is not validated !");
      return;
    }
    this.age = a;
  }

  public String getName() {
    return this.name;
  }

  // name
  public void setName(String n) {
    this.name = n;
  }
}
