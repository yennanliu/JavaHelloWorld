package com.yen.atguigu.lock.readWriteLock.course30;

/** ReadWrite Lock demo */

// course 30 : https://youtu.be/vQ3sv-8iL70?si=lqU61Jg4l1l1V6gT

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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

    /** create read write lock instance */
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // map
    // volatile : for NOT using cache, but sync with memory in each IO
    // https://github.com/yennanliu/til#20230304
    private volatile Map<String, Object> map = new HashMap<>();

    // put data
    public void put(String key, Object value) {

        /** add write lock */
        rwLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " put data !!" + " key = " + key);
            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " put data done. " + " key = " + key);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            /** release write lock */
            rwLock.writeLock().unlock();
        }

    }

    // get data
    public Object get(String key){

        /** add read lock */
        rwLock.readLock().lock();

        Object result = null;

        try {
            System.out.println(Thread.currentThread().getName() + " get data !!" + " key = " + key);
            TimeUnit.MICROSECONDS.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " get data done. " + " key = " + key);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            /** release read lock */
            rwLock.readLock().unlock();
        }
        return result;
    }
}

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        myCache myCache = new myCache();

        // create thread put data
        for (int i = 0; i < 5; i++){
            final int num = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myCache.put(num+"", num+"");
                }
            }, String.valueOf(i)).start();
        }


        // create thread get data
        for (int i = 0; i < 5; i++){
            final int num = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myCache.get(num+"");
                }
            }, String.valueOf(i)).start();
        }

        /**
         *  Before read, write lock :
         *
         *   -> NOT correct, ONLY can read after put data completed
         *
         *  log :
         * 1 get data !! key = 1
         * 2 put data !! key = 2
         * 3 get data !! key = 3
         * 4 get data !! key = 4
         * 1 put data !! key = 1
         * 0 get data !! key = 0
         * 0 put data !! key = 0
         * 3 put data !! key = 3
         * 4 put data !! key = 4
         * 2 get data !! key = 2
         * 4 put data done.  key = 4
         * 0 get data done.  key = 0
         * 0 put data done.  key = 0
         * 1 get data done.  key = 1
         * 1 put data done.  key = 1
         * 3 put data done.  key = 3
         * 2 put data done.  key = 2
         * 3 get data done.  key = 3
         * 4 get data done.  key = 4
         * 2 get data done.  key = 2
         *
         *
         */

    }

}
