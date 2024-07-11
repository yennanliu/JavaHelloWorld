package threadDev;

// https://docs.hazelcast.org/docs/1.9/manual/html/ch07s02.html

import java.io.Serializable;
import java.util.concurrent.*;

public class Test1 {
    public static void main(String[] args){

        //ThreadPoolExecutor es = new ThreadPoolExecutor(10); //Hazelcast.getExecutorService();

        final int _pcautoSchedulerPoolSize = 1000;
        final int KEEP_ALIVE_TIME = 60;

        final int MAX_POOL_SIZE = 1000;
        final int CORE_POOL_SIZE = 500; // Example value, set according to your needs

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadPoolExecutor.AbortPolicy() // DiscardPolicy
        );

        Test1 t1 = new Test1();
        Fibonacci fibonacci = new Fibonacci();
        int n = 10;
        Future future = executor.submit(new Fibonacci(n));
        
        try {
            //return future.get(3, TimeUnit.SECONDS);
            future.get(3, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            future.cancel(true);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(123);

    }

    public void myFunc(){
       System.out.println(123);
    }


}
