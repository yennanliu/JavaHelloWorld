package com.yen.TddPlayGround.Bank;

import com.yen.TddPlayGround.Bank.bean.po.User;
import com.yen.TddPlayGround.Bank.repository.UserRepository;
import com.yen.TddPlayGround.Bank.service.TransferService;
import com.yen.TddPlayGround.Bank.service.impl.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

class Bank{

    // attr
    private TransferService transferService;

    // constructor
    public Bank(TransferService transferService){
        this.transferService = transferService;
    }

    public void run(){

        User u1 = new User("id-01", 10.0);
        User u2 = new User("id-02", 30.0);
        System.out.println(u1);
        System.out.println(u2);

        System.out.println("----> bank op");

        this.transferService.transfer(u1, u2, 5.0);
        System.out.println(u1);
        System.out.println(u2);
    }

}

public class BankApp {

    public static void main(String[] args) {

        // integration test
        // TODO : fix below
        TransferService transferService = new TransferServiceImpl();
        Bank bank = new Bank(transferService);
        bank.run();
    }

}
