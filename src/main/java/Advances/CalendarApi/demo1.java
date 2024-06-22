package Advances.CalendarApi;

// https://www.youtube.com/watch?v=aPgJYCIc-fM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=482


/** CalendarApi demo1 :
 *
 *  Calendar class use class intro
 */

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 *   1) Calendar is an abstract class
 *
 *   2) there are 2 ways to instantiate it
 *
 *      - 2-1) create its sub-class' class (GregorianCalendar)
 *      - 2-2) call its static method : getInstance()
 *
 *      // these 2 methods are the same actually
 *
 *   3) frequent used methods
 *
 *      - 3-1) get()
 *      - 3-2) set()
 *      - 3-3) add()
 *      - 3-4) getTime()
 *      - 3-5) setTime()
 */
public class demo1 {

    @Test
    public void test1(){
        // 2-2) call its static method : getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass()); // still class java.util.GregorianCalendar
    }

    @Test
    public void test2(){
        Calendar calendar = Calendar.getInstance();

        // get()
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));

        System.out.println("--------------------------");

        // set() : change DAY_OF_MONTH or ... in Calendar
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        System.out.println("--------------------------");

        // add()
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        System.out.println("--------------------------");

        // getTime() : Calendar dtype -> Date dtype
        Date date = calendar.getTime();
        System.out.println(date);

        System.out.println("--------------------------");

        // setTime() : Date dtype -> Calendar dtype
        Date date1 = new Date();
        calendar.setTime(date1); // set calendar from date1
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
