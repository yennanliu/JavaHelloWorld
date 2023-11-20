package com.yen.TddPlayGround.Bank.service;

import com.yen.TddPlayGround.Bank.bean.po.User;

public interface TransferService {
    public Double updateBalance(User user, Double amount);

    public String transfer(User sender, User receiver, double amount);

    public User getUserById(String id);

    public User insertUser(User user);

    public Double deposit(User user, double amount);

    public Double withdraw(User user, double amount);
}