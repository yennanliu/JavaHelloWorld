package Advances.DynamicProxy;

// https://www.youtube.com/watch?v=ySJn484D19Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=686

import org.junit.jupiter.api.Test;

/** static proxy demo 2 */
public class StaticProxyDemo2 {

  /** example 1 : implement Runnable interface for multi thread */
  @Test
  public void test1() {

    // proxied class
    class MyThread implements Runnable {
      @Override
      public void run() {}
    }

      // proxy class
    class Thread implements Runnable {
      public Thread(MyThread t) {}

      @Override
      public void run() {}
    }

    // run
    MyThread t = new MyThread();
    Thread thread = new Thread(t);
    thread.run();
  }
}
