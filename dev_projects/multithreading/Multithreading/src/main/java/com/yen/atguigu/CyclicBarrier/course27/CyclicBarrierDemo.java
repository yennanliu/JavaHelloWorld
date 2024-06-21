package com.yen.atguigu.CyclicBarrier.course27;

// course 27 : https://youtu.be/ermOYA1THwU?si=tZLltSSefr0xzmvl

// call dragon when collect 7 dragon balls

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

  private static final int NUMBER = 7;

  public static void main(String[] args) {

    // create CyclicBarrier instance
    CyclicBarrier cyclicBarrier =
        new CyclicBarrier(
            NUMBER,
            new Runnable() {
              @Override
              public void run() {
                System.out.println("--> call dragon!!!  (collect 7 dragon balls OK)");
              }
            });

    // collect dragon ball op
    for (int i = 0; i < 7; i++) {
      new Thread(
              () -> {
                try {
                  System.out.println(
                      Thread.currentThread().getName() + " dragon ball is collected");
                  // await (if not yet collect 7 balls)
                  cyclicBarrier.await();
                } catch (InterruptedException e) {
                  throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                  throw new RuntimeException(e);
                }
              },
              String.valueOf(i))
          .start();
    }
  }
}
