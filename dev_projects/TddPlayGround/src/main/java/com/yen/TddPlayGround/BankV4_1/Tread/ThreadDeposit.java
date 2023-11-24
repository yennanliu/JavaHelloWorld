package com.yen.TddPlayGround.BankV4_1.Tread;

import com.yen.TddPlayGround.BankV4_1.bean.User;
import com.yen.TddPlayGround.BankV4_1.service.BaseBankService;

/** Deposit thread */


public class ThreadDeposit implements ThreadFactory {

    // attr
    private BaseBankService bank;
    private User user;
    private double amount;

    // TODO : double check this design (put Bank in ThreadDeposit constructor)
    public ThreadDeposit(BaseBankService bank, User user, double amount){
        this.bank = bank;
        this.user = user;
        this.amount = amount;
    }

    @Override
    public void run() {

        //System.out.println(Thread.currentThread().getName() + " ThreadDeposit run");
        try {
            this.bank.deposit(this.user, this.amount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
