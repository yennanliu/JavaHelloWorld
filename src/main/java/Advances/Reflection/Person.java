package Advances.Reflection;

// https://www.youtube.com/watch?v=UdZie846898&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=636

public class Person {

  public int age;
  // attr
  private String name;

  // constructor
  public Person() {
    System.out.println(">>> Person() no param constructor");
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  private Person(String name) {
    this.name = name;
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
  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
  }

  public void show() {
    System.out.println("person show !!!!");
  }

  private String showNation(String country) {
    // System.out.println("From US");
    String msg = "From " + country;
    System.out.println(msg);
    return msg;
  }
}
