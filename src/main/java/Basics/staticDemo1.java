package Basics;

// https://openhome.cc/Gossip/Java/Static.html
// https://www.geeksforgeeks.org/static-methods-vs-instance-methods-java/
// https://www.javatpoint.com/static-keyword-in-java#:~:text=A%20static%20method%20belongs%20to,change%20the%20value%20of%20it.

public class staticDemo1 {
  public static void main(String[] args) {

    // run 1
    System.out.println("staticDemo1");
    // no need to "new Ball", but can use Ball's value/method directly
    System.out.println(Ball.PI);

    // run 2
    System.out.println(User.counter);
    // "static" value is "unique" in the heap space,
    // so every change will change the "same" value from heap space
    User.counter += 1;
    System.out.println(User.counter);
    User.counter += 1;
    System.out.println(User.counter);
    User.counter += 1;
    System.out.println(User.counter);
  }
}

// define some classes
class Ball {
  static final double PI = 3.14;
  double radius;
}

class User {
  static Integer counter = 0;
}
