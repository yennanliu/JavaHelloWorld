package com.yen.atguigu.lock.course32;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Lock downgrade demo 2
 *
 * <p>-> Read lock CAN'T downgrade to write lock
 *
 * <p>(CAN'T write while read)
 */

// course 32 : https://youtu.be/tlaBTB2eZzY?si=guBy_9HnHt3Zc31O

public class demo2 {

  public static void main(String[] args) {

    // readwrite lock instance
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock(); // read lock
    ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock(); // write lock

    readLock.lock();

    writeLock.lock();

    //        writeLock.unlock();
    //
    //        readLock.unlock();

    /**
     * Program will neven end (CAN'T write while read)
     *
     * <p>/Users/yennanliu/Library/Java/JavaVirtualMachines/corretto-17.0.9/Contents/Home/bin/java
     * -javaagent:/Applications/IntelliJ IDEA
     * CE.app/Contents/lib/idea_rt.jar=49987:/Applications/IntelliJ IDEA CE.app/Contents/bin
     * -Dfile.encoding=UTF-8 -classpath
     * /Users/yennanliu/JavaHelloWorld/dev_projects/multithreading/Multithreading/target/classes
     * com.yen.atguigu.lock.course32.demo2 ....
     */
  }
}
