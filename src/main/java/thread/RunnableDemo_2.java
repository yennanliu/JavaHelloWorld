package thread;

class TicketWindow2 implements Runnable {
  private int tickets = 100;

  public void run() {
    while (true) {
      if (tickets > 0) {
        System.out.println(
            Thread.currentThread().getName() + " is selling " + tickets-- + " ticket now");
      }
    }
  }
}

public class RunnableDemo_2 {
  public static void main(String[] args) {
    // create TicketWindow object
    TicketWindow2 tw = new TicketWindow2();

    // create 4 threads separately, naming them, and run the process
    new Thread(tw, "window1").start();
    new Thread(tw, "window2").start();
    new Thread(tw, "window3").start();
    new Thread(tw, "window4").start();
  }
}
