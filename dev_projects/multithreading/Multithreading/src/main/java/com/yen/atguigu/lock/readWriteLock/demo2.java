package com.yen.atguigu.lock.readWriteLock;

// https://www.cnblogs.com/yxy-ngu/p/15696825.html


/**
 *  Read-write lock demo (讀寫互斥Demo)
 *
 *   In short,
 *
 *   1. 讀讀共享
 *   2. 寫寫互斥 (thread unsafe)
 *   3. 讀寫互斥 (thread unsafe)
 *
 *   https://en.wikipedia.org/wiki/Readers%E2%80%93writer_lock
 */

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 *  Conclusion :
 *
 *      1、讀取和讀取之間不互斥，因為讀取操作不會有線程安全問題
 *
 *      2、寫和寫之間互斥，避免一個寫操作影響另外一個寫操作，引發線程安全問題
 *
 *      3、讀取和寫入之間互斥，避免讀取操作的時候寫操作修改了內容，引發線程安全問題
 *
 *      -> 總結起來就是，多個Thread可以同時進行讀取操作，但是同一時刻只允許一個Thread進行寫入操作。
 *
 */

class MyDomain3 {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void testReadLock() {
        try {
            lock.readLock().lock();
            System.out.println(System.currentTimeMillis() + " 获取读锁");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void testWriteLock() {
        try {
            lock.writeLock().lock();
            System.out.println(System.currentTimeMillis() + " 获取写锁");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

}

// thread
class Mythread3_1 extends Thread {

    private MyDomain3 myDomain3;

    public Mythread3_1(MyDomain3 myDomain3) {
        this.myDomain3 = myDomain3;
    }

    @Override
    public void run() {
        myDomain3.testReadLock();
    }
}

class Mythread3_2 extends Thread {

    private MyDomain3 myDomain3;

    public Mythread3_2(MyDomain3 myDomain3) {
        this.myDomain3 = myDomain3;
    }

    @Override
    public void run() {
        myDomain3.testWriteLock();
    }
}

public class demo2 {
    public static void main(String[] args) throws InterruptedException {

        /** test run 1 : read + read */
//        MyDomain3 myDomain3 = new MyDomain3();
//        Mythread3_1 readLock = new Mythread3_1(myDomain3);
//        Mythread3_1 readLock2 = new Mythread3_1(myDomain3);
//        readLock.start();
//        readLock2.start();
//
//        Thread.sleep(3000);

        /** test run 2 : write + write */
//        MyDomain3 myDomain3 = new MyDomain3();
//        Mythread3_2 writeLock = new Mythread3_2(myDomain3);
//        Mythread3_2 writeLock2 = new Mythread3_2(myDomain3);
//
//        writeLock.start();
//        writeLock2.start();

        //Thread.sleep(3000);

        /** test run 3 : read + write */
        MyDomain3 myDomain3 = new MyDomain3();
        Mythread3_1 readLock = new Mythread3_1(myDomain3);
        Mythread3_2 writeLock = new Mythread3_2(myDomain3);

        readLock.start();
        writeLock.start();

        Thread.sleep(3000);
    }

}
