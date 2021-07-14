package Basics;

// https://www.youtube.com/watch?v=D0SB2HNdxvQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=360

/**
 *  Inner Class
 *
 *  1) Java allows to have class A inside the other class B
 *      -> so class A is class B 's inner class
 *
 *  2) Inner class type
 *    2-1) inner local class (成員內部類)
 *      - static
 *      - non-static
 *    2-2) local class (局部內部類)
 *
 */


public class InnerClassDemo1 {
    public static void main(String[] args) {

    }
}

class Person_inner{
    // attr

    // inner local class (成員內部類)
    static class Cat {

    }

    class Bird {

    }

    // method
    public void method(){
        class AA { //  local class (局部內部類)

        }
    }

    // code block
    {
        class BB { // local class (局部內部類)

        }

    }

    // constructor
    public Person_inner(){
        class CC { // local class (局部內部類)

        }
    }
}
