package com.yen.TddPlayGround.BankV3.service;

// https://www.geeksforgeeks.org/banking-transaction-system-using-java/

public class ThreadDeposit extends Thread {

    BankService object;
    String name;
    int dollar;

    public ThreadDeposit(BankService ob, String name, int money)
    {
        this.object = ob;
        this.name = name;
        this.dollar = money;
    }

    public void run() { object.deposit(name, dollar); }
}