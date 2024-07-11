package Basics;

// https://www.youtube.com/watch?v=qXb8Z9cjcDk&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=351
// https://www.youtube.com/watch?v=rM2f0mTie_Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=352

interface Flyable2 {

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

interface Attackable2 {
  void attack();
}

interface AA_ {
  void method1();
}

interface BB_ {
  void method2();
}

// interface's multiple inheritance
interface CC_ extends AA_, BB_ {}

/**
 * Interface part 2
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
 *
 * <p>6) in Java, we can implement multiple interfaces -> complement that java only have SINGLE
 * inheritance -> class Bullet implements Flyable, Attackable (check below) -> pattern : class AA
 * extends BB implement CC, DD, EE (inheritance -> implementation)
 *
 * <p>7) relationships
 *
 * <p>7.1) interface ----implementation --> class 7.2) class ----inheritance --> class 7.3)
 * interface ----inheritance --> interface -> example : interface CC_ extends AA_, BB
 *
 * <p>8) interface uses the mindset of polymorphism
 *
 * <p>9) interface is like a "rule", "standard", "format" -> that everyone needs to follow ->
 * (implemented by class)
 *
 * <p>10) interface VS abstract class ?
 */
public class interfaceDemo2 {
  public static void main(String[] args) {
    // run
    System.out.println(Flyable2.MAX_SPEED);
    System.out.println(Flyable2.MIN_SPEED);

    // Cannot assign a value to final variable 'MIN_SPEED'
    // Flyable.MIN_SPEED = 999;

    System.out.println("==============");

    Plane2 p1 = new Plane2();
    p1.fly();
    p1.stop();
  }
}

class Plane2 implements Flyable2 {

  @Override
  public void fly() {
    System.out.println("plane can fly !!!");
  }

  @Override
  public void stop() {
    System.out.println("plane can stop !!!");
  }
}

abstract class Kite2 implements Flyable2 {

  @Override
  public void fly() {}
}

class Bullet2 implements Flyable2, Attackable2 {

  @Override
  public void attack() {}

  @Override
  public void fly() {}

  @Override
  public void stop() {}
}

class Bullet3 extends Object implements Flyable2, Attackable2, CC_ {

  @Override
  public void fly() {}

  @Override
  public void stop() {}

  @Override
  public void attack() {}

  @Override
  public void method1() {}

  @Override
  public void method2() {}
}
