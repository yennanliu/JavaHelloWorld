package Advances.Reflection;

// https://www.youtube.com/watch?v=x6tmNMxMmZo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=648

public class Person2 extends Creature<String> implements Comparable<String>, MyInterface{

    private String name;
    int age;
    public int id;

    public Person2(){}

    private Person2(String name){
        this.name = name;
    }

    public Person2(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println(">>> I am a person2 ...");
    }

    private void show(String msg){
        System.out.println(">>> person2 show ..." + msg);
    }

    public String display(String input){
        return ">>> person2 input = " + input;
    }

}
