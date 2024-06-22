package Basics.FactoryDemo2;

// https://www.youtube.com/watch?v=aPXVO4ELqVA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=355

/** Design pattern - Factory : Factory method */

/** factory interface */
interface CarFactory {
  Car getCar();
}

// 2 factory class
class AudiFactory implements CarFactory {
  @Override
  public Audi getCar() {
    return new Audi();
  }
}

class LexusFactory implements CarFactory {
  @Override
  public Lexus getCar() {
    return new Lexus();
  }
}
