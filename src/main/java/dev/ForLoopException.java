package dev;

public class ForLoopException {
    public static void main(String[] args){
        System.out.println("ForLoopException !!!");
        try{
            for (int i = 0; i < 10; i++){
                //System.out.println(i);
                // will get an exception here : java.lang.ArithmeticException: / by zero
                System.out.println(10/i);
            }
        } catch (Exception e){
            System.out.println("ForLoopException failed..");
            e.printStackTrace();
        }
    }
}
