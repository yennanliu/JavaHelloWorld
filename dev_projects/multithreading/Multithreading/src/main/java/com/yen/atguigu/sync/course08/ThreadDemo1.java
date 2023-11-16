package com.yen.atguigu.sync.course08;

/**
 * Multi-thread (thread interaction) with synchronized
 */

// course 08 : https://youtu.be/h-Q9bqt1CEg?si=VJBenkX6NhCSgwYD

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
        if (number != 0){
            this.wait();
        }
        number += 1;
        System.out.println("--> " + Thread.currentThread().getName() + " number = " + number);
        this.notifyAll();
    }

    // - 1 method
    public synchronized void decr() throws InterruptedException {

        // decision, do logic, notification
        if (number != 1){
            this.wait();
        }

        number -= 1;
        System.out.println("--> " + Thread.currentThread().getName() + " number = " + number);
        this.notifyAll();
    }

}

public class ThreadDemo1 {

    public static void main(String[] args) {

        // - Step 3: Create threads, call resource class
        Share share = new Share();
        new Thread(() -> new Runnable(){
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

        new Thread(() -> new Runnable(){
            @Override
            public void run() {
                for(int i = 0; i <= 10; i++){
                    try {
                        share.decr(); // -1
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "BB").start();

    }

}
