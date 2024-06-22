package dev.bean;

public class Sales {

  private int id;
  private Double price;

  public Sales(Integer id, Double price) {
    this.id = id;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Sales{" + "id=" + id + ", price=" + price + '}';
  }
}
