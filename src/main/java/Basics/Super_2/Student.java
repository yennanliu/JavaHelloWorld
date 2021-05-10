package Basics.Super_2;

// https://www.youtube.com/watch?v=lAuVKrKOxmw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=276

public class Student extends Person {
    // attr
    String major;
    int id = 777; // school id

    // constructor
    public Student(){
        // by default, superclass' constructor is called in subclass' constructor (super(), no argument)
        //  -> by default, this command is not shown (but it existed!)
        //super();
    }

    public Student(String major){
        // by default, superclass' constructor is called in subclass' constructor (super(), no argument)
        //  -> by default, this command is not shown (but it existed!)
        //super();
    }

    public Student(String name, int age, String major){
        // V1 : via this
        //        this.major = major;
        //        this.age = age;
        //        this.name = name;

        // V2 : via super calling constructor in superclass
        super(name, age);  // same as calling "Person(String name, int age)" constructor in Person class
        this.name = name;

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
