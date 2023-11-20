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

        if (amount > sender.getBalance() || sender.getBalance() < 0){
            return "transfer failed, not enough balance";
        }

        //sender.setBalance(sender.getBalance() - amount);
        //receiver.setBalance(receiver.getBalance() + amount);
        //userRepository.save(sender);
        //userRepository.save(receiver);

        this.withdraw(sender, amount);
        this.deposit(receiver, amount);

        return "transfer " + amount + " from " + sender.getId() + " to " + receiver.getId();
    }

    public User getUserById(String id) {

        return userRepository.findById(id).get();
    }

    public User insertUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public Double deposit(User user, double amount){

        Double updatedBalance = user.getBalance() + amount;
        user.setBalance(updatedBalance);
        userRepository.save(user);
        return updatedBalance;
    }

    @Override
    public Double withdraw(User user, double amount) {
        Double updatedBalance = user.getBalance() - amount;
        user.setBalance(updatedBalance);
        userRepository.save(user);
        return updatedBalance;
    }

}