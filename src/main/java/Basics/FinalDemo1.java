package Basics;

// https://www.youtube.com/watch?v=KfywVjwQ8ZQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=333

/**
 *  Final
 *
 *  1) Can decorate : class, method, attr (variable)
 *  2) Final class
 *     2.1) CAN'T BE EXTENDED (no sub class)
 *           -> example : String, System, StringBuffer
 *
 *  3) Final method
 *      3.1) CAN'T BE OVERRIDDEN (no overwrite method)
 *           -> example : getClass() method in Object class
 *
 *  4) Final attr (variable)
 *      4.1) attr/variable becomes CONSTANT (unchanged)
 *      4.2) final attr
 *          -> can be used in
 *              - explicitly declaration
 *              - initialize in code block
 *              - initialize in constructor
 *      4.3) final variable
 *          -> thr variable is a CONSTANT now
 *          -> can't be changed, can only be used in method
 *
 *  5) static final
 *     5.1) can be used in
 *         - attr
 *         - method
 *    5.2) static attr -> global constant
 *
 */

public class FinalDemo1 {
    public static void main(String[] args) {
        FinalDemo1 finalDemo1 = new FinalDemo1();

        finalDemo1.show(10);
    }

    public FinalDemo1(){

        /** Final attr (variable) */
        final int width = 10;
        final int LEFT;
        final int RIGHT;
        final int Down;

        // wrong : Cannot assign a value to final variable 'width'
        //public void change(){
        //    width = 20;
        //}

        {
            LEFT = 2;
        }

        RIGHT = 2;
    }

//    public FinalDemo1(int n){
//        RIGHT = n;
//    }

//    public void setDown(int down){
//        this.Down = down;
//    }

    public void show(){
        final int NUM = 10;
        // wrong : Cannot assign a value to final variable 'num'
        //NUM += 10;
    }

    public void show(final int num){
        // wrong : Cannot assign a value to final variable 'num'
        //num = 20;
        System.out.println(num);
    }
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