package Basics;

// https://www.youtube.com/watch?v=5_Ltjn8gObw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=180

public class ClassDemo1 {
    public static void main(String [] args){
        // run
        // init the class
        Person p1 = new Person();

        // set up attribution
        p1.name = "tom";
        p1.isMale = true;
        System.out.println(p1.name);
        System.out.println(p1.isMale);
        p1.eat();

        System.out.println("===============");

        // if we create the other object of the same class (e.g. p2)
        // the p1's and value and p2's value will still not affect each other
        Person p2 = new Person();
        System.out.println(p2.name);
        System.out.println(p2.isMale);
        p2.eat();

        // since p3, and p1 point to the same object in Heap space,
        // p3 and p1 are using the same attribution
        // e.g. p1.name equals p3.name,
        // e.g. p1.isMale equals p3.isMale,
        System.out.println("===============");
        Person p3 = p1;
        System.out.println(p3.name);
        System.out.println(p3.isMale);
        p3.eat();
    }
}

// define a class
class Person{
    // attribution
    String name;
    int age = 1;
    boolean isMale;

    // method
    public void eat(){
        System.out.println(this.name + " is eating  !");
    }

    public void sleep(){
        System.out.println(this.name + "is sleeping  !");
    }
}