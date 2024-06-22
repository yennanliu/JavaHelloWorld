package Basics.instanceof_1;

// https://www.youtube.com/watch?v=kQtKcNX4O44&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=287
// https://www.youtube.com/watch?v=qlP0S-iNAJ8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=288

// ref : Basics.polymorphism_1

public class PersonTest {
  public static void main(String[] args) {

    System.out.println("============================");

    Person p2 = new Man();
    p2.name = "ken";
    Man m2 = (Man) p2; // DownCasting
    m2.makeMoney();
    m2.isSmoking = true;

    // when use DownCasting, we may face "ClassCastException" exception (as below)
    // so it's good to use isClassOf verify it before run
    // Woman w1 = (Woman) p2;
    // w1.goShopping();

    System.out.println("============================");

    /**
     * instanceof:
     *
     * <p>1) a instanceof A : check if a is instance of A, if yes, return True, else False 2) using
     * case : -> to prevent the "ClassCastException" exception, we use instanceof before we do
     * DownCasting. (if return true, then do DownCasting, else do nothing) 3) if a instanceof A
     * return true, and a instanceof B return true -> B is A's superclass
     */
    if (p2 instanceof Woman) {
      Woman w1 = (Woman) p2;
      w1.goShopping();
      System.out.println("==========  woman  ========== ");
    }

    System.out.println("============================");

    if (p2 instanceof Man) {
      Man m3 = (Man) p2;
      m3.makeMoney();
      System.out.println("==========  Man  ========== ");
    }

    System.out.println("============================");

    if (p2 instanceof Person) {
      System.out.println("==========  Person  ========== ");
    }

    System.out.println("============================");

    if (p2 instanceof Object) {
      System.out.println("==========  Object  ========== ");
    }

    System.out.println("============================");

    // more examples 1
    // https://www.youtube.com/watch?v=qlP0S-iNAJ8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=288

    // example 1: compile pass, runtime failed
    // Person p3 = new Woman();
    // Man m3 = (Man) p3;

    System.out.println("============================");

    // example 2: compile pass, runtime pass
    Object obj = new Woman();
    Person p3 = (Person) obj;

    System.out.println("============================");

    // example 3 : compile pass, runtime failed
    // -> in order to Downcasting, we need do Uppercasting first !!
    // Person p4 = new Person();
    // Man m4 = (Man) p4;
    // m2.makeMoney();

    // example 4 : compile failed, runtime failed
    // Man m5 = new Woman(); // type mismatch
  }
}
