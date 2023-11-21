package com.yen.TddPlayGround.BankV4.service;

import com.yen.TddPlayGround.BankV4.bean.User;

import java.util.concurrent.TimeUnit;

public class BankService implements BaseBankService{

    public BankService(){

    }

    public synchronized void deposit(User user, double amount) throws InterruptedException {

        double curBalance = user.getBalance();
        user.setBalance(curBalance + amount);
        System.out.println("(after deposit) current balance : " + user);
        //TimeUnit.MILLISECONDS.sleep(100); // sleep 1 sec
    }

    public synchronized void withdraw(User user, double amount) throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec

        double curBalance = user.getBalance();
        // TODO : check "虛假喚醒" (should use "while" instead of "if)
        while (curBalance >= amount){
            curBalance -= amount; // NOTE !! we update curBalance, so can reflect to while logic above (used by synchronized)
            user.setBalance(curBalance);
            System.out.println("(after withdraw) current balance : " + user);
            TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec
        }
//        else{
//            System.out.println("Not enough balance, sleep 3 sec ..." + user + " amount = " + amount);
//            TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec
//        }
        System.out.println("Not enough balance, sleep 3 sec ..." + user + " amount = " + amount);
        TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec
    }

}
