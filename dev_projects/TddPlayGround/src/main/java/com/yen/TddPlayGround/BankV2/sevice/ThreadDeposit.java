package com.yen.TddPlayGround.BankV2.sevice;

// Deposit method is called from ThreadDeposit class
// using the object of Bank class passed
// from the main method
public class ThreadDeposit extends Thread {

    BankService object;
    String name;
    int dollar;

    public ThreadDeposit(BankService ob, String name, int money) {
        // This keyword refers t ocurrent instance itself
        this.object = ob;
        this.name = name;
        this.dollar = money;
    }

    public void run() {
        object.deposit(name, dollar);
    }

}