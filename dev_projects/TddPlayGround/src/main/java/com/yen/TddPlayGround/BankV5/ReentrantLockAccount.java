package com.yen.TddPlayGround.BankV5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// https://www.unlogged.io/post/java-concurrency-unlocked-a-comparative-guide-to-synchronization-tools

public class ReentrantLockAccount {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public void withdraw(double amount) {
        lock.lock();
        try {
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void transfer(ReentrantLockAccount to, double amount) {
        lock.lock(); // The current thread acquires the lock
        try {
            this.withdraw(amount); // The same thread reacquires the lock
            to.deposit(amount);
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
