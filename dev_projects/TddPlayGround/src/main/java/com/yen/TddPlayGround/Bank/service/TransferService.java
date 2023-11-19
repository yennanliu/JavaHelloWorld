package com.yen.TddPlayGround.Bank.service;

import com.yen.TddPlayGround.Bank.bean.User;

import java.util.Optional;

public interface TransferService {
    public Double updateBalance(User user, Double amount);

    public String transfer(User u1, User u2, double amount);

    public User getUserById(String id);

    public User insertUser(User user);
}