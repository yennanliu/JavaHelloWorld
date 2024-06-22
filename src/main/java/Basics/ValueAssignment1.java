package Basics;

// https://www.youtube.com/watch?v=Hz7QgMP7Tro&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=209

public class ValueAssignment1 {
  public static void main(String[] args) {
    /*
     * Value Assignment
     * 1) Basic data type :  assigned value is the storage "actual value"
     * 2) Reference data type :  assigned value is the storage "address value" (e.g. : 0X111, 0XABC)
     */

    System.out.println("=========== BASIC DATA TYPE ===========");
    int m = 10;
    int n = m;
    System.out.println("m = " + m + ", n = " + n);
    n = 20;
    System.out.println("m = " + m + ", n = " + n);

    System.out.println("=========== REFERENCE DATA TYPE ===========");
    Order o1 = new Order();
    o1.orderId = 1001;
    Order o2 = o1;
    System.out.println("o1.orderId = " + o1.orderId + ", o2.orderId = " + o2.orderId);
    o1.orderId = 1002;
    System.out.println("o1.orderId = " + o1.orderId + ", o2.orderId = " + o2.orderId);
  }
}

class Order {
  int orderId;
}
