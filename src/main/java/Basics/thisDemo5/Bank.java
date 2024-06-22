package Basics.thisDemo5;

// https://www.youtube.com/watch?v=xOvPtmKI8_8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=236

public class Bank {

  // attr
  private Customer[] customers; // an array can save multiple customers inside
  private int numberOfCustomers; // record customer count

  // constructor
  public Bank() {
    // init value
    customers = new Customer[10]; // set default Customer init length = 10
  }

  // method
  // add new customer
  public void addCustomer(String f, String l) {
    Customer cust = new Customer(f, l);
    customers[numberOfCustomers] = cust;
    this.numberOfCustomers += 1;
    // or, can write as below
    // customers[numberOfCustomers++] = cust;
    System.out.println("Add new customer OK!");
  }

  // get count of customer
  public int getNumberOfCustomers() {
    return numberOfCustomers;
  }

  // get customer with index
  public Customer getCustomer(int index) {
    if (index >= 0 && index < numberOfCustomers) {
      return customers[index];
    }
    return null;
  }
}
