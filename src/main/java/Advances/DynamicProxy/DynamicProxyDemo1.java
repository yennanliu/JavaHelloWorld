package Advances.DynamicProxy;

// https://www.youtube.com/watch?v=_iMUk-LYNWE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=663

/**
 *  Dynamic proxy demo 1
 *
 */

import java.lang.reflect.Proxy;

/** interface */
interface Human{

    String getBelief();

    void eat(String food);
}

/** proxy class */
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "world peace";
    }

    @Override
    public void eat(String food) {
        System.out.println(">>> superman eat " + food);
    }

}

/** class factory */
//class ProxyFactory{
//
//    // get proxy class instance via method below (Q1 is resolved)
//    public static Object getProxyInstance(Object obj){ // obj : proxied class instance
//        //Proxy.newProxyInstance(obj.getClass().getClassLoader());
//    }
//
//}


/**
 *   In order to use dynamic proxy, we need to sort below :
 *
 *   Q1) how to load proxied class from memory, and init proxy class and its instance dynamically ?
 *   Q2) when call method through proxy class, how to call same method in proxied class dynamically ?
 */
public class DynamicProxyDemo1 {
}
