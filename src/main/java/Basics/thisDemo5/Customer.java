package Basics.thisDemo5;

// https://www.youtube.com/watch?v=xOvPtmKI8_8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=236

public class Customer {

  // attr
  private final String firstName;
  private final String lastName;
  private Account account;

  // constructor
  public Customer(String f, String l) {
    this.firstName = f;
    this.lastName = l;
  }

  // method
  // getter, setter
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
}
