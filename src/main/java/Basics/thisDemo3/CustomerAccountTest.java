package Basics.thisDemo3;

// https://www.youtube.com/watch?v=lc-IoBqYTTs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=235

public class CustomerAccountTest {
    public static void main(String[] args){
        // run
        Customer cust = new Customer("Jack", "Smith");

        Account acct = new Account(1000, 200, 0.01);

        // *** Notice here : put Account instance (acct) into Customer instance (cust)
        cust.setAccount(acct);

        System.out.println(
                "Customer " + cust.getLastName() + cust.getFirstName()
                + " has a account with id " + cust.getAccount().getId()
                + " with balance "  +  cust.getAccount().getBalance()
        );

        System.out.println("==================");

        cust.getAccount().deposit(100);
        System.out.println(acct.getBalance());

        cust.getAccount().withDraw(90);
        System.out.println(acct.getBalance());

        cust.getAccount().withDraw(2000);
        System.out.println(acct.getBalance());
    }
}
