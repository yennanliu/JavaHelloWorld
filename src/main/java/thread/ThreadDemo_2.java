package thread;

class TicketWindow extends Thread{
    private int tickets = 100;

    // re-write run method in Thread
    public void run(){
        while (true){
            System.out.println(Thread.currentThread().getName() +
                    " now selling the " + tickets + "ticket now");
        }
    }
}

public class ThreadDemo_2 {
    public static void main(String[] args){
        // will create 4 thread objects to simulate the 4 box offices
        new TicketWindow().start();
        new TicketWindow().start();
        new TicketWindow().start();
        new TicketWindow().start();
    }
}
