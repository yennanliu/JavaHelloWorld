package com.yen.atguigu.pool.course37;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Thread Pool demo 1: 1 pool, 5 threads */


// course 37 : https://youtu.be/pAxjc1nW6s8?si=eSVz8sQwSc9L34Ft

public class FixedThreadPoolDemo {
    public static void main(String[] args) {

        /** Demo 1: 1 pool, 5 threads */
        final int SIZE = 5;
        ExecutorService threadPool_1 = Executors.newFixedThreadPool(SIZE);
        try{
            // simulate 5 waiters, 10 customers
            for (int i = 0; i < 10; i++){
                // run
                threadPool_1.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " is running ...");
                    }
                });
            }
        }catch (Exception e){
            //System.out.println(e);
            e.printStackTrace();
        }finally {
            // close down
            threadPool_1.shutdown();
        }

        /** log :
         *
         *  -> total 5 threads can handle 10 requests
         *
         *
         * pool-1-thread-4 is running ...
         * pool-1-thread-4 is running ...
         * pool-1-thread-4 is running ...
         * pool-1-thread-4 is running ...
         * pool-1-thread-4 is running ...
         * pool-1-thread-4 is running ...
         * pool-1-thread-1 is running ...
         * pool-1-thread-2 is running ...
         * pool-1-thread-5 is running ...
         * pool-1-thread-3 is running ...
         *
         *
         */
    }

}
