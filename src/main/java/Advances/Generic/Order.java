package Advances.Generic;

// https://www.youtube.com/watch?v=kRiy9mS2B9A&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=568
// https://www.youtube.com/watch?v=kRiy9mS2B9A&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=568
// https://www.youtube.com/watch?v=Lws0GkOTckQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=569

import java.util.ArrayList;
import java.util.List;

// custom class with generic type
public class Order<T> {

    // attr
    String orderName;
    int orderId;
    T orderT;

    // constructor
    // inside class, we can use the genetic type (T)
    public Order(){
        // wrong (compile failed)
        //T[] arr = new T[10];

        // OK  (compile ok)
        T[] arr = (T[])  new Object[10];
    }

    public Order(String orderName, int orderId, T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    // getter, setter
    // below 3 methods (getOrderT, setOrderT, toString) are NOT generic method
    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    // method

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    // generic type CAN'T be used in static method
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    // generic method : use generic structure inside method
    //                  -> (generic type has NOTING TO DO (not relative) with generic method)
    //                  -> in other words : generic method has NOTHING TO DO with if its class is generic class or not

    public <E> List<E> copyFromArrayList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for (E e: arr){
            list.add(e);
        }

        return list;
    }
}
