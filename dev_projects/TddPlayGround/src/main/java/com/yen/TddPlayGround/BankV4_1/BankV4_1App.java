package com.yen.TddPlayGround.BankV4_1;

import com.yen.TddPlayGround.BankV4.Tread.ThreadDeposit;
import com.yen.TddPlayGround.BankV4.Tread.ThreadWithdraw;
import com.yen.TddPlayGround.BankV4.bean.User;
import com.yen.TddPlayGround.BankV4.service.BankServiceWithLock;

public class BankV4_1App {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("BankV4_1App start ...");

        // init
        //BankService bank = new BankService();
        BankServiceWithLock bank = new BankServiceWithLock();

        User u1 = new User("Mary", 1);
        //User u2 = new User("Kim", 10.0);

        System.out.println(u1);
        //System.out.println(u2);

        System.out.println("---- bank op ----");

        /** Run single */

        /** Run multiple */
        // V2
        for (int i = 0; i < 3; i++) {
            // deposit
            ThreadDeposit threadDeposit = new ThreadDeposit(bank, u1, 1.0);
            Thread thread_d = new Thread(threadDeposit);
            thread_d.start();
            // withdraw
            ThreadWithdraw threadWithdraw = new ThreadWithdraw(bank, u1, 2.0);
            Thread thread_w = new Thread(threadWithdraw);
            thread_w.start();
        }

        System.out.println("BankV4_1App end ...");
    }

}
