package Advances.Enumeration;

// https://www.youtube.com/watch?v=LVOWihqbM70&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=501

/** method 2) via `enum` (after >= jdk 5.0 : use `enum` key word for Enumeration) */
enum Season2 implements Info {

  // implement show() method 2)
  // 4-2) implement the abstract methods in each object in Enumeration separately
  SPRING("spring", "warm season") {
    @Override
    public void show() {
      System.out.println("this is a spring (show)");
    }
  },
  SUMMER("summer", "hot season") {
    @Override
    public void show() {
      System.out.println("this is a summer (show)");
    }
  },
  AUTUMN("autumn", "medium season") {
    @Override
    public void show() {
      System.out.println("this is a autumn (show)");
    }
  },
  WINTER("winter", "cold season") {
    @Override
    public void show() {
      System.out.println("this is a winter (show)");
    }
  };

  // attr
  private final String seasonName;
  private final String seasonDesc;

  // constructor
  Season2(String seasonName, String seasonDesc) {
    this.seasonName = seasonName;
    this.seasonDesc = seasonDesc;
  }

  // implement show() method 1)
  // 4-1) define interface, and implement abstract method in Enumeration
  //    @Override
  //    public void show() {
  //        System.out.println("this is a season (show)");
  //    }
}

interface Info {
  void show();
}

/** Enumeration (枚舉類) demo 3 : via `enum` : with interface implementation */
public class demo3 {
  public static void main(String[] args) {
    // test
    Season2 spring = Season2.SPRING;
    Season2 summer = Season2.SUMMER;
    Season2 autumn = Season2.AUTUMN;
    Season2 winter = Season2.WINTER;

    System.out.println(spring);
    System.out.println(summer);
    System.out.println(autumn);
    System.out.println(winter);

    // values
    Season2[] values = Season2.values();
    for (int i = 0; i < values.length; i++) {
      System.out.println(values[i]);
      values[i].show();
    }

    System.out.println("==================");

    winter.show();
  }
}
