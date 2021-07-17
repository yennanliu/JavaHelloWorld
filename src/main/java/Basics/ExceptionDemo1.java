package Basics;

// https://www.youtube.com/watch?v=dnOC7KxniZw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=373
// https://www.youtube.com/watch?v=RXPAMZEYEi8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=374

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  Exception :
 *
 *  - "throw" - "get" model
 *
 *  - Process 1 : "throw"
 *      - When program runs, once there is an exception
 *        -> will generate an exception obj at the running code
 *        -> and throw the exception obj (to the program)
 *        -> Once there is an exception, the code below will NOT be run
 *
 *  - Process 2 : "get"
 *      - method that deal with exception
 *          - 1. try-catch-finally
 *          - 2. throws
 *
 *  1)  try-catch-finally
 *    1-1) pattern
 *      try {
 *           // problematic code
 *      } catch (Exception1 exception1){
 *           // code deal with exception1
 *      } catch (Exception2 exception2){
 *           // code deal with exception1
 *      }catch (Exception3 exception3){
 *          // code deal with exception3
 *      } ...
 *      finally {
 *          // code that will runs anyway
 *      }
 *
 *    1-2) finally -> optional
 *    1-3) use "try" to wrap "potential problem" code, once there is an
 *         exception during runtime, will generate an associated exception class
 *         , and match its type with catch, if match, then will run the code
 *         inside catch, once it completed (run code inside catch), it will
 *         jump out of try-catch structure
 *    1-4) we can have multiple "catch" (e.g. try-catch-catch...).
 *         -> If the exceptions (in catch) have NO superclass-subclass relation => the ordering doesn't matter
 *         -> If the exceptions (in catch) HAVE superclass-subclass relation => the ordering DOES matter
 *            -> ordering : subclass first, then super class
 *    1-5) methods we use in catch oftenly
 *         - String getMessage()
 *         - void printStackTrace()
 *    1-6) variables defined in try-catch, CAN'T be used in outside
 *    1-7) try-catch-finally is for "compile" exception
 *        -> make the code can pass compile
 *        -> But, it may STILL has error when runtime
 *        -> via `try-catch-finally`, we delay potential exception to the runtime step
 *    1-8)
 *       - Compiler exception
 *          - use try-catch-finally
 *          - use
 *       - Runtime exception
 *       
 *  2) throws
 *
 */

public class ExceptionDemo1 {
    @Test
    public void test1(){
        String str1 = "123";
        str1 = "abc";
        int num2 = 0;

        try {
            // java.lang.NumberFormatException: For input string: "abc"
            int num = Integer.parseInt(str1);
            num2 = Integer.parseInt(str1);
            System.out.println("*** start"); // NOTE : this command will NOT be run
        } catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println("value transform exception");
        }

        // NOTE : we CAN'T use the var defined in try-catch structure
        //System.out.println(num);

        // but, we can use below trick solve it (above)
        System.out.println("num2 = " + num2);

        System.out.println("*** end"); // NOTE : this command will be run
    }

    // compare :
    @Test
    public void test2(){
        String str1 = "123";
        str1 = "abc";
        try {
            // java.lang.NumberFormatException: For input string: "abc"
            int num = Integer.parseInt(str1);
            System.out.println("*** start"); // NOTE : this command will NOT be run
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("value transform exception");
        }
        System.out.println("*** end"); // NOTE : this command will NOT be run -> SINCE EXCEPTION TYPE IS NOT CORRECT
    }

    @Test
    public void test3() {
        try{
            File file = new File("test.txt");
            FileInputStream fis = new FileInputStream(file);

            int data = fis.read();
            while (data != -1){
                System.out.println((char) data);
                data = fis.read();
            }
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
