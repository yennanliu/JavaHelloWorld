package DesignPattern.Singleton;

/** Singleton Demo 2 : Lazy (懶漢式) */

// https://www.runoob.com/design-pattern/singleton-pattern.html

class MyClass2 {

  // attr
  private static MyClass2 instance;

  // constructor
  private MyClass2() {}

  // method
  public static MyClass2 getInstance() {
    if (instance == null) {
      instance = new MyClass2();
    }
    return instance;
  }
}

public class Lazy {

  public static void main(String[] args) {

    MyClass2 myClass2_1 = MyClass2.getInstance();
    MyClass2 myClass2_2 = MyClass2.getInstance();
    System.out.println(myClass2_1 == myClass2_2);
  }
}
