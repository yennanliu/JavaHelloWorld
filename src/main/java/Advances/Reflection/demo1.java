package Advances.Reflection;

// https://www.youtube.com/watch?v=UdZie846898&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=636
// https://www.youtube.com/watch?v=4V-cslz9BpM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=636

import org.junit.jupiter.api.Test;

/**
 *  Reflection demo 1
 *
 *
 *
 */

public class demo1 {

    /**
     * test 1: Before reflection, op we can do on Person class
     */
    @Test
    public void test1(){
        // 1. create Person class (init)
        Person p1 = new Person("kate",17);

        // 2. via instance, use its method
        p1.age = 20;
        System.out.println(p1.toString());

        p1.show();

        // can't use Person instance's private method, attr.. outside Person class
    }

    /**
     * test 2: After reflection, op we can do on Person class
     */
    @Test
    public void test2(){

    }

}
