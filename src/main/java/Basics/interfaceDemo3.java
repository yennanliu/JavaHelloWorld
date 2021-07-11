package Basics;

// https://www.youtube.com/watch?v=rM2f0mTie_Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=352
// https://www.youtube.com/watch?v=JQzwqQfzl08&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=353

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

        /** DEMO 1: interface's non anonymous class and non anonymous instance */
        // will use the Flash class, which implements USB interface
        Flash flash = new Flash();
        pc1.transferData(flash);

        System.out.println("============");

        /** DEMO 2: interface's non anonymous class and anonymous instance */
        pc1.transferData(new Printer());

        System.out.println("============");

        /** DEMO 3: interface's anonymous class and non anonymous instance */
        USB phone = new USB(){

            @Override
            public void start() {
                System.out.println("phone start");
            }

            @Override
            public void stop() {
                System.out.println("phone stop");
            }
        };

        pc1.transferData(phone);

        System.out.println("============");

        /** DEMO 4: interface's anonymous class and anonymous instance */
        pc1.transferData(new USB(){

            @Override
            public void start() {
                System.out.println("ipod start");
            }

            @Override
            public void stop() {
                System.out.println("ipod stop");
            }
        });
    }
}

class Computer {
    // attr

    // method
    // NOTE : this method gets any implementation which from USB interface
    //        and use its start, stop method, while start, stop method
    //        are NOT implemented in USB (USB is an interface), but
    //        in the implementation of USB (e.g. Flash, Printer)
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