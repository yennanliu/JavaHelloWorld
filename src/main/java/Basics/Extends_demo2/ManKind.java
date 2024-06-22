package Basics.Extends_demo2;

// https://www.youtube.com/watch?v=i4HGpPEWN2k&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=266

public class ManKind {
  // attr
  private int sex;
  private int salary;

  // constructor
  public ManKind() {}

  public ManKind(int sex, int salary) {
    this.sex = sex;
    this.salary = salary;
  }

  // method
  public void manOrWoman() {
    if (sex == 1) {
      System.out.println("man");
    } else if (sex == 0) {
      System.out.println("woman");
    }
  }

  public void employed() {
    if (salary == 0) {
      System.out.println("no job");
    } else {
      System.out.println("has a job");
    }
  }

  // getter, setter
  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }
}
