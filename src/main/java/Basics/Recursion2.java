package Basics;

// https://www.youtube.com/watch?v=u67ck68saSs&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=215

public class Recursion2 {
    public static void main(String[] args){
        // run
        Recursion2 test = new Recursion2();
        int r = test.getFactorial(3);
        System.out.println("getFactorial = " + r);
    }

    public int getFactorial(int n){
        System.out.println("*** n = " + n ); //" getFactorial(n-1) = " +  getFactorial(n-1));

        if (n == 0 || n < 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            return n * getFactorial(n-1);
        }
    }
}