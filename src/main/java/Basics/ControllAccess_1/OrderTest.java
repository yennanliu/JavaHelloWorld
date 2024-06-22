package Basics.ControllAccess_1;

public class OrderTest {
  public static void main(String[] args) {
    // run

    // test 1
    Order order = new Order();
    order.orderDefault = 1;
    order.orderPublic = 2;

    order.methodDefault();
    order.methodProtected();
    order.methodPublic();

    // test 2
    // private are not visible in different class (but in same package)
    // order.orderPrivate = 4;
    // order.methodPrivate();
  }
}
