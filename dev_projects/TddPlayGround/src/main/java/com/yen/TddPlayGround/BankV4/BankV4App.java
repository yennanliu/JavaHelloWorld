package com.yen.TddPlayGround.BankV4;

import com.yen.TddPlayGround.BankV4.bean.User;
import com.yen.TddPlayGround.BankV4.service.BankService;
import com.yen.TddPlayGround.BankV4.service.ThreadDeposit;
import com.yen.TddPlayGround.BankV4.service.ThreadWithdraw;

import java.util.concurrent.TimeUnit;

public class BankV4App {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("BankV4App start ...");

        // init
        BankService bank = new BankService();

        User u1 = new User("mary", 10.0);
        User u2 = new User("kim", 10.0);

        System.out.println(u1);
        System.out.println(u2);

        System.out.println("---- bank op ----");

        ThreadDeposit threadDeposit_1 = new ThreadDeposit(bank, u1, 10.0);
        ThreadDeposit threadDeposit_2 = new ThreadDeposit(bank, u2, 10.0);

        ThreadWithdraw threadWithdraw_1 = new ThreadWithdraw(bank, u1, 30.0);
        ThreadWithdraw threadWithdraw_2 = new ThreadWithdraw(bank, u2, 20.0);

        Thread thread_1 = new Thread(threadDeposit_1);
        Thread thread_2 = new Thread(threadDeposit_2);
        Thread thread_3 = new Thread(threadWithdraw_1);
        Thread thread_4 = new Thread(threadWithdraw_2);

        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();

        System.out.println("BankV4App end ...");
    }

}
