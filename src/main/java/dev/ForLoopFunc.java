package dev;

public class ForLoopFunc {
    public static void main(String[] args){
        System.out.println("ForLoopFunc !!!");
        try{
            //RunForLoop.run(20);
            // will get the java.lang.ArithmeticException: / by zero exception
            RunForLoop.run(20/0);
        } catch (Exception e){
            System.out.println("ForLoopFunc failed");
            e.printStackTrace();
        }
    };
}

class RunForLoop{
    static void run(int x){
        for (int i = 0; i < x; i++){
            System.out.println(i);
        }
    }
    
}


