package Advances.ThreadDemo5;

// https://www.youtube.com/watch?v=BZCBBSGPTXk&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=422

/**
 *  Example :
 *      set up 3 box offices selling tickets,
 *      100 tickets in total
 */

class BoxOffice extends Thread {

    // attr
    // **** NOTE : WE NEED TO SET TICKET AS static attr
    //             since we want box offices sell 100 tickets in total
    //             rather than sell 100 tickets by each of them
    private static int ticket = 100;

    // method
    @Override
    public void run() {
        while(true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + " sells ticket, ticket num = " + ticket);
                ticket -=1 ;
            }else{
                break;
            }
        }
    }
}

// entry point
public class BoxOfficeDemo {
    public static void main(String[] args) {

        BoxOffice b1 = new BoxOffice();
        BoxOffice b2 = new BoxOffice();
        BoxOffice b3 = new BoxOffice();

        b1.setName("box office 1");
        b2.setName("box office 2");
        b3.setName("box office 3");

        b1.start();
        b2.start();
        b3.start();
    }
}
