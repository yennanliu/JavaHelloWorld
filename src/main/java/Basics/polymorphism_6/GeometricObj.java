package Basics.polymorphism_6;

// https://www.youtube.com/watch?v=Isy72aKb6Z0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=291

public class GeometricObj {
  // attr
  protected String color;

  protected double weight;

  // constructor
  public GeometricObj(String color, double weight) {
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
  public double findArea() {
    return 0.0;
  }
}
