package com.yen.atguigu.pool.course40;

import java.util.concurrent.*;

/** User define thread pool demo */

// Course 40 : https://youtu.be/KTkRVtfTWOA?si=BbemVgbMUDT8a5-L

public class CustomThreadPoolDemo1 {

  public static void main(String[] args) {

    /**
     * Ref : needed param
     *
     * <p>public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
     * TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory,
     * RejectedExecutionHandler handler) {
     */

    // setup param
    final int CORE_POOL_SIZE = 2;
    final int MAX_POOL_SIZE = 5;
    final long KEEP_ALIVE_TIME = 2L;
    final TimeUnit UNIT = TimeUnit.SECONDS;
    final BlockingQueue<Runnable> BLOCKING_QUEUE = new ArrayBlockingQueue<>(3);
    final ThreadFactory THREAD_FACTORY = Executors.defaultThreadFactory();
    final RejectedExecutionHandler REJECT_POLICY = new ThreadPoolExecutor.AbortPolicy();

    // init a custom thread pool
    ThreadPoolExecutor threadPool =
        new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            UNIT,
            BLOCKING_QUEUE,
            THREAD_FACTORY,
            REJECT_POLICY);

    // test run
    try {
      // simulate 10 customers
      for (int i = 0; i < 10; i++) {
        // run
        threadPool.execute(
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
      threadPool.shutdown();
    }

    /**
     * Note : we may see java.util.concurrent.RejectedExecutionException occasionally which is
     * normal, since we set our reject policy as new ThreadPoolExecutor.AbortPolicy(); above
     * exception may happen when number of thread is bigger than MAX_POOL_SIZE
     *
     * <p>log :
     *
     * <p>java.util.concurrent.RejectedExecutionException: Task
     * com.yen.atguigu.pool.course40.CustomThreadPoolDemo1$1@3ac3fd8b rejected from
     * java.util.concurrent.ThreadPoolExecutor@5594a1b5[Running, pool size = 5, active threads = 5,
     * queued tasks = 3, completed tasks = 0] at
     * java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2055)
     * at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:825) at
     * java.base/java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1355) at
     * com.yen.atguigu.pool.course40.CustomThreadPoolDemo1.main(CustomThreadPoolDemo1.java:51)
     * pool-1-thread-1 is running ... pool-1-thread-4 is running ... pool-1-thread-5 is running ...
     * pool-1-thread-1 is running ... pool-1-thread-3 is running ... pool-1-thread-2 is running ...
     * pool-1-thread-1 is running ... pool-1-thread-5 is running ...
     */
  }
}
