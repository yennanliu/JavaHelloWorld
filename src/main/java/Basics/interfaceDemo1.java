package Basics;

// https://www.youtube.com/watch?v=RbSnqxlIuik&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=350

interface Flyable {

  // attr
  // global constant
  int MAX_SPEED = 100;
  // public static final int MIN_SPEED = 1;
  // or, can write as below
  int MIN_SPEED = 1; // omit public static final

  // method
  void fly();

  void stop(); // omit public abstract
}

/**
 * Interface part 1
 *
 * <p>1) use keyword "interface" 2) in java, interface, and class are the structure in the same
 * level 3) how to define interface ? elements inside interface ? 3.1) JDK 7 and before -> can ONLY
 * use global constant and abstract method -> global constant : public static final (public static
 * final can be omitted) -> abstract method : public abstract (public abstract can be omitted) 3.2)
 * JDK 8 and after -> can HAVE global constant, abstract method, static method, default method
 *
 * <p>4) CAN NOT define constructor in interface -> interface CAN NOT be instantiated
 *
 * <p>5) in java, we usually use CLASS to "implement" interface (not extend) -> if class implements
 * all abstract methods in interface -> this class can be instantiated -> if class NOT implement all
 * abstract methods in interface -> this class CAN NOT be instantiated
 */
public class interfaceDemo1 {
  public static void main(String[] args) {
    // run
    System.out.println(Flyable.MAX_SPEED);
    System.out.println(Flyable.MIN_SPEED);

    // Cannot assign a value to final variable 'MIN_SPEED'
    // Flyable.MIN_SPEED = 999;

    System.out.println("==============");

    Plane p1 = new Plane();
    p1.fly();
    p1.stop();
  }
}

class Plane implements Flyable {

  @Override
  public void fly() {
    System.out.println("plane can fly !!!");
  }

  @Override
  public void stop() {
    System.out.println("plane can stop !!!");
  }
}

abstract class Kite implements Flyable {

  @Override
  public void fly() {}
}
