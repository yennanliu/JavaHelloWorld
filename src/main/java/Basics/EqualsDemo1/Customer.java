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
}
