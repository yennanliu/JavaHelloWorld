package Basics;

// https://www.youtube.com/watch?v=dDTN4kMptcw&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=227
// // Constructor practice 1

public class Constructor3 {
    public static void  main(String[] args){
        // run 1
        Traingle t1 = new Traingle();
        System.out.println("base = " + t1.getBase() + " height = " + t1.getHeight());

        // run 2
        Traingle t2 = new Traingle();
        t2.setBase(3.0);
        t2.setHeight(7.8);
        System.out.println("base = " + t2.getBase() + " height = " + t2.getHeight());
    }
}


class Traingle{

    // attr
    private double base;
    private double height;

    // constructor
    public Traingle(){ //constructor 1 (no args)
    }

    public Traingle(double b, double h){ //constructor 2 (double b, double h)
        base = b;
        height = h;
    }

    // method
    public void setBase(double b){
        base = b;
    }

    public double getBase(){
        return base;
    }

    public void setHeight(double h){
        height = h;
    }

    public double getHeight(){
        return height;
    }
}