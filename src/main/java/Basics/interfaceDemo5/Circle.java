package Basics.interfaceDemo5;

// https://www.youtube.com/watch?v=LfIyZ-iAJyE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=357

public class Circle {
    // attr
    private Double radius; // NOTE here : double -> Double

    // constructor
    public Circle(){
        super();
    }

    public Circle(Double radius){ // NOTE here : double -> Double
        super();
        this.radius = radius;
    }

    // getter, setter
    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    } // NOTE here : double -> Double
}
