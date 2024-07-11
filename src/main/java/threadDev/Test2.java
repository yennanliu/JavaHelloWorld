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
              for (; ; ) {}

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
      boolean c = future.cancel(true);
      System.out.println("Timeout " + c);
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("interrupted");
    }
    System.out.println("END");
  }
  
}
