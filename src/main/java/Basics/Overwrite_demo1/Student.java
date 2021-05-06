package Basics.Overwrite_demo1;

// https://www.youtube.com/watch?v=rLMYy4U9SvM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=271

public class Student extends Person{
    // attr
    String major;

    // constructor
    public Student(){

    }

    public Student(String major){
        this.major = major;
    }

    // method
    public void study(){
        System.out.println("hello !!! my major is " + major);
    }

    public void eat(){ // overwrite method from superclass
        System.out.println("**** Student is eating !!!");
    }
}
