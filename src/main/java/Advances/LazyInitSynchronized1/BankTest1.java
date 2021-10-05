package Advances.LazyInitSynchronized1;

// https://www.youtube.com/watch?v=y7_TW_ZQD20&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=437

/**
 *   Re-write  Lazy initialization (Singleton) for thread safety with `Synchronized method`
 *
 */

public class BankTest1 {
    // entry point
    public static void main(String[] args) {

    }
}

// Lazy initialization
class Bank1{
    // attr

    // constructor
    private Bank1(){
    }

    private static Bank1 instance = null;

    // method
    /**
     * Approach 1) use synchronized (private static synchronized Bank1 getInstance())
     *
     * -> performance not good
     */

    // new coming threads have to wait for lock (synchronized(Bank2.class)) for getting instance anyway
    // whether the instance is available or not (instance == null or not)
    private static synchronized Bank1 getInstance(){
        if (instance == null){
            // NOTE : here is the part that has the `thread safety` issue
            instance = new Bank1();
        }
        return instance;
    }

}