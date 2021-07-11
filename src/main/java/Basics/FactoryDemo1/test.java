package Basics.FactoryDemo1;

// https://www.youtube.com/watch?v=aPXVO4ELqVA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=355

/**
 *   Desing pattern - Factory : Simple Factory
 *
 *   1) xxxFactory -> this is class is for instantiating class
 *
 */

public class test {
    public static void main(String[] args) {

        // run
        Car a = CarFactory.getCar("Audi");
        a.run();

        System.out.println("=================");

        Car b = CarFactory.getCar("Lexus");
        b.run();
    }
}

