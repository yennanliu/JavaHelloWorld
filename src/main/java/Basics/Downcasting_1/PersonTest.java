package Basics.Downcasting_1;

// https://www.youtube.com/watch?v=AFlcbyee_vs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=286
// ref : Basics.polymorphism_1

public class PersonTest {
  public static void main(String[] args) {

    /**
     * Polymorphism (Upcasting) (subclass' instance) -> declare an instance, but it actually
     * implements on its SUBCLASS -> e.g. : call superclass and point to subclass' instance
     */
    System.out.println("============================");

    // example 1
    Person p2 = new Man();
    p2.name = "ken";
    /**
     * when polymorphism, subclass actually still load its (subclass') method, and attr However,
     * since we instantiate it as superclass type (Person p2 = new Man() ), so its only can call
     * superclass' attr, method... and subclass' attr, method CAN'T BE CALLED
     */
    // p2.isSmoking = true; // can't use this  isSmoking method as well, since it's Person class
    // type now

    /** Example 2 : how can we call subclass' attr and method ? -> DownCasting */
    Man m2 = (Man) p2; // DownCasting
    m2.makeMoney();
    m2.isSmoking = true;

    // when use DownCasting, we may face "ClassCastException" exception (as below)
    // so it's good to use isClassOf verify it before run
    // Woman w1 = (Woman) p2;
    // w1.goShopping();
  }
}
