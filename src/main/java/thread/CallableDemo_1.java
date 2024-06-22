package thread;

import java.util.concurrent.*;

class MyThread3 implements Callable<Object> {
  // rewrite call method in Callable
  public Object call() throws Exception {
    int i = 0;
    while (i++ < 10) {
      System.out.println(Thread.currentThread().getName() + "'s run() method is running");
    }
    return i;
  }
}

public class CallableDemo_1 {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    MyThread3 myThread3 = new MyThread3();

    // use FutureTask package callable interface
    FutureTask<Object> ft1 = new FutureTask<>(myThread3);

    // create 1st thread
    Thread thread1 = new Thread(ft1, "thread1");

    // use start() to run the thread
    thread1.start();

    // create 2nd thread
    FutureTask<Object> ft2 = new FutureTask<>(myThread3);
    Thread thread2 = new Thread(ft2, "thread1");
    thread2.start();

    // can take the thread return value via below method
    System.out.println("thread1 return : " + ft1.get());
    System.out.println("thread2 return : " + ft2.get());
  }
}
