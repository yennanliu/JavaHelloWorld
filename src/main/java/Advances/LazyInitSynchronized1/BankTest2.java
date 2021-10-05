package Advances.LazyInitSynchronized1;
/**
 *   Re-write  Lazy initialization (Singleton) for thread safety with `Synchronized method`
 *
 */

public class BankTest2 {
    // entry point
    public static void main(String[] args) {

    }
}

// Lazy initialization
class Bank2{
    // attr

    // constructor
    private Bank2(){
    }

    private static Bank2 instance = null;

    // method
    private static Bank2 getInstance(){
        /**
         * Approach 2) use Bank.class  (Synchronized method)
         *
         * -> performance not good
         */

        // new coming threads have to wait for lock (synchronized(Bank2.class)) for getting instance anyway
        // whether the instance is available or not (instance == null or not)
        synchronized(Bank2.class){
            if (instance == null){
                // NOTE : here is the part that has the `thread safety` issue
                instance = new Bank2();
            }
            return instance;
        }
    }
}