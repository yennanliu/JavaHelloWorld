package Advances.ThreadDemo6;

// https://www.youtube.com/watch?v=IvEED1x2bNs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=443

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Create multi-thread method 3 :  Callable interface (new from JDK 5.0)
 *
 *   1) Callable VS Runnable
 *      1-1) call() method can have returned value
 *      1-2) call() method can throw exception (can be caught by external code)
 *      1-3) Callable supports genetic type
 *
 *   2) Future interface
 *     - Can cancel, check... on Runnable, Callable tasks
 *     - FutureTask is the only implemented class of Future
 *     - FutureTask implement Runnable, Callable on the same time,
 *       it can not only run by Runnable thread, but also can as
 *       returned value (Future) of Callable
 */


// entry point
public class CallableDemo1 {
    public static void main(String[] args) {

        // step 3) create an instance for callable implemented class (NumThread)
        NumThread numThread = new NumThread();

        // step 4) pass callable implemented class (NumThread) as input to FutureTask constructor, make FutureTask instance
        FutureTask futureTask = new FutureTask(numThread);

        // step 5) pass FutureTask instance as input to Thread class, make Thread instance, and run start() method
        // start the thread
        new Thread(futureTask).start();

        try {
            // step 6) get the Callable's call() method return value
            // NOTE : get() returned value is FutureTask callable() 's (overwritten) returned value
            Object sum =  futureTask.get(); // this cmd is optional (in case we are interested in it)
            System.out.println("---> sum = " + sum);

        // call() method can throw exception
        } catch (InterruptedException e) {
            e.printStackTrace();
        // call() method can throw exception
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

// step 1) : make a class implements Callable interface
class NumThread implements Callable {

    @Override
    // step 2) : implement (override) call() method. put the needed op in this method
    public Object call() throws Exception {

        int sum = 0;

        for (int i=1; i <= 100; i++){
            if (i%2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        // the call() method can have return value (optional)
        return sum;  // NOTE : int (sum) is NOT sub type of Object (Object call()), but we transform int to Integer
        //return _;
    }
}
