package Basics.polymorphism_6;

// https://www.youtube.com/watch?v=Isy72aKb6Z0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=291

public class Circle extends GeometricObj {

    // attr
    private double radius;

    // constructor
    // this constructor is necessary,
    // since there is no such constructor (Circle) in superclass (GeometricObj)
    public Circle(double radius, String color, double weight) {
        super(color, weight);
        this.radius = radius;
    }

    // getter, setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // method
    @Override
    public double findArea(){
        return 3.14 * radius * radius;
    }
}
