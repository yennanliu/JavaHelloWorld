package Advances.ThreadSafety1;

// https://www.youtube.com/watch?v=A_mB0jxIrgo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=433

/**
 *  Implement 3 box offices with Thread class (total ticket=100)
 *
 *  - solve the thread safety via "Synchronized code block"
 *
 *
 *
 *
 */

class Thread_T extends Thread {

    // attr
    // **** NOTE : WE NEED TO SET TICKET AS static attr
    //             since we want box offices sell 100 tickets in total
    //             rather than sell 100 tickets by each of them
    private static int tickets = 100;

    // the object for `lock` (synchronized monitor)
    // NOTE : we need to make obj as `static` here,
    //        since we instantiate the Thread_T 3 times
    //        (we make obj as shared object via `static`)
    static Object obj = new Object();

    // method
    @Override
    public void run() {

        while(true){

            synchronized (obj){

                if (tickets > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " sells ticket, ticket num = " + tickets);
                    tickets -=1 ;
                }else{
                    break;
                }
            }
        }
    }
}

// entry point
public class BoxOfficeDemo2 {
    public static void main(String[] args) {

        Thread_T b1 = new Thread_T();
        Thread_T b2 = new Thread_T();
        Thread_T b3 = new Thread_T();

        b1.setName("box office 1");
        b2.setName("box office 2");
        b3.setName("box office 3");

        b1.start();
        b2.start();
        b3.start();
    }
}