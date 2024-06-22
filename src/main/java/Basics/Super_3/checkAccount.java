package Basics.Super_3;

// https://www.youtube.com/watch?v=tuysEmwSSQw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=278

public class checkAccount extends Account {

  private double overdraft; // the value account can use over current balance

  // constructor
  public checkAccount(int id, double balance, double annualInterestRate, double overdraft) {
    // use id, balance, annualInterestRate from account
    super(id, balance, annualInterestRate);
    // for the attr overdraft that only exists in checkAccount
    this.overdraft = overdraft;
  }

  // getter, setter
  public double getOverdraft() {
    return overdraft;
  }

  public void setOverdraft(double overdraft) {
    this.overdraft = overdraft;
  }

  // method
  @Override
  public void withDraw(double amount) {
    if (this.getBalance() >= amount) { // if balance enough
      // method 1
      this.setBalance(this.getBalance() - amount);
      System.out.println("withDraw OK");

      // method 2
      // super.withDraw(amount);
    } else if (overdraft >= amount - getBalance()) { // overdraft + balance is enough
      this.setBalance(0);
      overdraft -= (amount - this.getBalance());
      System.out.println("withDraw OK");
    } else {
      System.out.println("withDraw failed, exceed balance + overdraft");
    }
  }
}
