package com.yen.TddPlayGround.BankV2;

// https://www.geeksforgeeks.org/banking-transaction-system-using-java/

import com.yen.TddPlayGround.BankV2.sevice.BankService;
import com.yen.TddPlayGround.BankV2.sevice.ThreadDeposit;
import com.yen.TddPlayGround.BankV2.sevice.ThreadWithdrawal;

public class BankV2App {

    // Main driver method
    public static void main(String[] args)
    {
        // Declaring an object of Bank class and passing the
        // object along with other parameters to the
        // ThreadWithdrawal and ThreadDeposit class. This
        // will be required to call withdrawn and deposit
        // methods from those class

        // Creating an object of class1
        BankService obj = new BankService();

        ThreadWithdrawal t1
                = new ThreadWithdrawal(obj, "Arnab", 20);
        ThreadWithdrawal t2
                = new ThreadWithdrawal(obj, "Monodwip", 40);
        ThreadDeposit t3
                = new ThreadDeposit(obj, "Mukta", 35);
        ThreadWithdrawal t4
                = new ThreadWithdrawal(obj, "Rinkel", 80);
        ThreadWithdrawal t5
                = new ThreadWithdrawal(obj, "Shubham", 40);

        // When a program calls the start() method, a new
        // thread is created and then the run() method is
        // executed.

        // Starting threads created above
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        /**
         *  Execution log :
         *
         *   -> Problem : should NOT have balance < 0
         *   -> reason : thread is NOT safe
         *      (shared data read/write by different thread on the same time)
         *      e.g. : all the threads are updating the same resource at a time.
         *
         * Mukta deposited 35
         * Shubham withdrawn 40
         * 95
         * Arnab withdrawn 20
         * 75
         * Rinkel withdrawn 80
         * -5
         * Monodwip withdrawn 40
         * -45
         * Balance after deposit: 135
         *
         *
         */
    }

}
