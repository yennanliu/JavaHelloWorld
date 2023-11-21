package com.yen.TddPlayGround.BankV4;

import com.yen.TddPlayGround.BankV4.bean.User;
import com.yen.TddPlayGround.BankV4.service.BankService;
import com.yen.TddPlayGround.BankV4.service.ThreadDeposit;

public class BankV4App {

    public static void main(String[] args) {

        System.out.println("BankV4App start ...");

        // init
        BankService bank = new BankService();

        User u1 = new User("mary", 100.0);
        User u2 = new User("kim", 100.0);

        System.out.println(u1);
        System.out.println(u2);

        System.out.println("---- bank op ----");

        ThreadDeposit threadDeposit_1 = new ThreadDeposit(bank, u1, 30.0);
        ThreadDeposit threadDeposit_2 = new ThreadDeposit(bank, u2, 10.0);

        Thread thread_1 = new Thread(threadDeposit_1);
        Thread thread_2 = new Thread(threadDeposit_2);

        thread_1.start();
        thread_2.start();

        System.out.println(u1);
        System.out.println(u2);

        System.out.println("BankV4App end ...");
    }

}
