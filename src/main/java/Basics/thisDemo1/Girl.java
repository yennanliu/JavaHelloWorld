package Basics.thisDemo1;

// https://www.youtube.com/watch?v=PtVdxCPGDU4&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=234

public class Girl {
  // attr
  private String name;
  private int age;

  // constructor
  public Girl() {}

  public Girl(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // getter, setter
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // method
  public void marry(Boy boy) {
    System.out.println("I wanna marry to a boy !!! " + boy.getName());
    // ***  not this one :boy.marry(new Girl()); <- will create a new Girl instance, but not the
    // current one
    boy.marry(this); // "this" is the "current class" (Girl class type in this example)
  }

  public int compare(Girl girl) {
    // treat "Girl" class as a object
    // so we can compare the age via Girl's attr (e.g. Girl.age)
    // -> 1st girl : the one that instantiate the class (Girl g = new Girl)
    // -> 2nd girl : the one input as arg in this method (g.compare(new Girl()))
    if (this.age > girl.age) {
      return 1;
    } else if (this.age < girl.age) {
      return -1;
    } else return 0;
  }
}
