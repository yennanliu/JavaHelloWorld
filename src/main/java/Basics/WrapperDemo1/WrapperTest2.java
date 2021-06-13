package Basics.WrapperDemo1;

// https://www.youtube.com/watch?v=hR92BihwlyI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=304

import org.junit.jupiter.api.Test;

public class WrapperTest2 {

    /** wrapper -> basic type */
    // call wrapper class's xxxValue()
    @Test
    public void test1(){
        Integer in1 = new Integer(12);
        int in1_ = in1.intValue(); // intValue

        System.out.println(in1);
        System.out.println(in1_);

        Float f1 = new Float(12.3);
        float f1_ = f1.floatValue();

        System.out.println(f1);
        System.out.println(f1_);
    }
}
