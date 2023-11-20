package com.yen.atguigu.lock.readWriteLock.course30;

/** ReadWrite Lock demo */

// course 30 : https://youtu.be/vQ3sv-8iL70?si=lqU61Jg4l1l1V6gT

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

// - Step 1: Create resource class, implement attr, op method
class myCache{

    // map
    // volatile : for NOT using cache, but sync with memory in each IO
    // https://github.com/yennanliu/til#20230304
    private volatile Map<String, Object> map = new HashMap<>();

    // put data
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + " put data !!" + " key = " + key);
        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + " put data done. " + " key = " + key);
    }

    // get data
    public Object get(String key){

        Object result = null;

        System.out.println(Thread.currentThread().getName() + " get data !!" + " key = " + key);
        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        result = map.get(key);
        System.out.println(Thread.currentThread().getName() + " get data done. " + " key = " + key);
        return result;
    }
}

public class ReadWriteLockDemo {
}
