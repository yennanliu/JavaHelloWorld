package threadDev;

import java.util.concurrent.*;

public class Test1 {
    public static void main(String[] args) {
        final int CORE_POOL_SIZE = 10;
        final int MAX_POOL_SIZE = 11;
        final int KEEP_ALIVE_TIME = 60;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        int N = 10;
        Future<Integer> future = executor.submit(() -> {
            System.out.println("--> Thread name : " + Thread.currentThread().getName() + ", id = " + Thread.currentThread().getId());
            return new Fibonacci2(N).calculate();
        });

        for (int i = 0; i < 3; i++) {
            executor.submit(() -> {
                System.out.println("--> Thread name : " + Thread.currentThread().getName() + ", id = " + Thread.currentThread().getId());
                new Fibonacci2(2).calculate();
            });
        }

        try {
            System.out.println("Waiting for future result...");
            Integer result = future.get(10, TimeUnit.SECONDS);
            System.out.println("Future result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Future task timed out, cancelling...");
            future.cancel(true);
        } catch (ExecutionException e) {
            System.out.println("Exception occurred during task execution");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        System.out.println("Main method finished");
    }
}

class Fibonacci2 {
    private final int N;

    public Fibonacci2(int N) {
        this.N = N;
    }

    public int calculate() {
        System.out.println("Fibonacci2 calculate, N = " + N);
        return fibonacci(N);
    }

    private int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}