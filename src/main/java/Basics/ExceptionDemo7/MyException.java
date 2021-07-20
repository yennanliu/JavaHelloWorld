package Basics.ExceptionDemo7;

// https://www.youtube.com/watch?v=TJuq8kZiN9U&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=381

/**
 *  User Defined Exception
 *
 *   1) how to define our own exception ?
 *
 *     step 1) inherit from default exception class
 *         -> e.g. RuntimeException, Exception
 *         (RuntimeException : runtime exception)
 *         (Exception : runtime exception, need explicitly implementation)
 *
 *    step 2) offer a global constant : serialVersionUID (class ID for serialization)
 *
 *    step 3) offer an overloaded constructor
 *
 */

public class MyException extends RuntimeException{

    // attr
    static final long serialVersionUID = -70348971907353L;

    // constructor
    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }

    // method
}
