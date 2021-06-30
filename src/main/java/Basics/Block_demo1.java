package Basics;

// https://www.youtube.com/watch?v=SbqIcM4VjIA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=330

/**
 *   CODE BLOCK DEMO 1
 *
 *
 *   0. pattern :  { // code block code here }
 *   1. purpose : for class, object initializing
 *   2. if there is decorator, CAN ONLY USE static
 *   3. static code block VS non-static code block
 *
 *   4. static code block
 *      - can have output inside
 *      - *** Executed when class is loaded (since it's static)
 *      - will only run ONCE
 *
 *   5. non-static code block
 *      - can have output inside
 *      - *** Executed when class is instantiated
 *      - can be run MULTIPLE TIMES ( when class is instantiated)
 *      - *** can init class attr when instantiate the class
 *
 *
 *   6. extra : when can we update attr value (in class)
 *      6-1. default init
 *      6-2. explicitly declare
 *      6-3. init in constryctor
 *      6-4. when there is instance, via "class.attr" or "class.method"
 *      6-5. init in code block (non-static)
 *
 */

public class Block_demo1 {
    public static void main(String[] args) {
        // run

        // static
        String desc = Person2.desc;
        Person2.info();
        System.out.println("desc = " + desc);

        System.out.println("=================");

        // non-static
        Person2 p1 = new Person2();
        Person2 p2 = new Person2();

        System.out.println(p1.age);
    }
}


class Person2{
    // attr
    String name;
    int age;
    static String desc = "i AM a person";

    // constructor
    public Person2(){

    }

    public Person2(String name, int age){
        this.name = name;
        this.age = age;
    }


    /** CODE BLOCK */
    // can only use static as decorator
    // static code block
    static { // NOTE : static code block will be RUN when class is loaded
        System.out.println("helloooooo static block !!!!");
    }

    // or can without decorator
    // non-static code block
    {   // non-static code block will be run when class is instantiated
        System.out.println("hola ~~~~~~~ block !!!!");
        age = 1; // init attr (age) as 1
    }

    // method
    public void eat(){
        System.out.println("eat ~~~~");
    }

    @Override
    public String toString(){
        return "Person [ name = " + name  + ", age = " + age + " ]";
    }

    public static void info(){
        System.out.println("static info ~~");
    }
}
