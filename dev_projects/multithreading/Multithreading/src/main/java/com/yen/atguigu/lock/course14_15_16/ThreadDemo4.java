package com.yen.atguigu.lock.course14_15_16;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/** Demo list thread unsafely */

// Course 14 : https://youtu.be/0gz3RKOlt1g?si=2_jswaYyskzx0PsU
// Course 15 : https://youtu.be/bKVsxSjySiY?si=9lKReBdU48Y6zDiW
// Course 16 : https://youtu.be/AGA6KL4VvJk?si=KZQOr0udWPXCD6uA

/**
 *  - Step 1: Create resource class, implement attr, op method
 *  - Step 2: implement method in resource class
 * 	    - decision
 * 	    - main biz logic
 * 	    - notification (other thread)
 * - Step 3: Create threads, call resource class
 * - Step 4: Avoid "虛假喚醒" (if logic)
 *
 */

public class ThreadDemo4 {

    public static void main(String[] args) {

        // create ArrayList

        // method 1) : ArrayList : thread UNSAFELY
        // will cause exception below : Exception in thread "2" java.util.ConcurrentModificationException
        //List<String> list = new ArrayList<>();

        // method 2) : Vector : thread SAFELY
        // this works, since it implements synchronize in add method
        //List<String> list = new Vector<>();

        // method 3) :
        // Collections.synchronizedList : thread SAFELY
        //List<String> list = Collections.synchronizedList(new ArrayList<>());

        // method 4) (preferable)  :  CopyOnWriteArrayList
        // https://youtu.be/AGA6KL4VvJk?si=wHESlS_gfXL5YzIm&t=142
        List<String> list = new CopyOnWriteArrayList();

        for (int i = 0; i < 10; i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    // add context to list
                    list.add(UUID.randomUUID().toString().substring(0,8));
                    // get context from list
                    System.out.println(list);
                }
            }, String.valueOf(i)).start();
        }

    }

}
