package Basics.EqualsDemo1;

// https://www.youtube.com/watch?v=l6YQByB9Bks&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=294

import java.util.Objects;

public class Customer2 {
  // attr
  private String name;
  private int age;

  // constructor
  public Customer2() {}

  public Customer2(String name, int age) {
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
  // OVERWRITE the equals method -> compare if "content" are the same (via IDE)
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer2 customer2 = (Customer2) o;
    return age == customer2.age && Objects.equals(name, customer2.name);
  }
}
