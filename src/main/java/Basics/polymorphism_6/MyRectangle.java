package Basics.polymorphism_6;

// https://www.youtube.com/watch?v=Isy72aKb6Z0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=291

public class MyRectangle extends GeometricObj {
    // attr
    private double width;
    private double height;

    // constructor
    public MyRectangle(double width, double height, String color, double weight) {
        super(color, weight);
        this.width = width;
        this.height = height;
    }

    // getter, setter
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // method
    @Override
    public double findArea(){
        return width * height;
    }
}
