package threadDev;

// https://docs.hazelcast.org/docs/1.9/manual/html/ch07s02.html

import java.io.Serializable;
import java.util.concurrent.*;

public class Test1 {
    public static void main(String[] args){

        //ThreadPoolExecutor es = new ThreadPoolExecutor(10); //Hazelcast.getExecutorService();

        final int _pcautoSchedulerPoolSize = 10;
        final int KEEP_ALIVE_TIME = 60;

        final int MAX_POOL_SIZE = 11;
        final int CORE_POOL_SIZE = 10; // Example value, set according to your needs

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadPoolExecutor.AbortPolicy() // DiscardPolicy
        );

        //Test1 t1 = new Test1();
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("executor submit task");

        int N = 3;
        Future future = executor.submit(() -> {
            System.out.println("--> Thread name : " + Thread.currentThread().getName() + ", id = " + Thread.currentThread().getId());
            //fibonacci.call(10);
            new Fibonacci(N);
        });

        Fibonacci f = new Fibonacci(10);

//        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
//            System.out.println("--> Thread name : " + Thread.currentThread().getName() + ", id = " + Thread.currentThread().getId());
//            // Simulate some work, e.g., Fibonacci calculation
//            //new Fibonacci(10); // Replace '10' with 'N' if 'N' is defined elsewhere
//        });

        for (int i = 0; i < 3; i++){
            executor.submit(() -> {
                System.out.println("--> Thread name : " + Thread.currentThread().getName() + ", id = " + Thread.currentThread().getId());
                new Fibonacci(2);
            });
        }


        try {

//            while(!futureTask.isDone()){
//                System.out.println("wait for futureTask done, sleep 3 milli sec");
//                Thread.sleep(3);
//            }
//
//            System.out.println("futureTask.isDone() = " + futureTask.isDone());
//            System.out.println("futureTask result = " + futureTask.get());

            //return future.get(3, TimeUnit.SECONDS);
            System.out.println("future.isDone() = " + future.isDone());
            System.out.println("future result = " + future.get(10, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.out.println("future cancel");
            future.cancel(true);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally{
            System.out.println("executor shutdown");
            executor.shutdown();
        }

        System.out.println(123);

    }

    public void myFunc(){
       System.out.println(123);
    }


}
