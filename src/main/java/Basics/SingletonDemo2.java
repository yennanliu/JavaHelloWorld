package Basics;

// https://www.youtube.com/watch?v=uIWecsctHxM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=324

/**
 *  Singleton : Eager initialization
 *
 *  1) via some method, make sure THERE  IS ONLY 1 CLASS INSTANCE in the software program
 *  2) how to implement ?
 *    -> check below steps
 *
 *  3) // *** MAIN DIFFERENCE WITHIN EAGER & LAZY initialization (eager : create directly)
 */

public class SingletonDemo2 {
    public static void main(String[] args) {

        // run
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();

        // verify if b1, b2 are belong to same instance
        System.out.println(b1.toString());
        System.out.println(b2.toString());

        System.out.println(b1 == b2); // check if b1, b2 are in the same address
    }
}

// Singleton class : Eager initialization
class Bank{

    // step 1) private constructor
    // constructor
    private Bank(){

    }

    // step 2) create an "internal" class instance
    // step 4) make below class as static
    private static Bank instance = new Bank(); // *** MAIN DIFFERENCE WITHIN EAGER & LAZY initialization (eager : create directly)


    // step 3) offer public STATIC method that can return the class (we create above)
    //         -> reason why we use static here : we can't use getInstance without class, but we need getInstance to create class
    //         -> ... a dead cycle, so at below we make getInstance method as static
    //         -> so we DON'T NEED TO INSTANTIATE Bank class, but can use getInstance method directly
    // method
    public static Bank getInstance(){ // static method can only use static instance
        return instance;
    }
}
