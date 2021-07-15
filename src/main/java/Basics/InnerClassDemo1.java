package Basics;

// https://www.youtube.com/watch?v=D0SB2HNdxvQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=360
// https://www.youtube.com/watch?v=qjGy50cSiCQ&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=362

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
 *  3) inner local class (成員內部類)
 *    - 3-1) As an inner local class
 *       3-1-1) can use external structure
 *       3-1-2) can be decorated by static
 *       3-1-3) can be decorated by 4 different permissions
 *    - 3-2) As a class
 *       3-2-1) can define attr, method, constructor ..
 *       3-2-2) can be decorated by `final` ; if not decorated by final -> can be inherited
 *       3-2-3) can be decorated by `abstract`
 *
 *  4) Note : below questions
 *     4-1) how to instantiate object inside inner local class ?
 *     4-2) how to use external structure inside inner local class ?
 *     4-3) in development, how to use local class ?
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
