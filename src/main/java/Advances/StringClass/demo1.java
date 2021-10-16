package Advances.StringClass;

// https://www.youtube.com/watch?v=oYiiHgy3oRQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=450
// https://www.youtube.com/watch?v=mAprBYuW9uc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=450

import org.junit.jupiter.api.Test;

/**
 *  String class demo 1
 */

// demo via junit
public class demo1 {
    /**
     *  String: example : `xxx`
     *
     *  1) String is `final`, CAN NOT BE INHERITED
     *
     *  2) String implements Serializable interface -> support serialization:
     *      -> can be transmitted (e.g. via flow via internet)
     *
     *  3) String implements Deserializable interface:
     *     -> can be transmitted (e.g. via flow via internet)
     *
     *  4) String implements Comparable interface:
     *     -> can be compared (bigger or smaller)
     *
     *  5) String defines `final char[] value` for string data storage
     *
     *  6) String is unchangeable (CAN NOT BE modified)
     *
     *     - 6-1) when we re-assign value to a string
     *        java will re-assign a new address for it (string)
     *        but NOT reuse the original address
     *
     *     - 6-2) when concatenate string, the address will be re-assigned
     *
     *     - 6-3) when use String's replace() method, the address will be re-assigned
     *
     *  7) when via `literal` (not `new`) giving value to a string,
     *     the string is storage in the "string constant pool"
     *
     *  8) "string constant pool" DOES NOT storage duplicated values
     *
     */
    @Test
    public void test1(){
        /**
         * We don't need to `new` when create a new String
         *
         *  -> s1, s2 are actually using the SAME address
         */
        String s1 = "abc"; // literal (No need to `new` when create a new one)
        String s2 = "abc";

        // compare s1, s2's address
        System.out.println(s1==s2); // true

        s1 = "hello";

        System.out.println("s1 = " + s1 );
        System.out.println("s2 = " + s2 );

        System.out.println(s1==s2); // false

        System.out.println("===================");

        String s3 = "abc";
        s3 += "def";

        System.out.println("s3 = " + s3); // abcdef (address will be re-assigned)
        System.out.println("s2 = " + s2 );

        System.out.println("===================");

        String s4 = "abc";
        String s4_ =  s4.replace("a", "?");

        System.out.println("s4 = " + s4 );
        System.out.println("s4_ = " + s4_ );
    }
}
