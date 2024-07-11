package threadDev;

// https://stackoverflow.com/questions/28043225/future-cancel-does-not-work

import java.util.concurrent.*;

public class Test2 {
  public static void main(String[] args) {

    Runnable r =
        new Runnable() {
          @Override
          public void run() {
            try {
              while (!Thread.currentThread().isInterrupted()) {
                for (; ; ) {
                  System.out.println(
                          "--> Thread name : "
                                  + Thread.currentThread().getName()
                                  + ", id = "
                                  + Thread.currentThread().getId());
                  System.out.println("i = ");
                }
              }

              //              for (; ; ) {
              //                System.out.println("i = ");
              //              }
              //              for (int i = 0; i < 10; i++) {
              //                System.out.println("i = " + i);
              //              }

            } finally {
              System.out.println("FINALLY");
            }
          }
        };

    ExecutorService executor = Executors.newSingleThreadExecutor();

    Future<?> future = executor.submit(r);
    try {
      future.get(3, TimeUnit.SECONDS);
    } catch (TimeoutException e) {

      System.out.println(">>> (before) future.cancel");
      boolean c = future.cancel(true);
      System.out.println(">>> (after) future.cancel");

      System.out.println("Timeout " + c);
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("interrupted");
    } finally {
      System.out.println("executor.shutdown");
      executor.shutdown();
      System.out.println("END");
    }
  }

}
