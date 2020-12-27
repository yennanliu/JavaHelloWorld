package thread;

public class MultiSalesThread {
    public static void main(String[] args) {
        SalesThread sales_thread = new SalesThread();
        // create 4 threads, in order to simulate 4 box offices
        new Thread(sales_thread, "box office 1").start();
        new Thread(sales_thread, "box office 2").start();
        new Thread(sales_thread, "box office 3").start();
        new Thread(sales_thread, "box office 4").start();
    }
}

// implements from Runnable
class SalesThread implements Runnable {
    private int tickets = 10;
    public void run() {
        while (true) {
            if (tickets > 0) {
                try {
                    Thread.sleep(1000); // simulate the time cost during sales process
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(
                        Thread.currentThread().getName() + " is selling " + tickets + " ticket");
            }
        }
    }
}