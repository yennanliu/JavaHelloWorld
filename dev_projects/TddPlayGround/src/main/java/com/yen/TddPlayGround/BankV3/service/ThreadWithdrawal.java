package com.yen.TddPlayGround.BankV3.service;

// https://www.geeksforgeeks.org/banking-transaction-system-using-java/

// Method - Withdraw
// It is called from ThreadWithdrawal class using
// the object of Bank class passed from the main method
public class ThreadWithdrawal extends Thread {

    // Attributes of this class
    BankService object;
    String name;
    int dollar;

    // Constructor of this class
    public ThreadWithdrawal(BankService ob, String name, int money)
    {
        // This keyword refers to parent class
        this.object = ob;
        this.name = name;
        this.dollar = money;
    }

    // run() method for the thread
    public void run() { object.withdrawn(name, dollar); }
}