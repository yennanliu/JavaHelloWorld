package thread;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

public class ThreadSleep {
    public static void main(String[] args){
        // define 2 thread objects

        // thread 1
        Thread thread1 = new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println(
                        Thread.currentThread().getName() + " now output stream i = " + i);
                if (i == 2){
                    try{
                        // sleep while i = 2, in order to let other thread run first
                        Thread.sleep(5000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }, "THREAD-1");

        // thread 2
        Thread thread2 = new Thread(() ->{
            for (int j = 0; j < 10; j++) {
                System.out.println(
                        Thread.currentThread().getName() + " now output stream j = " + j);
            }
        }, "THREAD-2");

        // run
        thread1.start();
        thread2.start();
    }
}
