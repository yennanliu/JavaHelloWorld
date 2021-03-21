package Basics;

// https://www.youtube.com/watch?v=31dB1z78tvI&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=215

public class Recursion1 {
    public static void main(String[] args){

        // example : calculate 1-100 sum
        // run 1
        int sum = 0;
        for ( int i = 1; i <= 100 ; i++ ){
            sum += i;
        }
        System.out.println("sum = " + sum);

        System.out.println("===================");

        // run 2 (via recursion)
        // 1+ (1+1) + (1+1+1) +.... (1+1..1)
        Recursion1 test = new Recursion1();
        int sum_2 = test.getSum(100);
        System.out.println("sum_2 = " + sum_2);

    }

    public int getSum(int n){
        if (n == 1){
            return 1;
        } else {
            return n + getSum(n-1);
        }
    }
}
