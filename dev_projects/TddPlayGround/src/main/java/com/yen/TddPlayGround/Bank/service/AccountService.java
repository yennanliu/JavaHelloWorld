package com.yen.TddPlayGround.Bank.service;

import com.yen.TddPlayGround.Bank.bean.po.User;

import java.util.List;

public interface AccountService {

    public Double getBalance(String id);

    public List<User> getAllUsers();
}
