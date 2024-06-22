package Advances;

// https://www.youtube.com/watch?v=AkNZRvyYivk&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=417
// https://www.youtube.com/watch?v=bL5ppBbMJOQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=418

/**
 * Multi-thread
 *
 * <p>1) Method 1 : Inherit from `thread` class
 *
 * <p>-> Step 1) create a subclass inherited from `thread` class -> Step 2) override Thread class'
 * run() -> the operation this thread needs to do -> Step 3) create instance of (subclass inherited
 * from `thread` class) -> Step 4) run start() method via subclass above
 */

// example run 1 - 100 even integers
public class ThreadDemo1 {
  public static void main(String[] args) {

    // Step 3) create instance of (subclass inherited from `thread` class)
    MyThread t1 = new MyThread();

    // Step 4) run start() method via subclass above
    /**
     * `start` has 2 functionalities
     *
     * <p>1) launch current thread 2) run current thread's run() method
     */
    t1.start(); // 1st thread
    // t1.run();  // <-- if use run(), then there will be only 1 main thread, instead of multi
    // thread

    // 2nd thread
    // below "for loop" is in the `main thread`
    for (int i = 0; i < 100; i++) {
      if (i % 2 == 0) {
        // System.out.println("*****main()*****" + i);
        System.out.println(Thread.currentThread().getName() + " : " + i);
      }
    }
  }
}

// Step 1) create a subclass inherited from `thread` class
class MyThread extends Thread {
  // Step 2) override Thread class's run()
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
