package Basics.Overwrite_demo1;

// https://www.youtube.com/watch?v=rLMYy4U9SvM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=271

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
}
