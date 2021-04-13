package Basics.exampleApp1.view;

// https://www.youtube.com/watch?v=c2d0vVbvoSQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=248
// https://www.youtube.com/watch?v=KyQNP7_6DUM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=252

/*
 *   CustomerView
 *    -> for user interface, user data for client side...
 */

import Basics.exampleApp1.service.CustomerList;
import Basics.exampleApp1.utils.CMUtility;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    //method
    /***
     *  show customer app interface
     */
    private void enterMainMenu(){

        boolean isFlag = true;
        while (isFlag){
            System.out.println("----------------- Customer Management Program ----------------- ");
            System.out.println("                1 Add new customer");
            System.out.println("                2 Modify customer");
            System.out.println("                3 Delete customer");
            System.out.println("                4 Show all customer");
            System.out.println("                5 Leave \n");
            System.out.println("                1 Please choose (1-5)");

            // get users' choice
            char menu = CMUtility.readMenuSelection();
            switch (menu){
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
                    char isExist =  CMUtility.readConfirmSelection();
                    if (isExist == 'Y'){
                        isFlag = false;
                    }
                    //break;
            }
            //isFlag = false;
        }
    };

    /***
     *  add new customer
     */
    private void addNewCustomer(){
        System.out.println("addNewCustomer");

    };

    /***
     *  modify customer
     */
    private void modifyCustomer(){
        System.out.println("modifyCustomer");

    };

    /***
     *  delete customer
     */
    private void deleteCustomer(){
        System.out.println("deleteCustomer");

    };

    /***
     *  list all customer
     */
    private void listAllCustomer(){
        System.out.println("listAllCustomer");

    };

    public static void main(String[] args){
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }

}
