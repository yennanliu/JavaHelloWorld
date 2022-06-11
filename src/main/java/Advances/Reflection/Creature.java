package Advances.Reflection;

// https://www.youtube.com/watch?v=x6tmNMxMmZo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=648

import java.io.Serializable;

public class Creature<T> implements Serializable {

    private char gender;
    private double weight;

    private void breath(){
        System.out.println(">>> creature breath ...");
    }

    private void eat(){
        System.out.println(">>> creature eat ...");
    }

}
