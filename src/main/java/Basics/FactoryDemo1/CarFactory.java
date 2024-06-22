package Basics.FactoryDemo1;

// https://www.youtube.com/watch?v=aPXVO4ELqVA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=355

/**
 * Design pattern - Factory : Simple Factory
 *
 * <p>1) xxxFactory -> this is class is for instantiating class
 */
public class CarFactory {

  // method 1
  public static Car getCar(String type) {
    if ("Audi".equals(type)) {
      return new Audi();
    } else if ("Lexus".equals(type)) {
      return new Lexus();
    } else {
      return null;
    }
  }

  // method 2
  //    public static Car getAudi() {
  //        return new Audi();
  //    }
  //
  //    public static Car getLexus(){
  //        return new Lexus();
  //    }
}
