package Basics.polymorphism_1;

// https://www.youtube.com/watch?v=TcTwRuVB8V0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=279

public class Man extends Person {
  // attr
  boolean isSmoking;

  // method
  public void makeMoney() {
    System.out.println("man is makeMoney.");
  }

  // Override method
  @Override
  public void eat() {
    System.out.println("man is eating !!!!");
  }

  @Override
  public void walk() {
    System.out.println("man is walk ~~~~~~");
  }
}
