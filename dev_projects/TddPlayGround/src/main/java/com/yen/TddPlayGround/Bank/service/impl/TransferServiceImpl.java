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

    // TODO : verify what to return
    @Override
    public String transfer(User sender, User receiver, double amount){

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        userRepository.save(sender);
        userRepository.save(receiver);

        return "transfer " + amount + " from " + sender.getId() + " to " + receiver.getId();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

}