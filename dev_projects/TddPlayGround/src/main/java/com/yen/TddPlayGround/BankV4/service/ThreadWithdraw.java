package com.yen.TddPlayGround.BankV4.service;

import com.yen.TddPlayGround.BankV4.bean.User;

public class ThreadWithdraw implements Runnable{

    // attr
    private BankService bank;
    private User user;
    private double amount;


    // TODO : double check this design (put Bank in ThreadDeposit constructor)
    public ThreadWithdraw(BankService bank, User user, double amount){
        this.bank = bank;
        this.user = user;
        this.amount = amount;
    }

    @Override
    public void run() {

        //System.out.println(Thread.currentThread().getName() + " ThreadWithdraw run");
        try {
            this.bank.withdraw(this.user, this.amount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
