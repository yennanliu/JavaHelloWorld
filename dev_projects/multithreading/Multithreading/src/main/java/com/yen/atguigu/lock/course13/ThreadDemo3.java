package com.yen.atguigu.lock.course13;

/**
 * Multi-thread with lock (custom thread communication)
 */

// course 13 : https://youtu.be/FD5hx5woNM0?si=_jIsDBxsaE6H9xsE

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
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
class ShareResource{

    // define definition (flag)
    private int flag = 1; // flag=1 : AA, flag=2 : BB, flag=3 : CC

    // create lock
    private Lock lock = new ReentrantLock();

    // create conditions
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    // Step 2: implement method in resource class
    public void print_5(int loop) throws InterruptedException {

        // lock
        lock.lock();
        try{
            // decision
            while (flag != 1){
                // wait
                c1.await();
            }
            // do main logic
            for (int i = 0; i < 5; i++){
                System.out.println("--> " + Thread.currentThread().getName() + " i = " + i + ", loop = " + loop);
            }
            // notify the specific thread
            flag = 2;
            /** notify BB thread **/
            c2.signal();
        } finally {
            // unlock
            lock.unlock();
        }
    }

    public void print_10(int loop) throws InterruptedException {

        // lock
        lock.lock();
        try{
            // decision
            while (flag != 2){
                // wait
                c2.await();
            }
            // do main logic
            for (int i = 0; i < 10; i++){
                System.out.println("--> " + Thread.currentThread().getName() + " i = " + i + ", loop = " + loop);
            }
            // notify the specific thread
            flag = 3;
            /** notify CC thread **/
            c3.signal();
        } finally {
            // unlock
            lock.unlock();
        }
    }

    public void print_15(int loop) throws InterruptedException {

        // lock
        lock.lock();
        try{
            // decision
            while (flag != 3){
                // wait
                c3.await();
            }
            // do main logic
            for (int i = 0; i < 15; i++){
                System.out.println("--> " + Thread.currentThread().getName() + " i = " + i + ", loop = " + loop);
            }
            // notify the specific thread
            flag = 1;
            /** notify AA thread **/
            c1.signal();
        } finally {
            // unlock
            lock.unlock();
        }
    }

}

public class ThreadDemo3 {

    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource();

        // - Step 3: Create threads, call resource class
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        shareResource.print_5(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "AA").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        shareResource.print_10(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "BB").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        shareResource.print_15(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "CC").start();

    }

}
