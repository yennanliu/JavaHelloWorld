package com.yen.TddPlayGround.BankV4.Tread;

import com.yen.TddPlayGround.BankV4.bean.User;
import com.yen.TddPlayGround.BankV4.service.BankService;
import com.yen.TddPlayGround.BankV4.service.BaseBankService;

public class ThreadGetBalance implements Runnable{

    // attr
    private BaseBankService bankService;
    private User user;

    // constructor
    public ThreadGetBalance(){

    }

    public ThreadGetBalance(BaseBankService bankService, User user){
        this.bankService = bankService;
        this.user = user;
    }

    @Override
    public void run() {
        try{
            bankService.getBalance(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
