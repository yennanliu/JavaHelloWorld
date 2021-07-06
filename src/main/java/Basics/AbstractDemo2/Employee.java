package Basics.AbstractDemo2;

// https://www.youtube.com/watch?v=Cwv1ssWVB6Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=345

public abstract class Employee {
    // attr
    private String name;
    private int id;
    private double salary;

    // constructor
    public Employee(){
       super();
    }

    public Employee(String name, int id, double salary){
        super();
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // method
    public abstract void work();
}
