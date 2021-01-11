package Basics;

// https://www.youtube.com/watch?v=ADyLvAc6yXc&list=PLmOn9nNkQxJEqCNXBu5ozT_26xwvUbHyE&index=60

public class ConstructorDemo1 {
    public static void main(String [] args){

        // run 1 : use the default constructor
        Monster m1 = new Monster();
        System.out.println(m1.name + " " + m1.salary);

        System.out.println("-----------------------");

        // run 2 : use the constructor with input parameters
        Monster m2 = new Monster("spider man", 999);
        System.out.println(m2.name + " " + m2.salary);
    }
}

class Monster{
    public String name;
    public double salary;

    // make constructor with input parameters
    public Monster(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    // make constructor with NO input parameters (as default one)
    public Monster(){

    }
}
