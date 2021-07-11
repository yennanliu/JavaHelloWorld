package Basics.FactoryDemo2;

// https://www.youtube.com/watch?v=aPXVO4ELqVA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=355

/**
 *   Design pattern - Factory : Factory method
 *
 */

public class test {
    public static void main(String[] args) {

        // run
        Car a = new AudiFactory().getCar();
        a.run();

        System.out.println("=================");

        Car b = new LexusFactory().getCar();
        b.run();
    }
}
