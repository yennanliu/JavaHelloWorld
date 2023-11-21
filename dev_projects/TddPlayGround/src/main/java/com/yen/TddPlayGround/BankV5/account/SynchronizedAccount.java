package com.yen.TddPlayGround.BankV5.account;

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

        System.out.println("transfer " + amount + " to " + to.toString());
        this.withdraw(amount);
        to.deposit(amount);
    }

    public synchronized double getBalance() {

        return balance;
    }

    @Override
    public String toString() {
        return "SynchronizedAccount{" +
                "balance=" + balance +
                '}';
    }

}