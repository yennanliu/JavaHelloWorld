package Basics.objectDemo1;

// https://www.youtube.com/watch?v=KITuqq2JSDM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=293

/**
 *  1) java.lang.Object class
 *   -> 1-1) Object is all Java class' superclass
 *   -> 1-2) if there is no extends in java class, then it superclass is java.lang.Object class by default
 *
 *  2) java.lang.Object's attr, method.. can be used in general cases
 *   -> methods : equals, toString, getClass, hashCode, clone, finalize
 *
 *  3) java.lang.Object ony declares a null constructor
 *
 */
public class ObjectTest {
    public static void main(String[] args){
        // run
        Order order = new Order();
        System.out.println(order.getClass());
        System.out.println(order.getClass().getSuperclass()); // class java.lang.Object

    }

}

class Order { // actually : Order extends java.lang.Object

}
