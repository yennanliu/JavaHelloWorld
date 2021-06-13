package Basics.WrapperDemo1;

// https://www.youtube.com/watch?v=U00-S3mkKLU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=304

import org.junit.jupiter.api.Test;

/**
 *  1) Java offers 8 wrappers that can transform basic type to wrapper type (with class properties)
 *
 *  2) need to pickup
 *     2-1)  Basic type <--> Wrapper <--> String
 *
 *
 *
 *
 */

public class WrapperTest {

    /** Basic type -> wrapper */
    @Test
    public void test1(){
        int num1 = 10;
        //System.out.println(num1.toString()); // this one is not correct
        Integer in1 = new Integer(num1);
        System.out.println(in1.toString());

        // this one is also OK
        Integer in2 =  new Integer("123");
        System.out.println(in2.toString());

        Float f1 = new Float(12.3f);
        System.out.println(f1.toString());

        Float f2 = new Float("12.3");
        System.out.println(f2.toString());

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");

        Order order = new Order();
        System.out.println(order.isMale);
        System.out.println(order.isFemale);
    }
}


class Order{
    boolean isMale;     // basic data type
    Boolean isFemale;   // class
}