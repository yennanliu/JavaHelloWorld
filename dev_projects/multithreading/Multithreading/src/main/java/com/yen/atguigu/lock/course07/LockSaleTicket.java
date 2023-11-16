package com.yen.atguigu.lock.course07;

/**
 * Multi-thread with lock
 */

// course 07 : https://youtu.be/xTzUzmpBMLY?si=bT-_Qf0O-OCJwe0A

import java.util.concurrent.locks.ReentrantLock;

/**
 *  - Step 1: Create resource class, implement attr, op method
 *  - Step 2: implement method in resource class
 * 	    - decision
 * 	    - main biz logic
 * 	    - notification (other thread)
 * - Step 3: Create threads, call resource class
 * - Step 4: Avoid "虛假喚醒" (if logic)
 *
 */

// - Step 1: Create resource class, implement attr, op method
class LockTicket{

    private int number = 30;

    // create lock
    private final ReentrantLock lock = new ReentrantLock();

    // - Step 2: implement method in resource class
    public void sale(){

        // lock
        lock.lock();

        try{
            if (number > 0) {
                System.out.println("--> " + Thread.currentThread().getName() + " sales : " + (number--) + ", remain : " + number);
            }
        }finally {
            // unlock
            lock.unlock();
        }
    }

}

public class LockSaleTicket {

    public static void main(String[] args) {

        // Step 3: Create threads, call resource class
        LockTicket ticket = new LockTicket();

        /** NOTE !!! thread need in main method */
        // create 3 threads
        // use lambda expression here (syntax sugar)
        new Thread(() -> {
            // call resource class
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // call resource class
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "BB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // call resource class
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "CC").start();

    }

}
