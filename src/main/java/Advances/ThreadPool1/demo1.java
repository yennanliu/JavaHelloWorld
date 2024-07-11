package Advances.ThreadPool1;

// https://www.youtube.com/watch?v=wHFqa9hq6SA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=445

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demo1 Create thread method 4 : thread pool (basics)
 *
 * <p>* Pros 1) fast response speed (reduce creating new thread time) 2) reduce resource cost (reuse
 * used thread in pool, no need to create new ones every time) 3) easy to manage - corePoolSize :
 * core pool size - maximumPoolSize : max thread amount - keepAliveTime : how long thread got
 * terminated if no mission ...
 *
 * <p>1) methods we can create multi-thread ? -> 4 - e.g. - inherit Thread - implement Runnable -
 * Callable + future - thread pool - https://blog.csdn.net/baihualindesu/article/details/89523837
 */
class NumberThread implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i <= 100; i++) {
      if (i % 2 == 0) {
        System.out.println(Thread.currentThread().getName() + "-->" + i);
      }
    }
  }
}

class NumberThread2 implements Runnable {

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
public class demo1 {
  public static void main(String[] args) {

    // step 1) create a thread pool that can run 10 threads
    ExecutorService service = Executors.newFixedThreadPool(10);

    // step 2) execute the thread (via thread pool).
    //         NOTE : we need to offer instance implemented Runnable or Callable interface
    service.execute(new NumberThread()); // good to use with `Runnable`
    service.execute(new NumberThread2()); // good to use with `Runnable`

    // service.submit(Callable callable);  // good to use with `Callable`

    // step 3) shutdown thread pool
    service.shutdown();
  }
}
