package Basics.EmployeeCRM.team.domain;

// https://www.youtube.com/watch?v=1vbROSe7c7Q&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=389

public class NoteBook implements Equipment {
  // attr
  private String model; // machine type
  private double price; // price

  // constructor
  public NoteBook() {
    super();
  }

  public NoteBook(String model, double price) {
    super();
    this.model = model;
    this.price = price;
  }

  // getter, setter
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  // method
  @Override
  public String getDescription() {
    return model + " ( " + price + " )";
  }
}
