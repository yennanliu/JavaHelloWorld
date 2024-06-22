package Advances;

// https://www.youtube.com/watch?v=bL5ppBbMJOQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=418

public class ThreadDemo2 {
  public static void main(String[] args) {

    MyThread2 t1 = new MyThread2();

    /**
     * `start` has 2 functionalities
     *
     * <p>1) launch current thread 2) run current thread's run() method
     */
    t1.start(); // 1st thread
    // t1.run();  // <-- if use run(), then there will be only 1 main thread, instead of multi
    // thread

    /** HERE WE WANT TO LAUNCH THE OTHER THREAD -> STILL LOOPING EVEN NUMS WITHIN 0-100 */
    // in order to launch a new thread -> we need to create a new thread instance
    MyThread2 t2 = new MyThread2();
    t2.start();

    // below "for loop" is in the `main thread`
    for (int i = 0; i < 100; i++) {
      if (i % 2 == 0) {
        // System.out.println("*****main()*****" + i);
        System.out.println(Thread.currentThread().getName() + " : " + i);
      }
    }
  }
}

class MyThread2 extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      if (i % 2 == 0) {
        // System.out.println(i);
        System.out.println(Thread.currentThread().getName() + " : " + i);
      }
    }
  }
}
