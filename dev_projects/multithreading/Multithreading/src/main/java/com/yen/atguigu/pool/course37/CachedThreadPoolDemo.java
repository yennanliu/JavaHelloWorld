package com.yen.atguigu.pool.course37;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Thread Pool demo 1: cachedThreadPool (auto scale queue) */

// course 37 : https://youtu.be/pAxjc1nW6s8?si=eSVz8sQwSc9L34Ft

public class CachedThreadPoolDemo {
  public static void main(String[] args) {

    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    try {
      // simulate 10 customers
      for (int i = 0; i < 20; i++) {
        // run
        cachedThreadPool.execute(
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
      cachedThreadPool.shutdown();
    }

    /**
     * cachedThreadPool can scale out automatically
     *
     * <p>log :
     *
     * <p>pool-1-thread-1 is running ... pool-1-thread-4 is running ... pool-1-thread-5 is running
     * ... pool-1-thread-2 is running ... pool-1-thread-7 is running ... pool-1-thread-3 is running
     * ... pool-1-thread-6 is running ... pool-1-thread-8 is running ... pool-1-thread-2 is running
     * ... pool-1-thread-8 is running ...
     */
  }
}
