package Basics.objectDemo2;

// https://www.youtube.com/watch?v=yHBFLvnIM4E&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=301

public class GeometricObject {
  // attr
  protected String color;
  protected double weight;

  // constructor
  public GeometricObject() {
    super();
    this.color = "white";
    this.weight = 1.0;
  }

  public GeometricObject(String color, double weight) {
    super();
    this.color = color;
    this.weight = weight;
  }

  // getter, setter
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  // method
}
