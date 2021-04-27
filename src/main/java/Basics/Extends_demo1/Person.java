package Basics.Extends_demo1;

// https://www.youtube.com/watch?v=ArTiU9HR5Kw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=259

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
        System.out.println("eat @@@@");
    }

    public void sleep(){
        System.out.println("sleep !!!!!");
    }
}
