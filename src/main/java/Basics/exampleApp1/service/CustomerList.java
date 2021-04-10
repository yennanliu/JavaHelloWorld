package Basics.exampleApp1.service;

// https://www.youtube.com/watch?v=c2d0vVbvoSQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=248
// https://www.youtube.com/watch?v=HyZFx7MeTOs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=251

/*
 *  CustomerList
 *   -> offering op in Customer instance
 *   -> such as go through, edit, delete, adding
 */

import Basics.exampleApp1.bean.Customer;

public class CustomerList {
    // attr
    private Customer[] customers; // the array save customer information
    private int total = 0; // how many customer in the list

    // constructor
    /**
     *  for initializing Customer list
     *  @param totalCustomers, define the max length in Customer list
     */
    public CustomerList(int totalCustomers){
        customers = new Customer[totalCustomers];
    }

    // method
    /**
     * @Description : add customer to list
     * @param  : customer
     * @return : true: adding success, false : adding failed
     */
    public boolean addCustomer(Customer customer){
        if (total >= customers.length){
            System.out.println("addCustomer failed! (total >= customers.length)");
            return false;
        }
        customers[total] = customer;
        total += 1;
        // customers[total++] = customer;  <-- this one is OK as well
        return true;
    }

    /**
     * @Description : modify customer to list
     * @param  : customer
     * @return : true: modify success, false : modify failed
     */
    public boolean replaceCustomer(int index, Customer cust){
        if (index <= 0 || index >= total){
            System.out.println("replaceCustomer failed! (index <= 0 || index >= total)");
            return false;
        }
        customers[index] = cust;
        return true;
    }

    public boolean deleteCustomer(int index){
        if (index < 0 || index >= total){
            System.out.println("deleteCustomer failed! (index <= 0 || index >= total)");
            return false;
        }
        // delete element on the index, and move all right hand side elements to left one by one
        for (int i = index; i < total - 1; i ++){
            customers[i] = customers[i+1];
        }
        // NOTICE : make last index as null
        customers[total - 1] = null;
        // NOTICE : total needs to - 1
        total -= 1;
        return true;
    }

    /**
     * @Description : get all customer from list
     * @param  :
     * @return : customer list
     */
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i ++){
            // NOTE: here we copy address, not the customers[i] instance
            // (custs[i] gets the address that points to the actual customers[i] information)
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * @Description : get customer with index
     * @param  : index
     * @return : customer
     */
    public Customer getCustomer(int index){
        if (index < 0 || index > total){
            System.out.println("getCustomer failed !");
            return null;
        }
        return customers[index];
    }

    /**
     * @Description : get all customer number
     * @param  :
     * @return : customer count
     */
    public int getTotal(){
        return total;
        //return customers.length; <-- this one is wrong
    }
}
