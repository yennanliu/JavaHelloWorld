package Advances.ThreadPool1;

// https://www.youtube.com/watch?v=wHFqa9hq6SA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=445

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Demo 2 Create thread method 4 : thread pool (change pool property)
 *
 * <p>* Pros 1) fast response speed (reduce creating new thread time) 2) reduce resource cost (reuse
 * used thread in pool, no need to create new ones every time) 3) easy to manage - corePoolSize :
 * core pool size - maximumPoolSize : max thread amount - keepAliveTime : how long thread got
 * terminated if no mission ...
 */
class NumberThread_ implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i <= 100; i++) {
      if (i % 2 == 0) {
        System.out.println(Thread.currentThread().getName() + "-->" + i);
      }
    }
  }
}

class NumberThread2_ implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i <= 100; i++) {
      if (i % 2 != 0) {
        System.out.println(Thread.currentThread().getName() + "-->" + i);
      }
    }
  }
}

// entry point
public class demo2 {
  public static void main(String[] args) {

    // step 1) create a thread pool that can run 10 threads
    ExecutorService service = Executors.newFixedThreadPool(10);

    // 強轉
    ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

    // setting thread pool property
    // NOTE : we can't change property via interface, but can via class
    //        so that's why we have `ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;`
    //        for getting instance from the class (ThreadPoolExecutor) that implement
    // ExecutorService interface
    System.out.println(service.getClass()); // class java.util.concurrent.ThreadPoolExecutor
    service1.setCorePoolSize(5);
    // service1.setKeepAliveTime(10,2);

    // step 2) execute the thread (via thread pool).
    //         NOTE : we need to offer instance implemented Runnable or Callable interface
    service.execute(new NumberThread_()); // good to use with `Runnable`
    service.execute(new NumberThread2_()); // good to use with `Runnable`

    // service.submit(Callable callable);  // good to use with `Callable`

    // step 3) shutdown thread pool
    service.shutdown();
  }
}
