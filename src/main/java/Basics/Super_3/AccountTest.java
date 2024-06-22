package Basics.Super_3;

// https://www.youtube.com/watch?v=tuysEmwSSQw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=278

public class AccountTest {
  public static void main(String[] args) {
    // run
    Account acct1 = new Account(1122, 20000, 0.031);
    acct1.withDraw(30000);
    System.out.println("balance = " + acct1.getBalance());
    acct1.withDraw(2500);
    acct1.deposit(3000);
    System.out.println("balance = " + acct1.getBalance());
    System.out.println("AnnualInterestRate = " + acct1.getAnnualInterestRate());
  }
}
