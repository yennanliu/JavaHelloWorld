package Basics;

// https://www.youtube.com/watch?v=9aWoG5su_Kg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=202

public class AnonymousObject2 {
  public static void main(String[] args) {

    PhoneMall2 mall = new PhoneMall2();
    // ypu can still do below, as regular way (instantiate a class)
    // Phone2 p = new Phone2();
    // mall.show(p);

    /*** BUT WE COULD ALSO DO THIS VIA "Anonymous Object" as below */
    mall.show(new Phone2()); // Anonymous Object
  }
}

class PhoneMall2 {

  public void show(Phone2 phone2) {
    phone2.sendEmail();
    phone2.playGame();
  }
}

class Phone2 {
  double price;

  public void sendEmail() {
    System.out.println("send email !!!");
  }

  public void playGame() {
    System.out.println("play game !!!");
  }

  public void showPrice() {
    System.out.println("phone price = " + price);
  }
}
