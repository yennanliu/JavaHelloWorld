package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=8Zg6QDXSSAc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=535
// https://www.youtube.com/watch?v=SzLxAGZwnj4&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=540

import java.util.Objects;

public class User implements Comparable {
  private String name;
  private final int age;

  // constructor
  public User(String name, int age) {
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

  // method
  @Override
  public String toString() {
    return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
  }

  /** equals(), hashCode() methods are for "Set, HashSet comparision" */
  @Override
  public boolean equals(Object o) {
    System.out.println("--> User's equals() ...");
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return age == user.age && Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }

  /** compareTo(), compare() methods are for "TreeSet comparision" */
  // ordering User obj
  @Override
  public int compareTo(Object o) {
    if (o instanceof User) {
      User user = (User) o;

      // approach 1) order by name (small -> big)
      // return this.name.compareTo(user.name);

      // approach 2) order by name (big -> small), order by age (small -> big)
      int compare = -this.name.compareTo(user.name);
      if (compare != 0) {
        return compare;
      } else {
        return Integer.compare(this.age, user.age);
      }
    } else {
      throw new RuntimeException("input type not match!");
    }
  }
}
