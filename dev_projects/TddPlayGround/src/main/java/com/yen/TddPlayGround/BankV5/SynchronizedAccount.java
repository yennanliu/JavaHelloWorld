package com.yen.TddPlayGround.BankV5;

// https://www.unlogged.io/post/java-concurrency-unlocked-a-comparative-guide-to-synchronization-tools


public class SynchronizedAccount {
    private double balance;

    public synchronized void withdraw(double amount) {
        balance -= amount;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized void transfer(SynchronizedAccount to, double amount) {
        this.withdraw(amount);
        to.deposit(amount);
    }

    public synchronized double getBalance() {
        return balance;
    }
}