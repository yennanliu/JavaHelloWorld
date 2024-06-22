package Basics;

// https://www.youtube.com/watch?v=Obgvqy4_DVA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=318

public class staticDemo4 {
  public static void main(String[] args) {
    // demo 1
    // can use class's static method directlu
    Japanese2.show();
  }
}

class Japanese2 {

  static String nation; // static attr
  // attr
  String name;
  int age;

  // method
  public static void show() {
    System.out.println("I am Japanese");
  }

  public static void show2() {
    // this, super is not allowed in static method
    // System.out.println(this.nation);

    // can't call non static attr
    // System.out.println(age);

    // can call static attr
    System.out.println(Japanese2.nation);
    System.out.println(nation); // nation is actually Basics.Japanese2.nation
  }

  public void eat() {
    System.out.println("JP is eating");

    // can call non static attr
    System.out.println(age + name);

    // can call static attr
    System.out.println(nation);
    System.out.println(Japanese2.nation);
  }

  public void info() {
    System.out.println("name : " + name + " age = " + age);
  }
}
