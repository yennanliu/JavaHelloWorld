package thread;

class MyThread2 implements Runnable {
  // rewrite run method in Runnable
  public void run() {
    int i = 0;
    while (i++ < 10) {
      System.out.println(Thread.currentThread().getName() + "'s run() method is running");
    }
  }
}

public class RunnableDemo_1 {
  public static void main(String[] args) {
    MyThread2 myThread2 = new MyThread2();

    // create the 1st thread (thread1)
    Thread thread1 = new Thread(myThread2, "thread1");
    thread1.start();

    // create the 2nd thread (thread2)
    Thread thread2 = new Thread(myThread2, "thread2");
    thread2.start();
  }
}
