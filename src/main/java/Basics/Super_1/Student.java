package Basics.Super_1;

// https://www.youtube.com/watch?v=ieTLbX0nExI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=275

public class Student extends Person {
    // attr
    String major;
    int id = 777; // school id

    // constructor
    public Student(){

    }

    public Student(String major){

    }

    // method
    @Override
    public void eat() {
        System.out.println("Student is eating !!!");
    }

    public void super_eat(){
        super.eat();
    }

    @Override
    public void walk() {
        System.out.println("Student is walking !!!");
    }

    public void study(){
        System.out.println("Student is studying !!!");
    }

    public void show(){
        // this.name can be name, this.age can be age
        System.out.println("Student's name = " + this.name + " age = " + this.age);
        System.out.println("personal id " + super.id + " student id + " + this.id);
    }
}
