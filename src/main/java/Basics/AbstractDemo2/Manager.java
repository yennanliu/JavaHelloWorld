package Basics.AbstractDemo2;

// https://www.youtube.com/watch?v=Cwv1ssWVB6Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=345

public class Manager extends Employee {
    // attr
    private double bonus;

    // constructor
    public Manager(){
        super();
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    // method
    @Override
    public void work() {
        System.out.println("Manager does management");
    }
}
