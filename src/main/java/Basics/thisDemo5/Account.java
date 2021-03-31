package Basics.thisDemo5;

// https://www.youtube.com/watch?v=xOvPtmKI8_8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=236

public class Account {

    // attr
    private double balance;

    // constructor
    public Account(double init_balance){
        this.balance = init_balance;
    }

    // method
    public double getBalance(){
        return balance;
    }

    public void deposit(double amt){
        if (amt > 0){
            balance += amt;
            System.out.println("deposit OK!");
        } else {
            System.out.println("deposit failed!");
        }
    }

    public void withDraw(double amt){
        if (balance >= amt){
            balance -= amt;
            System.out.println("withDraw OK!");
        } else {
            System.out.println("withDraw failed!");
        }
    }
}
