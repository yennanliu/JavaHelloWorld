package Basics;

// https://www.youtube.com/watch?v=9aWoG5su_Kg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=202

public class AnonymousObject1 {
  public static void main(String[] args) {

    // run
    Phone p = new Phone();
    System.out.println(p);

    p.sendEmail();
    p.playGame();

    System.out.println("======================");

    /*** Anonymous object */
    // below 2 Anonymous object are in DIFFERENT LOCATION IN heap space, (since they are with
    // different "New"
    new Phone().sendEmail();
    new Phone().playGame();

    System.out.println("======================");

    new Phone().price = 1999;
    new Phone().showPrice(); // 0.0
  }
}

class Phone {
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
