package Basics.interfaceDemo4;

// https://www.youtube.com/watch?v=LfIyZ-iAJyE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=357

public class Circle {
  // attr
  private double radius;

  // constructor
  public Circle() {
    super();
  }

  public Circle(double radius) {
    super();
    this.radius = radius;
  }

  // getter, setter
  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }
}
