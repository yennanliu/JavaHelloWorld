package Basics.thisDemo3;

// https://www.youtube.com/watch?v=lc-IoBqYTTs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=235

public class Customer {
  // attr
  private String firstName;
  private String lastName;
  private Account account; // from AccountDemo1.java (class type = Account)

  // constructor
  public Customer(String f, String l) {
    this.firstName = f;
    this.lastName = l;
  }

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
