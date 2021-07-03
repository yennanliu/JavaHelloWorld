package Basics;

// https://www.youtube.com/watch?v=KfywVjwQ8ZQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=333

/**
 *  Final
 *
 *  1) Can decorate : class, method, attr
 *  2) Final class
 *     2.1) CAN'T BE EXTENDED (no sub class)
 *           -> example : String, System, StringBuffer
 *
 *  3) Final method
 *      3.1) CAN'T BE OVERRIDDEN (no overwrite method)
 *           -> example : getClass() method in Object class
 */

public class FinalDemo1 {
}

/** Final class */

final class finalA{

}

// wrong : Cannot inherit from final 'Basics.finalA'
//class B_ extends finalA{
//
//}

// wrong : Cannot inherit from final 'Basics.finalA'
//class C_ extends String{
//
//}

/** Final method */

class AA{
    public final void show(){

    }
}

class BB extends AA {
    // wrong : 'show()' cannot override 'show()' in 'Basics.AA'; overridden method is final
//    public void show(){
//
//    }
}
