package com.yen.atguigu.forkjoin.course42;

// course 42 : https://youtu.be/cLpIxXV-0iU?si=aJnEZtv6zySOdzs1

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

// create RecursiveTask implementation
class MyTask extends RecursiveTask<Integer> {

  // attr
  // diff should < 10
  private static final Integer VALUE = 10;
  private final int begin; // start value
  private final int end; // end value
  private int result; // return result

  // constructor
  public MyTask(int begin, int end) {
    this.begin = begin;
    this.end = end;
  }

  // fork - join logic (break down - merge)
  @Override
  protected Integer compute() {

    // if diff <= 10, do add op directly
    if (end - begin <= VALUE) {

      // add op
      // TODO : double check i <= end or i < end
      for (int i = begin; i <= end; i++) {
        result = result + i;
      }
      // else, do break and merge (fork - join)
    } else {

      // break down further
      // get middle value
      int middle = (begin + end) / 2;

      // break down left
      MyTask task_1 = new MyTask(begin, middle);

      // break down right
      MyTask task_2 = new MyTask(middle + 1, end);

      // call method break down
      task_1.fork();
      task_1.fork();

      // merge result
      result = task_1.join() + task_2.join();
    }

    return result;
  }
}

public class ForkJoinDemo {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    // TODO : fix below code (seems gets stuck, program never complete)

    // create task instance
    MyTask myTask = new MyTask(0, 100);

    // create fork - join pool instance
    ForkJoinPool forkjoinpool = new ForkJoinPool();
    // submit
    ForkJoinTask<Integer> forkJoinTask = forkjoinpool.submit(myTask);

    // get final result
    Integer result = forkJoinTask.get();
    System.out.println(result);

    // shutdown resource
    forkjoinpool.shutdown();
  }
}
