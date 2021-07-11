package Basics.FactoryDemo2;

// https://www.youtube.com/watch?v=aPXVO4ELqVA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=355

/**
 *   Design pattern - Factory : Factory method
 *
 */


interface Car{
    void run();
}

class Audi implements Car {
    @Override
    public void run() {
        System.out.println("Audi is running");
    }
}

class Lexus implements Car {
    @Override
    public void run() {
        System.out.println("Lexus is running");
    }
}