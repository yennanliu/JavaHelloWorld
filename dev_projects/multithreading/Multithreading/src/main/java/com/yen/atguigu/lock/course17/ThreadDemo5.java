package com.yen.atguigu.lock.course17;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/** Demo HashMap thread unsafely */

// Course 17 : https://youtu.be/RL-RxAaj0aQ?si=Lj3jCiObI1pk48TO

/**
 * - Step 1: Create resource class, implement attr, op method - Step 2: implement method in resource
 * class - decision - main biz logic - notification (other thread) - Step 3: Create threads, call
 * resource class - Step 4: Avoid "虛假喚醒" (if logic)
 */
public class ThreadDemo5 {

  public static void main(String[] args) {

    // method 1) : HashSet : thread UNSAFELY
    // will cause exception : Exception in thread "1" java.util.ConcurrentModificationException
    // Set<String> set = new HashSet<>();

    // method 2) : CopyOnWriteArraySet : thread SAFELY
    // 1. NOT ordering, no duplicated
    Set<String> set = new CopyOnWriteArraySet<>();

    // NOTE !!! HashMap : thread UNSAFELY
    // we don't do demo below

    // via ConcurrentHashMap can make Map thread SAFELY

    for (int i = 0; i < 10; i++) {

      new Thread(
              new Runnable() {
                @Override
                public void run() {
                  // add context to list
                  set.add(UUID.randomUUID().toString().substring(0, 8));
                  // get context from list
                  System.out.println(set);
                }
              },
              String.valueOf(i))
          .start();
    }
  }
}
