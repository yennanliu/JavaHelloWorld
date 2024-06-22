package Basics.Super_3;

// https://www.youtube.com/watch?v=tuysEmwSSQw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=278

public class checkAccountTest {
  public static void main(String[] args) {
    // run
    checkAccount acct1 = new checkAccount(1122, 20000, 0.0321, 5000);

    acct1.withDraw(5000);
    System.out.println("balance = " + acct1.getBalance());
    System.out.println("overdraft = " + acct1.getOverdraft());

    System.out.println("=================");

    acct1.withDraw(18000);
    System.out.println("balance = " + acct1.getBalance());
    System.out.println("overdraft = " + acct1.getOverdraft());

    System.out.println("=================");

    acct1.withDraw(30000);
    System.out.println("balance = " + acct1.getBalance());
    System.out.println("overdraft = " + acct1.getOverdraft());
  }
}
