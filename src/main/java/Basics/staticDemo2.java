package Basics;

// https://www.geeksforgeeks.org/static-methods-vs-instance-methods-java/

public class staticDemo2 {

    public static void main(String [] args){

        // run 1
        System.out.println("staticDemo2");
        // no need to "new myClass"
        myClass.sayHI();

        System.out.println("=======================");

        // run 2
        System.out.println("Geek.geekName =  " + Geek.geekName);
        // no need to "new Geek"
        // Geek.name is static value, so it's unique in the heap space
        // e.g. every update (against the value) will reflect to each call
        Geek.geek("xxxx");
        System.out.println("Geek.geekName =  " + Geek.geekName);
    }
}

class myClass{
    Integer myValue;
    public static void sayHI() {
        System.out.println("this is myClass's say HI !");
    }
}

class Geek {

    public static String geekName = "";

    public static void geek(String name)
    {
        geekName = name;
    }
}


