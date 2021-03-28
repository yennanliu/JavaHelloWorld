package Basics.thisDemo3;

// https://www.youtube.com/watch?v=lc-IoBqYTTs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=235

public class Account {
    // attr
    private int id;
    private double balance;
    private double annualInterestRate;

    // constructor
    public Account(int id, double balance, double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    // getter, setter
    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // method
    public void withDraw(double amount){ // get money
        if (balance < amount){
            System.out.println("WithDraw failed : balance is not enough!");
            return;
        }
        balance -= amount;
        System.out.println("WithDraw OK : get " + amount);
    }

    public void deposit(double amount){ // save money
        if (amount > 0){
            balance += amount;
            System.out.println("Deposit OK : get " + amount);
        }
    }
}
