package Advances.DeadLock1;

// https://www.youtube.com/watch?v=g2yVtdnxATk&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=437

/**
 *  Dead Lock Demo 1
 *
 *  1) dead lock : different threads occupy resources needed by each other
 *                 , both of them (2 threads for example) are waiting
 *                 resources releasing from each other (e.g. synchronized lock).
 *                 we call this situation as `thread dead lock`
 *
 *  2) we MUST AVOID dead lock when we use synchronized values in threading
 *
 */

public class demo1 {
    // entry point
    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        /** thread 1 */
        new Thread(){

            // NOTE : we have 2 synchronized locks here (s1, s2) (s1 first)
            @Override
            public void run(){

                synchronized (s1) {
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized(s2){
                        s1.append("b");
                        s2.append("2");

                        System.out.println("s1 = " + s1);
                        System.out.println("s2 = " + s2);
                    }
                }
            }
        }.start();

       /** thread 2 */
       new Thread(new Runnable() {

           // NOTE : we have 2 synchronized locks here (s1, s2) (s2 first)
           @Override
           public void run() {

               synchronized (s2) {
                   s1.append("c");
                   s2.append("3");

                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

                   synchronized(s1){
                       s1.append("d");
                       s2.append("4");

                       System.out.println("s1 = " + s1);
                       System.out.println("s2 = " + s2);
                   }
               }
           }
       }
      ).start();
    }
}
