package com.yen.TddPlayGround.Bank.service.impl;

import com.yen.TddPlayGround.Bank.bean.User;
import com.yen.TddPlayGround.Bank.service.TransferService;

public class TransferServiceImpl implements TransferService {
    @Override
    public Double updateBalance(User user, Double amount) {
        // Implementation of the method
        // Adjust the balance and return the updated balance
        user.setBalance(user.getBalance() + amount);
        return user.getBalance();
    }
}