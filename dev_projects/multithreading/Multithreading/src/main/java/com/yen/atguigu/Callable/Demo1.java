package com.yen.atguigu.Callable;

import java.util.concurrent.Callable;

/**
 *  Comparison : Callable VS Runnable
 *
 */

// https://youtu.be/1rOoUmzjPFw?si=ZakPKztzlqy5-9OS&t=314

class MyThread1 implements Runnable{

    @Override
    public void run() {

    }

}

class MyThread2 implements Callable{

    // NOTE : call() method has return value
    @Override
    public Object call() throws Exception {
        return null;
    }

}

public class Demo1 {

    public static void main(String[] args) {

        // Runnable
        new Thread(new MyThread1(), "AA").start();

        // Callable
        // https://youtu.be/1rOoUmzjPFw?si=IlIH_QJuKPStR361&t=513
        //new Thread(new MyThread2(), "BB").run(); // No such construct way

        // https://youtu.be/1rOoUmzjPFw?si=MCc2qFwhHsaPv4Pw&t=739
        // FutureTask implement Runnable
        // FutureTask can be constructed with Callable

    }

}
