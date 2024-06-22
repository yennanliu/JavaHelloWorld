package Basics.instanceof_1;

// https://www.youtube.com/watch?v=kQtKcNX4O44&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=287

public class Man extends Person {
  // attr
  boolean isSmoking;
  int id = 9999;

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
