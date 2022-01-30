package Advances.Generic;

// https://www.youtube.com/watch?v=kRiy9mS2B9A&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=567

/** demo3 : generic class, generic interface, generic method */

import org.junit.jupiter.api.Test;

public class demo3 {
    @Test
    public void test1(){
        // will assume type as "object" if already defined generic type in class,
        // but not use it (generic type) when instantiate
        // (not recommended)
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("abc");

    }

    @Test
    public void test2(){
        // instantiate with generic type
        // (recommended)
        Order<String> order = new Order<String>("orderAA",1001,"oder:AA");
        //order.setOrderT(123);
        order.setOrderT("123");
        order.setOrderT("abc");
    }

    @Test
    public void test3(){
        // since we already defined generic type when define SubOrder
        // so it's NO NEEDED to define generic type when instantiate the class (subOrder)
        SubOrder sub1 = new SubOrder();
        sub1.setOrderT(123);
        sub1.setOrderT(456);

        SubOrder2<String> sub2 = new SubOrder2<>(); // type inference (either new SubOrder2<String>() or new SubOrder2<>() is OK)
        sub2.setOrderT("abc");
        sub2.setOrderT("xyz");
    }
}
