package dev.bean;

public class Car {

  private int id;
  private String brand;
  private double price;

  public Car() {}

  public Car(int id, String brand, double price) {
    this.id = id;
    this.brand = brand;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getIdAndBrand() {

    return id + "-" + brand;
  }

  @Override
  public String toString() {
    return "Car{" + "id=" + id + ", brand='" + brand + '\'' + ", price=" + price + '}';
  }
}
