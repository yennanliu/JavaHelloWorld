package Basics;

// https://www.youtube.com/watch?v=U_ho3BRDwsE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=321


/**
 *   static attr can be shared by ALL instances
 */

public class staticDemo5 {
    public static void main(String[] args) {

        // run
        Circle c1 = new Circle();
        Circle c2 = new Circle();

        System.out.println("c1.id = " + c1.getId()); // 1001
        System.out.println("c2.id = " + c2.getId()); // 1002

        System.out.println("total instances = " + Circle.getTotal());

        Circle c3 = new Circle();

        System.out.println("total instances = " + Circle.getTotal());

        Circle c4 = new Circle(9.99);
        System.out.println("c4's area = " + c4.findArea());

        System.out.println("total instances = " + Circle.getTotal());
    }
}

class Circle{
    // static attr
    private static int total; // how many instances created
    private static int init = 1001; // multiple instances share this attr
    // attr
    private double radius;
    private int id;

    // constructor
    public Circle(){
        // first time : 1001
        // second time : 1002
        // ....
        id = init++;

        // first time : 0
        // second time : 1
        // ....
        total++;
    }

    public Circle(double radius){
        // don't forget below
        // V1
        //this();
        // V2
        id = id++;
        total++;
        this.radius = radius;
    }

    /** Note : getter for total is static method (since total is static attr) */
    public static int getTotal() {
        return total;
    }

    public double getRadius() {
        return radius;
    }

    // getter, setter
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // method
    public double findArea(){
        return 3.14 * radius * radius;
    }
}
