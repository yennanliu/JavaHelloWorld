package Basics;

// https://www.youtube.com/watch?v=kA42AuUDWJY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=374
// https://www.youtube.com/watch?v=u9Jz6ja8GiU&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=376

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
 *
 *    5) we can have 1 try-catch-finally in the other try-catch-finally
 *       ... and so on
 *
 *    6) we can use try-catch-finally to delay potential exception in compile to runtime
 *
 *    7) In regular cases, we only do the " try-catch-finally" for exception in compile,
 *       but we do NOTHING for the exception in runtime
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

    @Test
    public void test4(){
        // NOTE : this trick
        // -> we declare fis first,
        //    so if it's failed in try-catch
        //    we can still use it in finally
        FileInputStream fis = null;
        try {
            File file = new File("test.txt");
            fis = new FileInputStream(file);

            int data = fis.read();
            while (data != -1){
                System.out.println((char) data);
                data = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)  // if File file = new File("test.txt"); failed
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
