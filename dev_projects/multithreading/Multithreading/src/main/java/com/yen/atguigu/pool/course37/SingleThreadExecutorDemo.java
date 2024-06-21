package com.yen.atguigu.pool.course37;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Thread Pool demo 2: 1 pool, 1 threads */

// course 37 : https://youtu.be/pAxjc1nW6s8?si=eSVz8sQwSc9L34Ft

public class SingleThreadExecutorDemo {
  public static void main(String[] args) {

    /** 1 pool, 1 threads */
    ExecutorService singleThread = Executors.newSingleThreadExecutor();

    // only 1 waiter, serve 10 customers
    try {
      // simulate 1 waiters, 10 customers
      for (int i = 0; i < 10; i++) {
        // run
        singleThread.execute(
            new Runnable() {
              @Override
              public void run() {
                System.out.println(Thread.currentThread().getName() + " is running ...");
              }
            });
      }
    } catch (Exception e) {
      // System.out.println(e);
      e.printStackTrace();
    } finally {
      // close down
      singleThread.shutdown();
    }

    /**
     * -> total 1 thread can handle 10 requests log:
     *
     * <p>pool-1-thread-1 is running ... pool-1-thread-1 is running ... pool-1-thread-1 is running
     * ... pool-1-thread-1 is running ... pool-1-thread-1 is running ... pool-1-thread-1 is running
     * ... pool-1-thread-1 is running ... pool-1-thread-1 is running ... pool-1-thread-1 is running
     * ... pool-1-thread-1 is running ...
     */
  }
}
