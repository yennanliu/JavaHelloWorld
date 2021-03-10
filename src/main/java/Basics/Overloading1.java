package Basics;

// https://www.youtube.com/watch?v=DIJ4V5u-Of0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=204

// example : BinarySearch, sort, ....


public class Overloading1 {
    public static void main(String[] args){
        // run
        OverloadingClass1 overload_c = new OverloadingClass1();
        System.out.println(overload_c.myPrint("yayaya"));
        System.out.println(overload_c.myPrint(100));
    }
}


class OverloadingClass1{

    public String myPrint(String s) {
        return  "this is String print !!! " + s;
    };

    public String myPrint(Integer i) {
        return  "this is Integer print !!!  " + i.toString();
    };
}