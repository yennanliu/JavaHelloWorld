package Basics;

// https://www.youtube.com/watch?v=ODTnZQXWV9w&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=325

/**
 * Singleton : Lazy initialization
 *
 * <p>1) via some method, make sure THERE IS ONLY 1 CLASS INSTANCE in the software program 2) how to
 * implement ? -> check below steps
 *
 * <p>3) private static Order2 instance = null; // *** MAIN DIFFERENCE WITHIN EAGER & LAZY
 * initialization (lazy : doesn't create at this stage)
 */
public class SingletonDemo3 {
  public static void main(String[] args) {

    // run
    Order2 o1 = Order2.getInstance();
    Order2 o2 = Order2.getInstance();

    System.out.println(o1 == o2);
  }
}

class Order2 {

  // step 2) declare current class, *** NO NEED TO INSTANTIATE
  // step 4) make below class as static
  private static Order2 instance =
      null; // *** MAIN DIFFERENCE WITHIN EAGER & LAZY initialization (lazy : doesn't create at this

  // step 1) private constructor
  // constructor
  private Order2() {}

  // stage)

  // step 3) offer a public, static method that can return current class
  public static Order2 getInstance() {
    // NOTE : since we ONLY want to have ONE class instance
    // so use below logic :
    //   -> if instance is null => instantiate a new class
    //   -> if instance != null => return current instance directly
    if (instance == null) {
      instance = new Order2();
    }
    return instance;
  }
}
