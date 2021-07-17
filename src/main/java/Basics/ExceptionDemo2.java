package Basics;

// https://www.youtube.com/watch?v=kA42AuUDWJY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=374

import org.junit.jupiter.api.Test;

/**
 *   Exception 2
 *    - finally using
 *
 *   plz ref : https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Basics/ExceptionDemo1.java
 *
 *   ...
 *
 *    1) pattern
 *        try {
 *             // problematic code
 *        } catch (Exception1 exception1){
 *             // code deal with exception1
 *        } catch (Exception2 exception2){
 *             // code deal with exception1
 *        }catch (Exception3 exception3){
 *            // code deal with exception3
 *        } ...
 *        finally {
 *            // code that will runs anyway
 *        }
 *
 *    2) finally is optional
 *    3) code inside finally
 *       -> will be RUN anyway, even though there is an exception or return
 *
 *    4) `finally` use case ?
 *        (JVM can't auto do below, so we need to close then manually)
 *       - file IO close
 *       - DB connection close
 *       - socket close
 *       - ....
 */

public class ExceptionDemo2 {

    @Test
    public void test1(){
        try{
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("*** test1 program end");
        }
    }

    @Test
    public void test2(){
        try{
            int a = 10;
            int b = 0;
            System.out.println(a / b);
            //return 123;
        }catch (ArithmeticException e){

            e.printStackTrace();

            int[] arr = new int[10];
            System.out.println(arr[11]);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("*** test2 program end");
        }
    }

    @Test
    public void test3(){
        int num = method();
        System.out.println("num = " + num);
    }

    public int method(){
        try{
            int[] arr = new int[10];
            System.out.println(arr[11]);
            return 1;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return 2;
        }finally {
            System.out.println("*** test3 program end");
            //return 3;  // <-- will return 3 if uncomment it
        }
    }
}
