package Advances.ThreadDemo5;

// https://www.youtube.com/watch?v=G6ip9IvXMY0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=424

/**
 * Example : (Method 2 :implement Runnable interface) set up 3 box offices selling tickets, 100
 * tickets in total
 */
class WindowR implements Runnable {

  // attr
  // *** NOTE : here, we don't need to set tickets as static
  private int tickets = 100;

  @Override
  public void run() {
    while (true) {
      if (tickets > 0) {
        System.out.println(
            Thread.currentThread().getName() + " sells ticket, ticket num = " + tickets);
        tickets -= 1;
      } else {
        break;
      }
    }
  }
}

// entry point
public class BoxOfficeDemo2 {
  public static void main(String[] args) {

    WindowR w1 = new WindowR();

    // *** NOTE : since we create a single instance : WindowR w1 = new WindowR();
    //            and put that into thread
    //            so the threads ARE USING SAME tickets
    //            e.g. all box office sale 100 tickets in total
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
