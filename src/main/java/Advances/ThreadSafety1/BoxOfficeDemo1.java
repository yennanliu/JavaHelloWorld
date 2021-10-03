package Advances.ThreadSafety1;

// https://www.youtube.com/watch?v=yB5BP_txa6g&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=431
// https://www.youtube.com/watch?v=A_mB0jxIrgo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=433

/**
 *   Implement 3 box offices with Runnable interface (total ticket=100)
 *
 *   Issues
 *    1) duplicated, wrong ticket -> thready safety
 *
 *    2) why we have issues above ?
 *      -> when one thread is doing ticket op (not finished yet); there are the other
 *         threads joining and doing the same op, so tickets are affected
 *         (`private int tickets = 100` is the shared var in this example)
 *
 *    3) how to solve ?
 *      -> when one thread (e.g. : thread1) is doing the op, ALL OF THE OTHER THREADS
 *         CAN'T JOIN, they have to wait till thread (thread1) finish its op, then
 *         the other threads can join and do their op
 *
 *    4) in java, we can solve above issue via `sync mechanism`
 *
 *         - https://www.baeldung.com/java-thread-safety
 *
 *         4-1) method 1 : Synchronized code block
 *
 *
 *            // 1) shared information : the variables that are modified/accessed ... by multiple threads
 *            // 2) Synchronized monitor : known as `lock`, any class instance can be a `lock`
 *            //    -> multiple threads MUST use the SAME lock
 *            // 3) in Runnable thread, we can use `this` as Synchronized monitor
 *                  (make sure Synchronized monitor is UNIQUE)
 *
 *            Synchronized(Synchronized monitor){
 *
 *             // the code we need to sync
 *             // i.e. : the code manipulates the shared information
 *            }
 *
 *         4-2) method 2 : Synchronized method
 *
 *
 *    5) Pros and Cons
 *       pros : solve thread safety issue
 *       cons : speed is slow ( a `single thread` now actually)
 *              -> concurrent = 1
 *              -> can have one thread run on the same time
 */


class WindowR implements Runnable{

    // attr
    // *** NOTE : here, we don't need to set tickets as static
    private int tickets = 100;

    // the object for `lock` (synchronized monitor)
    Object obj = new Object();

    @Override
    public void run() {
        //Object obj = new Object();  -> thread NOT safety, since the threads are NOT using the same lock
        while(true){

            //synchronized (obj) {
            synchronized (this) {   // note : we can use current object (this) as synchronized monitor as well
                                    // `this` in this example is `WindowR`
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " sells ticket, ticket num = " + tickets);
                    tickets -= 1;
                } else {
                    break;
                }
            }
        }
    }
}

// entry point
public class BoxOfficeDemo1 {
    public static void main(String[] args) {

        WindowR w1 = new WindowR();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("box office 1");
        t2.setName("box office 2");
        t3.setName("box office 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
