package Basics.polymorphism_6;

// https://www.youtube.com/watch?v=Isy72aKb6Z0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=291

public class GeometricTest {
  public static void main(String[] args) {
    // run test 1

    // *** Note : we need to instantiate the object here
    GeometricTest test = new GeometricTest();

    Circle c1 = new Circle(2.3, "blu", 1.0);
    test.displayGeometricObj(c1); // polymorphism

    System.out.println("==============");

    Circle c2 = new Circle(2.3, "gray", 200.0);
    test.displayGeometricObj(c2); // polymorphism

    System.out.println("==============");

    boolean isEquals = test.equalsArea(c1, c2);
    System.out.println("c1, c2 isEquals = " + isEquals);

    System.out.println("==============");

    // run test 2
    MyRectangle rec1 = new MyRectangle(7.0, 8.0, "red", 10);

    MyRectangle rec2 = new MyRectangle(70.0, 8.0, "red", 10);

    test.displayGeometricObj(rec1);

    test.equalsArea(rec1, rec2);
  }

  // method
  public boolean equalsArea(GeometricObj o1, GeometricObj o2) { // polymorphism
    return o1.findArea() == o2.findArea();
  }

  public void displayGeometricObj(GeometricObj o) {
    System.out.println("Area = " + o.findArea());
  }
}
