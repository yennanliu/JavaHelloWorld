package com.yen.TddPlayGround.Bank.service.impl;

import com.yen.TddPlayGround.Bank.bean.User;
import com.yen.TddPlayGround.Bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransferServiceImpl implements TransferService {

    private User user;

    public TransferServiceImpl(User user) {

        this.user = user;
    }

    @Override
    public Double updateBalance(Double amount) {
        // Implementation of the method
        // Adjust the balance and return the updated balance
        user.setBalance(user.getBalance() + amount);
        return user.getBalance();
    }
}