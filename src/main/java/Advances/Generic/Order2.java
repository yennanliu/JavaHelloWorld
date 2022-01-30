package Advances.Generic;

// https://www.youtube.com/watch?v=ilutsOhRmuk&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=568

// custom class with generic type
public class Order2<T> {

    // attr
    String orderName;
    int orderId;
    T orderT;

    // constructor
    // inside class, we can use the genetic type (T)
    public Order2(){

        // wrong (compile failed)
        //T[] arr = new T[10];

        // OK  (compile ok)
        T[] arr = (T[])  new Object[10];
    }

    public Order2(String orderName, int orderId, T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    // getter, setter
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
}
