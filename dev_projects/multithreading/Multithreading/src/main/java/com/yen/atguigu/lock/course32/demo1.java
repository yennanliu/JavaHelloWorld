package com.yen.atguigu.lock.course32;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/** Lock downgrade demo 1
 *
 *   -> Write lock CAN downgrade to read lock
 *
 *    step 1) get write lock
 *    step 2) get read lock
 *    step 3) release write lock (downgrade write lock to read lock)
 *    step 4) release read lock
 *
 *    (CAN read while write)
 */


// course 32 : https://youtu.be/tlaBTB2eZzY?si=guBy_9HnHt3Zc31O

public class demo1 {

    public static void main(String[] args) {

        // readwrite lock instance
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock(); // read lock
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock(); // write lock

        /** Lock downgrade demo */

        // step 1) get write lock
        writeLock.lock();
        System.out.println("---> get write lock");

        // step 2) get read lock
        readLock.lock(); // can read while write
        System.out.println("---> get read lock"); // NOTE !!! we can still read while write : https://youtu.be/tlaBTB2eZzY?si=8JCmiXK-v16QpkLo&t=539

        // step 3) release write lock
        writeLock.unlock();

        // step 4) release read lock
        readLock.unlock();
    }

}
