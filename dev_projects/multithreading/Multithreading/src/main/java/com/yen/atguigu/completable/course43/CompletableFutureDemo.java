package com.yen.atguigu.completable.course43;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/** Sync, Async call demo */
// course 43 : https://youtu.be/hnLX0QiSmPw?si=9gR-lGZQcSF0AVL6

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /** demo 1: Sync call */
        // NOTE : Void means no return value
        CompletableFuture<Void> completableFuture_1 = CompletableFuture.runAsync(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +  " completableFuture_1 ");
            }
        });

        completableFuture_1.get();


        /** demo 2: Async call */
        // However, in reality, we seldom use CompletableFuture for async calling
        // -> what we usually use is queue service such as RabbitMQ

        // V1 : normal
        CompletableFuture<Integer> completableFuture_2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println(Thread.currentThread().getName() +  " completableFuture_2 ");
                // simulate exception
                //int x = 1 / 0;
                return 1024;
            }
        });

        // V2 : lambda expression
//        CompletableFuture<Integer> completableFuture_2 = CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName() +  " completableFuture_2 ");
//            return 1024;
//        });

        // get async result, exception via lambda expression
        completableFuture_2.whenComplete((t,u) -> {
            // t : result
            // u : exception (null if NO exception)
            System.out.println("--> t = " + t); // 1024
            System.out.println("--> u = " + u); // null
        }).get();

    }

}
