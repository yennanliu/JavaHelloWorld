package com.yen.TddPlayGround.BankV4.service;

public class ThreadWithdraw implements Runnable{

    // attr
    private Bank bank;
    private double amount;

    // TODO : double check this design (put Bank in ThreadDeposit constructor)
    public ThreadWithdraw(Bank bank, double amount){
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run() {

        this.bank.withdraw(this.amount);
    }

}
