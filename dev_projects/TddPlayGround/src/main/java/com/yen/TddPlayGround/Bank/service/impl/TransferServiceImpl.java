package com.yen.TddPlayGround.Bank.service.impl;

import com.yen.TddPlayGround.Bank.bean.po.User;
import com.yen.TddPlayGround.Bank.repository.UserRepository;
import com.yen.TddPlayGround.Bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    //@Autowired
    private UserRepository userRepository;

    // constructor
    //@Autowired // TODO : double check if @Autowired is necessary ?
    public TransferServiceImpl(){

        this.userRepository = userRepository;
    }

    public TransferServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    @Override
    public Double updateBalance(User user, Double amount) {

        //user.setBalance(user.getBalance() + amount);
        user.setBalance(amount);
        this.userRepository.save(user);
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

        return this.userRepository.findById(id).get();
    }

    public User insertUser(User user) {

        return this.userRepository.save(user);
    }

    @Override
    public Double deposit(User user, double amount){

        Double updatedBalance = user.getBalance() + amount;
        user.setBalance(updatedBalance);
        this.userRepository.save(user);
        return updatedBalance;
    }

    @Override
    public Double withdraw(User user, double amount) {

        Double updatedBalance = user.getBalance() - amount;
        user.setBalance(updatedBalance);
        this.userRepository.save(user);
        return updatedBalance;
    }

}