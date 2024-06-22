package Basics.Downcasting_2;

// https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/311843/

public class AnimalTest {
  public static void main(String[] args) {
    // demo 1 : basics
    Animal a1 = new Animal();
    System.out.println(a1.getAge());
    System.out.println(a1.getLeg());

    System.out.println("====================");

    // demo 2 : Downcasting
    /**
     * Downcasting
     *
     * <p>1) pattern : // MUST do upperCasting first (?) superclass p1 = new subclass(); //
     * uppercasting // then do downcasting subclass x1 = (subclass) p1; // downcasting
     *
     * <p>-> then we can use instance (x1)
     *
     * <p>2) Note : Uppercasting : make subclass -> superclass Downcasting : make superclass ->
     * subclass
     */

    // let's do a polymorphism (uppercasting) first
    Animal a2 = new Dog(); // *** a2 is Animal type, but it will run methods overridden in Dog

    // them, Downcasting
    Dog d2 = (Dog) a2;

    d2.eat();
    d2.walk();
    d2.wolf();

    // demo 3 : Downcasting
    // a2 instanceof Cat will return False, since a2 is uppercasted from Dog to Animal
    // It's not Cat's instance, so we use "instanceof" to avoid if below code may pass
    // compile, but failed in runtime
    if (a2 instanceof Cat) {
      Cat c2 = (Cat) a2;
      c2.eat();
      c2.walk();
      c2.creep();
    }
  }
}
