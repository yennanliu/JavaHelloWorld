package Advances.Enumeration;

// https://www.youtube.com/watch?v=s24HnhgQHiA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=498
// https://www.youtube.com/watch?v=Um-n9ecN898&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=498
// https://www.youtube.com/watch?v=LVOWihqbM70&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=501

/**
 * Enumeration (枚舉類) demo 1 : user defined Enumeration
 *
 * <p>1) general intro
 *
 * <p>1-1) when we have a class with limited, defined objects, we call this class as `Enumeration`
 * 1-2) if we want to define a set of constant values : Enumeration is highly recommended 1-3) if
 * there is only 1 object in the Enumeration, we can use singleton implementation
 *
 * <p>2) how to define Enumeration ?
 *
 * <p>2-1) before jdk 5.0 : user defined - ref :
 * https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/Enumeration/demo1.java
 * 2-2) after >= jdk 5.0 : use `enum` key word for Enumeration - ref :
 * https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/Enumeration/demo2.java
 *
 * <p>3) common used methods in `enum` class
 *
 * <p>3-1) values() - return Enumeration object array, we can visit all elements in Enumeration via
 * this method 3-2) valueOf(String objName) - transform a string to Enumeration object 3-3)
 * toString() - return current Enumeration constant value name
 *
 * <p>4) define Enumeration via `enum` and implement Interface
 *
 * <p>- ref :
 * https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/Enumeration/demo3.java
 *
 * <p>4-1) define interface, and implement abstract method in Enumeration 4-2) implement the
 * abstract methods in each object in Enumeration separately
 */
public class demo1 {
  public static void main(String[] args) {
    // test
    Season spring = Season.SPRING;
    Season summer = Season.SUMMER;
    Season autumn = Season.AUTUMN;
    Season winter = Season.WINTER;

    System.out.println(spring);
    System.out.println(summer);
    System.out.println(autumn);
    System.out.println(winter);

    System.out.println("==================");

    System.out.println(spring.getSeasonName());
  }
}

/** method 1) user defined Enumeration (2-1) before jdk 5.0 : user defined) */
class Season {
  // step 3) offer multiple objects on current Enumeration
  public static final Season SPRING = new Season("spring", "warm season");
  public static final Season SUMMER = new Season("summer", "hot season");
  public static final Season AUTUMN = new Season("autumn", "medium season");
  public static final Season WINTER = new Season("winter", "cold season");
  // attr
  // step 1) declare Season object's attr, and make it private final
  private final String seasonName;
  private final String seasonDesc;

  // constructor
  // step 2) make constructor private, and give attr value
  private Season(String seasonName, String seasonDesc) {
    this.seasonName = seasonName;
    this.seasonDesc = seasonDesc;
  }

  // step 4) other requirement, e.g. get properties of Enumeration
  // getter
  public String getSeasonName() {
    return seasonName;
  }

  public String getSeasonDesc() {
    return seasonDesc;
  }

  // other methods
  @Override
  public String toString() {
    return "Season{"
        + "seasonName='"
        + seasonName
        + '\''
        + ", seasonDesc='"
        + seasonDesc
        + '\''
        + '}';
  }
}
