package thread;

public class ThreadSynchronizeed {
    public static void main(String[] args){
        SalesThread3 salesThread = new SalesThread3();
        // run
        // create 4 threads, for simulating the 4 box offices
        new Thread(salesThread, "box office 1").start();
        new Thread(salesThread, "box office 2").start();
        new Thread(salesThread, "box office 3").start();
        new Thread(salesThread, "box office 4").start();
    }
}

class SalesThread3 implements Runnable{
    private int tickets = 20;
    public void run(){
        while (true){
            saleTicket();
        }
    }

    // *** Define a synchronized method : salesTicket
    private synchronized void saleTicket(){
        if (tickets > 0){
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
            + " is selling the " + tickets-- + "ticket");
        }
    }
}
