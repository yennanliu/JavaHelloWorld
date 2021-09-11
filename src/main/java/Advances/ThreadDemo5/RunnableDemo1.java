package Advances.ThreadDemo5;

// https://www.youtube.com/watch?v=5YY5j2aHDxU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=423

/**
 *   Demo: Multiple thread via : Runnable interface
 *
 *    step 1) : create a class implement Runnable interface
 *    step 2) : implement the abstract method run() in Runnable interface
 *    step 3) : create the class instance
 *    step 4) : pass above instance to the Thread constructor, and create Thread class instance
 *    step 5) : call the start() method via Threwad class instance
 */

// step 1)
class Thread_R implements Runnable{

    // attr

    // step 2)
    // method
    @Override
    public void run() {
        for (int i = 0; i < 100; i ++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()  + " : " + i);
            }
        }
    }
}


// entry point
public class RunnableDemo1 {
    public static void main(String[] args) {

        // step 3)
        Thread_R thread_r = new Thread_R();

        // step 4)
        Thread t1 = new Thread(thread_r);

        t1.setName("myTread1");

        // step 5)
        /**
         *  Note : t1.start() will call the implemented run() in thread_r,
         *         plz check ref source code below
         *
         * # ----------------------
         *
         *     @Override
         *     public void run() {
         *         if (target != null) {
         *             target.run();
         *         }
         *     }
         *
         *   // while target is as below
         *   private Runnable target
         *
         *
         *   // below Thread constructor accept Runnable as input param, same as our case here
         *   public Thread(Runnable target) {
         *      this(null, target, "Thread-" + nextThreadNum(), 0);
         *   }
         *
         * # ----------------------
         */
        t1.start();

        // create another thread, looping 1-100 even int
        Thread t2 = new Thread(thread_r);
        t2.setName("myTread2");
        t2.start();
    }
}
