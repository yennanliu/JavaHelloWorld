package Advances.ThreadDemo4;

// https://www.youtube.com/watch?v=dOfnzCLJAG8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=420

/**
 *  Demo common methods in threads
 *
 *   1) start() : launch current thread ( execute run() method in current thread)
 *   2) run() :   usually we need to override run() method in thread class,
 *                and put the logic run by thread in it (run() method)
 *   3) currentThread() : a static method, return current running thread
 *   4) getName() : get current thread name (getter)
 *   5) setName() : set current thread name (setter)
 *      5-1) via setName() method
 *      5-2) via constructor
 *
 *   6) yield : release current CPU execution
 *   7) join : when use thread b's join() in thread a,
 *             thread a will being `blocked` till thread b finished
 *             , then thread a can run again
 *   8) stop : force to terminate thread (not recommended)
 *   9) sleep : (long millisecond) : ask thread sleep (for millisecond)
 *              (current thread is blocked)
 *   10) isAlive() : check if thread is active
 */

class MyThread4_ extends Thread{
    @Override
    public void run() {
       for (int i = 0; i < 100; i ++){
           if (i % 2 == 0){
               try {
                   sleep(10);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName() + " : " + i);
           }
       }
    }
}

public class ThreadMethodDemo1 {
    public static void main(String[] args) {

        // multi-thread
        MyThread4_ h1 = new MyThread4_();
        // set thread name
        h1.setName("Thread X");
        h1.start();

        // main thread
        // set thread name for main thread
        Thread.currentThread().setName("MAIN THREAD");
        for (int i = 0; i < 100; i ++){
            if (i % 2 == 1){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
            if (i == 31){
                try {
                    /**
                     * when `join`, it will stop, and run the other thread first
                     * -> use case : when we need data from the other thread,
                     *               we use `join` make current thread `wait` a bit
                     */
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("h1.isAlive() = " + h1.isAlive());
    }
}
