package hello;

import org.joda.time.LocalTime;

public class HelloWorld2 {
  public static void main(String[] args) {
    LocalTime currentTime = new LocalTime();
    System.out.println("HelloWorld2 !!!");
    System.out.println("The current local time is: " + currentTime);
    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());
  }
}
