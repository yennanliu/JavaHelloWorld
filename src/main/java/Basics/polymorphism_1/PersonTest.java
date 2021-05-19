package Basics.polymorphism_1;

// https://www.youtube.com/watch?v=TcTwRuVB8V0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=279

/**
 *  Polymorphism
 *   1) a "various" type of a thing
 *   2) call superclass and point to subclass' instance
 *   3) pattern : superclass p1 = new subclass();
 *   4) (following above) p1 will be the superclass class type, so it CAN'T use the method that only exist in subclass
 *   5) During compile
 *      -> can only call methods defined in superclass
 *   6) During runtime
 *     -> will run the methods overridden in subclass
 *
 *   7) summary :
 *      -> Compile : check left (<-)
 *      -> Running : check right (->)
 *
 *   8) use requirements:
 *      8-1) there is extends in class (superclass, subclass)
 *      8-2) method override is necessary
 */


public class PersonTest {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.eat();
        Man m1 = new Man();
        m1.eat();
        m1.makeMoney();

        System.out.println("============================");

        /** Polymorphism  (subclass' instance)
         *   -> declare an instance, but it actually implements on its SUBCLASS
         *   -> e.g. : call superclass and point to subclass' instance
         */
        // example 1
        Person p2 = new Man();

        // when class the method same as the one in superclass -> will use the method in subclass (pseudo method)
        p2.eat(); // should call subclass' method (rewrite from superclass)
        p2.walk();
        //p2.makeMoney();  //but can't use makeMoney, since it's Person class type now
        p2.name = "jim";
        //p2.isSmoking = true; // can't use this  isSmoking method as well, since it's Person class type now

        System.out.println("============================");

        // example 2
        Person p3 = new Woman();
    }
}
