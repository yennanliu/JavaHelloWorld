package com.yen.TddPlayGround.BankV2.sevice;

// https://www.geeksforgeeks.org/banking-transaction-system-using-java/


// Method - Withdraw method
// Called from ThreadWithdrawal class
// using the object of Bank class passed
// from the main() method

public class ThreadWithdrawal extends Thread {

    BankService object;
    String name;
    int dollar;

    // Constructor of this method
    public ThreadWithdrawal(BankService ob, String name, int money) {
        this.object = ob;
        this.name = name;
        this.dollar = money;
    }

    // run() method for thread
    @Override
    public void run() {
        object.withdrawn(name, dollar);
    }

}