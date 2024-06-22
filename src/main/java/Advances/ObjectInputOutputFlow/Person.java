package Advances.ObjectInputOutputFlow;

// https://www.youtube.com/watch?v=F7FPaVlGhhc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=611

import java.io.Serializable;

/**
 * Note : Person class needs to have below things, so can be serializable:
 *
 * <p>1) need to implements Serializable interface 2) offer a global static value : serialVersionUID
 */
public class Person implements Serializable {

  // serialVersionUID for offering an unique version id
  public static final long serialVersionUID = 345345345345346L;

  // attr
  private String name;
  private int age;

  // constructor
  public Person() {}

  public Person(String name, int age) {
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
  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
  }
}
