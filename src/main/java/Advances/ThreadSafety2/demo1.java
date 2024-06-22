package Advances.ThreadSafety2;

// https://www.youtube.com/watch?v=vx97FYJ3VvA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=438

import java.util.concurrent.locks.ReentrantLock;

/**
 * Solve thread safety method 3 -- Lock (new since JDK 5.0)
 *
 * <p>1) difference / same between synchronized and lock ?
 *
 * <p>- difference : - synchronized (method, code block) will release synchronized monitors
 * automatically after running - lock : we need to manually run (lock.lock(), lock.unlock()) - same
 * : - both of them can solve thread safety
 *
 * <p>2) preference - Lock -> synchronized code block -> synchronized method
 *
 * <p>3) apps, classes... (before JDK 5.0) use synchronized (method, code block) mainly for cases
 * after JDK 5.0, we use Lock more
 *
 * <p>ps : list of ways solve thready safety: - synchronized method - synchronized code block - lock
 */
class Window implements Runnable {

  private int ticket = 100;

  // step 1) define/instantiate a lock
  private ReentrantLock lock = new ReentrantLock();

  @Override
  public void run() {
    while (true) {
      try {

        // step 2) use the lock.lock(); method
        lock.lock();

        if (ticket > 0) {
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

          System.out.println(
              Thread.currentThread().getName() + " sells ticket, ticket num = " + ticket);
          ticket -= 1;

        } else {
          break;
        }
      } finally {
        // step 3) call the lock.unlock(); method
        lock.unlock();
      }
    }
  }
}

// entry point
public class demo1 {
  public static void main(String[] args) {
    // run
    Window w = new Window();

    Thread t1 = new Thread(w);
    Thread t2 = new Thread(w);
    Thread t3 = new Thread(w);

    t1.setName("window 1");
    t2.setName("window 2");
    t3.setName("window 3");

    t1.start();
    t2.start();
    t3.start();
  }
}
