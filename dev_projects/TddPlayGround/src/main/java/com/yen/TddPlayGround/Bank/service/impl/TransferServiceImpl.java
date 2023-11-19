package com.yen.TddPlayGround.Bank.service.impl;

import com.yen.TddPlayGround.Bank.bean.User;
import com.yen.TddPlayGround.Bank.repository.UserRepository;
import com.yen.TddPlayGround.Bank.service.TransferService;

import java.util.Optional;

public class TransferServiceImpl implements TransferService {

    private UserRepository userRepository;

    public TransferServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public Double updateBalance(User user, Double amount) {

        //user.setBalance(user.getBalance() + amount);
        user.setBalance(amount);
        userRepository.save(user);
        return user.getBalance();
    }

    @Override
    public void transfer(User u1, User u2, double amount){

        u1.setBalance(u1.getBalance() - amount);
        u2.setBalance(u2.getBalance() + amount);

        userRepository.save(u1);
        userRepository.save(u2);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

}