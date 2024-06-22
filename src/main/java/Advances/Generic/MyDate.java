package Advances.Generic;

// https://www.youtube.com/watch?v=3VqFJPmA3wg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=348

public class MyDate implements Comparable<MyDate> {

  // attr
  private int year;
  private int month;
  private int day;

  // constructor
  public MyDate() {}

  public MyDate(int year, int month, int day) {
    super();
    this.year = year;
    this.month = month;
    this.day = day;
  }

  // getter, setter
  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  // method
  public String toDateString() {
    return " year = " + year + " month = " + month + " day = " + day;
  }

  @Override
  public int compareTo(MyDate m) {
    // compare year
    int minusYear = this.getYear() - m.getYear();
    if (minusYear != 0) {
      return minusYear;
    }

    // compare month
    int minusMonth = this.getMonth() - m.getMonth();
    if (minusMonth != 0) {
      return minusMonth;
    }

    // compare date
    return this.getDay() - m.getDay();
  }
}
