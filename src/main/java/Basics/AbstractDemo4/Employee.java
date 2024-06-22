package Basics.AbstractDemo4;

// https://www.youtube.com/watch?v=3VqFJPmA3wg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=348

public abstract class Employee {

  // attr
  private String name;
  private int number;
  private MyDate birthday;

  // constructor
  public Employee(String name, int number, MyDate birthday) {
    super();
    this.name = name;
    this.number = number;
    this.birthday = birthday;
  }

  // getter, setter
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public MyDate getBirthday() {
    return birthday;
  }

  public void setBirthday(MyDate birthday) {
    this.birthday = birthday;
  }

  // method
  public abstract double earnings();

  @Override
  public String toString() {
    // need to call birthday.toDateString() for getting its content
    return "name='"
        + name
        + '\''
        + ", number="
        + number
        + ", birthday : "
        + birthday.toDateString();
  }
}
