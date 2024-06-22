package Advances.ThreadSafety1;

// https://www.youtube.com/watch?v=xNJ6jZlCFVs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=436

/**
 * Implement 3 box offices with Thread class (total ticket=100)
 *
 * <p>- `Synchronized method` for solving thread safety
 */
class Thread_T2 extends Thread {

  // attr
  // **** NOTE : WE NEED TO SET TICKET AS static attr
  //             since we want box offices sell 100 tickets in total
  //             rather than sell 100 tickets by each of them
  private static int tickets = 100;

  // we need `static` below to make sure the synchronized lock is UNIQUE
  private static synchronized void show() { // synchronized monitor : Thread_T2.class
    // private static synchronized void show(){ // this one is WRONG
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
    //            else{
    //                break;
    //            }
  }

  // method
  @Override
  public void run() {

    while (true) {
      show();
    }
  }
}

// entry point
public class BoxOfficeThread2 {
  public static void main(String[] args) {

    Thread_T2 b1 = new Thread_T2();
    Thread_T2 b2 = new Thread_T2();
    Thread_T2 b3 = new Thread_T2();

    b1.setName("box office 1");
    b2.setName("box office 2");
    b3.setName("box office 3");

    b1.start();
    b2.start();
    b3.start();
  }
}
