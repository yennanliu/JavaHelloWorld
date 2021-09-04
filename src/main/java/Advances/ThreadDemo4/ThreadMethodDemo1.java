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
 */

class MyThread4_ extends Thread{
    @Override
    public void run() {
       for (int i = 0; i < 100; i ++){
           if (i % 2 == 0){
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
        }
    }
}
