package com.yen.TddPlayGround.Bank.service;

import com.yen.TddPlayGround.Bank.bean.User;

public interface TransferService {
    Double updateBalance(User user, Double amount);
}