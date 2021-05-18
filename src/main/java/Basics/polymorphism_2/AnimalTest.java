package Basics.polymorphism_2;

// https://www.youtube.com/watch?v=-dlhK0u7d2I&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=280

public class AnimalTest{
    public static void main(String[] args){
        // test run
        AnimalTest test1 = new AnimalTest();

        // use Dog's method (with Animal type)
        test1.func(new Dog());

        System.out.println("===================");

        // use Cat's method (with Animal type)
        test1.func(new Cat());
    }

    // method
    /**
     *  Can use Polymorphism below :
     *   -> Animal animal = new Dog();
     *   -> instantiate with animal superclass, but implement with Dog subclass when runtime
     *   -> will use subclass' OVERRIDE eat, shout methods
     */
    public void func(Animal animal){ // Animal animal = new Dog();
        animal.eat();
        animal.shout();
    }
}


class Animal {
    // method
    public void eat(){
        System.out.println("animal is eating !!!!");
    }

    public void shout(){
        System.out.println("animal is shout !!!!");
    }
}


class Dog extends Animal{
    // method
    @Override
    public void eat(){
        System.out.println("Dog is eating !!!!");
    }

    @Override
    public void shout(){
        System.out.println("waf waf waf ~~~");
    }
}


class Cat extends Animal{
    // method
    @Override
    public void eat(){
        System.out.println("Cat is eating !!!!");
    }

    @Override
    public void shout(){
        System.out.println("Miu miu MIU~~~");
    }
}
