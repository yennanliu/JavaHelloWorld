package Others.FreeMarker.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User2 {

  private String name;
  private String location;
  private int cash;
  private Date createdDate;
  private List<Book> books = new ArrayList<>();

  public User2(String name, String location, int cash, Date createdDate) {
    this.name = name;
    this.location = location;
    this.cash = cash;
    this.createdDate = createdDate;
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public int getCash() {
    return cash;
  }

  public void setCash(int cash) {
    this.cash = cash;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
