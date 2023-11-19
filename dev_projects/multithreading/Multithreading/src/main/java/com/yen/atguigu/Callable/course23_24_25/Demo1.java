package com.yen.atguigu.Callable.course23_24_25;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  Comparison : Callable VS Runnable
 *
 *      - FutureTask example :
 *          - 1) create a new (not main thread), do sth,
 *             NOT wait it complete, (Not affect main thread)
 *             and can get result via "get()" method
 *
 *           - 2) have 3 tasks (run by FutureTask),
 *                (task 1 completed, task 2 running, task 3 running ..)
 *                (task 1 completed, task 2 completed, task 3 running ..)
 *                cam wait till ALL tasks completed
 *
 *
 *
 */

// course 23 : https://youtu.be/1rOoUmzjPFw?si=ZakPKztzlqy5-9OS&t=314
// course 24 : https://youtu.be/eqHmPDqgXDI?si=oAAHAdNAb0udhnGv
// course 25 : https://youtu.be/1uG5vwYPj1w?si=jQR3fv8WmMYncB_F
// course 26 : https://youtu.be/1uG5vwYPj1w?si=GhSgMys5hV0o1Xb5

class MyThread1 implements Runnable{

    @Override
    public void run() {
    }

}

class MyThread2 implements Callable{

    // NOTE : call() method has return value
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " (callable) ");
        return 100;
    }

}

public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /** Runnable */
        new Thread(new MyThread1(), "AA").start();

        /** Callable */
        // https://youtu.be/1rOoUmzjPFw?si=IlIH_QJuKPStR361&t=513
        //new Thread(new MyThread2(), "BB").run(); // No such construct way

        // https://youtu.be/1rOoUmzjPFw?si=MCc2qFwhHsaPv4Pw&t=739
        // FutureTask implement Runnable

        // FutureTask can be constructed with Callable :
        // V1
        FutureTask<Integer> futureTask1 = new FutureTask<>(new MyThread2());

        // V2
        // or, can via Lambda expression
        FutureTask<Integer> futureTask2 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " futureTask2 come in callable ");
                return 100;
            }
        });

        // create a thread (with Callable)
        new Thread(futureTask2, "c_1").start();

        while(!futureTask2.isDone()){
            System.out.println("wait ....");
        }

        // get() method
        System.out.println(futureTask2.get()); // 100

        System.out.println(Thread.currentThread().getName() + " done !!!");
    }

}
