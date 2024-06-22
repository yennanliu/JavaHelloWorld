package Basics.EmployeeCRM.team.domain;

// https://www.youtube.com/watch?v=1vbROSe7c7Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=389

public class PC implements Equipment {
  // attr
  private String model; // machine type
  private String display; // machine name

  // constructor
  public PC() {
    super();
  }

  public PC(String model, String display) {
    super();
    this.model = model;
    this.display = display;
  }

  // getter, setter
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getDisplay() {
    return display;
  }

  public void setDisplay(String display) {
    this.display = display;
  }

  // method
  @Override
  public String getDescription() {
    return model + " ( " + display + " ) ";
  }
}
