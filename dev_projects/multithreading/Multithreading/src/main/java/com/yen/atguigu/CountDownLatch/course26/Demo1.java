package com.yen.atguigu.CountDownLatch.course26;

import java.util.concurrent.CountDownLatch;

/** CountDownLatch demo */

// course 26 : https://youtu.be/7kVpV-UxJ8U?si=XsuLW8EwTX0JqDGw

public class Demo1 {

  public static void main(String[] args) throws InterruptedException {

    /** V1 : without CountDownLatch */

    // all 6 students left classroom -> lock classroom
    // https://youtu.be/7kVpV-UxJ8U?si=-ycGvDYMEZUYVk4L&t=372
    //        for (int i = 0; i < 6; i++){
    //            new Thread(new Runnable() {
    //                @Override
    //                public void run() {
    //                    System.out.println(Thread.currentThread().getName() + " student leave
    // classroom");
    //                }
    //            }, String.valueOf(i)).start();
    //        }
    //
    //        System.out.println(Thread.currentThread().getName() + " LOCK classroom !!!");

    /**
     * V1 is NOT what we want -> Lock classroom is NOT already executed as final step
     *
     * <p>example log : 0 student leave classroom 5 student leave classroom 2 student leave
     * classroom main LOCK classroom !!! 4 student leave classroom 1 student leave classroom 3
     * student leave classroom
     */

    /** V2 : with CountDownLatch */
    /**
     * Steps : step 1 : create CountDownLatch instance, and setup init value step 2 : update value
     * step 3 : wait (block) op
     *
     * <p>example log:
     *
     * <p>5 student leave classroom 3 student leave classroom 1 student leave classroom 2 student
     * leave classroom 0 student leave classroom 4 student leave classroom main LOCK classroom !!!
     */
    // step 1
    CountDownLatch countDownLatch = new CountDownLatch(6);
    for (int i = 0; i < 6; i++) {
      new Thread(
              new Runnable() {
                @Override
                public void run() {
                  System.out.println(Thread.currentThread().getName() + " student leave classroom");
                  //  step 2
                  countDownLatch.countDown();
                }
              },
              String.valueOf(i))
          .start();
    }

    // step 3
    countDownLatch.await();

    System.out.println(Thread.currentThread().getName() + " LOCK classroom !!!");
  }
}
