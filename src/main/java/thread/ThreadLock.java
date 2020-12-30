package thread;

import java.util.concurrent.locks. * ;

public class ThreadLock {
  public static void main(String[] args) {
    LockThread salesThread = new LockThread();
    // run
    // create 4 threads, for simulating the 4 box offices
    new Thread(salesThread, "box office 1").start();
    new Thread(salesThread, "box office 2").start();
    new Thread(salesThread, "box office 3").start();
    new Thread(salesThread, "box office 4").start();
  }
}

class LockThread implements Runnable {
  private int tickets = 10;
  // *** define a lock object
  private final Lock lock = new ReentrantLock();
  public void run() {
    while (true) {
      // add lock to the the application code
      lock.lock();
      while (tickets > 0) {
        try {
          Thread.sleep(100);
          System.out.println(Thread.currentThread().getName() + " is selling the " + tickets-- + "ticket");
        } catch(InterruptedException e) {
          e.printStackTrace();
        }
        finally {
          // release the lock when code run completed
          lock.unlock();
        }
      }
    }
  }
}