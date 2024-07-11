package Advances.Generic;

// https://www.youtube.com/watch?v=UhgmcVG05qA&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=574


public class demo8 {
  public static void main(String[] args) {
    Person<Contact> per = null;
    per = new Person<Contact>(new Contact("london", "0001", "s101"));
    System.out.println(per);

    Person<Introduction> per2 = null;
    per2 = new Person<Introduction>(new Introduction("jobs", "male", 20));
    System.out.println(per2);
  }
}
