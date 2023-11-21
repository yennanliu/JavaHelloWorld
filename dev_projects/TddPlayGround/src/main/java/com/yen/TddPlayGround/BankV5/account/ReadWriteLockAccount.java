package com.yen.TddPlayGround.BankV5.account;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// https://www.unlogged.io/post/java-concurrency-unlocked-a-comparative-guide-to-synchronization-tools


public class ReadWriteLockAccount {
    private double balance;
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public boolean withdraw(double amount) {
        rwLock.writeLock().lock();
        try {
            balance -= amount;
            return true;
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public boolean deposit(double amount) {
        rwLock.writeLock().lock();
        try {
            balance += amount;
            return true;
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public boolean transfer(ReadWriteLockAccount to, double amount) {
        System.out.println("transfer start ...");
        rwLock.writeLock().lock();
        try {
            System.out.println("transfer " + amount + " to " + to.toString());
            if (!this.withdraw(amount)) return false; // Withdrawal failure
            return to.deposit(amount); // Deposit and return the result
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public double getBalance() {
        rwLock.readLock().lock();
        try {
            return balance;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    @Override
    public String toString() {
        return "ReadWriteLockAccount{" +
                "balance=" + balance +
                ", rwLock=" + rwLock +
                '}';
    }

}
