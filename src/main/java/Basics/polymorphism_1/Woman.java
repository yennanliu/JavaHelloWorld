package Basics.polymorphism_1;

// https://www.youtube.com/watch?v=TcTwRuVB8V0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=279

public class Woman extends Person{
    // attr
    boolean isBeauty;

    // method
    public void goShopping(){
        System.out.println("woman is shopping ~~~~");
    }

    @Override
    public void eat(){
        System.out.println("woman is eating xddd");
    }

    @Override
    public void walk(){
        System.out.println("woman is walk xddd");
    }
}
