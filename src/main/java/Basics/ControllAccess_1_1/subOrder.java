package Basics.ControllAccess_1_1;

// https://www.youtube.com/watch?v=dPgnPoFWkFY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=274

import Basics.ControllAccess_1.Order;

public class subOrder extends Order{

    public void method(){
        orderProtected = 1;
        orderPublic = 2;

        methodProtected();
        methodPublic();

        /** For subclass In different package
         *  -> We CAN NOT use its methods with default, private, and "missing" control access
         */

        //orderDefault;
        //orderPrivate ;

        //methodDefault();
        //methodPrivate();
    }
}
