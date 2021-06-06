package Basics.EqualsDemo1;

// https://www.youtube.com/watch?v=l6YQByB9Bks&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=294

public class Customer {
    // attr
    private String name;
    private int age;

    // constructor
    public Customer() {

    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter, setter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // method
    // OVERWRITE the equals method -> compare if "content" are the same
    @Override
    public boolean equals(Object obj) {
        // check if in same address -> if same address, the objects must are the SAME instance
        System.out.println("Customer's equals ...");
        if (this == obj){
            return  true;
        }

        // check if objects are belong to the same class (Customer)
        if (obj instanceof Customer){
            Customer cust = (Customer) obj; // downcasting
            // compare every attr
//            if (this.age == cust.age && this.name.equals(cust.name)){ // NOTE : we need equals compare name attr here ( name is reference type)
//                return true;
//            } else {
//                return false;
//            }
            return (this.age == cust.age && this.name.equals(cust.name)); // same as above logic
        }
        return false;
    }
}
