package Advances.DynamicProxy;

// https://www.youtube.com/watch?v=_iMUk-LYNWE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=663

/**
 *  Dynamic proxy demo 1
 *
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
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
class ProxyFactory{

    // get proxy class (代理類) instance via method below (Qestion 1 is resolved)
    public static Object getProxyInstance(Object obj){ // obj : proxied class instance

        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj; // have to use proxied class' (被代理類) when set attr

    public void bind(Object obj){
        this.obj = obj;
    }

    // when call method A through proxy-class (代理類) instance, will call below method : invoke()
    // implement proxied class' (被代理類) method A in invoke()
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /**
         *   -> method : method called by proxy class (代理類)
         *   -> called by proxied class' (被代理類)
         *   -> obj : proxied class' (被代理類)
         */
        Object returnedVal =  method.invoke(obj, args);
        // above method's return as invoke() 's return value
        return returnedVal;
    }
}


/**
 *   In order to use dynamic proxy, we need to sort below :
 *
 *   Qestion 1) how to load proxied class from memory, and init proxy class and its instance dynamically ?
 *   Qestion 2) when call method through proxy class, how to call same method in proxied class dynamically ?
 */
public class DynamicProxyDemo1 {
    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();

        /** example 1 */
        // 1) create proxy class instance (proxyInstance : proxy class instance)
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        /** NOTE !!! : call method via proxy class, but actually call proxied class method */
        String res1 = proxyInstance.getBelief();
        System.out.println(">>> res1 = " + res1);
        proxyInstance.eat("sushi");

        System.out.println("====================");

        /** example 2 */
        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyClothFactory.produceCloth();
    }

}
