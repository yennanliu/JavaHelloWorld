package Basics.polymorphism_3;

public class AnimalTest {
  public static void main(String[] args) {
    // demo 1 : basics
    Animal a1 = new Animal();
    System.out.println(a1.getAge());
    System.out.println(a1.getLeg());

    System.out.println("====================");

    // demo 2 : Polymorphism
    /**
     * Polymorphism (Upcasting)
     *
     * <p>1) pattern : superclass p1 = new subclass();
     */
    Animal a2 = new Dog();
    a2.eat();
    a2.walk();
    System.out.println(a2.getAge());
    System.out.println(a2.getLeg());

    System.out.println("====================");

    // demo 3 : Polymorphism (Upcasting)
    Animal a3 = new Cat();
    a3.eat();
    a3.walk();
    System.out.println(a3.getAge());
    System.out.println(a3.getLeg());
  }
}
