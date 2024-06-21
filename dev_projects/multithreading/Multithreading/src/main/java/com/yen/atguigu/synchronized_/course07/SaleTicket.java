package com.yen.atguigu.synchronized_.course07;

/** Multi-thread with synchronized */

// course 06 : https://youtu.be/vBzCBFpcGKk?si=V1EncXqP1IkMZrqO&t=71

/**
 * - Step 1: Create resource class, implement attr, op method - Step 2: implement method in resource
 * class - decision - main biz logic - notification (other thread) - Step 3: Create threads, call
 * resource class - Step 4: Avoid "虛假喚醒" (if logic)
 */

//  Step 1: Create resource class, implement attr, op method
class Ticket {

  // ticket count
  private int number = 30;

  public synchronized void sale() {
    // Step 2: implement method in resource class
    // decision : check if sale ticket
    if (number > 0) {
      System.out.println(
          "--> "
              + Thread.currentThread().getName()
              + " sales : "
              + (number--)
              + ", remain : "
              + number);
    }
  }
}

public class SaleTicket {

  public static void main(String[] args) {

    // Step 3: Create threads, call resource class
    Ticket ticket = new Ticket();

    /** NOTE !!! thread need in main method */
    // create 3 threads
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                // call resource class
                for (int i = 0; i < 40; i++) {
                  ticket.sale();
                }
              }
            },
            "AA")
        .start();

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                // call resource class
                for (int i = 0; i < 40; i++) {
                  ticket.sale();
                }
              }
            },
            "BB")
        .start();

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                // call resource class
                for (int i = 0; i < 40; i++) {
                  ticket.sale();
                }
              }
            },
            "CC")
        .start();

    // https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/ThreadDemo5/RunnableDemo1.java#L16C16-L16C26
    //    class MyThread implements Runnable{
    //
    //        @Override
    //        public void run() {
    //            // call resource class
    //            for (int i = 0; i < 40; i++){
    //                ticket.sale();
    //            }
    //        }
    //    }

  }
}
