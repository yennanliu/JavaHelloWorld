package Basics.objectDemo2;

// https://www.youtube.com/watch?v=yHBFLvnIM4E&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=301

public class Circle extends GeometricObject {
  // attr
  private double radius;

  // constructor
  public Circle() {
    super();
    radius = 1.0;
    // below already covered by super() -> no necessary
    // color = "white";
    // weight = 2.0;
  }

  public Circle(double radius) {
    super();
    this.radius = radius;
  }

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
  public double findArea() {
    return 3.14 * radius * radius;
  }

  // overwrite equals() method
  // only need to consider radius
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj instanceof Circle) {
      Circle c = (Circle) obj;
      return this.radius == c.radius;
    }
    return false;
  }

  // overwrite ToString() method
  @Override
  public String toString() {
    return "Circle{ " + "radius=" + radius + " }";
  }
}
