package Basics.Downcasting_2;

public class Dog extends Animal {
  // attr
  int leg = 4;
  int age = 15;

  // method
  @Override
  public void eat() {
    System.out.println("Dog eats meat !!!");
  }

  @Override
  public void walk() {
    System.out.println("Dog can walk");
  }

  public void wolf() {
    System.out.println("wolf !!!!! !!!");
  }
}
