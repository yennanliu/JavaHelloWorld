package Advances.ThreadSafety1;

// https://www.youtube.com/watch?v=A_mB0jxIrgo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=433

/**
 * Implement 3 box offices with Thread class (total ticket=100)
 *
 * <p>- solve the thread safety via "Synchronized code block"
 *
 * <p>1) in `Thread` thread, we can use `this` as Synchronized monitor (make sure Synchronized
 * monitor is UNIQUE)
 */
class Thread_T extends Thread {

  // the object for `lock` (synchronized monitor)
  // NOTE : we need to make obj as `static` here,
  //        since we instantiate the Thread_T 3 times
  //        (we make obj as shared object via `static`)
  static Object obj = new Object();
  // attr
  // **** NOTE : WE NEED TO SET TICKET AS static attr
  //             since we want box offices sell 100 tickets in total
  //             rather than sell 100 tickets by each of them
  private static int tickets = 100;

  // method
  @Override
  public void run() {

    while (true) {

      // note : we CAN'T use synchronized (this) below
      //        since this is not THE ONLY object -> lock is NOT THE ONLY LOCK
      //        `this` in ths example : b1, b2, b3
      // synchronized (obj){
      synchronized (Thread_T.class) { // but we can use Thread_T.class as synchronized monitor
        // -> since class is also an object
        // example : class clazz = Thread_T.class;
        // (Thread_T.class will be loaded ONCE only)
        if (tickets > 0) {

          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

          System.out.println(
              Thread.currentThread().getName() + " sells ticket, ticket num = " + tickets);
          tickets -= 1;
        } else {
          break;
        }
      }
    }
  }
}

// entry point
public class BoxOfficeThread1 {
  public static void main(String[] args) {

    Thread_T b1 = new Thread_T();
    Thread_T b2 = new Thread_T();
    Thread_T b3 = new Thread_T();

    b1.setName("box office 1");
    b2.setName("box office 2");
    b3.setName("box office 3");

    b1.start();
    b2.start();
    b3.start();
  }
}
