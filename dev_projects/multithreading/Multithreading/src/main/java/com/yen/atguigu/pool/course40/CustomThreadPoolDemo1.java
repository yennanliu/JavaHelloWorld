package com.yen.atguigu.pool.course40;

import java.util.concurrent.*;

/** User define thread pool demo */

// Course 40 : https://youtu.be/KTkRVtfTWOA?si=BbemVgbMUDT8a5-L

public class CustomThreadPoolDemo1 {

    public static void main(String[] args) {

        /**
         *  Ref : needed param
         *
         *      public ThreadPoolExecutor(int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         *                               RejectedExecutionHandler handler) {
         *
         */

        // setup param
        final int CORE_POOL_SIZE = 2;
        final int MAX_POOL_SIZE = 5;
        final long KEEP_ALIVE_TIME = 2L;
        final TimeUnit UNIT = TimeUnit.SECONDS;
        final BlockingQueue<Runnable> BLOCKING_QUEUE = new ArrayBlockingQueue<>(3);
        final ThreadFactory THREAD_FACTORY = Executors.defaultThreadFactory();
        final RejectedExecutionHandler REJECT_POLICY = new ThreadPoolExecutor.AbortPolicy();

        ThreadPoolExecutor x = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                UNIT, BLOCKING_QUEUE,
                THREAD_FACTORY,
                REJECT_POLICY);

    }

}
