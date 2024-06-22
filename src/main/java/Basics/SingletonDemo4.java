package Basics;

// https://www.youtube.com/watch?v=QFgDlAis0cM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=339

public class SingletonDemo4 {
  public static void main(String[] args) {
    // run
    System.out.println(Order3.getInstance());

    Order3 order3 = Order3.getInstance();
    System.out.println(order3);
  }
}

// Eager initialization
// since there is a static code block that returns the instance when class in called
class Order3 {

  private static Order3 instance = null;

  static {
    instance = new Order3();
  }

  private Order3() {}

  public static Order3 getInstance() {
    return instance;
  }
}
