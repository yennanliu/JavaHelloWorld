package Advances.DateTimeApi;

// https://www.youtube.com/watch?v=Phw5yXG4dHM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=467

/** DateTimeApi demo1 : DateTime API before JDK 8 */


import org.junit.jupiter.api.Test;

public class demo1 {

    // currentTimeMillis in System class
    @Test
    public void test1(){
        // unit : milliSecond
        // will return time difference rom 1980/1/1 0 hr 0 min 0 sec and current time
        System.out.println(System.currentTimeMillis());
    }
}
