package thread;

public class ThreadYield {
  public static void main(String[] args) {
    // create 2 threads
    Thread thread1 = new YieldThread("thread1");
    Thread thread2 = new YieldThread("thread2");

    // run
    thread1.run();
    thread2.run();
  }
}

// extend from thread
class YieldThread extends Thread {
  // define a method with parameter
  public YieldThread(String name) {
    // use the "parent class" method
    super(name);
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + " ----- " + i);
      if (i == 2) {
        System.out.println("thread STOP");
        /*
         *  "yield" will NOT BLOCK THE PROCESS, but let the JVM be able to dispense the resources again,
         *  the high priority or other process would then be able to run
         */
        Thread.yield();
      }
    }
  }
}
