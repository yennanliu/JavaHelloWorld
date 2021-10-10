package Advances.ThreadSafety3;

// https://www.youtube.com/watch?v=rAZjbjjcjUA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=439

/**
 *  There are 2 accounts, each of them deposits 1000 dollar to one account each time,
 *  repeating 3 times, print account status every time
 *
 *  1) checks : if a multi-thread ? -> yes (2 accounts)
 *  2) thread safety ? -> yes (if shared values)
 *  3) how to solve it ? -> 3 ways
 *      - 3-1) Synchronized code block
 *      - 3-2) Synchronized method
 *      - 3-3) lock
 */

// entry point
public class AccountDemo1{
    public static void main(String[] args) {

        // run
        Account acct = new Account(0);
        // 2 threads (Customer) share one value (account)
        Customer c1 =  new Customer(acct);
        Customer c2 =  new Customer(acct);

        c1.setName("thread_c1");
        c2.setName("thread_c2");

        c1.start();
        c2.start();
    }
}

class Account{

    // attr
    private double balance;

    // constructor
    public Account(double balance){
        this.balance = balance;
    }

    // method
    public void deposit(double amt){
        if (amt >= 0){

            this.balance += amt;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()
                    + " deposit OK!, balance = " + this.balance);
        }
    }
}

class Customer extends Thread{

    // attr
    private Account acct;

    // constructor
    public Customer(Account acct){
        this.acct = acct;
    }

    // method
    @Override
    public void run() {
        super.run();
        for (int i=0; i<3; i++){
            // deposit money into account
            acct.deposit(1000);
        }
    }
}
