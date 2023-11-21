package com.yen.TddPlayGround.BankV4.service;

import com.yen.TddPlayGround.BankV4.bean.User;

import java.util.concurrent.TimeUnit;

public class BankService {

    //private User user;

    public BankService(){

    }

//    public BankService(User user){
//        this.user = user;
//    }

    public void deposit(User user, double amount) throws InterruptedException {

        user.setBalance(user.getBalance() + amount);
        System.out.println("(after deposit) current balance : " + user);
        TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec
    }

    public void withdraw(User user, double amount) throws InterruptedException {

        user.setBalance(user.getBalance() - amount);
        System.out.println("(after withdraw) current balance : " + user);
        TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec
    }

}
