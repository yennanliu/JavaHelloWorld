package Basics.CustomerCRM.view;

// https://www.youtube.com/watch?v=c2d0vVbvoSQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=248
// https://www.youtube.com/watch?v=KyQNP7_6DUM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=252
// https://www.youtube.com/watch?v=wWzlY8i8klE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=254
// https://www.youtube.com/watch?v=7BPztY4LTD0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=255
// https://www.youtube.com/watch?v=tyHqaFFLxEY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=256
// https://www.youtube.com/watch?v=zD8ezdN_KZw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=257

/*
 *   CustomerView
 *    -> for user interface, user data for client side...
 */

import Basics.CustomerCRM.bean.Customer;
import Basics.CustomerCRM.service.CustomerList;
import Basics.CustomerCRM.utils.CMUtility;

public class CustomerView {
  private CustomerList customerList = new CustomerList(10);

  // constructor

  // init with some default customers here for testing
  public CustomerView() {
    Customer customer1 = new Customer("king", 'g', 19, "0987654321", "king@fb.com");
    Customer customer2 = new Customer("blue.mary", 'g', 31, "09877721", "blue.mary@fb.com");

    customerList.addCustomer(customer1);
    customerList.addCustomer(customer2);
  }

  // method

  /** entry point */
  public static void main(String[] args) {
    CustomerView customerView = new CustomerView();
    customerView.enterMainMenu();
  }
  ;

  /***
   *  show customer app interface
   */
  private void enterMainMenu() {

    boolean isFlag = true;
    while (isFlag) {
      System.out.println("----------------- Customer Management Program ----------------- ");
      System.out.println("                1 Add new customer");
      System.out.println("                2 Modify customer");
      System.out.println("                3 Delete customer");
      System.out.println("                4 Show all customer");
      System.out.println("                5 Leave \n");
      System.out.println("                1 Please choose (1-5)");

      // get users' choice
      char menu = CMUtility.readMenuSelection();
      switch (menu) {
        case '1':
          addNewCustomer();
          break;
        case '2':
          modifyCustomer();
          break;
        case '3':
          deleteCustomer();
          break;
        case '4':
          listAllCustomer();
          break;
        case '5':
          System.out.println("leave !");

          System.out.println("Confirm if leave ?");
          char isExist = CMUtility.readConfirmSelection();
          if (isExist == 'Y') {
            isFlag = false;
          }
          // break;
      }
      // isFlag = false;
    }
  }
  ;

  /***
   *  add new customer
   */
  private void addNewCustomer() {
    // System.out.println("addNewCustomer");
    System.out.println("--------------------- Add New Customer --------------------- \n");

    System.out.println("name, ");
    String name = CMUtility.readString(10); // max name length = 10

    System.out.println("gender, ");
    char gender = CMUtility.readChar(); // gender is char tyep

    System.out.println("age, ");
    Integer age = CMUtility.readInt();

    System.out.println("phone, ");
    String phone = CMUtility.readString(10);

    System.out.println("email, ");
    String email = CMUtility.readString(10);

    // init a Customer class instance
    Customer customer = new Customer(name, gender, age, phone, email);

    // save above records into a CustomerList
    boolean isSuccess = customerList.addCustomer(customer);
    if (isSuccess) {
      System.out.println("add new customer OK !");
      System.out.println("--------------------- Add New Customer End --------------------- \n");
    } else {
      System.out.println("add new customer failed !");
    }
  }
  ;

  /***
   *  modify customer
   */
  private void modifyCustomer() {
    // System.out.println("modifyCustomer");
    System.out.println("--------------------- Modify Customer  --------------------- \n");
    // here we declare Customer first, because we want to modify the Customer information outside
    // the for loop
    Customer cust;
    // here we declare number first, because we want to use number outside the for loop
    int number;
    // infinite loop
    for (; ; ) {
      System.out.println("Please input customer id you want to modify (-1 exit)");
      number = CMUtility.readInt();
      if (number == -1) {
        return;
      }

      cust = customerList.getCustomer(number - 1);
      if (cust == null) {
        System.out.println("can't find customer !");
      } else {
        // if customer found, end the loop
        break;
      }
    }
    // let's modify the customer here
    System.out.println("Customer name(" + cust.getName() + "):");
    String name =
        CMUtility.readString(
            10,
            cust
                .getName()); // if user don't input new name, but just press enter -> use the
                             // original customer name by default

    System.out.println("Customer gender(" + cust.getGender() + "):");
    char gender = CMUtility.readChar(cust.getGender());

    System.out.println("Customer age(" + cust.getAge() + "):");
    Integer age = CMUtility.readInt(cust.getAge());

    System.out.println("Customer phone(" + cust.getPhone() + "):");
    String phone = CMUtility.readString(13, cust.getPhone());

    System.out.println("Customer email(" + cust.getEmail() + "):");
    String email = CMUtility.readString(30, cust.getEmail());

    Customer newCust = new Customer(name, gender, age, phone, email);

    boolean isReplaced = customerList.replaceCustomer(number - 1, newCust);
    if (isReplaced) {
      System.out.println("--------------------- Modify Customer OK ! --------------------- \n");
    } else {
      System.out.println("--------------------- Modify Customer Failed ! --------------------- \n");
    }
  }
  ;

  /***
   *  delete customer
   */
  private void deleteCustomer() {
    // System.out.println("deleteCustomer");
    System.out.println("--------------------- Delete Customer --------------------- \n");

    int number;
    // infinite loop
    for (; ; ) {
      System.out.println("Please input customer id you want to delete (-1 exit)");
      number = CMUtility.readInt();

      if (number == -1) {
        return;
      }

      Customer customer = customerList.getCustomer(number - 1);
      if (customer == null) {
        System.out.println("customer not found !");
      } else {
        break;
      }
    }
    // let's delete the customer here
    System.out.println("Make sure if delete (Y/N), ");
    char isDelete = CMUtility.readConfirmSelection();
    if (isDelete == 'Y') {
      // actual delete op
      boolean deleteSuccess = customerList.deleteCustomer(number - 1);
      if (deleteSuccess) {
        System.out.println("--------------------- Delete Customer OK ! --------------------- \n");
      } else {
        System.out.println(
            "--------------------- Delete Customer Failed ! --------------------- \n");
      }

    } else {
      // but this return is not necessary, since the program will back to the main menu if isDelete
      // != 'Y' anyway
      return;
    }
  }
  ;

  /***
   *  list all customer
   */
  private void listAllCustomer() {
    // System.out.println("listAllCustomer");
    System.out.println("--------------------- Customer List --------------------- \n");
    int total = customerList.getTotal();

    if (total == 0) {
      System.out.println("no any customer !");
    } else {
      System.out.println("id\tname\tsex\tage\tgender\tphone\t\temail");
      Customer[] custs = customerList.getAllCustomers();
      for (int i = 0; i < custs.length; i++) {
        Customer cust = custs[i];
        System.out.println(
            (i + 1)
                + "\t"
                + cust.getName()
                + "\t"
                + cust.getGender()
                + "\t"
                + cust.getAge()
                + "\t"
                + cust.getPhone()
                + "\t"
                + cust.getEmail());
      }
    }

    System.out.println("--------------------- Customer List End --------------------- \n");
  }
}
