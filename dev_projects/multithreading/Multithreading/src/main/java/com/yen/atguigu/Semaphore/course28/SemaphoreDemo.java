package com.yen.atguigu.Semaphore.course28;

// Course 28 : https://youtu.be/1-0qVNJfl78?si=Fd-OTucTi7exttCG

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// 6 cars, 3 parking lot, simulate car compete for parking lot
public class SemaphoreDemo {

  public static void main(String[] args) {

    // create Semaphor instance (permits = 3)
    Semaphore semaphore = new Semaphore(3);

    // 6 cars (simulated by 6 threads)
    for (int i = 0; i < 6; i++) {
      new Thread(
              new Runnable() {
                @Override
                public void run() {

                  // get parking lot
                  try {

                    // car get parking lot
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " get parking lot !!");

                    // parking time (random)
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));

                    // car leave parking lot
                    System.out.println(
                        Thread.currentThread().getName() + " ---- leave parking lot");

                  } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                  } finally {
                    // release parking lot
                    semaphore.release();
                  }
                }
              },
              String.valueOf(i))
          .start();
    }
  }
}
