package Basics;

// https://www.youtube.com/watch?v=X1HoGjmGPPo&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=205

public class Overloading2 {
    public static void main(String[] args){
        // run
        OverloadingClass2 overload_c = new OverloadingClass2();
        overload_c.getSum(1,2);
        overload_c.getSum(1.2, 2.1);
        overload_c.getSum("xxx", 2);
        overload_c.getSum(1, "yyy");
    }
}


class OverloadingClass2 {
    // below are the overloading methods
    public void getSum(int i, int j){
        System.out.println(i + j);
    }

    public void getSum(double d1, double d2){
        System.out.println(d1 + d2);
    }

    public void getSum(String s, int j){
        System.out.println("getSum(String s, int j");
    }

    public void getSum(int i, String s){
        System.out.println("getSum(int i, String s)");
    }
}