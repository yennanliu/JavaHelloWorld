package com.yen.TddPlayGround.BankV5;

// https://www.unlogged.io/post/java-concurrency-unlocked-a-comparative-guide-to-synchronization-tools

import com.yen.TddPlayGround.BankV5.account.ReadWriteLockAccount;
import com.yen.TddPlayGround.BankV5.account.ReentrantLockAccount;
import com.yen.TddPlayGround.BankV5.account.SynchronizedAccount;

public class BankV5App {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("BankV5App run !!!");

        /** V1 **/
//        var account1 = new SimpleAccount();
//        var account2 = new SimpleAccount();

        /** V2 **/
        // will cause dead lock
//        var account1 = new SynchronizedAccount();
//        var account2 = new SynchronizedAccount();

        /** V3 **/
        // will cause dead lock
//        var account1 = new ReentrantLockAccount();
//        var account2 = new ReentrantLockAccount();

        // ReadWriteLockAccount
        /** V4 **/
        var account1 = new ReadWriteLockAccount();
        var account2 = new ReadWriteLockAccount();

        final int REPEAT = 10;

        //Thread thread = Thread.ofPlatform().daemon().start(runnable);

        // Thread to handle transfers from account1 to account2
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < REPEAT; i++) {
                    System.out.println(Thread.currentThread().getName());
                    account1.transfer(account2, 100.00);
                }
            }
        });

//        var t1 = Thread.ofPlatform().unstarted(() -> {
//            for (int i = 0; i < repeat; i++) {
//                account1.transfer(account2, 100.00);
//            }
//        });

        // Thread to handle transfers from account2 to account1
//        var t2 = Thread.ofPlatform().unstarted(() -> {
//            for (int i = 0; i < repeat; i++) {
//                account2.transfer(account1, 100.00);
//            }
//        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < REPEAT; i++) {
                    System.out.println(Thread.currentThread().getName());
                    account2.transfer(account1, 100.00);
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Print out the final balance of each account
        System.out.println("account1.getBalance() = " + account1.getBalance());
        System.out.println("account2.getBalance() = " + account2.getBalance());
    }

}
