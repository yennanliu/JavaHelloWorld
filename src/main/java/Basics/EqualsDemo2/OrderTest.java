package Basics.EqualsDemo2;

// https://www.youtube.com/watch?v=pK3oW2xlNXA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=298

public class OrderTest {
  public static void main(String[] args) {
    // run
    Order order1 = new Order(777, "xxx");
    Order order2 = new Order(777, "yyy");

    System.out.println(order1.equals(order2)); // false

    System.out.println("==============");

    Order order3 = new Order(777, "xxx");

    System.out.println(order1.equals(order3)); // true
  }
}

class Order {

  // attr
  private int orderId;
  private String orderName;

  // constructor
  public Order() {}

  public Order(int orderId, String orderName) {
    this.orderId = orderId;
    this.orderName = orderName;
  }

  // getter, setter
  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }

  // method
  // rewrite equals
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj instanceof Order) {
      Order order = (Order) obj; // DownCasting
      return this.orderId == order.orderId && this.orderName.equals(order.orderName);
    }
    return false;
  }
}
