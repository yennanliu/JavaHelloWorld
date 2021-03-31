package Basics.thisDemo5;

// https://www.youtube.com/watch?v=xOvPtmKI8_8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=236

public class TestBankAccountCustomer {
    public static void main(String[] args){

        // run
        Bank bank = new Bank();

        // create customer
        bank.addCustomer("Amy", "Watson");

        // get customer with init its account with balance=1000
        bank.getCustomer(0).setAccount(new Account(1000));

        // withdraw 500
        bank.getCustomer(0).getAccount().withDraw(500);

        // get balance
        double balance_1 = bank.getCustomer(0).getAccount().getBalance();

        // print result
        System.out.println("Customer " + bank.getCustomer(0).getFirstName() + " " + bank.getCustomer(0).getLastName() +
                " has balance = " + balance_1);

        System.out.println("=================");

        bank.addCustomer("Jack", "West");
        System.out.println("Bank has " + bank.getNumberOfCustomers() + " customers");
    }

}
