package Basics;

// https://www.youtube.com/watch?v=Cmc1jNY2DSc&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=230

/*
 * CustomerBean is a demo javabean
 */

public class CustomerBean {
  // attr
  private int id;
  private String name;

  // constructor
  public CustomerBean() {}

  public int getId() {
    return id;
  }

  // getter, setter
  public void setId(int i) {
    id = i;
  }

  public String getName() {
    return name;
  }

  public void setName(String n) {
    name = n;
  }
}
