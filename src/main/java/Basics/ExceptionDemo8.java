package Basics;

// https://www.youtube.com/watch?v=SE6hBkP7Xog&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=382

public class ExceptionDemo8 {
    public static void main(String[] args) {
        /**
         *  expected output :
         *
         *  into method A
         *  finally (method A)
         *  exception ! (method A)
         *  into method B
         *  finally (method B)
         */

        ReturnExceptionDemo returnExceptionDemo = new ReturnExceptionDemo();
        try{
            returnExceptionDemo.methodA();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        returnExceptionDemo.methodB();
    }
}

class ReturnExceptionDemo {

    static void methodA(){
        try{
            System.out.println("into method A");
            throw new RuntimeException("exception ! (method A)");
        }finally {
            System.out.println("finally (method A)");
        }
    }

    static void methodB(){
        // NOTE : there is no `catch` here
        try{
            System.out.println("into method B");
            return;
        }finally {
            System.out.println("finally (method B)");
        }
    }
}