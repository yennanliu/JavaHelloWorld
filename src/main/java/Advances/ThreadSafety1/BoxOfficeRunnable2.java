package Advances.ThreadSafety1;

// https://www.youtube.com/watch?v=ypAUxzhpWZs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=434

/**
 * Implement 3 box offices with Runnable interface (total ticket=100) - `Synchronized method` for
 * solving thread safety
 */
class WindowR2 implements Runnable {

  // attr
  // *** NOTE : here, we don't need to set tickets as static
  private int tickets = 100;

  @Override
  public void run() {

    while (true) {

      show();
    }
  }

  private synchronized void show() { // synchronized monitor : this

    if (tickets > 0) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(
          Thread.currentThread().getName() + " sells ticket, ticket num = " + tickets);
      tickets -= 1;
    }
    //        else {
    //            break;
    //        }
  }
}

// entry point
public class BoxOfficeRunnable2 {
  public static void main(String[] args) {

    WindowR2 w1 = new WindowR2();

    Thread t1 = new Thread(w1);
    Thread t2 = new Thread(w1);
    Thread t3 = new Thread(w1);

    t1.setName("box office 1");
    t2.setName("box office 2");
    t3.setName("box office 3");

    t1.start();
    t2.start();
    t3.start();
  }
}
