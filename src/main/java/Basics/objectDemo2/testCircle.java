package Basics.objectDemo2;

// https://www.youtube.com/watch?v=yHBFLvnIM4E&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=301


public class testCircle {

  public static void main(String[] args) {
    Circle c1 = new Circle(2.9);
    Circle c2 = new Circle(2.9);
    Circle c3 = new Circle(2.9, "blu", 2.0);
    Circle c4 = new Circle(3, "black", 3.0);

    // check if circle are the same
    // Note : use equals for reference type comparision
    System.out.println("Check if color same : " + c1.getColor().equals(c2.getColor()));

    System.out.println("Check if radius same : " + c1.equals(c2));

    System.out.println("Print circle as string : " + c1);
    System.out.println("Print circle as string : " + c3);
  }
}
