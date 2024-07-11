package threadDev;

import java.util.concurrent.*;

/**
 *  future cancel fixing (modified by gpt)
 *
 *  - boolean c = future.cancel(true);
 *
 *
 *  1. Check for Interruption in the Loop:
 * 	  - Within the infinite loop, I added a check if (Thread.currentThread().isInterrupted())
 * 	    to break the loop if the thread is interrupted.
 *
 * 	2.	Thread Interruption Handling:
 * 	  - When future.cancel(true) is called, it interrupts the thread running the task.
 * 	    The check within the loop ensures that the thread stops executing when it is interrupted.
 *
 * 	3.	Executor Shutdown:
 * 	  - The executor.shutdown() is still called in the finally block
 * 	    to ensure that the executor is properly shut down,
 * 	    but now the thread running the task will properly exit when interrupted.
 *
 *
 */
public class Test2 {
  public static void main(String[] args) {

    Runnable r = new Runnable() {
      @Override
      public void run() {
        try {
          while (!Thread.currentThread().isInterrupted()) {
            int iteration = 0;
            for (; ; ) {
              System.out.println(
                      "--> Thread name : "
                              + Thread.currentThread().getName()
                              + ", id = "
                              + Thread.currentThread().getId() + ", iteration = " + iteration);
              iteration += 1;
              /**
               *  NOTE !!! how we quit iteration when future.cancel(true) is called
               *
               *  Thread Interruption Handling:
               * 	•	When future.cancel(true) is called, it interrupts the thread running the task. The check within the loop ensures that the thread stops executing when it is interrupted.
               *
               */
              if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread interrupted, exiting...");
                break;
              }
            }
          }
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