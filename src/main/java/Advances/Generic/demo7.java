package Advances.Generic;

// https://www.youtube.com/watch?v=UhgmcVG05qA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=574

import java.util.List;
import org.junit.jupiter.api.Test;

/** generic type with limited condition
 *
 *    1) ? extends A:
 *      -> G<? extends A> : can be G<A>, and G<B>'s super class, B is A's sub class
 *
 *    2)? super Student2:
 *      -> G<? super A> : can be G<A>, and G<B>'s super class, B is A's super class
 *
 */
public class demo7 {
    @Test
    public void test1(){

        // extends : "<="
        List<? extends Student2> list1 = null;

        // super : ">="
        List<? super Student2> list2 = null;

        List<Student> list3 = null;
        List<Student2> list4 = null;
        List<Object> list5 = null;

        // assign values
        //list1 = list3;
        //list1 = list4;
        //list1 = list5;
    }
}

