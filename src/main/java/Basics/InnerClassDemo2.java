package Basics;

// https://www.youtube.com/watch?v=qjGy50cSiCQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=362

/**
 *  Inner Class
 *
 *  .....
 *
 *  plz refer https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Basics/InnerClassDemo1.java
 *
 *  4) Note : below questions
 *     4-1) how to instantiate object inside inner local class ?
 *     4-2) how to use external structure inside inner local class ?
 *     4-3) in development, how to use local class ?
 */


public class InnerClassDemo2 {
    public static void main(String[] args) {
        // run

        // create Dog instance (static member's inner local class)
        Person_inner2.Dog dog =  new Person_inner2.Dog();
        dog.show();

        System.out.println("=================");

        // create Bird instance (Non-static member's inner local class)
        // wrong
        //Person_inner2.Bird bird = new Person_inner2.Bird();
        Person_inner2 p = new Person_inner2();
        Person_inner2.Bird bird = p.new Bird(); // *** NOTE HERE !
        bird.sing();
    }
}


class Person_inner2{
    // attr
    String name;
    int age;

    // method
    public void eat(){
        System.out.println("ppl eat !!");
    }

    // inner local class (成員內部類)
    static class Dog {
        // attr
        String name;
        int age;

        // method
        public void show(){
            System.out.println("Lucky is a dog !");
        }
    }

    class Bird {
        // method
        public void sing(){
            System.out.println("Bird is singing !");
        }
    }

    // method
    public void method(){
        class AA { //  local class (局部內部類)

        }
    }

    // code block
    {
        class BB { // local class (局部內部類)

        }

    }

    // constructor
    public Person_inner2(){
        class CC { // local class (局部內部類)

        }
    }
}
