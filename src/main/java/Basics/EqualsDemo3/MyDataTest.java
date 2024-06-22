package Basics.EqualsDemo3;

// https://www.youtube.com/watch?v=dGqcHBCUoOM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=298

public class MyDataTest {
  public static void main(String[] args) {
    // run
    MyDate m1 = new MyDate(14, 3, 1999);
    MyDate m2 = new MyDate(14, 3, 1999);

    if (m1 == m2) {
      System.out.println("m1 == m1");
    } else {
      System.out.println("m1 != m2");
    }

    if (m1.equals(m2)) {
      System.out.println("m1 is equal to m2");
    } else {
      System.out.println("m1 is not equal to m2");
    }
  }
}

class MyDate {
  // attr
  private int day;
  private int month;
  private int year;

  // constructor
  public MyDate(int day, int month, int year) {
    super();
    this.day = day;
    this.month = month;
    this.year = year;
  }

  // getter, setter
  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  // method
  // rewrite equals
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj instanceof MyDate) {
      MyDate mydate = (MyDate) obj;
      return (this.day == mydate.day && this.month == mydate.month && this.year == mydate.year);
    }
    return false;
  }
}
