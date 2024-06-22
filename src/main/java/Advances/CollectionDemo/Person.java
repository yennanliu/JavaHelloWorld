package Advances.CollectionDemo;

// https://www.youtube.com/watch?v=WO-54GprY0M&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=519

/** a Person java bean */
import java.util.Objects;

public class Person {
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
  // override compare methods
  @Override
  public boolean equals(Object o) {
    System.out.println("---> Person's equals");
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age && Objects.equals(name, person.name);
  }

  //    @Override
  //    public int hashCode() {
  //        return Objects.hash(name, age);
  //    }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
  }
}
