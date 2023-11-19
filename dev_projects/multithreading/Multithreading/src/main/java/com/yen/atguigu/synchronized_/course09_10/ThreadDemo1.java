package com.yen.atguigu.synchronized_.course09_10;

/**
 * Multi-thread (thread interaction) with synchronized
 */

// course 09 : https://youtu.be/h-Q9bqt1CEg?si=VJBenkX6NhCSgwYD
// course 10 : https://youtu.be/CvOdSZnJnnM?si=q4EsLQ_6w3t8EM6f

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

class Share{

    // attr
    private int number = 0;

    // method

    // + 1 method
    public synchronized void incr() throws InterruptedException {

        // decision, do logic, notification
        /** NOTE !!! use while, instead of "if" to avoid "虛假喚醒" */
//        if (number != 0){
//            this.wait();
//        }
        while (number != 0){
            this.wait();
        }
        number += 1;
        System.out.println("--> " + Thread.currentThread().getName() + " number = " + number);
        this.notifyAll();
    }

    // - 1 method
    public synchronized void decr() throws InterruptedException {

        // decision, do logic, notification
        /** NOTE !!! use while, instead of "if" to avoid "虛假喚醒" */
        while (number != 1){
            this.wait();
        }

        number -= 1;
        System.out.println("--> " + Thread.currentThread().getName() + " number = " + number);
        this.notifyAll();
    }

}

public class ThreadDemo1 {

    public static void main(String[] args) {


        System.out.println("ThreadDemo1 start");

        // - Step 3: Create threads, call resource class
        Share share = new Share();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0; i <= 10; i++){
                    try {
                        share.incr(); // +1
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "AA").start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0; i <= 10; i++){
                    //System.out.println("--> (BB) i = " + i);
                    try {
                        share.decr(); // -1
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "BB").start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0; i <= 10; i++){
                    //System.out.println("--> (BB) i = " + i);
                    try {
                        share.incr(); // +1
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "CC").start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0; i <= 10; i++){
                    //System.out.println("--> (BB) i = " + i);
                    try {
                        share.decr(); // -1
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "DD").start();

    }

}
