package com.yen.TddPlayGround.BankV4_1.service;

import com.yen.TddPlayGround.BankV4_1.bean.User;

public interface BaseBankService {

    public void deposit(User user, double amount) throws InterruptedException;

    public void withdraw(User user, double amount) throws InterruptedException;

}
