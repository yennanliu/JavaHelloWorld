package com.yen.TddPlayGround.Bank.service.impl;

import com.yen.TddPlayGround.Bank.bean.po.User;
import com.yen.TddPlayGround.Bank.repository.UserRepository;
import com.yen.TddPlayGround.Bank.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private UserRepository userRepository;

    public AccountServiceImpl(UserRepository userRepository){

        this.userRepository = userRepository;
    }


    @Override
    public Double getBalance(String id) {

        User u = userRepository.findById(id).get();
        return userRepository.findById(id).get().getBalance();
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

}
