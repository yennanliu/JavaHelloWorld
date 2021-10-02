package Advances.ThreadSafety1;

// https://www.youtube.com/watch?v=yB5BP_txa6g&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=431

/**
 *   Implement 3 box offices with Runnable interface (total ticket=100)
 *
 *   Issues
 *    1) duplicated, wrong ticket -> thready safety
 *    2) why we have issues above ?
 *      -> when one thread is doing ticket op (not finished yet); there are the other
 *         threads joining and doing the same op, so tickets are affected
 *         (`private int tickets = 100` is the shared var in this example)
 *
 *   3) how to solve ?
 *      -> when one thread (e.g. : thread1) is doing the op, ALL OF THE OTHER THREADS
 *         CAN'T JOIN, they have to wait till thread (thread1) finish its op, then
 *         the other threads can join and do their op
 */


class WindowR implements Runnable{

    // attr
    // *** NOTE : here, we don't need to set tickets as static
    private int tickets = 100;

    @Override
    public void run() {
        while(true){
            if (tickets > 0){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " sells ticket, ticket num = " + tickets);
                tickets -=1;
            }else{
                break;
            }
        }
    }
}

// entry point
public class BoxOfficeDemo1 {
    public static void main(String[] args) {

        WindowR w1 = new WindowR();

        // *** NOTE : since we create a single instance : WindowR w1 = new WindowR();
        //            and put that into thread
        //            so the threads ARE USING SAME tickets
        //            e.g. all box office sale 100 tickets in total
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("box office 1");
        t2.setName("box office 2");
        t3.setName("box office 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
