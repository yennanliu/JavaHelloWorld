package Basics.polymorphism_3;

public class Animal {
  // attr
  int leg = 0;
  int age = 0;

  // method
  public void eat() {
    System.out.println("Animal can eat");
  }

  public void walk() {
    System.out.println("Animal can walk");
  }

  // getter, setter
  public int getLeg() {
    return leg;
  }

  public void setLeg(int leg) {
    this.leg = leg;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
