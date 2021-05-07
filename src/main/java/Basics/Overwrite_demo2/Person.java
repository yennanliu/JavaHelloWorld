package Basics.Overwrite_demo2;

// https://www.youtube.com/watch?v=z4jVMvyf1D8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=272

public class Person {
    // attr
    String name;
    int age;

    // constructor
    public Person(){
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    // method
    public void eat(){
        System.out.println("i am eating !!!");
    }

    public void walk(int distance){
        System.out.println("i am walking ~~~~"  + "distance = " + distance);
    }

    public Object info(){
        return null;
    }

    public Double info_1(){
        return 3.14;
    }

    // static method CAN NOT be overwritten
    public static void eat_static(){
        System.out.println("this is eat_static !");
    }

}
