package Basics.Super_3;

// https://www.youtube.com/watch?v=tuysEmwSSQw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=278

public class Account {
    // attr
    private int id;
    private double balance;
    private double annualInterestRate;

    // constructor
    public Account(int id, double balance, double annualInterestRate) {
        super(); // optional (by default there is a super() in 1st line
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    // getter, setter
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    // method
    public double getMonthlyInterest(){
        return this.annualInterestRate / 12;
    }

    public void withDraw (double amount){
        if (balance > amount) {
            balance -= amount;
            System.out.println("withDraw OK");
            return;
        }
        System.out.println("withDraw failed : amount not enough !");

    }

    public void deposit (double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("deposit OK");
        }
    }
}
