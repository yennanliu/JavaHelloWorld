package thread;

public class MultiSalesThreadSynchronized {
  public static void main(String[] args) {
    SalesThread2 sales_thread = new SalesThread2();
    // create 4 threads, in order to simulate 4 box offices
    new Thread(sales_thread, "box office 1").start();
    new Thread(sales_thread, "box office 2").start();
    new Thread(sales_thread, "box office 3").start();
    new Thread(sales_thread, "box office 4").start();
  }
}

// implements from Runnable AND WITH synchronized
class SalesThread2 implements Runnable {
  // define the lock object
  Object lock = new Object();
  private int tickets = 10;

  public void run() {
    while (true) {
      /*
       * use "synchronized" to lock the process with "lock" object
       */
      synchronized (lock) {
        if (tickets > 0) {
          try {
            Thread.sleep(1000); // simulate the time cost during sales process
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println(
              // tickets-- is equal as tickets = tickets - 1
              Thread.currentThread().getName() + " is selling " + tickets-- + " ticket");
        }
      }
    }
  }
}
