package Basics;

// https://www.youtube.com/watch?v=VaG4KHBBLc8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=221

public class Encapsulation1 {
  public static void main(String[] args) {
    // run
    Animal a = new Animal();
    a.name = "jerry";
    a.age = 10;
    a.setLegs(4);
    a.show();
    a.eat();
  }
}

class Animal {
  // attr
  String name;
  int age;
  private int legs;

  // method
  // getter & setter
  public void setLegs(int l) {
    if (l >= 0 && l % 2 == 0) {
      legs = l;
    }
    legs = 0; // default
  }

  public void eat() {
    System.out.println("eat !!");
  }

  public void show() {
    System.out.println("name = " + name + " age = " + age + " legs = " + legs);
  }
}
