package Basics.EmployeeCRM.team.domain;

// https://www.youtube.com/watch?v=rN0byZHtGw8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=390

public class Employee {

  // attr
  private int id;
  private String name;
  private int age;
  private double salary;

  // constructor
  public Employee() {
    super();
  }

  public Employee(int id, String name, int age, double salary) {
    super();
    this.id = id;
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  // getter, setter
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  // method
  public String getDetails() {
    return "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", salary=" + salary;
  }

  @Override
  public String toString() {
    return this.getDetails();
  }
}
