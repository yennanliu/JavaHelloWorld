package com.yen.atguigu.lock.course20;

// course 20 : https://youtu.be/kfgWpS8bSHw?si=DtRZ0t5l11usnYz3

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

public class SyncLockDemo {

    public static void main(String[] args) {

        // synchronized
        Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println(Thread.currentThread().getName() + " 外層 ");
                }
            }
        }, "t1").start();

    }


}
