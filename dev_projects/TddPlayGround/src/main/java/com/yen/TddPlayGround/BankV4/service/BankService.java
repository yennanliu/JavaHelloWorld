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

    public synchronized void deposit(User user, double amount) throws InterruptedException {

        double curBalance = user.getBalance();
        user.setBalance(curBalance + amount);
        System.out.println("(after deposit) current balance : " + user);
        //TimeUnit.MILLISECONDS.sleep(100); // sleep 1 sec
    }

    public synchronized void withdraw(User user, double amount) throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec

        double curBalance = user.getBalance();
        if (curBalance >= amount){
            user.setBalance(user.getBalance() - amount);
            System.out.println("(after withdraw) current balance : " + user);
            TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec
        }else{
            System.out.println("Not enough balance, sleep 3 sec ..." + user + " amount = " + amount);
            TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec
        }
    }

}
