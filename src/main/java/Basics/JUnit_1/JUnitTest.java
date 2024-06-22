package Basics.JUnit_1;

import org.junit.jupiter.api.Test;

// https://www.youtube.com/watch?v=O1XnFHdsjYU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=302

/**
 *   JUnit unit test in Java
 *
 *   Steps :
 *
 *   1) add library -> JUnit (JUnit4)
 *      - for intelliJ : https://www.jetbrains.com/help/idea/library.html#lib_levels
 *
 *   2) create a java class for unit test
 *      - requirement of the java class
 *          - 1. public class
 *          - 2. offers a public non param constructor (use default is OK)
 *          - 3. implement the unit test method in the class -> public method, NO param, and WITHOUT return value
 *
 *   3) need to add @Test over the test method, and import the corresponding library
 *
 *   4) after creating the test method, write the test code
 *
 *   5) after finishing the test code -> click "run JUnit test"
 *
 *   6) if there is no exception -> green
 *      else -> red, and with error/exception msg
 */

// class for unit test
public class JUnitTest {

    // test method
    @Test
    public void testEquals(){
        String s1 = "KK";
        String s2 = "KK";

        System.out.println(s1.equals(s2));
    }

//    @Test
//    public void testDownCasting(){
//        Object obj = new String ("XX");
//        Date date = (Date) obj;
//    }

    @Test
    public void testToString(){
        String s1 = "KK";
        System.out.println(s1.toString());
    }
}
