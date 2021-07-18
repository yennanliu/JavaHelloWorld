package Basics.ExceptionDemo5;

// https://www.youtube.com/watch?v=MlPACzQi8TA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=378

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *   Method override
 *
 *   1) exception from overwritten method in subclass
 *      should be "smaller" than the exception from
 *      method in superclass
 */

public class OverrideTest {

    public static void main(String[] args) {
        // run
        OverrideTest test = new OverrideTest();
        test.display(new SubClass());
    }

    public void display(SuperClass s){
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SuperClass{

    public void method() throws IOException {

    }
}

class SubClass extends SuperClass {
    @Override
    public void method() throws FileNotFoundException { // FileNotFoundException is "smaller" than IOException. So it's OK

    }
}
