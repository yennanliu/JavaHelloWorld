package Advances.Generic;

// https://www.youtube.com/watch?v=cgsQbgB5egA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=566
// https://spring.io/guides/tutorials/rest/
// https://www.youtube.com/watch?v=3VqFJPmA3wg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=348

public class Employee implements Comparable<Employee>{

    //attr
    private String name;
    private int number;
    private MyDate birthday;

    // constructor
    public Employee(String name, int number, MyDate birthday){
        super();
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    // getter, setter
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    // method
    //public abstract double earnings();

    @Override
    public String toString() {
        // need to call birthday.toDateString() for getting its content
        return "name='" + name + '\'' + ", number=" + number + ", birthday : " + birthday.toDateString();
    }

    // compareTo with generic type -> NO NEED to care about class type
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
        }

        // compareTo without generic type -> need to care about class type
        //    @Override
        //    public int compareTo(Object o) {
        //        if (o instanceof Employee){
        //            Employee e = (Employee) o;
        //            return this.name.compareTo(e.name);
        //        }
        //        throw new RuntimeException("input type invalid !");
        //    }

}
