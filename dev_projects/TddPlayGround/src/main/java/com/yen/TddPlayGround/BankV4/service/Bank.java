package com.yen.TddPlayGround.BankV4.service;

import com.yen.TddPlayGround.BankV4.bean.User;

public class Bank {

    private User user;

    public Bank(){

    }

    public Bank(User user){
        this.user = user;
    }

    public void deposit(double amount){

        this.user.setBalance(this.user.getBalance() + amount);
    }

    public void withdraw(double amount){

        this.user.setBalance(this.user.getBalance() - amount);
    }

}
