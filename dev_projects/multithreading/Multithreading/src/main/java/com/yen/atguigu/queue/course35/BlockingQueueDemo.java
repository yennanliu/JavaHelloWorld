package com.yen.atguigu.queue.course35;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/** Blocking Queue demo */

// course 35 : https://youtu.be/MHB_pD32PUQ?si=KVaGwC4AqqQpxRMf

public class BlockingQueueDemo {

  public static void main(String[] args) throws InterruptedException {

    // create BlockingQueue
    final int SIZE = 3;
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(SIZE);

    // op 1 : add, remove
    //        System.out.println(blockingQueue.add("a")); // true
    //        System.out.println(blockingQueue.add("b")); // true
    //        System.out.println(blockingQueue.add("c")); // true
    //        System.out.println(blockingQueue.element()); // a
    //
    //        //System.out.println(blockingQueue.add("z")); // Exception in thread "main"
    // java.lang.IllegalStateException: Queue full
    //
    //        System.out.println(blockingQueue.remove()); // a

    // op 2 : offer, poll
    //        System.out.println(blockingQueue.offer("a")); // true
    //        System.out.println(blockingQueue.offer("b")); // true
    //        System.out.println(blockingQueue.offer("c")); // true
    //
    //        System.out.println(blockingQueue.offer("z")); // false, but there is NO exception
    //
    //        System.out.println(blockingQueue.poll()); // a
    //        System.out.println(blockingQueue.poll()); // b
    //        System.out.println(blockingQueue.poll()); // c

    // op 3 : put
    //        blockingQueue.put("a"); // blocking ....
    //        blockingQueue.put("b");
    //        blockingQueue.put("c");
    //
    //        //blockingQueue.put("z"); // will block the queue, since queue size is 3, but we are
    // trying to put 4th element, which is oversize
    //
    //        System.out.println(blockingQueue.take());
    //        System.out.println(blockingQueue.take());
    //        System.out.println(blockingQueue.take());
    // System.out.println(blockingQueue.take()); // will block the queue, since queue size is 3, but
    // there is NO 4th element, so queue is blocked, waiting for 4th element to be added

    // op 4
    System.out.println(blockingQueue.offer("a"));
    System.out.println(blockingQueue.offer("a"));
    System.out.println(blockingQueue.offer("a"));
    System.out.println(
        blockingQueue.offer(
            "a", 3L, TimeUnit.SECONDS)); // will give up (unblock queue) if pending > 3 sec
  }
}
