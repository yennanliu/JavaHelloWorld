package com.yen.TddPlayGround.Bank.service.impl;

import com.yen.TddPlayGround.Bank.bean.User;
import com.yen.TddPlayGround.Bank.service.TransferService;

public class TransferServiceImpl implements TransferService {

    @Override
    public Double updateBalance(User user, double value) {

        Double updatedBalance = user.getBalance() + value;
        System.out.println("updateBalance = " + updatedBalance);
        user.setBalance(updatedBalance);
        //return user.updateBalance(updatedBalance);
        return updatedBalance;
    }



}
