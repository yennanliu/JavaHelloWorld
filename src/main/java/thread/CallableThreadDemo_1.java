package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// https://www.youtube.com/watch?v=gw5OyY83ZT8&list=PLmOn9nNkQxJEDjzl0iBYZ3WuXUuUStxZl&index=11

public class CallableThreadDemo_1 {
  public static void main(String[] args) throws Exception {

    FutureTask<Integer> ft1 = new FutureTask<Integer>(new MyCallable10());
    FutureTask<Integer> ft2 = new FutureTask<Integer>(new MyCallable100());
    FutureTask<Integer> ft3 = new FutureTask<Integer>(new MyCallable1000());

    Thread t1 = new Thread(ft1);
    Thread t2 = new Thread(ft2);
    Thread t3 = new Thread(ft3);

    t1.start();
    t2.start();
    t3.start();

    // will be waiting till all ft1.get(), ft2.get(), ft3.get() finished, (get method)
    // then do the next command
    System.out.println(">>> MAIN SUM = " + (ft1.get() + ft2.get() + ft3.get()));
  }
}

class MyCallable10 implements Callable<Integer> {
  public Integer call() throws Exception {
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
      sum += i;
    }
    return sum;
  }
}

class MyCallable100 implements Callable<Integer> {
  public Integer call() throws Exception {
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
      sum += i;
    }
    return sum;
  }
}

class MyCallable1000 implements Callable<Integer> {
  public Integer call() throws Exception {
    int sum = 0;
    for (int i = 1; i <= 1000; i++) {
      sum += i;
    }
    return sum;
  }
}
