package thread;

class DamonThread implements Runnable {
  public void run() {
    while (true) {
      System.out.println(Thread.currentThread().getName() + "--- is running");
    }
  }
}

public class DamonThread_Demo1 {
  public static void main(String[] args) {

    // check if is daemon thread
    System.out.println("is main thread the daemon thread ??" + Thread.currentThread().isDaemon());

    DamonThread dt = new DamonThread();

    Thread thread = new Thread(dt, "DaemonThread");

    System.out.println("is thread the daemon thread ?" + thread.isDaemon());

    // set thread as daemon thread
    thread.setDaemon(true);
    thread.start();

    // simulate main process
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }
  }
}
