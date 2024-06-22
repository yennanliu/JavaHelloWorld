package Basics.staticDemo6;

// https://www.youtube.com/watch?v=SFLcas0keQ8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=322

public class Account {
  private static double interestRate;
  private static double minBalance = 1.0;
  private static int init = 1001; // for id
  // attr
  private int id;
  private String pwd = "0000"; // init with 0000
  private double balance;

  // constructor
  public Account() {
    id = init++;
  }

  public Account(String pwd, double balance) {
    id = init++;
    this.pwd = pwd;
    this.balance = balance;
  }

  public static double getInterestRate() {
    return interestRate;
  }

  public static void setInterestRate(double interestRate) {
    Account.interestRate = interestRate;
  }

  public static double getMinBalance() {
    return minBalance;
  }

  public static void setMinBalance(double minBalance) {
    Account.minBalance = minBalance;
  }

  public int getId() {
    return id;
  }

  public String getPwd() {
    return pwd;
  }

  // getter, setter
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public double getBalance() {
    return balance;
  }

  // method
  // overwrite toString
  @Override
  public String toString() {
    return "Account [ id = " + id + ", pwd = " + pwd + " balance = " + balance + " ]";
  }
}
