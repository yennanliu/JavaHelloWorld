package Basics.polymorphism_3;

public class Cat extends Animal {
  // attr
  int leg = 4;
  int age = 10;

  // method
  @Override
  public void eat() {
    System.out.println("cat eats fish !!!");
  }

  public void walk() {
    System.out.println("cat can walk");
  }

  public void creep() {
    System.out.println("cat is creeping !!!");
  }
}
