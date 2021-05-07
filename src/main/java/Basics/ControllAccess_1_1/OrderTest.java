package Basics.ControllAccess_1_1;

// https://www.youtube.com/watch?v=dPgnPoFWkFY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=274

import Basics.ControllAccess_1.Order;

public class OrderTest {
    public static void main(String[] args){

        Order order = new Order();

        order.orderPublic = 1;
        order.methodPublic();

        /** For normal class (not subclass) In different package
         *  -> We CAN NOT use its methods with default, private, and "missing", and protected control access
         */
        // below method/attr are ALL NOT VISIBLE
        //order.methodDefault();
        //order.methodProtected();
        //order.methodPrivate();

        //order.orderDefault;
        //order.orderProtected;
    }
}
