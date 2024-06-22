package Advances.Optional;

// https://www.youtube.com/watch?v=MYXoEU3RkG0&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=684

public class Girl {

  private String name;

  public Girl() {}

  public Girl(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Girl{" + "name='" + name + '\'' + '}';
  }
}
