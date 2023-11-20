package com.yen.TddPlayGround.BankV3.service;

// https://www.geeksforgeeks.org/banking-transaction-system-using-java/

// Class 1
// Helper class
public class BankService {

    // Initial balance $100
    static int total = 100;

    // Money withdrawal method. Withdraw only if total money
    // greater than or equal to the money requested for
    // withdrawal
    static synchronized void withdrawn(String name,
                                       int withdrawal)
    {
        if (total >= withdrawal) {
            System.out.println(name + " withdrawn "
                    + withdrawal);
            total = total - withdrawal;
            System.out.println("Balance after withdrawal: "
                    + total);
			/* Making the thread sleep for 1 second after
				each withdrawal.*/
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // If the money requested for withdrawal is greater
        // than the balance then deny transaction
        else {
            System.out.println(name
                    + " you can not withdraw "
                    + withdrawal);
            System.out.println("your balance is: " + total);

            // Making the thread sleep for 1 second after
            // each transaction failure

            // Try block to check for exceptions
            try {

                // Making thread to sleep for 1 second
                Thread.sleep(1000);
            }

            // Catch bloc kto handle exceptions
            catch (InterruptedException e) {

                // Display the line number where exception
                // occurred
                // Using printStackTrace() method
                e.printStackTrace();
            }
        }
    }

    // Method - Deposit method
    // Accepting money whenever deposited
    static synchronized void deposit(String name,
                                     int deposit)
    {
        System.out.println(name + " deposited " + deposit);
        total = total + deposit;
        System.out.println("Balance after deposit: "
                + total);

        // Making the thread sleep for 1 second
        // after each deposit

        // Try block to check for exceptions
        try {

            // Making thread to sleep for 1 second
            Thread.sleep(1000);
        }

        // Catch block to handle InterruptedException
        // exception
        catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}

