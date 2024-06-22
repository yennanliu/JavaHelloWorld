package thread;

public class ThreadWithPriority {
  public static void main(String[] args) {
    // define 2 thread objects

    // thread 1
    Thread thread1 =
        new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                System.out.println(
                    Thread.currentThread().getName() + " now output stream i = " + i);
              }
            },
            "LOW PRIORITY THREAD");

    // thread 2
    Thread thread2 =
        new Thread(
            () -> {
              for (int j = 0; j < 10; j++) {
                System.out.println(
                    Thread.currentThread().getName() + " now output stream j = " + j);
              }
            },
            "HIGH PRIORITY THREAD");

    // set up the thread priority
    thread1.setPriority(Thread.MIN_PRIORITY);
    thread2.setPriority(10);

    // run
    thread1.start();
    thread2.start();
  }
}
