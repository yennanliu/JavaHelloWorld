package org.example.DynamicProxy;

// https://youtu.be/pjGu5Y8e2vU?si=Dp0IbtWzpmjsJuJX&t=232

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

    // attr
    // pass proxied instance (目標對象)
    private Object target;


    // constructor
    public ProxyFactory(Object target){
        this.target = target;
    }

    // method
    // method return proxied instance (目標對象) (in dynamic way)
    public Object getProxy(){

        /**
         *  roxy.newProxyInstance() needs 3 parameters
         *
         *   https://youtu.be/pjGu5Y8e2vU?si=LwCV4O2qu3iPGnv-&t=580
         *
         *  1) ClassLoader: load proxied instance dynamically
         *  2) interfaces: interfaces (array) for target classes
         *  3) InvocationHandler: setup the `progress` that proxied instance implement target instance
         *
         */

        // 1) ClassLoader
        ClassLoader classLoader = target.getClass().getClassLoader();
        // 2) interfaces
        Class<?>[] interfaces = target.getClass().getInterfaces();
        // 3) InvocationHandler
        InvocationHandler invocationHandler = new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                /** logging before method called */
                System.out.println("[Log][Dynamic proxy] before method ------ , method = " + method.getName() + ", param = " + Arrays.toString(method.getParameters()));

                /** call the target method */
                Object result = method.invoke(target, args);

                /** logging after method called */
                System.out.println("[Log][Dynamic proxy] after method ------ , result = " + result);
                return result;
            }
        };

        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }

}
