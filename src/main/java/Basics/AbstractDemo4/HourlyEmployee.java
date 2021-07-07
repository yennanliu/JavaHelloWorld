package Basics.AbstractDemo4;

// https://www.youtube.com/watch?v=3VqFJPmA3wg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=348

public class HourlyEmployee extends Employee {

    // attr
    private int wage; // hourly salary
    private int hour;

    // constructor
    public HourlyEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }

    public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    // getter, setter
    public int getWage() {
        return wage;
    }

    public int getHour() {
        return hour;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    // method
    @Override
    public double earnings() {
        return wage * hour;
    }

    public String toString(){
        // NOTE : call super class' toString method via :  super.toString()
        return "HourlyEmployee : " + super.toString();
    }
}
