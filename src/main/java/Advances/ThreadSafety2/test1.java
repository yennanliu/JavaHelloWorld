package Advances.ThreadSafety2;

// https://www.youtube.com/watch?v=vx97FYJ3VvA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=438

/**
 *   Solve thread safety method 3 -- Lock (new since JDK 5.0)
 *
 *
 *
 *
 *
 *
 *  ps : list of ways solve thready safety:
 *      - synchronized method
 *      - synchronized code block
 *      - lock
 */

class Window implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket > 0){

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " sells ticket, ticket num = " + ticket);
                ticket -=1 ;
            }else{
                break;
            }
        }
    }
}


// entry point
public class test1 {
    public static void main(String[] args) {
        // run
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("window 1");
        t2.setName("window 2");
        t3.setName("window 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
