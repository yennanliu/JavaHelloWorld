package Advances.ThreadCommunication1;

// https://www.youtube.com/watch?v=Rq7ZGSyV65U&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=440

/**
 * Thread Communication demo 1 -> 2 threads print 1-100, `one thread prints after the other` (`one
 * thread prints after the other` : thread Communication)
 *
 * <p>Thread Communication methods 1) wait(): -> once run this method, the thread will be in
 * `blocked` status and RELEASE Synchronized monitor (lock)
 *
 * <p>2) notify(): -> once run this method, the thread will be "WAKED UP", if there are multiple
 * threads, the first priority thread will be waked up
 *
 * <p>3) notifyAll() -> once run this method, ALL of the OTHER threads will be "WAKED UP"
 *
 * <p>Note : 1) Thread Communication methods CAN ONLY be used IN `Synchronized code block` or
 * `Synchronized method` (e.g. wait(), notify(), notifyAll())
 *
 * <p>2) wait(), notify(), notifyAll() SHOULD BE CALLED by the Synchronized monitor, or will raise
 * an `IllegalMonitorException` exception
 *
 * <p>3) wait(), notify(), notifyAll() are defined under java.lang.Object class (because every obj
 * in java can be used as a Synchronized monitor) example :
 * https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/ThreadSafety1/BoxOfficeRunnable1.java#L67-L71
 */

// entry point
public class demo1 {
  public static void main(String[] args) {

    // run
    Number number = new Number();
    Thread t1 = new Thread(number);
    Thread t2 = new Thread(number);

    t1.setName("thread-1");
    t2.setName("thread-2");

    t1.start();
    t2.start();
  }
}

class Number implements Runnable {

  // attr
  private int number = 1;

  // constructor

  // method
  @Override
  public void run() {

    while (true) {
      synchronized (this) {

        // NOTE : we only have 2 threads in this demo, so notify() is OK
        //        However, if multiple threads (>2) case, then we need to use notifyAll() method
        // e.g. :
        // notify() : will wake 1 thread up only
        // notifyAll(): will wake ALL OF THE OTHER threads up
        this.notify(); // or notify() is OK as all

        if (number <= 100) {

          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

          System.out.println(Thread.currentThread().getName() + " : " + number);
          number += 1;

          // NOTE : below use wait() method in thread -> make thread into "blocked" status
          // NOTE : when use `wait()`, we also need `notify()`, so the treads will not ALWAYS be in
          // blocked status
          // NOTE : wait() will RELEASE THE LOCK
          // https://github.com/yennanliu/JavaHelloWorld/blob/main/doc/pic/thread_cycle2.svg
          try {
            this.wait(); // or wait() is OK as well
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

        } else {
          break;
        }
      }
    }
  }
}
