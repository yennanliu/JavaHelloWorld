package com.yen.TddPlayGround.BankV5.account;

// https://www.unlogged.io/post/java-concurrency-unlocked-a-comparative-guide-to-synchronization-tools


public class SimpleAccount {
    private double balance;

    public void withdraw(double amount) {

        balance -= amount;
    }

    public void deposit(double amount) {

        balance += amount;
    }

    public void transfer(SimpleAccount to, double amount) {

        System.out.println("transfer " + amount + " to " + to.toString());
        this.withdraw(amount);
        to.deposit(amount);
    }

    public double getBalance() {

        return balance;
    }

    @Override
    public String toString() {
        return "SimpleAccount{" +
                "balance=" + balance +
                '}';
    }

}
