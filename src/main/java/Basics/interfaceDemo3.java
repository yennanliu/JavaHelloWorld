package Basics;

// https://www.youtube.com/watch?v=rM2f0mTie_Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=352

/**
 *   Interface part 3
 *
 *  1) interface using : reflects OOP's Polymorphism
 *  2) interface essentially defines the "format", "standard"
 *      -> that can be implemented by the class
 *
 *  3) using cases :
 *      -> JDBC for DB
 *
 *  4) during development, we usually do "interface facing" development
 */


public class interfaceDemo3 {
    public static void main(String[] args) {
        // run
        Computer pc1 = new Computer();

        // wrong : 'USB' is abstract; cannot be instantiated
        //pc1.transferData(new USB());

        // will use the Flash class, which implements USB interface
        pc1.transferData(new Flash());
        // or
        Flash flash = new Flash();
        pc1.transferData(flash);

        System.out.println("============");
    }
}

class Computer {
    // attr

    // method
    public void transferData(USB usb){
        usb.start();
        // code that implements data transfer

        usb.stop();
        // code that implements stop
    }
}

// define a rule, standard, format
interface USB {
    // attr

    // method
    void start();

    void stop();
}

class Flash implements USB {

    @Override
    public void start() {
        System.out.println("Flash start");
    }

    @Override
    public void stop() {
        System.out.println("Flash stop");
    }
}

class Printer implements USB {

    @Override
    public void start() {
        System.out.println("Printer start");
    }

    @Override
    public void stop() {
        System.out.println("Printer stop");
    }
}