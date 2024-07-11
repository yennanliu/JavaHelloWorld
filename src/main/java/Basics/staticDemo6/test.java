package Basics.staticDemo6;

// https://www.youtube.com/watch?v=SFLcas0keQ8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=322

public class test {
  public static void main(String[] args) {

    // run
    Account a1 = new Account();

    Account a2 = new Account("123", 100);

    System.out.println(a1);
    System.out.println(a2);

    Account.setInterestRate(0.38);

    Account a3 = new Account();
    System.out.println(Account.getInterestRate());
    System.out.println(a3);
  }
}
