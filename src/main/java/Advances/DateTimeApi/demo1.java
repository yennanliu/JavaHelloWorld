package Advances.DateTimeApi;

// https://www.youtube.com/watch?v=Phw5yXG4dHM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=467
// https://www.youtube.com/watch?v=xgCcuk6RGJo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=469

/** DateTimeApi demo1 :
 *     DateTime API before JDK 8
 *      - basic constructors
 *      - basic methods
 */

import org.junit.jupiter.api.Test;

import java.util.Date;

public class demo1 {

    /** currentTimeMillis in System class */
    @Test
    public void test1(){
        // unit : milliSecond
        // will return time difference between `1980/1/1 0 hr 0 min 0 sec` and now
        System.out.println(System.currentTimeMillis());
    }

    /**
     *   java.util.Date class
     *      |--- java.sql.Date class
     *
     *   1) 2 constructors
     *      - Date() : create an Date() instance of CURRENT TIME
     *      - Date(someTimeStamp) : create an Date() instance of `given timestamp`
     *
     *   2) 2 methods
     *      - toString() : show current year, month, day, hour, min, sec
     *      - getTime(): get current timeStamp (milliSecond) (e.g. time difference between `1980/1/1 0 hr 0 min 0 sec` and now)
     *
     *   3) java.sql.Date class is for datetime objects in database
     *      - how to instantiate ?
     *      - transform java.util.Date to java.sql.Date ?
     */
    @Test
    public void test2(){
        // constructor1 : Date()
        //              -> create an Date() instance of CURRENT TIME
        Date date1 = new Date();  // java.util.Date
        System.out.println(date1.toString()); // Sun Nov 07 08:21:46 CST 2021
        System.out.println(date1.getTime()); // 1636244580892 (milliSecond)

        System.out.println("================");

        // constructor2 : Date(year, month, date, hr, min)  (this constructor is depreciated)
        //              -> create an Date() instance with year, month, date, hr, min
        Date date2 = new Date(2021,11,01,01,00);
        System.out.println(date2.toString()); // Thu Dec 01 01:00:00 CST 3921
        System.out.println(date2.getTime()); // 61596435600000 (milliSecond)

        System.out.println("================");

        // constructor3 : Date(someTimeStamp)
        //              -> create an Date() instance of `given timestamp`
        Date date3 = new Date(1636244580892L);
        System.out.println(date3.toString()); // Sun Nov 07 08:23:00 CST 2021
        System.out.println(date3.getTime()); // 1636244580892 (milliSecond)
    }

    /** java.sql.Date demo */
    @Test
    public void test3(){
        // create a java.sql.Date object
        java.sql.Date sql_date1 =  new java.sql.Date(1636244580892L);
        System.out.println(sql_date1.toString()); // 2021-11-07
        System.out.println(sql_date1.getTime()); // 1636244580892

        System.out.println("================");

        // transform java.util.Date to java.sql.Date
        Date date1 = new Date(1636244580892L);

        //java.sql.Date date_1_ = (java.sql.Date) date1; // wrong, Date is not java.sql.Date 's parent class

        /** NOTE here !!! */
        // so we get date1's timestamp via getTime() method, then put the output into java.sql.Date constructor
        java.sql.Date date_1_1 = new java.sql.Date(date1.getTime());
        System.out.println(date_1_1);
    }
}
