package threadDev;

// https://docs.hazelcast.org/docs/1.9/manual/html/ch07s02.html
// https://stackoverflow.com/questions/11158454/future-task-of-executorservice-not-truly-cancelling
// https://stackoverflow.com/questions/28043225/future-cancel-does-not-work

import java.io.Serializable;
import java.util.concurrent.*;

public class Test3 {
    public static void main(String[] args){

        System.out.println(123);

        //ExecutorService es = Hazelcast.getExecutorService();
//        Future future = es.submit(new Fibonacci(n));
//        try {
//            return future.get(3, TimeUnit.SECONDS);
//        } catch (TimeoutException e) {
//            future.cancel(true);
//        }

    }

    public class Fibonacci<Long> implements Callable<java.lang.Long>, Serializable {
        int input = 0;

        public Fibonacci() {
        }

        public Fibonacci(int input) {
            this.input = input;
        }

        public java.lang.Long call() {
            return calculate (input);
        }

        private long calculate (int n) {
            if (Thread.currentThread().isInterrupted()) return 0;
            if (n <= 1) return n;
            else return calculate(n-1) + calculate(n-2);
        }
    }

}