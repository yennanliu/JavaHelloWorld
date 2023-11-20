package com.yen.TddPlayGround.BankV2.bean.service.impl;

/** Implement service with Concurrent */

import com.yen.TddPlayGround.Bank.bean.po.User;
import com.yen.TddPlayGround.BankV2.bean.service.BaseTransferService;

// https://www.geeksforgeeks.org/banking-transaction-system-using-java/


public class HSBCTransferService extends Thread implements BaseTransferService {

    @Override
    public Double updateBalance(User user, Double amount) {
        return null;
    }

    @Override
    public String transfer(User sender, User receiver, double amount) {
        return null;
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User insertUser(User user) {
        return null;
    }

    @Override
    public Double deposit(User user, double amount) {
        return null;
    }

    @Override
    public Double withdraw(User user, double amount) {
        return null;
    }

}
