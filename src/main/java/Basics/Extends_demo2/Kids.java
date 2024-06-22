package Basics.Extends_demo2;

// https://www.youtube.com/watch?v=i4HGpPEWN2k&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=266

/**
 * Note : Kids is a java bean, since it meets 1) is a public class 2) has a non-input constructor 3)
 * has getter, setter
 */
public class Kids extends ManKind {
  // attr
  private int yearsOld;

  // constructor
  public Kids() {}

  public Kids(int yearsOld) {
    this.yearsOld = yearsOld;
  }

  // method
  public void printAge() {
    System.out.println("hii i am " + yearsOld + " years old !");
  }

  // getter, setter
  public int getYearsOld() {
    return yearsOld;
  }

  public void setYearsOld(int yearsOld) {
    this.yearsOld = yearsOld;
  }
}
