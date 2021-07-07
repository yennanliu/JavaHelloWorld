package Basics.AbstractDemo4;

// https://www.youtube.com/watch?v=3VqFJPmA3wg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=348

public class SalaryEmployee extends Employee {

    // attr
    private double monthlySalary;

    // constructor
    public SalaryEmployee(String name, int number, MyDate birthday){
        super(name, number, birthday);
    }

    public SalaryEmployee(String name, int number, MyDate birthday, double monthlySalary){
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    // getter, setter
    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    // method
    @Override
    public double earnings() {
        return monthlySalary;
    }

    public String toString(){
        // NOTE : call super class' toString method via :  super.toString()
        return "SalaryEmployee : " + super.toString();
    }
}
