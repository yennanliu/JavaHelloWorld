package Advances.LazyInitSynchronized1;
/**
 *   Re-write  Lazy initialization (Singleton) for thread safety with `Synchronized method`
 *
 */

public class BankTest3 {
    // entry point
    public static void main(String[] args) {

    }
}

// Lazy initialization
class Bank3{
    // attr

    // constructor
    private Bank3(){
    }

    private static Bank3 instance = null;

    // method
    private static Bank3 getInstance(){
        /**
         *  Approach 3) use Bank.class (Synchronized method and if logic ( if (instance == null)))
         *
         *  -> better performance
         */

        // if instance != null, the new coming thread will get instance directly (but not wait for lock)
        if (instance == null){
            synchronized(Bank3.class){
                if (instance == null){
                    // NOTE : here is the part that has the `thread safety` issue
                    instance = new Bank3();
                }
            }
        }
        return instance;
    }
}