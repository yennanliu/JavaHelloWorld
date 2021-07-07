package Basics.TemplateDemo3;

// https://www.youtube.com/watch?v=3VqFJPmA3wg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=348

public abstract class Employee {

    //attr
    private String name;
    private int number;
    private MyDate birthday;

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
    public abstract void earnings();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday +
                '}';
    }
}
