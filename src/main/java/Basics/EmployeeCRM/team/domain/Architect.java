package Basics.EmployeeCRM.team.domain;

// https://www.youtube.com/watch?v=rN0byZHtGw8&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=390

/** Architect class */
public class Architect extends Designer {

  // attr
  private int stock;

  // constructor
  public Architect() {
    super();
  }

  public Architect(
      int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
    super(id, name, age, salary, equipment, bonus);
    this.stock = stock;
  }

  // getter, setter
  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  // method
  @Override
  public String toString() {
    return super.getDetails()
        + " status="
        + getStatus()
        + " bonus="
        + getBonus(); // ",stock=" + stock + super.getEquipment().getDescription();  // TODO : fix
    // this
  }
}
