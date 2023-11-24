package com.yen.TddPlayGround.BankV4;

import com.yen.TddPlayGround.BankV4.Tread.ThreadGetBalance;
import com.yen.TddPlayGround.BankV4.bean.User;
import com.yen.TddPlayGround.BankV4.service.BankServiceWithLock;
import com.yen.TddPlayGround.BankV4.Tread.ThreadDeposit;
import com.yen.TddPlayGround.BankV4.Tread.ThreadWithdraw;
import com.yen.TddPlayGround.BankV4.service.BankServiceWithReadWriteLock;

public class BankV4App {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("BankV4App start ...");

        // init
        //BankService bank = new BankService();
        //BankServiceWithLock bank = new BankServiceWithLock();
        BankServiceWithReadWriteLock bank = new BankServiceWithReadWriteLock();

        User u1 = new User("Mary", 1);
        //User u2 = new User("Kim", 10.0);

        System.out.println(u1);
        //System.out.println(u2);

        System.out.println("---- bank op ----");

        /** Run single */
//        ThreadDeposit threadDeposit_1 = new ThreadDeposit(bank, u1, 1.0);
//        //ThreadDeposit threadDeposit_2 = new ThreadDeposit(bank, u2, 10.0);
//
//        TimeUnit.MILLISECONDS.sleep(300); // sleep 3 sec
//
//        ThreadWithdraw threadWithdraw_1 = new ThreadWithdraw(bank, u1, 1.0);
//        //ThreadWithdraw threadWithdraw_2 = new ThreadWithdraw(bank, u2, 20.0);
//
//        Thread thread_1 = new Thread(threadDeposit_1);
//        //Thread thread_2 = new Thread(threadDeposit_2);
//        Thread thread_3 = new Thread(threadWithdraw_1);
//        //Thread thread_4 = new Thread(threadWithdraw_2);

//        thread_1.start();
//        //thread_2.start();
//        thread_3.start();
//        //thread_4.start();

        /** Run multiple times  */
        //simulate multi times op

        // V1
        // below is WRONG, thread CAN'T be activated again once finished
        // -> will cause IllegalThreadStateException exception
//        for(int i = 0; i < 10; i++){
//            thread_1.start();
//            thread_3.start();
//        }

        // V2
        for (int i = 0; i < 5; i++) {

            // get current balance
            ThreadGetBalance threadGetBalance = new ThreadGetBalance(bank, u1);
            Thread thread_g = new Thread(threadGetBalance);
            thread_g.start();

            // deposit
            ThreadDeposit threadDeposit = new ThreadDeposit(bank, u1, 1.0);
            Thread thread_d = new Thread(threadDeposit);
            thread_d.start();

            //thread_g.start();

            // withdraw
            ThreadWithdraw threadWithdraw = new ThreadWithdraw(bank, u1, 2.0);
            Thread thread_w = new Thread(threadWithdraw);
            thread_w.start();
        }

        System.out.println("BankV4App end ...");
    }

}
